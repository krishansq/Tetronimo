
package com.example.tetronimo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.Display;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;

public class TetGameView extends SurfaceView implements Runnable {
    private boolean mRunning;
    Paint paint = new Paint();
    private MainThread mGameThread;
    private GameState mGameState;
    SurfaceHolder mSurfaceHolder;
    Context mContext;

    public TetGameView(Context context) {
        super(context);
        init(context);
    }

    public TetGameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TetGameView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mContext = context;
        mSurfaceHolder = getHolder();
        mGameThread = new MainThread(this);
        setFocusable(true);
        mGameState = new GameState();
    }

    @Override
    public void run()
    {
        Canvas canvas;
        if (mSurfaceHolder.getSurface().isValid()) {
            canvas = mSurfaceHolder.lockCanvas();
            canvas.save();

        }

            while (mRunning)
            {

                canvas = null;

                try {
                    canvas = this.mSurfaceHolder.lockCanvas();
                    synchronized (mSurfaceHolder) {
                        update();
                        draw(canvas);
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                } finally {
                    if (canvas != null) {
                        try {
                            mSurfaceHolder.unlockCanvasAndPost(canvas);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }

    }




    public void pause() {
        mRunning = false;
        try {
            // Stop the thread (rejoin the main thread)
            mGameThread.join();
        } catch (InterruptedException e) {
        }
    }

    public void resume() {
        mRunning = true;
        mGameThread = new MainThread(this);
        mGameThread.start();
    }

    public void update()
    {
        mGameState.update();

    }

    @Override
    public void draw(Canvas canvas) {
        int rowDivider = this.getMeasuredHeight() / 24;
        int colDivider = this.getMeasuredWidth() / 10;

        super.draw(canvas);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(3);
        for(int i = 0; i < 24; i++)
        {
            canvas.drawLine(0, i*rowDivider, this.getMeasuredWidth(), i*rowDivider, paint);
        }

        for(int i = 0; i < 10; i++)
        {
            canvas.drawLine(i*colDivider, 0, i*colDivider, this.getMeasuredHeight(), paint);
        }
    }

}

//    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
//
//    }
//
//
//    public void surfaceCreated(SurfaceHolder holder) {
//        thread.setRunning(true);
//        thread.start();
////        int x = 1;
////        int y = 0;
////        int z = x / y;
//    }
//
//
//    public void surfaceDestroyed(SurfaceHolder holder) {
//        boolean retry = true;
//        while (retry) {
//            try {
//                thread.setRunning(false);
//                thread.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            retry = false;
//        }
//    }






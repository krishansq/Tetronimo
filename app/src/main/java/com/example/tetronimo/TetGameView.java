
package com.example.tetronimo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class TetGameView extends SurfaceView {
   // private boolean mRunning;
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
        setFocusable(true);
        mGameState = new GameState();
    }




    public void pause() {
        mGameThread.setRunning(false);
        try {
            // Stop the thread (rejoin the main thread)
            mGameThread.join();
        } catch (InterruptedException e) {
        }
    }

    public void resume() {

        mGameThread = new MainThread(this, mSurfaceHolder);
        mGameThread.setRunning(true);
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
        paint.setColor(Color.CYAN);
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






package com.example.tetronimo;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class MainThread extends Thread
{
    private SurfaceHolder mSurfaceHolder;
    private TetGameView mGameView;
    private boolean mRunning;
    public static Canvas mCanvas;

    public MainThread(TetGameView gameView, SurfaceHolder surfaceHolder)
    {
        super();
        this.mSurfaceHolder = surfaceHolder;
        this.mGameView = gameView;
    }

    @Override
    public void run()
    {

        while (mRunning)
        {

            mCanvas = null;
            if (mSurfaceHolder.getSurface().isValid())
            {

                try {
                    mCanvas = mSurfaceHolder.lockCanvas();
                    mCanvas.save();
                    synchronized (mSurfaceHolder) {
                        //mGameView.update();
                        mGameView.draw(mCanvas);

                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                } finally {
                    if (mCanvas != null) {
                        try {
                            mCanvas.restore();
                            mSurfaceHolder.unlockCanvasAndPost(mCanvas);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        }
    }
    public void setRunning(boolean isRunning)
    {
        mRunning = isRunning;
    }

}

package com.example.tetronimo;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class MainThread extends Thread
{
    private SurfaceHolder surfaceHolder;
    private TetGameView gameView;
    private boolean mRunning;
    public static Canvas canvas;

    public MainThread(TetGameView gameView)
    {
        super();
        this.surfaceHolder = surfaceHolder;
        this.gameView = gameView;
    }

    @Override
    public void run()
    {
        while (mRunning)
        {

            canvas = null;

            try {
                canvas = this.surfaceHolder.lockCanvas();
                synchronized (surfaceHolder) {
                   //update();
                    gameView.draw(canvas);
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            finally
            {
                if (canvas != null)
                {
                    try {
                       surfaceHolder.unlockCanvasAndPost(canvas);
                    } catch (Exception e2) {
                        e2.printStackTrace();
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

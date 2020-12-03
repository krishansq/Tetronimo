package com.example.tetronimo;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class MainThread extends Thread
{
    private SurfaceHolder surfaceHolder;
    private GameView gameView;
    private boolean running;
    public static Canvas canvas;

    public MainThread(SurfaceHolder surfaceHolder, GameView gameView)
    {
        super();
        this.surfaceHolder = surfaceHolder;
    }

    @Override
    public void run()
    {
        while (running)
        {
            canvas = null;

            try {
                canvas = this.surfaceHolder.lockCanvas();
                synchronized (surfaceHolder) {
                    //update();
                    //draw(canvas);
                }
            } catch (Exception e1) {
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
        running = isRunning;
    }

}

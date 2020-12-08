package com.example.tetronimo;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

import java.util.TimerTask;

public class MainThread extends Thread //overloads thread class to implement a better run method
{
    private SurfaceHolder mSurfaceHolder;
    private TetGameView mGameView;
    private boolean mRunning;
    public static Canvas mCanvas;

    public MainThread(TetGameView gameView, SurfaceHolder surfaceHolder) //constructs thread
    {
        super();
        this.mSurfaceHolder = surfaceHolder;
        this.mGameView = gameView;
    }

    public void run () //runs the program by updating the gameboard and drawing on the canvas
    {

        while (mRunning) { //try catch blocks aren't totally necessary, but useful for increasing amount of threads and more complex game

            mCanvas = null;
            if (mSurfaceHolder.getSurface().isValid()) {

                try {
                    mCanvas = mSurfaceHolder.lockCanvas();
                    mCanvas.save();
                    synchronized (mSurfaceHolder) {
                        mGameView.update();
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
    } //sets mrunning to what is passed in

}

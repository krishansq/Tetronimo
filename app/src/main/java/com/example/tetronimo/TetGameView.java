package com.example.tetronimo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
//This class is what draws the game board
public class TetGameView extends SurfaceView {
    //private boolean mRunning;
    Paint paint = new Paint();
    private MainThread mGameThread;
    private GameState mGameState;
    SurfaceHolder mSurfaceHolder;
    Context mContext;

    public TetGameView(Context context) { //necessary constructors
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

    private void init(Context context) { //initiates the view
        mContext = context;
        mSurfaceHolder = getHolder();
        setFocusable(true);
        mGameState = new GameState();
    }




    public void pause() { //pause method, not used currently
        mGameThread.setRunning(false);
        try {
            // Stop the thread (rejoin the main thread)
            mGameThread.join();
        } catch (InterruptedException e) {
        }
    }

    public void resume() { //resume method, not used currently

        mGameThread = new MainThread(this, mSurfaceHolder);
        mGameThread.setRunning(true);
        mGameThread.start();
    }

    public void update() //updates the gamestate before drawing
    {

        if(!mGameState.checkGame(mGameState.getCurrentPiece()))
        {
            mGameState.placePiece(mGameState.getCurrentPiece());

        }
        else{
        }
    }


    @Override
    public void draw(Canvas canvas) { //draws rectangles where they are indicated in the gameboard array
        float rectHeight = (float)this.getMeasuredHeight() / mGameState.ROWS;
        float rectWidth = (float)this.getMeasuredWidth() / mGameState.COLS;
        super.draw(canvas);
        canvas.drawARGB(40, 25, 125, 55);
        paint.setColor(Color.CYAN);

        for(int i = 0; i < mGameState.ROWS; i++)
        {
            for(int j = 0; j < mGameState.COLS; j++)
            {
                if(mGameState.getGameBoard()[i][j] > 0 && mGameState.getGameBoard()[i][j] < 8)
                {
                    canvas.drawRect(j * rectWidth, i * rectHeight, (j + 1) * rectWidth, (i + 1) * rectHeight, paint);
                }
            }
        }


    }

    public void buttonMove(int buttonID) { //method that calls methods based on button output passed in
        switch (buttonID) {
            case 1:

                mGameState.moveLeft(mGameState.getCurrentPiece());
                break;

            case 2:

                mGameState.moveDown(mGameState.getCurrentPiece());
                break;

            case 3:

                mGameState.moveUp(mGameState.getCurrentPiece());
                break;

            case 4:

                mGameState.moveRight(mGameState.getCurrentPiece());
                break;
        }
    }


}








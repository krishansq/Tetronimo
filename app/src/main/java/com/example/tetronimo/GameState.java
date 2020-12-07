package com.example.tetronimo;

public class GameState
{
    final int ROWS = 24; //amount of rows
    final int COLS = 10; //amount of columns
    private int[][] gameBoard = new int[ROWS][COLS];

    public GameState() //initializes gameBoard to be filled with zeroes
    {
        for(int i = 0; i < ROWS; i++)
        {
            for(int j = 0; j < COLS; j++)
            {
                gameBoard[i][j] = 0;
            }
        }
    }

    public void update()
    {

    }

    public int[][] getGameBoard()
    {
        return gameBoard;
    }


}

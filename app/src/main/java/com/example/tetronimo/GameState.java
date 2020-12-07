package com.example.tetronimo;

import android.graphics.Color;
import android.graphics.Point;
import android.view.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class GameState
{
    public final int ROWS = 24;
    public final int COLS = 10;
    private int gameBoard[][] = new int[ROWS][COLS];
    private final Random random = new Random();
    private ArrayList<Pieces> piecesList = new ArrayList<Pieces>();
    private final int Piecesamt = 7;

    public GameState()
    {
        piecesList.add(new Pieces(random.nextInt(Piecesamt) + 1));
        piecesList.add(new Pieces(random.nextInt(Piecesamt) + 1));
    }


    public void clearBoard() //clears and initializes gameBoard
    {
        for(int i = 0; i < ROWS; i++)
        {
            for(int j = 0; j < COLS; j++)
            {
                gameBoard[i][j] = 0;
            }
        }
    }

    public ArrayList<Pieces> getPiecesList()
    {
        return piecesList;
    }

    public Pieces getCurrentPiece()
    {
        return piecesList.get(piecesList.size() - 2);
    }

    public Pieces getNextPiece()
    {
        return piecesList.get(piecesList.size() - 1);
    }

    public void placePiece(Pieces currentPiece)
    {
        gameBoard[currentPiece.x1][currentPiece.y1] = currentPiece.colorCode;
        gameBoard[currentPiece.x2][currentPiece.y2] = currentPiece.colorCode;
        gameBoard[currentPiece.x3][currentPiece.y3] = currentPiece.colorCode;
        gameBoard[currentPiece.x4][currentPiece.y4] = currentPiece.colorCode;
    }

    private void deletePiece(Pieces currentPiece)
    {
        gameBoard[currentPiece.x1][currentPiece.y1] = 0;
        gameBoard[currentPiece.x2][currentPiece.y2] = 0;
        gameBoard[currentPiece.x3][currentPiece.y3] = 0;
        gameBoard[currentPiece.x4][currentPiece.y4] = 0;
    }

    //check if piece can move in x/y directions
    //copy piece and try to move it, return true if it can move
    private boolean piece_moves(Pieces currentPiece, int x, int y)
    {
        int temp = 0;
        //copy piece coordinates

        Point p1 = new Point(currentPiece.x1, currentPiece.y1);
        Point p2 = new Point(currentPiece.x2, currentPiece.y2);
        Point p3 = new Point(currentPiece.x3, currentPiece.y3);
        Point p4 = new Point(currentPiece.x4, currentPiece.y4);

        Point temp1 = new Point(currentPiece.x1 + x, currentPiece.y1 + y);
        Point temp2 = new Point(currentPiece.x2 + x, currentPiece.y2 + y);
        Point temp3 = new Point(currentPiece.x3 + x, currentPiece.y3 + y);
        Point temp4 = new Point(currentPiece.x4 + x, currentPiece.y4 + y);

        ArrayList<Point> tempPieceCords = new ArrayList<Point>();

        tempPieceCords.add(temp1);
        tempPieceCords.add(temp2);
        tempPieceCords.add(temp3);
        tempPieceCords.add(temp4);

        for(Point p : tempPieceCords)
        {
            if(p.x < ROWS && p.y >= 0 && p.y < COLS && gameBoard[p.x][p.y] == 0)
            {
                temp++;
            }
            else if(p.equals(p1) || p.equals(p2) || p.equals(p3) || p.equals(p4))
            {
                temp++;
            }
        }

        if(temp == 4)
        {
            return true;
        }
        return false;
    }

    //copy current piece and check if it can rotate
    //return true if true
    private boolean piece_rotates(Pieces currentPiece)
    {
        int temp = 0;
        ArrayList<Point> tempPieceCords = new ArrayList<Point>();

        Pieces tempPiece = new Pieces(currentPiece);

        Point p1 = new Point(currentPiece.x1, currentPiece.y1);
        Point p2 = new Point(currentPiece.x2, currentPiece.y2);
        Point p3 = new Point(currentPiece.x3, currentPiece.y3);
        Point p4 = new Point(currentPiece.x4, currentPiece.y4);

        tempPiece.turnPieces();

        Point temp1 = new Point(tempPiece.x1, tempPiece.y1);
        Point temp2 = new Point(tempPiece.x2, tempPiece.y2);
        Point temp3 = new Point(tempPiece.x3, tempPiece.y3);
        Point temp4 = new Point(tempPiece.x4, tempPiece.y4);

        tempPieceCords.add(temp1);
        tempPieceCords.add(temp2);
        tempPieceCords.add(temp3);
        tempPieceCords.add(temp4);

        for(Point p : tempPieceCords)
        {
            if(p.x < ROWS && p.y >= 0 && p.y < COLS && gameBoard[p.x][p.y] == 0)
            {
                temp++;
            }
            else if(p.equals(p1) || p.equals(p2) || p.equals(p3) || p.equals(p4))
            {
                temp++;
            }
        }
        if(temp == 4)
        {
            return true;
        }
        return false;
    }

    private boolean moves_left(Pieces currentPiece)
    {
        if(piece_moves(currentPiece, 0, -1))
        {
            return true;
        }
        return false;
    }

    private boolean moves_right(Pieces currentPiece)
    {
        if(piece_moves(currentPiece, 0, 1))
        {
            return true;
        }
        return false;
    }

    public boolean moves_down(Pieces currentPiece)
    {
        if(piece_moves(currentPiece, 1, 0))
        {
            return true;
        }
        return false;
    }

    public boolean moves_up(Pieces currentPiece)
    {
        if(piece_moves(currentPiece, -1, 0))
        {
            return true;
        }
        return false;
    }

    private void movePiece(Pieces currentPiece, int x, int y)
    {
        deletePiece(currentPiece);
        currentPiece.move(x, y);
        placePiece(currentPiece);
    }

    public void moveLeft(Pieces currentPiece)
    {
        if(moves_left(currentPiece) == true)
        {
            movePiece(currentPiece, 0, -1);
        }
    }

    public void moveRight(Pieces currentPiece)
    {
        if(moves_right(currentPiece) == true)
        {
            movePiece(currentPiece, 0 , 1);
        }
    }

    public void moveDown(Pieces currentPiece)
    {
        if(moves_down(currentPiece) == true)
        {
            movePiece(currentPiece, 1, 0);
        }

    }

    public void moveUp(Pieces currentPiece)
    {
        if(moves_up(currentPiece) == true)
        {
            movePiece(currentPiece, -1, 0);
        }

    }
    public void Drop(Pieces currentPiece)
    {
        deletePiece(currentPiece);

        while(moves_down(currentPiece))
        {
            moveDown(currentPiece);

        }
        placePiece(currentPiece);
    }

    public void rotate(Pieces currentPiece)
    {
        if(piece_rotates(currentPiece) == true && currentPiece.colorCode != 1)
        {
            deletePiece(currentPiece);
            currentPiece.turnPieces();
            placePiece(currentPiece);
        }
        placePiece(currentPiece);
    }

    public int clearRows()
    {
        int RowIndex;
        int deletedRows = 0;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        for(int i = 0; i < ROWS; i ++)
        {
            for(int j = COLS - 1; j >= 0; j--)
            {
                if(gameBoard[i][j] == 0) //Row is not full
                {
                    break;
                }
                if(j == 0)
                {
                    RowIndex = i;
                    arrayList.add(RowIndex);
                    deletedRows++;
                    deleteRow(RowIndex);
                }
            }
        }

        if(deletedRows >= 1)
        {
            int topRow = Collections.min(arrayList); //searches for highest row that can be cleared
            int[][] gameBoardNew = new int[topRow][COLS];

            for(int i = 0; i < gameBoardNew.length; i++)
            {
                for(int j = 0; j < gameBoardNew[1].length; j++)
                {
                    gameBoardNew[i][j] = gameBoard[i][j];
                }
            }

            for(int i = 0; i < gameBoardNew.length; i++)
            {
                for(int j = 0; j < gameBoardNew[1].length; j++)
                {
                    gameBoard[i+deletedRows][j] = gameBoardNew[i][j];
                }
            }
        }
        return deletedRows;
    }

    public void deleteRow(int r)
    {
        for(int i = 0; i < COLS; i++)
        {
            gameBoard[r][i] = 0;
        }
    }

    public boolean checkGame(Pieces gamePieces)
    {
        if(moves_down(gamePieces) == false && gamePieces.getMinXCoordinate(
                gamePieces.x1, gamePieces.x2, gamePieces.x3, gamePieces.x4) <= 1)
        {
            return true;
        }
        return false;
    }

    public int[][] getGameBoard()
    {
        return gameBoard;
    }

    public void setNextPiece()
    {
    }
//    public void onClick(View view) {
//
//        switch (view.getId()) {
//            case R.id.rButton:
//                this.moveRight(this.getCurrentPiece());
//                break;
//            case R.id.lButton:
//                this.moveLeft(this.getCurrentPiece());
//                break;
//            case R.id.lcButton:
//                this.Drop(this.getCurrentPiece());
//                break;
//            case R.id.rcButton:
//                this.rotate(this.getCurrentPiece());
//                break;
//        }
//    }
}
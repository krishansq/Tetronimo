package com.example.tetronimo;

public class Pieces
{
    public int colorCode;
    public int x1, y1;
    public int x2, y2;
    public int x3, y3;
    public int x4, y4;
    private Pieces pieces;

    public Pieces(Pieces pieces)
    {
        this.pieces = pieces;
        this.x1 = pieces.x1; this.x2 = pieces.x2;
        this.x1 = pieces.x3; this.x3 = pieces.x4;
        this.y1 = pieces.y1; this.y2 = pieces.y2;
        this.y3 = pieces.y3; this.y4 = pieces.y4;
    }

    //create a block based on the colorCode
    public Pieces(int f)
    {
        switch(f)
        {
            case 1:         //Square
                x1 = 0; y1 = 7;
                x2 = 0; y2 = 8;
                x3 = 1; y3 = 7;
                x4 = 1; y4 = 8;

                colorCode = 1;
                break;

            case 2:         //Z block
                x1 = 0; y1 = 7;
                x2 = 0; y2 = 8;
                x3 = 1; y3 = 8;
                x4 = 1; y4 = 9;

                colorCode = 2;
                break;

            case 3:         //I block
                x1 = 0; y1 = 6;
                x2 = 0; y2 = 7;
                x3 = 0; y3 = 8;
                x4 = 0; y4 = 9;

                colorCode = 3;
                break;

            case 4:         //T block
                x1 = 0; y1 = 8;
                x2 = 1; y2 = 7;
                x3 = 1; y3 = 8;
                x4 = 1; y4 = 9;

                colorCode = 4;
                break;

            case 5:         //S block
                x1 = 0; y1 = 7;
                x2 = 0; y2 = 8;
                x3 = 1; y3 = 6;
                x4 = 1; y4 = 7;

                colorCode = 5;
                break;

            case 6:         //J block
                x1 = 0; y1 = 7;
                x2 = 0; y2 = 8;
                x3 = 0; y3 = 9;
                x4 = 1; y4 = 9;

                colorCode = 6;
                break;

            case 7:         //L block
                x1 = 0; y1 = 7;
                x2 = 0; y2 = 8;
                x3 = 0; y3 = 9;
                x4 = 1; y4 = 7;

                colorCode = 7;
                break;
        }
    }

    public void move(int x, int y)
    {
        x1 = x1 + x;
        y1 = y1 + y;
        x2 = x2 + x;
        y2 = y2 + y;
        x3 = x3 + x;
        y3 = y3 + y;
        x4 = x4 + x;
        y4 = y4 + y;
    }

    //rotates the pieces about the (x1,y1) coordinates
    //set three sets of temporary variables
    public void turnPieces()
    {
        int temp_x1, temp_y1;
        int temp_x2, temp_y2;
        int temp_x3, temp_y3;

        temp_x1 = rotateX1(y2);
        temp_y1 = rotateY1(x2);
        x2 = temp_x1;
        y2 = temp_y1;

        temp_x2 = rotateX1(y3);
        temp_y2 = rotateY1(x3);
        x3 = temp_x2;
        y3 = temp_y2;

        temp_x3 = rotateX1(y4);
        temp_y3 = rotateY1(x4);
        x4 = temp_x3;
        y4 = temp_y3;
    }

    public int rotateX1(int y)
    {
        return x1 + y - y1;
    }

    public int rotateY1(int x)
    {
        return y1 - x + x1;
    }

    public int getMinXCoordinate(int x1, int x2, int x3, int x4)
    {
        return Math.min(Math.min(x1,x2),Math.min(x3,x4));
    }
}

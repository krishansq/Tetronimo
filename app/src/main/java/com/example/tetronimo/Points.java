package com.example.tetronimo;

import android.content.Context;
import android.content.SharedPreferences;

public class Points
{
    private int currentPoints = 0;
    private MainThread mainThread;
    private int level = 0;

    public Points(Context context)
    {
        mainThread = (MainThread) context;
    }

    public void showHS() //displays high score
    {
        SharedPreferences pref = mainThread.getSharedPreferences("Game",0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("High Score", level);
        editor.commit();
    }

    public int loadHS() //loads high score
    {
        SharedPreferences pref = mainThread.getSharedPreferences("Game", 0);
        return pref.getInt("High Score", 0);
    }

    public void setCP(int currentPoints) //sets user's current points
    {
        this.currentPoints = currentPoints;
    }

    public int getCP()
    {
        return this.currentPoints;
    }

    public void setLevel()
    {
        if(currentPoints >= 20)
        {
            this.level = 1;
        }

        if(currentPoints >= 40)
        {
            this.level = 2;
        }

        if(currentPoints >= 60)
        {
            this.level = 3;
        }

        if(currentPoints >= 80)
        {
            this.level = 4;
        }

        if(currentPoints >= 80)
        {
            this.level = 5;
        }

        if(currentPoints >= 100)
        {
            this.level = 6;
        }

        if(currentPoints >= 120)
        {
            this.level = 7;
        }

        if(currentPoints >= 140)
        {
            this.level = 8;
        }

        if(currentPoints >= 160) {
            this.level = 9;
        }

        if(currentPoints >= 180)
        {
        this.level = 10;
        }
    }

    public int getLevel()
    {
        return this.level;
    }
}

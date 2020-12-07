package com.example.tetronimo;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.app.Activity;
import java.util.Random;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class GameActivity extends Activity implements View.OnClickListener
{
    private TetGameView mGameView;
    private ImageButton leftButton;
    private ImageButton rightButton;
    private ImageButton leftcenterButton;
    private ImageButton rightcenterButton;
    private TextView title;
    private GameState gameState;
    private MainThread mainThread;
    private Random random = new Random();
    private ArrayList<Pieces> pieceList;
    private Timer timer = new Timer();
    private Points points;


    public GameActivity(Context context, GameState gameState, MainThread mainThread)
    {
        super();

        this.mainThread = mainThread;
        this.gameState = gameState;
        points = new Points(context);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        leftButton = findViewById(R.id.lButton);
        leftButton.setOnClickListener(this);

        rightButton = findViewById(R.id.rButton);
        rightButton.setOnClickListener(this);

        leftcenterButton = findViewById(R.id.lcButton);
        leftcenterButton.setOnClickListener(this);

        rightcenterButton = findViewById(R.id.rcButton);
        rightcenterButton.setOnClickListener(this);

        title = findViewById(R.id.gameTitle);

        mGameView = findViewById(R.id.XMLGAMEVIEW);


    }

    @Override
    protected void onPause() {
        super.onPause();
        mGameView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mGameView.resume();
    }

    @Override
    public void onClick(View view)
    {
       if(MainThread.getPause() == false)
       {
           switch (view.getId()) {
               case R.id.rButton:
                   gameState.moveRight(gameState.getCurrentPiece());
                   break;
               case R.id.lButton:
                   gameState.moveLeft(gameState.getCurrentPiece());
                   break;
               case R.id.lcButton:
                   gameState.Drop(gameState.getCurrentPiece());
                   break;
               case R.id.rcButton:
                   gameState.rotate(gameState.getCurrentPiece());
                   break;
           }
       }
       public Timer getTimer()
        {
            return this.timer;
        }
    }
}





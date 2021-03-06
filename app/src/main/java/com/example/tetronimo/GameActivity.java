package com.example.tetronimo;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.Activity;
import java.util.Random;
import java.util.ArrayList;


public class GameActivity extends Activity implements View.OnClickListener {
    private TetGameView mGameView;
    private GameState gameState;
    private MainThread mainThread;
    private ArrayList<Pieces> pieceList;


    public GameActivity(Context context, GameState gameState, MainThread mainThread) {
        super();
        this.mainThread = mainThread;
        this.gameState = gameState;

    }
    public GameActivity(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton leftButton = findViewById(R.id.lButton);
        leftButton.setOnClickListener(this);

        ImageButton rightButton = findViewById(R.id.rButton);
        rightButton.setOnClickListener(this);

        ImageButton leftcenterButton = findViewById(R.id.lcButton);
        leftcenterButton.setOnClickListener(this);

        ImageButton rightcenterButton = findViewById(R.id.rcButton);
        rightcenterButton.setOnClickListener(this);

        ImageView title = findViewById(R.id.title);

        mGameView = findViewById(R.id.XMLGAMEVIEW);
    }

    @Override
    protected void onPause() { //currently unused
        super.onPause();
        mGameView.pause();
    }

    @Override
    protected void onResume() { //starts up game
        super.onResume();
        mGameView.resume();
    }

    @Override
    public void onClick(View view) { //handles button inputs and sends the result to the view class

            switch (view.getId()) {
                case R.id.lButton:
                    mGameView.buttonMove(1);
                    break;
                case R.id.lcButton:
                    mGameView.buttonMove(2);
                    break;
                case R.id.rcButton:
                    mGameView.buttonMove(3);
                    break;
                case R.id.rButton:
                    mGameView.buttonMove(4);
                    break;

            }
    }
}



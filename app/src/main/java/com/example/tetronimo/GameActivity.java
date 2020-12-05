package com.example.tetronimo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.app.Activity;

public class GameActivity extends Activity implements View.OnClickListener
{
    private TetGameView mGameView;
    private ImageButton leftButton;
    private ImageButton rightButton;
    private ImageButton centerButton;
    private TextView title;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        leftButton = findViewById(R.id.lButton);
        leftButton.setOnClickListener(this);

        rightButton = findViewById(R.id.rButton);
        rightButton.setOnClickListener(this);

        centerButton = findViewById(R.id.cButton);
        centerButton.setOnClickListener(this);

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
        switch (view.getId()) {
            case R.id.rButton:
                return;
            case R.id.lButton:
                return;
            case R.id.cButton:
                return;
        }
    }
}





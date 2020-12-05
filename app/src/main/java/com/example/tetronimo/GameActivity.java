package com.example.tetronimo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.app.Activity;

public class GameActivity extends Activity implements View.OnClickListener
{
    private TetGameView mGameView;
    private ImageButton leftButton;
    private ImageButton rightButton;
    private ImageButton centerButton;
    private View XMLView;
    private ViewGroup gameViewGroup;
    private TextView title;
    private int x = 1;
    private int y = 0;
    public int bCount = 0;

    //TextView counterText; used for number button press test

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

        mGameView = new TetGameView( this);
        //mGameView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);


        XMLView = findViewById(R.id.XMLGAMEVIEW);

        gameViewGroup = (ViewGroup)XMLView.getParent();
        gameViewGroup.removeAllViews();

        gameViewGroup.addView(mGameView);


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
               // int z = x / y;
        }
    }
}





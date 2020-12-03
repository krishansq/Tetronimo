package com.example.tetronimo;

import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity implements View.OnClickListener
{
    GameView gameView;
    private ImageButton leftButton;
    private ImageButton rightButton;
    private ImageButton centerButton;
    private int x = 1;
    private int y = 0;
    public int bCount = 0;
    TextView counterText;

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

      //  counterText = findViewById(R.id.counter);

        //gameView = new GameView(this, AttributeSet this);

    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId()) {
            case R.id.rButton:
                bCount++;
                counterText.setText(Integer.toString(bCount));
                break;
            case R.id.lButton:
                bCount++;
                counterText.setText(Integer.toString(bCount));
                break;
            case R.id.cButton:
                bCount--;
                counterText.setText(Integer.toString(bCount));
                break;
        }
    }
}





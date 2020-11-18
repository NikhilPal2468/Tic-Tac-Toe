package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//    0 --> X
//    1 --> O
    int activePlayer = 0;
    int [] gamestate = {2 ,2 ,2 ,2 ,2 ,2 ,2 ,2 ,2};
//    0 --> X
//    1 --> O
//    2 --> null
    int [][] winPosition = {{0, 1, 2 },{3, 4, 5}, {6 ,7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 7}};

    boolean gameActive = true;

    public void tapToPlay(View view) {
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        if(!gameActive){
            reset(view);
        }
        if(gamestate[tappedImage] == 2 && gameActive){
            gamestate[tappedImage] = activePlayer;
            img.setTranslationY(-1000f);
            if(activePlayer == 0){
                img.setImageResource(R.drawable.x);
                activePlayer = 1;
                TextView status = findViewById(R.id.status);
                status.setText("O's Turn Tap to Play");
            }
            else{
                img.setImageResource(R.drawable.o);
                activePlayer = 0;
                TextView status = findViewById(R.id.status);
                status.setText("X's Turn Tap to Play");
            }
            img.animate().translationYBy(1000f).setDuration(500);
        }
//        Check if anyone has won
        for(int []winPositions : winPosition){
            if(gamestate[winPositions[0]] == gamestate[winPositions[1]] && gamestate[winPositions[1]] == gamestate[winPositions[2]]
            && gamestate[winPositions[0]]!=2){
                String winnnerStr;
                if(gamestate[winPositions[0]] == 0){
                    gameActive =false;
                    winnnerStr = "X has won";
                    TextView status = findViewById(R.id.status);
                    status.setText(winnnerStr);
                }
                else{
                    gameActive = false;
                    winnnerStr = "O has won";
                    TextView status = findViewById(R.id.status);
                    status.setText(winnnerStr);
                }
            }
        }
    }

    public void reset(View view) {
        gameActive = true;
        activePlayer = 0;
        for(int i = 0; i < gamestate.length; i++) {
            gamestate[i] = 2;
        }
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(R.drawable.blank);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(R.drawable.blank);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(R.drawable.blank);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(R.drawable.blank);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(R.drawable.blank);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(R.drawable.blank);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(R.drawable.blank);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(R.drawable.blank);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(R.drawable.blank);
        TextView status = findViewById(R.id.status);
        status.setText("X's Turn Tap to Play");
    }
}
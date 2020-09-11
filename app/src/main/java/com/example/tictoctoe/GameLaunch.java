package com.example.tictoctoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.makeText;

public class GameLaunch extends AppCompatActivity implements View.OnClickListener {
    private Button[][] buttons = new Button[3][3];
    private boolean player1Turn = true;
    private int roundCount;

    private int player1points;
    private int player2points;

    private TextView textViewplayer1;
    private TextView textViewplayer2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_launch);
        textViewplayer1 = findViewById(R.id.text_View_p1);
        textViewplayer2 = findViewById(R.id.text_View_p2);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String buttonId = "button_" + i + j;
                int resId = getResources().getIdentifier(buttonId, "id", getPackageName());
                buttons[i][j] = findViewById(resId);
                buttons[i][j].setOnClickListener(this);
            }
        }
        Button buttonReset = findViewById(R.id.resetbtn);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }

    @Override
    public void onClick(View view) {
        if (!((Button) view).getText().toString().equals("")) {
            return;
        }
        if (player1Turn) {
            ((Button) view).setText("X");
        } else {
            ((Button) view).setText("0");

        }
        roundCount++;
        if (checkForWin()){
            if (player1Turn){
                player1Wins();
            }else {
                player2Wins();
            }
        }else if (roundCount ==9){
            draw();
        }else {
            player1Turn =!player1Turn;
        }


    }

    private boolean checkForWin() {
        String[][] field = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = buttons[i][j].getText().toString();
            }
        }
        for (int i = 0; i < 3; i++) {
            if (field[i][0].equals(field[i][1])
                    && field[i][0].equals(field[i][2])
                    && !field[i][0].equals("")) {
                return true;

            }
        }
        if (field[0][0].equals(field[1][1])
                && field[0][0].equals(field[2][2])
                && !field[0][0].equals("")) {
            return true;
        }
        if (field[0][2].equals(field[1][1])
                && field[0][2].equals(field[2][0])
                && !field[0][2].equals("")) {
            return true;
        }
        return false;
    }
    private void player1Wins(){
        player1points++;
        makeText(this,"Player 1 win",Toast.LENGTH_SHORT).show();
        updatePointText();
        resetBoard();
    }

    private void player2Wins()
    {
        player2points++;
        makeText(this,"Player 2 win",Toast.LENGTH_SHORT).show();
        updatePointText();
        resetBoard();
    }
    private void draw(){
        makeText(this,"Draw",Toast.LENGTH_SHORT).show();
    }
    private void updatePointText(){
        textViewplayer1.setText("player 1:"+player1points);
        textViewplayer2.setText("player 2:"+player2points);
    }
    private void resetBoard(){
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                buttons[i][j].setText("");
            }
            roundCount =0;
            player1Turn =true;
        }
    }

}
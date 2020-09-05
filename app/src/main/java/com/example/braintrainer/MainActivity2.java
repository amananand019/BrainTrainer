package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {
    int totalAnswer, correctAnswer, tag;
    int correctTag;
    TextView correctAnswerRadio;
    TextView checkResult;
    TextView number1;
    TextView number2;
    boolean timerIsRunning;
    boolean checkForResult;
    Button button1, button2, button3, button4, playAgainButton;
    int random1, random2, sumAnswer;
    Random random;
    Button[] buttonArray = new Button[4];


    @Override
    public void onBackPressed() {

        finish();
        //super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        timerIsRunning = true;
        final TextView timer = (TextView)findViewById(R.id.timer);
        random = new Random();
        totalAnswer = 0;
        correctAnswer = 0;
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);
        playAgainButton = (Button)findViewById(R.id.playAgain);

        number1 = (TextView)findViewById(R.id.number1);
        number2 = (TextView)findViewById(R.id.number2);
        correctAnswerRadio = (TextView)findViewById(R.id.correctAnswerRatio);
        checkResult = (TextView)findViewById(R.id.checkResult);

        buttonArray[0] = button1;
        buttonArray[1] = button2;
        buttonArray[2] = button3;
        buttonArray[3] = button4;

        checkResult.setVisibility(View.INVISIBLE);
        playAgainButton.setVisibility(View.INVISIBLE);

        playAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(getIntent());
            }
        });

        CountDownTimer countDownTimer = new CountDownTimer(31000,1000){
            @Override
            public void onTick(long millisUntilFinished) {
                timer.setText(String.valueOf(millisUntilFinished/1000)+"s");
            }

            @Override
            public void onFinish() {
                timerIsRunning = false;
                playAgainButton.setVisibility(View.VISIBLE);
                button1.setClickable(false);
                button2.setClickable(false);
                button3.setClickable(false);
                button4.setClickable(false);
            }
        }.start();

            correctTag = createQuestion();

            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   if(correctTag == Integer.parseInt(button1.getTag().toString())){
                       correctAnswer++;
                       checkResult.setTextColor(getResources().getColor(R.color.white));
                       checkResult.setText("Correct");
                   } else {
                       checkResult.setTextColor(getResources().getColor(R.color.red));
                       checkResult.setText("Wrong");
                   }
                    correctAnswerRadio.setText(correctAnswer + "/" + totalAnswer);
                   correctTag = createQuestion();
                   checkResult.setVisibility(View.VISIBLE);
                }
            });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(correctTag == Integer.parseInt(button2.getTag().toString())){
                    correctAnswer++;
                    checkResult.setTextColor(getResources().getColor(R.color.white));
                    checkResult.setText("Correct");
                } else {
                    checkResult.setTextColor(getResources().getColor(R.color.red));
                    checkResult.setText("Wrong");
                }
                correctAnswerRadio.setText(correctAnswer + "/" + totalAnswer);
                correctTag = createQuestion();
                checkResult.setVisibility(View.VISIBLE);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(correctTag == Integer.parseInt(button3.getTag().toString())){
                    correctAnswer++;
                    checkResult.setTextColor(getResources().getColor(R.color.white));
                    checkResult.setText("Correct");
                } else {
                    checkResult.setTextColor(getResources().getColor(R.color.red));
                    checkResult.setText("Wrong");
                }
                correctAnswerRadio.setText(correctAnswer + "/" + totalAnswer);
                correctTag = createQuestion();
                checkResult.setVisibility(View.VISIBLE);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(correctTag == Integer.parseInt(button4.getTag().toString())){
                    correctAnswer++;
                    checkResult.setTextColor(getResources().getColor(R.color.white));
                    checkResult.setText("Correct");
                } else {
                    checkResult.setTextColor(getResources().getColor(R.color.red));
                    checkResult.setText("Wrong");
                }
                correctAnswerRadio.setText(correctAnswer + "/" + totalAnswer);
                correctTag = createQuestion();
                checkResult.setVisibility(View.VISIBLE);
            }
        });

    }

    protected int createQuestion(){
        totalAnswer++;
        random1 = random.nextInt(50-1)+1;
        random2 = random.nextInt(50-1)+1;
        number1.setText(String.valueOf(random1));
        number2.setText(String.valueOf(random2));
        sumAnswer=random1+random2;
        tag = random.nextInt(5-1)+1;
        checkForResult = false;
        for(int i=0; i<4; i++){
            buttonArray[i].setText(String.valueOf(random.nextInt(100-11)+11));
            if(Integer.parseInt(buttonArray[i].getText().toString())==sumAnswer) {
                checkForResult = true;
                tag = Integer.parseInt(buttonArray[i].getTag().toString());
            }
        }
        if(checkForResult==false){
            getButton(tag).setText(String.valueOf(sumAnswer));
        }
        return tag;
    }

    protected Button getButton(int tag){
        if(tag==Integer.parseInt(button1.getTag().toString())){
            return button1;
        }else if(tag==Integer.parseInt(button2.getTag().toString())){
            return button2;
        }else if(tag==Integer.parseInt(button3.getTag().toString())){
            return button3;
        }
        else {
            return button4;
        }
    }

}
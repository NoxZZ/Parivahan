package com.example.gautamnair.myapplication;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Random;

public class mt extends AppCompatActivity {
    private TextView textViewCountDown;
    private QuestionLibrary mQuestionLibrary = new QuestionLibrary();
    private  static  final long CountDownTimerInMilli=300000;
    private TextView mScoreView;
    private TextView mQuestionView;

    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button mButtonQuit;
    private String mAnswer;
    private int mScore=0;

    private ImageView mImageView;
    private int mQuestionNumber=0;
    private TextView QuestionNoview;

    private ColorStateList textColorDefaultCd;

    private CountDownTimer mCountDownTimer;
    private long lefttimeinmillis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mt);

        mScoreView=(TextView) findViewById(R.id.score);
        mQuestionView=(TextView)findViewById(R.id.question);
        mImageView = (ImageView)findViewById(R.id.imageid);
        mButtonChoice1=(Button) findViewById(R.id.choice1);
        mButtonChoice2=(Button) findViewById(R.id.choice2);
        mButtonChoice3=(Button) findViewById(R.id.choice3);
        QuestionNoview=findViewById(R.id.questionNo);
        textViewCountDown=findViewById(R.id.text_time) ;


        textColorDefaultCd =textViewCountDown.getTextColors();

        updateQuestion();
        startCountDown();
        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mButtonChoice1.getText()==mAnswer){
                    if(mQuestionNumber<11)
                        mScore=mScore+1;

                    else
                        mScore=mScore+2;
                    updateScore(mScore);
                    updateQuestion();
                    Toast.makeText(mt.this,"Correct",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(mt.this,"Wrong",Toast.LENGTH_SHORT).show();

                    updateQuestion();
                }

            }

        });

        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mButtonChoice2.getText()==mAnswer){
                    if(mQuestionNumber<11)
                        mScore=mScore+1;
                    else
                        mScore=mScore+2;
                    updateScore(mScore);
                    updateQuestion();
                    Toast.makeText(mt.this,"Correct",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(mt.this,"Wrong",Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }

            }

        });

        mButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mButtonChoice3.getText()==mAnswer){
                    if(mQuestionNumber<11)
                        mScore=mScore+1;

                    else
                        mScore=mScore+2;
                    updateScore(mScore);
                    updateQuestion();
                    Toast.makeText(mt.this,"Correct",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(mt.this,"Wrong",Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }

        });



    }

    private void updateQuestion() {
        if(mQuestionNumber<mQuestionLibrary.getlength()) {
            mQuestionView.setText(mQuestionLibrary.getquestion(mQuestionNumber));
            mButtonChoice1.setText(mQuestionLibrary.getChoice1(mQuestionNumber));
            mButtonChoice2.setText(mQuestionLibrary.getChoice2(mQuestionNumber));
            mButtonChoice3.setText(mQuestionLibrary.getChoice3(mQuestionNumber));
            QuestionNoview.setText("Question : " + (mQuestionNumber + 1) + "/15");
            if(mQuestionNumber>9)
                mImageView.setImageDrawable(getResources().getDrawable(mQuestionLibrary.getImage(mQuestionNumber)));

            mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
            lefttimeinmillis=CountDownTimerInMilli;
            mQuestionNumber++;
        }
        else
        {
            mCountDownTimer.cancel();
            Intent i =new Intent(mt.this,fmt.class);
            i.putExtra("Score" , mScore);
            startActivity(i);
            finish();
        }


    }
    private void updateScore(int score) {
        mScoreView.setText("" + mScore);
    }

    private void startCountDown()
    {
        mCountDownTimer=new CountDownTimer(lefttimeinmillis,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                lefttimeinmillis=millisUntilFinished;
                updateCountdownText();
            }

            @Override
            public void onFinish() {

                lefttimeinmillis=0;
                updateCountdownText();
                updateQuestion();
                Intent i =new Intent(mt.this,fmt.class);
                i.putExtra("Score",mScore);
                startActivity(i);
                finish();
            }
        }.start();
    }

    private void updateCountdownText()
    {
        int minutes=(int)(lefttimeinmillis/1000) /60;
        int seconds=(int)(lefttimeinmillis/1000) % 60;

        String timeFormatted=String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);
        textViewCountDown.setText(timeFormatted);

        if(lefttimeinmillis<10000){
            textViewCountDown.setTextColor(Color.RED);
        }
        else{
            textViewCountDown.setTextColor(textColorDefaultCd);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (mCountDownTimer != null) {
            mCountDownTimer.cancel();
        }
    }
}

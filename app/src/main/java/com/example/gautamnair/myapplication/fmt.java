package com.example.gautamnair.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class fmt extends AppCompatActivity {
    private TextView Score ;
    private Button restartbtn,exitbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fmt);

        Score = findViewById(R.id.textView);
        restartbtn=(Button)findViewById(R.id.restart);
        exitbtn=findViewById(R.id.exit);

        int score_no = getIntent().getExtras().getInt("Score");
        if(score_no>=15){
            Score.setText("Congratulations you've passed! Your score is "+score_no);
        }
        else
        Score.setText("Your Score is : " + score_no+". Better luck next time!");


        restartbtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i =new Intent(fmt.this,smt.class);
                startActivity(i);
            }
        });

        exitbtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

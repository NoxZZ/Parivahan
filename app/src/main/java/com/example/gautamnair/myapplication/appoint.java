package com.example.gautamnair.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

public class appoint extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appoint);
        final RadioGroup r1=findViewById(R.id.radio);
        r1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                View radioButton=r1.findViewById(i);
                int index=r1.indexOfChild(radioButton);
                switch (index){
                    case 0:
                        Intent i1=new Intent(appoint.this,nll.class);
                        startActivity(i1);
                        break;
                    case 1:
                        Intent i2=new Intent(appoint.this,login.class);
                        i2.putExtra("act",1);
                        startActivity(i2);
                        break;
                    case 2:
                        Intent i3=new Intent(appoint.this,login.class);
                        i3.putExtra("act",2);
                        startActivity(i3);
                        break;
                }
            }
        });
    }
}

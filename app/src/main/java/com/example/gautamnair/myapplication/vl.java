package com.example.gautamnair.myapplication;

import android.Manifest;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class vl extends AppCompatActivity {

    private EditText e1;
    private Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vl);
        e1=findViewById(R.id.editText3);
        b=findViewById(R.id.button2);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n=e1.getText().toString();
                if(n.isEmpty()) {
                    // Toast.makeText(vl.this,"Please enter registration number",Toast.LENGTH_SHORT).show();
                    e1.setError("Cannot be empty!");
                }
                else{
                    startActivity(new Intent(vl.this, vd.class));
                }

            }
        });
    }
}

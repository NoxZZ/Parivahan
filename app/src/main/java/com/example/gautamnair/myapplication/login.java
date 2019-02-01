package com.example.gautamnair.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText e1;
    private EditText e2;

    private Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        e1=findViewById(R.id.editText);
        e2=findViewById(R.id.editText2);
        b1=findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startLogIn();
            }
        });
    }

    public void startLogIn(){
        String e=e1.getText().toString().trim();
        String p=e2.getText().toString().trim();

        if(e.isEmpty() || p.isEmpty())
        {
            /*Toast.makeText(login.this, "All the fields are mandatory.",
                    Toast.LENGTH_SHORT).show();*/
            if (e.isEmpty()){
                e1.setError("Cannot be empty!");
            }
            if(p.isEmpty()){
                e2.setError("Cannot be empty!");
            }
        }
        else {
            String email=e1.getText().toString().trim();
            String password=e2.getText().toString().trim();
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(login.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(login.this, "Logged In.",Toast.LENGTH_SHORT).show();
                        int check_act = getIntent().getExtras().getInt("act");
                        if (check_act == 1) {
                            startActivity(new Intent(login.this, ndl.class));
                        }else if(check_act == 2){
                            startActivity(new Intent(login.this, ar.class));
                        }
                    } else {
                        Toast.makeText(login.this, "Authentication failed.",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}

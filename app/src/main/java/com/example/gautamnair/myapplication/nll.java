package com.example.gautamnair.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class nll extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private String ApplicationID;
    private EditText e1;
    private EditText e2;
    private EditText e3;
    private EditText e4;
    private EditText e5;
    private EditText e6;
    private EditText e7;
    private EditText e8;
    private EditText e9;
    private EditText e10;
    private RadioGroup r1;
    private RadioGroup r2;
    private Button b1;
    private Button b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nll);
        mAuth = FirebaseAuth.getInstance();
        final FirebaseFirestore db = FirebaseFirestore.getInstance();
        e1=findViewById(R.id.email);
        e2=findViewById(R.id.password);
        e3=findViewById(R.id.password1);
        e4=findViewById(R.id.first);
        e5=findViewById(R.id.middle);
        e6=findViewById(R.id.last);
        e7=findViewById(R.id.address);
        e8=findViewById(R.id.aadharno);
        e9=findViewById(R.id.contactno);
        e10=findViewById(R.id.ID);
        r1=findViewById(R.id.gender);
        r2=findViewById(R.id.type);
        b1=findViewById(R.id.submitbtn);
        b2=findViewById(R.id.proceedbtn);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String first=e4.getText().toString().trim();
                final String middle=e5.getText().toString().trim();
                final String last=e6.getText().toString().trim();
                String e=e1.getText().toString().trim();
                String p=e2.getText().toString().trim();
                String p1=e3.getText().toString().trim();
                final String address=e7.getText().toString().trim();
                final String aadharno=e8.getText().toString().trim();
                final String contactno=e9.getText().toString().trim();

                if(first.isEmpty() || middle.isEmpty() || last.isEmpty() || e.isEmpty() || p.isEmpty() || p1.isEmpty() || address.isEmpty() || aadharno.isEmpty() || contactno.isEmpty() || !p.equals(p1)){

                    if (first.isEmpty()) {
                        e4.setError("Cannot be empty!");
                    }
                    if (middle.isEmpty()) {
                        e5.setError("Cannot be empty!");
                    }
                    if (last.isEmpty()) {
                        e6.setError("Cannot be empty!");
                    }
                    if (e.isEmpty()) {
                        e1.setError("Cannot be empty!");
                    }
                    if (p.isEmpty()) {
                        e2.setError("Cannot be empty!");
                    }
                    if (p1.isEmpty()) {
                        e3.setError("Cannot be empty!");
                    }
                    if (!p.equals(p1)) {
                        e3.setError("Password didn't match!");
                    }
                    if (address.isEmpty()) {
                        e7.setError("Cannot be empty!");
                    }
                    if (aadharno.isEmpty()) {
                        e8.setError("Cannot be empty!");
                    }
                    if (contactno.isEmpty()) {
                        e9.setError("Cannot be empty!");
                    }
                }
                else{
                    final String email=e1.getText().toString().trim();
                    String password=e2.getText().toString().trim();

                    mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(nll.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                storeData();
                                generateID();

                            } else {
                                Toast.makeText(nll.this, "Authentication failed.",Toast.LENGTH_SHORT).show();
                            }// ...
                        }

                        private void generateID() {
                            int getselID=r2.getCheckedRadioButtonId();
                            RadioButton selectedRb=(RadioButton)findViewById(getselID);
                            String radioText=selectedRb.getText().toString();
                            String appID=getID(aadharno,radioText);
                           // Toast.makeText(nll.this,appID,Toast.LENGTH_SHORT).show();
                            e10.setText("Your Application ID : "  + appID);
                            appID=ApplicationID;
                        }

                        private String getID(String aadharno, String radioText) {
                            return ("LL" + aadharno.charAt(0) + aadharno.charAt(4) + aadharno.charAt(8) + radioText);
                        }

                        private void storeData() {
                            Map<String, String> user = new HashMap<>();
                            user.put("First name", first);
                            user.put("Middle name", middle);
                            user.put("Last name", last);
                            user.put("Email ID",email);
                            user.put("Contact no.",contactno);
                            user.put("Address",address);
                            user.put("Aadhar No.",aadharno);

                            db.collection("Database").add(user).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                @Override
                                public void onSuccess(DocumentReference documentReference) {
                                    Toast.makeText(nll.this,"Data stored to Firestore",Toast.LENGTH_SHORT).show();
                                   }
                            });
                        }
                    });
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(nll.this,sb.class));
            }
        });
    }
}

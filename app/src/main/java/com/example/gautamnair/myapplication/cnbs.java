package com.example.gautamnair.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class cnbs extends AppCompatActivity {

    private EditText e1;
    private EditText e2;
    private Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cnbs);

        e1 = findViewById(R.id.editText);
        e2 = findViewById(R.id.editText2);
        b = findViewById(R.id.button);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ID = e1.getText().toString();
                String num = e2.getText().toString();
                FirebaseFirestore ff = FirebaseFirestore.getInstance();
                Map<String, String> user = new HashMap<>();
                user.put(ID, num);

                ff.collection("Choice Number").add(user).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(cnbs.this, "Data stored to Firestore", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}

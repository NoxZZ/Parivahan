package com.example.gautamnair.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

public class sd extends AppCompatActivity {

    private EditText e1;
    private Button b1;
    final FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sd);
        e1=findViewById(R.id.editText);
        b1=findViewById(R.id.proceedbtn);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String test=e1.getText().toString().trim();
                if(test.isEmpty())
                {
                    e1.setError("Cannot be empty!");
                }

            db.collection(test).document("8aAPHwUdRWoVI9wJnA1f").delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(sd.this,"Slot Deleted.",Toast.LENGTH_SHORT).show();;
                    finish();
                }
            });
            }
        });


    }
}

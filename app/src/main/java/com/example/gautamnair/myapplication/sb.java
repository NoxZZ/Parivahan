package com.example.gautamnair.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class sb extends AppCompatActivity {

    private EditText e1;
    private Button b1;
    private int d,m,y;
    private String date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sb);
        final FirebaseFirestore db = FirebaseFirestore.getInstance();
        e1=findViewById(R.id.editText);
        b1=findViewById(R.id.button3);
        CalendarView calendarView=findViewById(R.id.calendarView2);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                Toast.makeText(getApplicationContext(),"Slot chosen is "+i2+"/"+(i1+1)+"/"+i,0).show();
                d=i2;
                m=i1;
                y=i;
                date=d+"/"+(m+1)+"/"+y;
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ID=e1.getText().toString().trim();

                Map<String, String> user = new HashMap<>();
                user.put(ID, date);

                db.collection(ID).add(user).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(sb.this,"Data stored to Firestore",Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
            }
        });
    }
}

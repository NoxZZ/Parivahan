package com.example.gautamnair.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class ndl extends AppCompatActivity {

    private EditText e1,e2;
    private Button b1,b2;
    private int d,m,y;
    private String date;
    private String dappid="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ndl);
        final FirebaseFirestore db = FirebaseFirestore.getInstance();
        e1=findViewById(R.id.editText);
        b1=findViewById(R.id.button3);
        b2=findViewById(R.id.proceedbtn);
        e2=findViewById(R.id.ID);
        CalendarView calendarView=findViewById(R.id.calendarView2);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {

                Toast.makeText(ndl.this, dappid,Toast.LENGTH_SHORT).show();
                //Toast.makeText(getApplicationContext(),"Slot chosen is "+i2+"/"+i1+"/"+i, 0).show();
                d=i2;
                m=i1;
                y=i;
                date=d+"/"+(m+1)+"/"+y;
                Toast.makeText(getApplicationContext(),"Slot chosen is "+date, 0).show();
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String lappid=e1.getText().toString().trim();
                dappid= "D" + lappid.substring(1);

                if(lappid.isEmpty())
                {
                    e1.setError("Cannot be empty!");
                }

                e2.setText("Your Application ID : "  +dappid);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String, String> user = new HashMap<>();
                user.put(dappid,date);

                db.collection(dappid).add(user).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(ndl.this,"Data stored to Firestore",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
}

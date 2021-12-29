package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GiveFeedback extends AppCompatActivity {
Button b1;
    EditText oid,feebback;
    DBHelper_Feedback DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_give_feedback);

        DB=new DBHelper_Feedback(this);

        b1=(Button)findViewById(R.id.b1);

        oid=(EditText)findViewById(R.id.et1);
        feebback=(EditText)findViewById(R.id.et2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(oid.getText().toString().isEmpty()||feebback.getText().toString().isEmpty())
                {
                    if (oid.getText().toString().isEmpty())
                        oid.setError("*Please enter your name");
                    if (feebback.getText().toString().isEmpty())
                        feebback.setError("*Please enter your phone");}
                else{

                    String oidtxt = oid.getText().toString();
                    String feedbacktxt = feebback.getText().toString();

                    Boolean checkinsertdata = DB.insertdata(oidtxt,feedbacktxt);
                    if (checkinsertdata == true) {


                        Toast.makeText(GiveFeedback.this, "Feedback Sent.", Toast.LENGTH_SHORT).show();
                    }else
                        Toast.makeText(GiveFeedback.this, "Error.", Toast.LENGTH_SHORT).show();


                }
                oid.getText().clear();
                feebback.getText().clear();
                }


        });



    }
}
package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Buy_food extends AppCompatActivity {
    Button b1,b2,b3,b4;
    EditText q1,q2,q3,q4;
    public static final String EXTRA_q1 = "com.example.foodapp.q1";
    public static final String EXTRA_pro1 = "";
    public static final String EXTRA_p1 = "com.example.foodapp.p1";
    public static final String EXTRA_amt1 = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_food);

        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);
        b4=(Button)findViewById(R.id.b4);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openac1();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openac2();
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openac3();
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openac4();
            }
        });
    }

    public void openac1(){

        Intent intent=new Intent(Buy_food.this,Confirm_order.class);
        q1=(EditText)findViewById(R.id.q1);
        q2=(EditText)findViewById(R.id.q2);
        q3=(EditText)findViewById(R.id.q3);
        q4=(EditText)findViewById(R.id.q4);
        if(q1.getText().toString().isEmpty())
            q1.setError("Error");
        else {
            String eq1 = q1.getText().toString();
            Integer amt = 150 * (Integer.parseInt(eq1));
            intent.putExtra(EXTRA_q1, eq1);
            intent.putExtra(EXTRA_pro1, "Pizza");
            intent.putExtra(EXTRA_p1, "150");
            intent.putExtra(EXTRA_amt1, String.valueOf(amt));
            q1.getText().clear();
            q2.getText().clear();
            q3.getText().clear();
            q4.getText().clear();
            startActivity(intent);
        }
    }

    public void openac2(){
        Intent intent=new Intent(this,Confirm_order.class);
        q1=(EditText)findViewById(R.id.q1);
        q2=(EditText)findViewById(R.id.q2);
        q3=(EditText)findViewById(R.id.q3);
        q4=(EditText)findViewById(R.id.q4);
        if(q2.getText().toString().isEmpty())
            q2.setError("Error");
        else {
            String eq1 = q2.getText().toString();
            Integer amt = 100 * (Integer.parseInt(eq1));
            intent.putExtra(EXTRA_q1, eq1);
            intent.putExtra(EXTRA_pro1, "Burger");
            intent.putExtra(EXTRA_p1, "100");
            intent.putExtra(EXTRA_amt1, String.valueOf(amt));
            q1.getText().clear();
            q2.getText().clear();
            q3.getText().clear();
            q4.getText().clear();
            startActivity(intent);
        }
    }

    public void openac3(){
        Intent intent=new Intent(this,Confirm_order.class);
        q1=(EditText)findViewById(R.id.q1);
        q2=(EditText)findViewById(R.id.q2);
        q3=(EditText)findViewById(R.id.q3);
        q4=(EditText)findViewById(R.id.q4);
        if(q3.getText().toString().isEmpty())
            q3.setError("Error");
        else {
            String eq1 = q3.getText().toString();
            Integer amt = 250 * (Integer.parseInt(eq1));
            intent.putExtra(EXTRA_q1, eq1);
            intent.putExtra(EXTRA_pro1, "Pasta");
            intent.putExtra(EXTRA_p1, "250");
            intent.putExtra(EXTRA_amt1, String.valueOf(amt));
            q1.getText().clear();
            q2.getText().clear();
            q3.getText().clear();
            q4.getText().clear();
            startActivity(intent);
        }
    }

    public void openac4(){
        Intent intent=new Intent(this,Confirm_order.class);
        q1=(EditText)findViewById(R.id.q1);
        q2=(EditText)findViewById(R.id.q2);
        q3=(EditText)findViewById(R.id.q3);
        q4=(EditText)findViewById(R.id.q4);
        if(q4.getText().toString().isEmpty())
            q4.setError("Error");
        else {
            String eq1 = q4.getText().toString();
            Integer amt = 200 * (Integer.parseInt(eq1));
            intent.putExtra(EXTRA_q1, eq1);
            intent.putExtra(EXTRA_pro1, "Oreo Shake");
            intent.putExtra(EXTRA_p1, "200");
            intent.putExtra(EXTRA_amt1, String.valueOf(amt));
            q1.getText().clear();
            q2.getText().clear();
            q3.getText().clear();
            q4.getText().clear();
            startActivity(intent);
        }
    }
}
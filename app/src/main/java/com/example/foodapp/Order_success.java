package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Order_success extends AppCompatActivity {
Button b1;
String oid;
TextView t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_success);

        oid=getIntent().getStringExtra(Confirm_order.EXTRA_oid);

        b1=(Button)findViewById(R.id.b1);

        t2=(TextView) findViewById(R.id.t2);
        t2.setText("Order ID : "+oid);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openac6();
            }
        });
    }
    public void openac6(){
        Intent intent=new Intent(this,Login_Successful.class);
        startActivity(intent);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }
}
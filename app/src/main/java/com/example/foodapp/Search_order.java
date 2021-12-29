package com.example.foodapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Search_order extends AppCompatActivity {
Button b1;
EditText et1;
DBHelper_Order DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_order);

        b1=(Button)findViewById(R.id.b1);
        et1=(EditText)findViewById(R.id.et1);
        DB=new DBHelper_Order(this);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et1.getText().toString().isEmpty())
                    et1.setError("*Please Enter your order id");

                else{



                    String phone=et1.getText().toString();
                    Cursor res = DB.searchdata(phone);
                    if (res.getCount() == 0) {
                        Toast.makeText(Search_order.this, "order not found.", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    StringBuffer buffer = new StringBuffer();
                    while (res.moveToNext()){
                        buffer.append("Order ID: "+res.getString(0)+"\n");
                        buffer.append("Name: "+res.getString(1)+"\n");
                        buffer.append("Phone: "+res.getString(2)+"\n");
                        buffer.append("City: "+res.getString(3)+"\n");
                        buffer.append("Address: "+res.getString(4)+"\n");
                        buffer.append("Product: "+res.getString(5)+"\n");
                        buffer.append("Price: Rs."+res.getString(6)+"\n");
                        buffer.append("Quantity: "+res.getString(7)+"\n");
                        buffer.append("Total Amount : Rs."+res.getString(8)+"\n\n");

                    }
                    AlertDialog.Builder builder=new AlertDialog.Builder(Search_order.this);
                    builder.setCancelable(true);
                    builder.setTitle("Order Details");
                    builder.setMessage(buffer.toString());
                    builder.show();






                }
                et1.getText().clear();


            }
        });
    }
}
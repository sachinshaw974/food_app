package com.example.foodapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Admin_Page extends AppCompatActivity {
    SharedPreferences prf;
    Button b1,b2;
    DBHelper_Order DB;
    DBHelper_Feedback DB1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__page);

        prf = getSharedPreferences("user_details",MODE_PRIVATE);

        DB=new DBHelper_Order(this);
        DB1=new DBHelper_Feedback(this);

        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = DB.fetchdata();
                if (res.getCount() == 0) {
                    Toast.makeText(Admin_Page.this, "No order found.", Toast.LENGTH_SHORT).show();
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
                AlertDialog.Builder builder=new AlertDialog.Builder(Admin_Page.this);
                builder.setCancelable(true);
                builder.setTitle("All Orders Details");
                builder.setMessage(buffer.toString());
                builder.show();

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = DB1.fetchdata();
                if (res.getCount() == 0) {
                    Toast.makeText(Admin_Page.this, "No feedback found.", Toast.LENGTH_SHORT).show();
                    return;
                }


                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()){
                    buffer.append("Order ID: "+res.getString(0)+"\n");
                    buffer.append("Feedback: "+res.getString(1)+"\n\n");

                }
                AlertDialog.Builder builder=new AlertDialog.Builder(Admin_Page.this);
                builder.setCancelable(true);
                builder.setTitle("All Feedbacks");
                builder.setMessage(buffer.toString());
                builder.show();

            }
        });
    }







    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:{
                Toast.makeText(Admin_Page.this,"Logout Successful.",Toast.LENGTH_SHORT).show();
                SharedPreferences.Editor editor = prf.edit();
                editor.clear();
                editor.commit();
                openac1();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    public void openac1(){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }
}
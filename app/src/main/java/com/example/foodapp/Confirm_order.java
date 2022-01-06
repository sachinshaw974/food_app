package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Confirm_order extends AppCompatActivity {
TextView t6,t7,t8,t9;
Button b1;
EditText name,phone,city,addr;
DBHelper_Order DB;
String pro1,p1,eq1,amt1,oidtxt1;
    public static final String EXTRA_oid = "";
    public String uid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order);


        DB=new DBHelper_Order(this);

        b1=(Button)findViewById(R.id.b1);
        
        name=(EditText)findViewById(R.id.et1);
        phone=(EditText)findViewById(R.id.et2);
        city=(EditText)findViewById(R.id.et3);
        addr=(EditText)findViewById(R.id.et4);


        t6=(TextView)findViewById(R.id.t6);
        t7=(TextView)findViewById(R.id.t7);
        t8=(TextView)findViewById(R.id.t8);
        t9=(TextView)findViewById(R.id.t9);



        pro1=getIntent().getStringExtra(Buy_food.EXTRA_pro1);
        p1=getIntent().getStringExtra(Buy_food.EXTRA_p1);
        eq1=getIntent().getStringExtra(Buy_food.EXTRA_q1);
        amt1=getIntent().getStringExtra(Buy_food.EXTRA_amt1);
        oidtxt1="OD"+getuid();

        t6.setText("Product : "+pro1);
        t7.setText("Price : Rs. "+p1);
        t8.setText("Quantity : "+eq1);
        t9.setText("Amount : Rs. "+amt1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = phone.getText().toString();

                    if (name.getText().toString().isEmpty() || phone.getText().toString().isEmpty()
                            || city.getText().toString().isEmpty() || addr.getText().toString().isEmpty()) {
                        if (name.getText().toString().isEmpty())
                            name.setError("*Please enter your name");
                        if (phone.getText().toString().isEmpty())
                            phone.setError("*Please enter your phone");
                        if (city.getText().toString().isEmpty())
                            city.setError("*Please enter your city");
                        if (addr.getText().toString().isEmpty())
                            addr.setError("*Please enter your address");
                    } else {
                        if (is_valid(n)) {


                        String oidtxt = oidtxt1;
                        String nametxt = name.getText().toString();
                        String phonetxt = phone.getText().toString();
                        String citytxt = city.getText().toString();
                        String addrtxt = addr.getText().toString();
                        String protxt = pro1;
                        String ptxt = p1;
                        String qtytxt = eq1;
                        String amounttxt = amt1;

                        Boolean checkinsertdata = DB.insertdata(oidtxt, nametxt, phonetxt, citytxt, addrtxt, protxt, ptxt, qtytxt, amounttxt);
                        if (checkinsertdata == true) {

                            openac1();
                            Toast.makeText(Confirm_order.this, "Order Successfull.", Toast.LENGTH_SHORT).show();
                        } else
                            Toast.makeText(Confirm_order.this, "Error.", Toast.LENGTH_SHORT).show();


                            name.getText().clear();
                            phone.getText().clear();
                            city.getText().clear();
                            addr.getText().clear();
                    }
                        else {
                            phone.setError("*Please enter your valid phone no.");
                        }
                }
            }



        });



    }


    public void openac1(){
        Intent intent=new Intent(this,Order_success.class);
        intent.putExtra(EXTRA_oid, oidtxt1);
        startActivity(intent);
    }

    String getuid(){
        int max=100000;
        int min =1;
        Random randomNum=new Random();
        int s=min+randomNum.nextInt(max);
        uid= String.valueOf(s);
        return uid;
    }
    public  static boolean is_valid(String str){
        Pattern ptrn=Pattern.compile("[6-9][0-9]{9}");
        Matcher match =ptrn.matcher(str);
        return (match.find()&&match.group().equals(str));
    }
}
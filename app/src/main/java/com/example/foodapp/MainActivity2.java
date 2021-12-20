package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.*;
import android.os.Bundle;

public class MainActivity2 extends AppCompatActivity  {
    //String[] city = { "Kolkata", "Delhi", "Mumbai"};

    Button b1,b2;
    DBHelper DB;
    EditText name,uname,pass,email,phone,city,addr;



    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        name=findViewById(R.id.et1);
        uname=findViewById(R.id.et2);
        pass=findViewById(R.id.et3);
        email=findViewById(R.id.et4);
        phone=findViewById(R.id.et5);
        city=findViewById(R.id.et6);
        addr=findViewById(R.id.et7);

        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);

        DB=new DBHelper(this);

        /*Spinner spin = (Spinner) findViewById(R.id.s1);
        spin.setOnItemSelectedListener(this);
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,city);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);*/

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name.getText().toString().isEmpty()||uname.getText().toString().isEmpty()
                        ||pass.getText().toString().isEmpty()||email.getText().toString().isEmpty()
                        ||phone.getText().toString().isEmpty()||city.getText().toString().isEmpty()
                        ||addr.getText().toString().isEmpty()) {
                    if (name.getText().toString().isEmpty())
                        name.setError("*Please enter your name");
                    if (uname.getText().toString().isEmpty())
                        uname.setError("*Please enter your username");
                    if (pass.getText().toString().isEmpty())
                        pass.setError("*Please enter your password");
                    if (email.getText().toString().isEmpty())
                        email.setError("*Please enter your email-id");
                    if (phone.getText().toString().isEmpty())
                        phone.setError("*Please enter your phone number");
                    if (city.getText().toString().isEmpty())
                        city.setError("*Please enter your city");
                    if (addr.getText().toString().isEmpty())
                        addr.setError("*Please enter your address");
                }
                else {

                    String nametxt = name.getText().toString();
                    String unametxt = uname.getText().toString();
                    String passtxt = pass.getText().toString();
                    String emailtxt = email.getText().toString();
                    String phonetxt = phone.getText().toString();
                    String citytxt = city.getText().toString();
                    String addrtxt = addr.getText().toString();


                    Boolean checkinsertdata = DB.insertdata(nametxt, unametxt, passtxt, emailtxt, phonetxt, citytxt, addrtxt);
                    if (checkinsertdata == true)
                        Toast.makeText(MainActivity2.this, "Registration Complete.", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(MainActivity2.this, "Not registered.", Toast.LENGTH_SHORT).show();


                }
                name.getText().clear();
                uname.getText().clear();
                pass.getText().clear();
                email.getText().clear();
                phone.getText().clear();
                city.getText().clear();
                addr.getText().clear();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openac1();
            }
        });

    }

    public void openac1(){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void ShowHidePass(View view){

        if(view.getId()==R.id.show_pass_btn){


            if(pass.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())){
                ((ImageView)(view)).setImageResource(R.drawable.view);

                //Show Password
                pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            }
            else{
                ((ImageView)(view)).setImageResource(R.drawable.hidden);

                //Hide Password
                pass.setTransformationMethod(PasswordTransformationMethod.getInstance());

            }
        }
    }


    /*@Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }*/
}
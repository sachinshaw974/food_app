package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.*;
import android.os.Bundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
                String n = phone.getText().toString();
                String eml = email.getText().toString();
                String pas = pass.getText().toString();



                    if (name.getText().toString().isEmpty() || uname.getText().toString().isEmpty()
                            || pass.getText().toString().isEmpty() || email.getText().toString().isEmpty()
                            || phone.getText().toString().isEmpty() || city.getText().toString().isEmpty()
                            || addr.getText().toString().isEmpty()) {
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
                    } else {
                        if ((is_emailValid(eml)==false) && (is_valid(n)==false) && (isValidPassword(pas)==false)){

                            pass.setError("*Please enter your valid pass \n " +
                                    "It contains at least 8 characters and at most 20 characters.\n" +
                                    "It contains at least one digit.\n" +
                                    "It contains at least one upper case alphabet.\n" +
                                    "It contains at least one lower case alphabet.\n" +
                                    "It contains at least one special character which includes !@#$%&*()-+=^.\n" +
                                    "It doesn’t contain any white space.");


                            email.setError("*Please enter your valid email-id");


                            phone.setError("*Please enter your valid phone number");


                        }

                        if (is_emailValid(eml) || is_valid(n) || isValidPassword(pas)) {


                            if (is_emailValid(eml) && is_valid(n) && isValidPassword(pas)) {


                                String nametxt = name.getText().toString();
                                String unametxt = uname.getText().toString();
                                String passtxt = pass.getText().toString();
                                String emailtxt = email.getText().toString();
                                String phonetxt = phone.getText().toString();
                                String citytxt = city.getText().toString();
                                String addrtxt = addr.getText().toString();


                                Boolean checkinsertdata = DB.insertdata(nametxt, unametxt, passtxt, emailtxt, phonetxt, citytxt, addrtxt);
                                if (checkinsertdata == true) {
                                    Toast.makeText(MainActivity2.this, "Registration Complete.", Toast.LENGTH_SHORT).show();
                                    openac1();
                                } else
                                    Toast.makeText(MainActivity2.this, "Not registered.", Toast.LENGTH_SHORT).show();


                                name.getText().clear();
                                uname.getText().clear();
                                pass.getText().clear();
                                email.getText().clear();
                                phone.getText().clear();
                                city.getText().clear();
                                addr.getText().clear();


                            } else {


                                //if ((is_emailValid(eml)==false) || (is_valid(n)==false) ||(isValidPassword(pas)==false)){
                                if (isValidPassword(pas) == false) {
                                    pass.setError("*Please enter your valid pass \n " +
                                            "It contains at least 8 characters and at most 20 characters.\n" +
                                            "It contains at least one digit.\n" +
                                            "It contains at least one upper case alphabet.\n" +
                                            "It contains at least one lower case alphabet.\n" +
                                            "It contains at least one special character which includes !@#$%&*()-+=^.\n" +
                                            "It doesn’t contain any white space.");
                                }
                                if (is_emailValid(eml) == false) {
                                    email.setError("*Please enter your valid email-id");
                                }
                                if (is_valid(n) == false) {
                                    phone.setError("*Please enter your valid phone number");
                                }



                            }


                        //}


                        }
                    }

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
    public  static boolean is_valid(String str){
        Pattern ptrn=Pattern.compile("[6-9][0-9]{9}");
        Matcher match =ptrn.matcher(str);
        return (match.find()&&match.group().equals(str));
    }
    public static boolean
    isValidPassword(String password)
    {
        // Regex to check valid password.
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";

        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        // If the password is empty
        // return false
        if (password == null) {
            return false;
        }

        // Pattern class contains matcher() method
        // to find matching between given password
        // and regular expression.
        Matcher m = p.matcher(password);

        // Return if the password
        // matched the ReGex
        return m.matches();
    }
    public static boolean is_emailValid(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
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
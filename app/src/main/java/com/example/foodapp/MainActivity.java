package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText uname,pass;
Button b1,b2;
DBHelper DB;
SQLiteDatabase db;
SQLiteOpenHelper dbh;
SharedPreferences pref;

Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);

        uname=findViewById(R.id.et1);
        pass=findViewById(R.id.et2);

        DB=new DBHelper(this);
        dbh=new DBHelper(this);
        db=dbh.getReadableDatabase();

        pref = getSharedPreferences("user_details",MODE_PRIVATE);

        if(pref.contains("username") && pref.contains("password")){
            openac3();
        }
        else if(pref.contains("ausername") && pref.contains("apassword")){
            openac7();
        }

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (uname.getText().toString().isEmpty() ||
                        pass.getText().toString().isEmpty()) {
                    if (uname.getText().toString().isEmpty())
                        uname.setError("*Please enter your username");
                    if (pass.getText().toString().isEmpty())
                        pass.setError("*Please enter your password");
                }
                else {
                    String _uname=uname.getText().toString();
                    String _pass=pass.getText().toString();

                    cursor=db.rawQuery("SELECT * FROM detail WHERE uname=? AND pass=?",new String[]{_uname,_pass});

                    if(cursor!=null||(_uname.equalsIgnoreCase("admin")&&_pass.equalsIgnoreCase("admin"))){
                        if(cursor.getCount()>0){
                            Toast.makeText(MainActivity.this, "Login Successful.", Toast.LENGTH_SHORT).show();

                            SharedPreferences.Editor editor = pref.edit();
                            editor.putString("username",_uname);
                            editor.putString("password",_pass);
                            editor.commit();

                            openac3();
                            uname.getText().clear();
                            pass.getText().clear();
                        }
                        else if(_uname.equalsIgnoreCase("admin")&&_pass.equalsIgnoreCase("admin")){
                            SharedPreferences.Editor editor = pref.edit();
                            editor.putString("ausername","admin");
                            editor.putString("apassword","admin");
                            editor.commit();
                            openac7();
                            uname.getText().clear();
                            pass.getText().clear();
                        }
                        else{
                            Toast.makeText(MainActivity.this, "User not registered./Wrong username or password.", Toast.LENGTH_SHORT).show();
                        }

                    }
                    else{
                        Toast.makeText(MainActivity.this, "User not registered./Wrong username or password.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openac2();
                uname.getText().clear();
                pass.getText().clear();
            }
        });
    }

    public  void openac2(){
        Intent intent=new Intent(this,MainActivity2.class);
        startActivity(intent);
    }
    public  void openac3(){
        Intent intent=new Intent(this,Login_Successful.class);
        startActivity(intent);
    }

    public  void openac7(){
        Intent intent=new Intent(this,Admin_Page.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
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

}
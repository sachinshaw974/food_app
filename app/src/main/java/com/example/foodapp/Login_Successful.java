package com.example.foodapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Login_Successful extends AppCompatActivity {

    Button b1,b2,b3;
    SharedPreferences prf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__successful);


        /*btnLogout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                logoutUser();
            }
        });
    }


    private void logoutUser() {
        session.setLogin(false);
        db.deleteUsers();
        Intent intent = new Intent(Activity_Main.this, Activity_Login.class);
        startActivity(intent);
        finish();
    }*/

        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);
        prf = getSharedPreferences("user_details",MODE_PRIVATE);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openac4();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openac5();
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openac6();
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
                Toast.makeText(Login_Successful.this,"Logout Successful.",Toast.LENGTH_SHORT).show();
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

    public void openac4(){
        Intent intent=new Intent(this,Buy_food.class);
        startActivity(intent);
    }

    public void openac5(){
        Intent intent=new Intent(this,Search_order.class);
        startActivity(intent);
    }

    public void openac6(){
        Intent intent=new Intent(this,GiveFeedback.class);
        startActivity(intent);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }
}

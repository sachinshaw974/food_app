package com.example.foodapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class Admin_Page extends AppCompatActivity {
    SharedPreferences prf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__page);

        prf = getSharedPreferences("user_details",MODE_PRIVATE);
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
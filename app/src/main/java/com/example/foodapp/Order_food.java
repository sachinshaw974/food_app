package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.pdf.PdfDocument;
import android.location.SettingInjectorService;
import android.os.Bundle;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.w3c.dom.Document;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.annotation.Documented;

public class Order_food extends AppCompatActivity {
Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_food);

        b1=(Button)findViewById(R.id.b1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openac5();
            }
        });
    }

    /*private void createPdf(String) throws FileNotFoundException{
        String pdfPath= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString();
        File file=new File(pdfPath,"Food_Order.pdf");
        OutputStream outputStream=new FileOutputStream(file);

        PdfWriter writer=new PdfWriter(file);
        PdfDocument pdfDocument=new PdfDocument(writer);
        Document document=new Document(pdfDocument);
        document.close();*/



    public void openac5(){
        Intent intent=new Intent(this,Order_success.class);
        startActivity(intent);
    }
}
package com.example.finalproject;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalDate;
import java.util.Calendar;

import static android.widget.Toast.LENGTH_LONG;

public class ItemActivity extends AppCompatActivity {

    private EditText itemName;
    private EditText itemPrice;
    private Button btnItemSubmit;
    final DBHelper db = new DBHelper(this);
    String id;
    LocalDate date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        init();
        date = LocalDate.now();
      final   String x = date.toString();
        btnItemSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.insertItem(id,itemName.getText().toString(),itemPrice.getText().toString());



            }
        });
    }

    public void init () {

        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        itemName = findViewById(R.id.item_name);
        itemPrice = findViewById(R.id.item_cost);
        btnItemSubmit = findViewById(R.id.btnSubmitItem);

    }


}
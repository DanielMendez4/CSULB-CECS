package com.example.finalproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.database.sqlite.SQLiteDatabase;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import android.widget.Toast.*;

import static android.widget.Toast.LENGTH_LONG;

public class SettingsActivity extends AppCompatActivity  {

    private EditText annualIncome;
    private EditText dailyExpenses;
    private EditText saveGoal;
  //  private EditText mEmail;
  //  private EditText mPhone;
    private Button mSubmit;
    private Button mItems;
    Context context;

    private AwesomeValidation awesomeValidation;

    // **************************************************************
    private  ArrayList<String> mItemList;
    private RecyclerView mItemRecycler;
    private ItemListAdapter mAdapter;
   String userid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        final DBHelper mydb = new DBHelper(this);
        Intent intent = getIntent();
         userid = intent.getStringExtra("id");
        final String id = userid;
        context = getApplicationContext();
        mSubmit = findViewById(R.id.btnSubmitSetting);
        annualIncome = findViewById(R.id.annual_hint);
        dailyExpenses = findViewById(R.id.daily_expense);
        saveGoal = findViewById(R.id.save_goal);
        mItems = findViewById(R.id.buttonExpenseItem);

        mItemList = mydb.getItemsAsList(id);
        mItemRecycler = findViewById(R.id.item_view);
        mAdapter = new ItemListAdapter(this, mItemList,Integer.valueOf(id));
        mItemRecycler.setAdapter(mAdapter);
        mItemRecycler.setLayoutManager(new LinearLayoutManager(this));

        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mydb.insertSetting(id,annualIncome.getText().toString(),dailyExpenses.getText().toString(),saveGoal.getText().toString());
                Toast.makeText(getApplicationContext(), "Sign up successful", LENGTH_LONG).show();
            }
        });

        mItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, ItemActivity.class);
                intent.putExtra("id", id.toString());
                startActivity(intent);
                Toast toast = Toast.makeText(getApplicationContext(), "settings!", Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }


    @Override
    public void onResume(){
        super.onResume();

        final DBHelper mydb = new DBHelper(this);
        mItemList = mydb.getItemsAsList(userid);
        mItemRecycler = findViewById(R.id.item_view);
        mAdapter = new ItemListAdapter(this, mItemList,Integer.valueOf(userid));
        mItemRecycler.setAdapter(mAdapter);

        mItemRecycler.setLayoutManager(new LinearLayoutManager(this));
        mAdapter.notifyDataSetChanged();
    }

}
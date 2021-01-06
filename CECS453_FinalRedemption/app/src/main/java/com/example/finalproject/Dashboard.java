package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalDate;
import java.util.ArrayList;

public class Dashboard extends AppCompatActivity {

    private TextView annualSaving;
    private TextView welcomeMsg;
    private TextView annualIncome;
    private TextView dailyExpense;
    private TextView desiredSaving;
    private TextView dailySaving;
    private Button mSetting;
    private Button mReports;
    String id;

    private ArrayList<String> mItemList;
    private RecyclerView mItemRecycler;
    private ItemPurchaseAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        try {
            buttonInit();
        } catch (Exception e ) {

        }
        final DBHelper db = new DBHelper(this);
        try {

            if(!getResources().getBoolean(R.bool.portrait_only)) {
                  FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

                    ft.replace(R.id.parent_fragment_container, new DailyExpenseChartFragment());
                    ft.commit();
            }




        } catch (Exception e ) {
            e.printStackTrace();


        }

        try {
            init();
        } catch (Exception e ) {

        }
        try {
            mSetting.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Dashboard.this, SettingsActivity.class);
                    intent.putExtra("id", id);
                    startActivity(intent);
                    Toast toast = Toast.makeText(getApplicationContext(), "settings!", Toast.LENGTH_LONG);
                    toast.show();
                }
            });

            mReports.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Dashboard.this, ReportSlideActivity.class);
                    intent.putExtra("id", id);
                    startActivity(intent);
                }
            });
        } catch (Exception e ) {

        }


    }

    @Override
    public void onResume(){
        super.onResume();
        try {
            LocalDate date;
            date = LocalDate.now();
            final   String x = date.toString();

            Toast toast = Toast.makeText(getApplicationContext(), x, Toast.LENGTH_LONG);
            toast.show();
            init();

        } catch (Exception e ) {

        }


    }

    public void buttonInit() {

        setContentView(R.layout.activity_dashboard);
        mSetting = findViewById(R.id.buttonSettings);
        mReports = findViewById(R.id.buttonReports);
        welcomeMsg = findViewById(R.id.txtDisplay);
        annualIncome = findViewById(R.id.annual_income_txt);
        dailyExpense = findViewById(R.id.daily_expenses_txt);
        desiredSaving = findViewById(R.id.desired_savings_txt);
        dailySaving = findViewById(R.id.daily_saving_txt);
        annualSaving = findViewById(R.id.annual_saving_txt);
        Intent intent = getIntent();
        id = intent.getStringExtra("id");

        welcomeMsg.setText(welcomeMsg.getText().toString() + " " + id.toString());

    }
    public void init(){

        final DBHelper mydb = new DBHelper(this);
        ArrayList<String> settings = mydb.getUserSettings(id);
        annualIncome.setText(settings.get(0));
        dailyExpense.setText(settings.get(1));
        desiredSaving.setText(settings.get(2));
        String dailySavingStr =  new Integer((Integer.valueOf(settings.get(0))/365)-Integer.valueOf(settings.get(1))).toString();
        dailySaving.setText(dailySavingStr);
        annualSaving.setText(Integer.valueOf(dailySavingStr)*365 + "");
        mItemList = mydb.getItemPurchaseList(id);
        mItemRecycler = findViewById(R.id.dash_item_view);
        mAdapter = new ItemPurchaseAdapter(this, mItemList,Integer.valueOf(id));
        mItemRecycler.setAdapter(mAdapter);
        mItemRecycler.setLayoutManager(new LinearLayoutManager(this));


    }
}
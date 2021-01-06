package com.example.finalproject;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.core.cartesian.series.Line;

import java.util.ArrayList;
import java.util.List;

public class DailySavingChartFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_daily_saving_chart, container, false);

        Cartesian line = AnyChart.line();
        line.title("Daily Savings");

        List<DataEntry> data = new ArrayList<>();
        data.add(new ValueDataEntry("Monday", 10000));
        data.add(new ValueDataEntry("Tuesday", 12000));
        data.add(new ValueDataEntry("Peter", 18000));

        line.data(data);
        AnyChartView anyChartView = rootView.findViewById(R.id.any_chart_view);
        anyChartView.setChart(line);
        return rootView;
    }

   /*
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public DailySavingChartFragment() {
        // Required empty public constructor
    }

    public static DailySavingChartFragment newInstance(String param1, String param2) {
        DailySavingChartFragment fragment = new DailySavingChartFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_daily_saving_chart, container, false);
    }
    */
}
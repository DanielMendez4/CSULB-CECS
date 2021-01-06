package com.example.finalproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class ReportSlideFragment extends Fragment {

    private String mChart;
    private Fragment childFragment;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    public ReportSlideFragment() {

    }

    public ReportSlideFragment(String chart) {
        this.mChart = chart;
    }

    public static ReportSlideFragment newInstance(String chart) {
        ReportSlideFragment fragment = new ReportSlideFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, chart);

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_report_slide, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        if (getResources().getBoolean(R.bool.portrait_only)) {
            if ("DE".equals(mChart)) {
                childFragment = new DailyExpenseChartFragment();
            }
            if ("DS".equals(mChart)) {
                childFragment = new DailySavingChartFragment();
            }
            if ("IR".equals(mChart)) {
                childFragment = new ItemReportChartFragment();
            }
            FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
            transaction.replace(R.id.child_fragment_container, childFragment).commit();

        } else {
            if ("DE".equals(mChart)) {
                childFragment = new DailyExpenseChartFragment();
            }
            if ("DS".equals(mChart)) {
                childFragment = new DailySavingChartFragment();
            }
            if ("IR".equals(mChart)) {
                childFragment = new ItemReportChartFragment();
            }
            FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
            transaction.replace(R.id.parent_fragment_container, childFragment).commit();
        }
    }

}
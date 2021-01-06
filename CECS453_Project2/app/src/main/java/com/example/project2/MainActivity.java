/**
 * CECS 453
 * June 11, 2020
 * MainActivity.java
 * Authors: Ricky Tan & Daniel Mendez
 * **/

package com.example.project2;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity implements OnButtonPressListener {

    private Fragment frag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * @param index - int value of the index of the current element in the array
     * **/
    @Override
    public void onForwardPressed(int index) {
        frag = getSupportFragmentManager().findFragmentById(R.id.fragment);
        ((ImageFrgmnt) frag).onFragmentInteraction(index);
    }

    /**
     * @param index - int value of the index of the current element in the array
     * **/
    @Override
    public void onBackPressed(int index) {
        FragmentManager fm = getSupportFragmentManager();
        frag =  fm.findFragmentById(R.id.fragment);
        ((ImageFrgmnt ) frag).onFragmentInteraction(index);
    }

    /**
     * @param view - boolean value of the view
     * **/
    @Override
    public void onGridCheck(boolean view){
        FragmentManager fm = getSupportFragmentManager();
        frag =  fm.findFragmentById(R.id.fragment);
        ((ImageFrgmnt ) frag).onGridCheck(view);
    }

    @Override
    public void onGridUnCheck(boolean view){
        FragmentManager fm = getSupportFragmentManager();
        frag =  fm.findFragmentById(R.id.fragment3);
        ((GridFrgmnt) frag).onGridUnCheck(view);
    }

    /**
     * @param view - boolean value of the view
     * **/
    @Override
    public void onSlideCheck(boolean view){
        FragmentManager fm = getSupportFragmentManager();
        frag =  fm.findFragmentById(R.id.fragment);
        ((ImageFrgmnt ) frag).onSlideCheck(view);
    }
}
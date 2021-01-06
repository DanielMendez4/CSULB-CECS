/**
 * CECS 453
 * June 24, 2020
 * MainActivity.java
 * Authors: Ricky Tan & Daniel Mendez
 */

package com.example.project3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements OnChangeListener {

    public MainActivity() { }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Updates the model that is in the spinner
     * @param urlAppend - link to all the available models
     */
    @Override
    public void modelUpdate(String urlAppend) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ModelFragment mFragment = ModelFragment.newInstance(urlAppend);
        ft.detach(mFragment);
        ft.replace(R.id.modelFragment, mFragment);
        ft.commit();
    }

    /**
     * Updates the list of vehicles based off the make and model
     * @param makeID - ID of the current make in the spinner
     * @param modelID - ID of the current model in the spinner
     */
    @Override
    public void listUpdate(String makeID, String modelID) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ListFragment mFragment = ListFragment.newInstance(makeID, modelID);
        ft.detach(mFragment);
        ft.replace(R.id.listFragment, mFragment);
        ft.commit();
    }

    /**
     * Detects if the screen is in landscape
     * @param id
     * @param name
     */
    @Override
    public void wideScreenSwitch(String id, String name) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.carDetailFrame, CarDetailFragment.newInstance(id, name));
        ft.commit();
    }
}
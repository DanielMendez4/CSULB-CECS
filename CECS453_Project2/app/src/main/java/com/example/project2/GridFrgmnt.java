/**
 * CECS 453
 * June 11, 2020
 * GridFrgmnt.java
 * Authors: Ricky Tan & Daniel Mendez
 * **/

package com.example.project2;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

public class GridFrgmnt extends Fragment {

    static int animals[] = {R.drawable.animal13, R.drawable.animal14, R.drawable.animal15, R.drawable.animal16, R.drawable.animal17, R.drawable.animal18};
    GridView simpleGrid;

    @Override
    public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); }

    /**
     * @param inflater
     * @param container
     * @param savedInstanceState
     * Sets the instance variables when the view is created
     * @return root
     * **/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_grid_frgmnt, container, false);
        simpleGrid = root.findViewById(R.id.simpleGridView);
        CustomAdapter customAdapter = new CustomAdapter(getActivity(), animals);
        simpleGrid.setAdapter(customAdapter);
        // Inflate the layout for this fragment
        return root;
    }

    /**
     * @param view - boolean value of the view
     * Shows a grid view if true, else image view is visible
     * **/
    public void onGridUnCheck(boolean view) {
        final FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fragment, new ImageFrgmnt());
        ft.commit();
    }
}
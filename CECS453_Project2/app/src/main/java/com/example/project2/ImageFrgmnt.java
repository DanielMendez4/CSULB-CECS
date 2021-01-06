/**
 * CECS 453
 * June 11, 2020
 * ImageFrgmnt.java
 * Authors: Ricky Tan & Daniel Mendez
 * **/

package com.example.project2;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ImageFrgmnt extends Fragment {

    private static ImageView mImageView;
    static int animals[] = {R.drawable.animal13, R.drawable.animal14, R.drawable.animal15, R.drawable.animal16, R.drawable.animal17, R.drawable.animal18};

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
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_image_frgmnt, container, false);
        mImageView = root.findViewById(R.id.imgView);
        // Inflate the layout for this fragment
        return root;
    }

    /**
     * @param index - int value of the current element in the array
     * **/
    public void onFragmentInteraction(int index) {
        mImageView.setImageResource(animals[index]);
        System.out.println();
    }

    /**
     * @param view - boolean value of the view
     * Shows a grid view if true, else image view is visible
     * **/
    public void onGridCheck(boolean view) {
        if (view) {
            final FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.fragment, new GridFrgmnt());
            ft.commit();
        }
    }

    public void onSlideCheck(boolean view) {}
}
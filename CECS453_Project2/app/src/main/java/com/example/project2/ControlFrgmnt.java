/**
 * CECS 453
 * June 11, 2020
 * ControlFrgmnt.java
 * Authors: Ricky Tan & Daniel Mendez
 * **/

package com.example.project2;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

public class ControlFrgmnt extends Fragment {

    private CheckBox mGridView, mSlideShow;
    private Button mPrevious, mNext;
    public static int index = 0;
    final int delay = 2700;
    static int animals[] = {R.drawable.animal13, R.drawable.animal14, R.drawable.animal15, R.drawable.animal16, R.drawable.animal17, R.drawable.animal18};
    OnButtonPressListener buttonListener;

    public ControlFrgmnt() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    // In fragment class onCreateView actually inflates the fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Fragment is part of the Viewgroup of the main activity
        // Inflate the layout for this fragment
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_control_frgmnt, container, false);
        mGridView = root.findViewById(R.id.chkGallery);
        mSlideShow = root.findViewById(R.id.chkSlide);
        mPrevious = root.findViewById(R.id.btnPrev);
        mNext = root.findViewById(R.id.btnNext);

        // Listens for when the "Next" button is pressed
        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                int tmp = index;
                try {
                    buttonListener.onForwardPressed(++index);
                } catch (Exception e) {
                    index = tmp;
                }
            }
        });

        // Listens for when the "Previous" button is pressed
        mPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                int tmp = index;
                try {
                    buttonListener.onBackPressed(--index);
                } catch (Exception e) {
                    index = tmp;
                }
            }
        });

        // Listens for when the "Gallery View" check box is checked
        mGridView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //is chkIos checked?
                if (((CheckBox) v).isChecked()) {
                    if (mSlideShow.isChecked()) {
                        mSlideShow.toggle();
                    }
                    buttonListener.onGridCheck(((CheckBox) v).isChecked());
                } else {
                    buttonListener.onGridUnCheck(true);
                }
            }
        });

        // Handles the delay between the images changing
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                //do something
                if (mSlideShow.isChecked()) {
                    int tmp = index;
                    try {
                        buttonListener.onForwardPressed(++index);
                    } catch (Exception e) {
                        index = -1;
                    }
                }
                handler.postDelayed(this, delay);
            }
        }, delay);

        // Listens for when the "Slide Show" check box is checked
        mSlideShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //is chkIos checked?
                if (((CheckBox) v).isChecked()) {
                    if (mSlideShow.isChecked()) {
                        if (mGridView.isChecked()) {
                            buttonListener.onGridUnCheck(!mGridView.isChecked());
                            mGridView.toggle();
                        }
                    }
                }
            }
        });
        return root;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            buttonListener = (OnButtonPressListener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement onButtonPressed");
        }
    }
}
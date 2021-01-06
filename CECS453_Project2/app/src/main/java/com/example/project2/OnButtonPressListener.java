/**
 * CECS 453
 * June 11, 2020
 * OnButtonPressListener.java
 * Authors: Ricky Tan & Daniel Mendez
 * **/

package com.example.project2;

public interface OnButtonPressListener {
    void onBackPressed(int index);
    void onForwardPressed(int index);
    void onGridCheck(boolean view);
    void onGridUnCheck(boolean view);
    void onSlideCheck(boolean view);
}
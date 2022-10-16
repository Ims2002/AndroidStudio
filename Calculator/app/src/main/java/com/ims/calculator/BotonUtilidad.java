package com.ims.calculator;

import android.widget.TextView;

public class BotonUtilidad {
    public static void X(TextView display) {
        String displayTxt = String.valueOf(display.getText());
        display.setText(displayTxt.concat("*"));
    }
    public static void printMod(TextView display) {
        String displayTxt = String.valueOf(display.getText());
        display.setText(displayTxt.concat("%"));
    }
    public static void printDiv(TextView display) {
        String displayTxt = String.valueOf(display.getText());
        display.setText(displayTxt.concat("/"));
    }
    public static void printPlus(TextView display) {
        String displayTxt = String.valueOf(display.getText());
        display.setText(displayTxt.concat("+"));
    }
    public static void printMin(TextView display) {
        String displayTxt = String.valueOf(display.getText());
        display.setText(displayTxt.concat("-"));
    }
}

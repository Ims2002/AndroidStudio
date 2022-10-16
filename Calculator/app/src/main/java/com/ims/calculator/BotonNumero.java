package com.ims.calculator;

import android.widget.TextView;

public class BotonNumero {
    public static void choiceNum(TextView display, long num) {
        String displayTxt = String.valueOf(display.getText());
        display.setText(displayTxt.concat(String.valueOf(num)));
    }
}

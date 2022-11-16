package com.ims.twogamestoolbar.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ims.twogamestoolbar.R;

public class FragmentTicTacToe extends Fragment {

    ImageView iv00;ImageView iv01;ImageView iv02;
    ImageView iv10;ImageView iv11;ImageView iv12;
    ImageView iv20;ImageView iv21;ImageView iv22;

    public FragmentTicTacToe() {
        super(R.layout.fragment_tictactoe);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        iv00 = view.findViewById(R.id.iv00);iv00 = view.findViewById(R.id.iv01);iv00 = view.findViewById(R.id.iv02);
        iv00 = view.findViewById(R.id.iv10);iv00 = view.findViewById(R.id.iv11);iv00 = view.findViewById(R.id.iv12);
        iv00 = view.findViewById(R.id.iv20);iv00 = view.findViewById(R.id.iv21);iv00 = view.findViewById(R.id.iv22);
    }
}

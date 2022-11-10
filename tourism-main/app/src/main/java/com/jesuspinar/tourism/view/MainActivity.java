package com.jesuspinar.tourism.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentOnAttachListener;

import com.jesuspinar.tourism.R;
import com.jesuspinar.tourism.controller.FragmentList;
import com.jesuspinar.tourism.controller.IClickListener;

public class MainActivity extends AppCompatActivity implements IClickListener, FragmentOnAttachListener {

    //ToDo: Refactor Data array that will be used to handle data through the view holder
    private Object[] data;
    //private final ArrayList<Object> data;

    public MainActivity() {
        super(R.layout.activity_main);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        data = new Object[]{"Name one", "Name two..."};

        if(savedInstanceState == null){
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.FrgList, FragmentList.class, null)
                    .commit();

            manager.addFragmentOnAttachListener(this::onAttachFragment);
        }
    }

    @Override
    public void onClick(int position) {
        //ToDo: Implement action to load other fragment
    }

    @Override
    public void onAttachFragment(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        if(fragment.getId() == R.id.FrgList) {
            FragmentList frgList = (FragmentList) fragment;
            frgList.setDataListener(data,this::onClick);
        }
    }
}

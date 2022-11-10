package com.jesuspinar.tourism.controller;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jesuspinar.tourism.R;

public class FragmentList extends Fragment {
    //ToDo: Refactor Data array that will be used to handle data through the view holder
    private Object[] data;
    //ToDo: Refactor click interface that will be used to handle clicks
    private IClickListener listener;

    public FragmentList() {
        super(R.layout.fragment_list);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView rvList = view.findViewById(R.id.rvList);
        ObjAdapter adaptador = new ObjAdapter(this.data, listener);
        rvList.setAdapter(adaptador);
        rvList.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false));
    }

    public void setDataListener(Object[] data,IClickListener listener) {
        this.data = data;
        this.listener = listener;
    }
}

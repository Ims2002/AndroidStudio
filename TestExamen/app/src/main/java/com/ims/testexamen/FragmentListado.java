package com.ims.testexamen;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentListado extends Fragment {
    private Car[] cars;
    private IOnClickListener clickListener;

    public interface IOnAttachListener {
        Car[] getCars();
    }

    public FragmentListado() {
        super(R.layout.fragment_listado);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        CarAdapter adapter = new CarAdapter(cars,getContext(),clickListener);
        RecyclerView recyclerView = view.findViewById(R.id.rvCars);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        clickListener = (IOnClickListener) context;
        IOnAttachListener attachListener = (IOnAttachListener) context;
        cars = attachListener.getCars();
    }
}

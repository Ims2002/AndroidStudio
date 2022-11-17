package com.ims.testexamen;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentDetalle extends Fragment {

    public interface IOnAttachListener {
        Car getCar();
    }

    private Car car;
    private TextView tvKm;
    private TextView tvCarName;
    private TextView tvCarCode;
    private TextView tvFabricadoEn;

    public FragmentDetalle() {
        super(R.layout.fragment_detalle);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvCarCode = view.findViewById(R.id.tvCode);
        tvCarName = view.findViewById(R.id.tvName);
        tvFabricadoEn = view.findViewById(R.id.tvFabricadoEn);
        tvKm = view.findViewById(R.id.tvKm);
        if(car!=null) {
            mostrarDetalle(car);
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        IOnAttachListener attachListener = (IOnAttachListener) context;
        car = attachListener.getCar();
    }

    public void mostrarDetalle(Car car) {
        this.car = car;
        tvKm.setText(car.getKm());
        tvCarCode.setText(car.getCarCode());
        tvFabricadoEn.setText(car.getFabricadoEn());
        tvCarName.setText(car.getCarName());
    }
}

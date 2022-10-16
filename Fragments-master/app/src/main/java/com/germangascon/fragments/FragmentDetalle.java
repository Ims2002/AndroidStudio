package com.germangascon.fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FragmentDetalle extends Fragment {
    public static final String TEXTO_CORREO = "com.germangascon.fragments.TEXTO_CORREO";
    private TextView tvDetalle;
    private String textoCorreo;

    public FragmentDetalle() {
        super(R.layout.fragment_detalle);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        assert getArguments() != null;
        textoCorreo = getArguments().getString(TEXTO_CORREO);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvDetalle = view.findViewById(R.id.tvDetalle);
        mostrarDetalle(textoCorreo);
    }

    public void mostrarDetalle(String texto) {
        tvDetalle.setText(texto);
    }
}

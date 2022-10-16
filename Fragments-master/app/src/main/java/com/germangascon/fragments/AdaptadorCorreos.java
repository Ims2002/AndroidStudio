package com.germangascon.fragments;


import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.Objects;

public class AdaptadorCorreos extends ArrayAdapter<Correo> {
    private final Context context;
    private final Correo[] datos;

    public AdaptadorCorreos(Fragment context, Correo[] datos) {
        super(context.requireActivity(), R.layout.listitem_correo, datos);
        this.datos = datos;
        this.context = context.getActivity();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View item = inflater.inflate(R.layout.listitem_correo, null);
        TextView tvDe = item.findViewById(R.id.tvDe);
        tvDe.setText(datos[position].getDe());
        TextView tvAsunto = item.findViewById(R.id.tvAsunto);
        tvAsunto.setText(datos[position].getAsunto());
        return item;
    }
}

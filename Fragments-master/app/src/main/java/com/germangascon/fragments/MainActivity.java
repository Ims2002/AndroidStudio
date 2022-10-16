package com.germangascon.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentOnAttachListener;


public class MainActivity extends AppCompatActivity implements  ICorreosListener, FragmentOnAttachListener {
    private FragmentDetalle frgDetalle;
    private boolean tabletLayout;

    public MainActivity() {
        super(R.layout.activity_main);
        frgDetalle = null;
        tabletLayout = false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tabletLayout = findViewById(R.id.FrgDetalle) != null;

        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.FrgListado, FragmentListado.class, null)
                .commit();
        manager.addFragmentOnAttachListener(this);
    }

    @Override
    public void onCorreoSeleccionado(Correo c) {
        if(tabletLayout) {
            frgDetalle.mostrarDetalle(c.getTexto());
        } else {
            Intent i = new Intent(this, DetalleActivity.class);
            i.putExtra(DetalleActivity.EXTRA_TEXTO, c.getTexto());
            startActivity(i);
        }
    }

    @Override
    public void onAttachFragment(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        if(fragment.getId() == R.id.FrgListado) {
            FragmentListado fragmentListado = (FragmentListado) fragment;
            fragmentListado.setCorreosListener(this);
            if(tabletLayout) {
                Bundle bundle = new Bundle();
                bundle.putString(FragmentDetalle.TEXTO_CORREO, fragmentListado.getDatos()[0].getTexto());
                FragmentManager manager = getSupportFragmentManager();
                manager.beginTransaction()
                        .setReorderingAllowed(true)
                        .add(R.id.FrgDetalle, FragmentDetalle.class, bundle)
                        .commit();
            }
        }
        if(fragment.getId() == R.id.FrgDetalle) {
            frgDetalle = (FragmentDetalle) fragment;
        }
    }
}

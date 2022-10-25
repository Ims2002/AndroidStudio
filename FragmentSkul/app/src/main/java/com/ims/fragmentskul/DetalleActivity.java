package com.ims.fragmentskul;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import java.util.Objects;

public class DetalleActivity extends AppCompatActivity {
    public static final String EXTRA_COURSE = "com.ims.fragments.EXTRA_COURSE";
    public static final String EXTRA_ALUMNO = "com.ims.fragments.EXTRA_ALUMNO";

    public DetalleActivity() {
        super(R.layout.activity_detail);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState == null) {
            Alumno alumno = (Alumno) Objects.requireNonNull(getIntent().getSerializableExtra(EXTRA_ALUMNO));
            Bundle bundle = new Bundle();
            bundle.putSerializable(FragmentDetalle.EXTRA_ALUMNO,alumno);
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().setReorderingAllowed(false)
                    .add(R.id.FrgDetalle,FragmentDetalle.class,bundle)
                    .commit();
        }
    }
}

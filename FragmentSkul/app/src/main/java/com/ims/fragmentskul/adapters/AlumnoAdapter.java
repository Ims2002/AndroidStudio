package com.ims.fragmentskul.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ims.fragmentskul.Alumno;
import com.ims.fragmentskul.Interfaces.IClickListener;
import com.ims.fragmentskul.Libs.Lib;
import com.ims.fragmentskul.R;

public class AlumnoAdapter extends RecyclerView.Adapter<AlumnoAdapter.AlumnoViewHolder> {
    private Alumno[] alumnos;
    private IClickListener listener;

    public AlumnoAdapter(IClickListener listener, Alumno[] alumnos) {
        this.alumnos = alumnos;
        this.listener = listener;
    }

    @NonNull
    @Override
    public AlumnoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_alumno,
                parent,false);
        return new AlumnoViewHolder(itemView,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull AlumnoViewHolder holder, int position) {
        Alumno alumno = alumnos[position];
        holder.bindAlumno(alumno);
    }

    @Override
    public int getItemCount() {
        return alumnos.length;
    }

    public static class AlumnoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        //private TextView tvNia;
        private TextView tvName;
        private TextView tvSurname1;
        private TextView tvSurname2;
        private TextView tvEmail;
        private TextView tvBirthDate;
        private IClickListener listener;


        public AlumnoViewHolder(@NonNull View itemView, IClickListener listener) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvSurname1 = itemView.findViewById(R.id.tvSurname1);
            tvSurname2 = itemView.findViewById(R.id.tvSurname2);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            tvBirthDate = itemView.findViewById(R.id.tvAge);
            this.listener = listener;
            itemView.setOnClickListener(this);
        }

        public void bindAlumno(Alumno alumno) {

            tvName.setText(alumno.getName());
            tvSurname1.setText(alumno.getSurname1());
            tvSurname2.setText(alumno.getSurname2());
            tvEmail.setText(alumno.getEmail());
            tvBirthDate.setText(String.valueOf(Lib.calculoEdad(alumno.getBirthDate())));

        }

        @Override
        public void onClick(View view) {
            if(listener != null) {
                listener.onClick(getAdapterPosition());
            }
        }
    }
}

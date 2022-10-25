package com.ims.fragmentskul.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ims.fragmentskul.Alumno;
import com.ims.fragmentskul.Asignatura;
import com.ims.fragmentskul.Interfaces.IClickListener;
import com.ims.fragmentskul.Nota;
import com.ims.fragmentskul.R;

import java.util.HashMap;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {


    private Alumno[] alumnos;
    private IClickListener listener;

    public CourseAdapter(Alumno[] alumnos, IClickListener listener) {
        this.alumnos = alumnos;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.mark_detail,
                parent,false);
        return new CourseViewHolder(itemView,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        Alumno alumno = alumnos[position];
        holder.bindCourse(alumno);
    }

    @Override
    public int getItemCount() {
        return alumnos.length;
    }

    public static class CourseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tvCourseName;
        private TextView tvCourseCode;
        private TextView tvMark;
        private IClickListener listener;
        private HashMap<String,String> hm;


        public CourseViewHolder(@NonNull View itemView, IClickListener listener) {
            super(itemView);
            tvCourseCode = itemView.findViewById(R.id.tvCourseCode);
            tvCourseName = itemView.findViewById(R.id.tvCourseName);
            tvMark = itemView.findViewById(R.id.tvNota);
            this.listener = listener;
            hm = initCourseName();
        }

//warning
        public void bindCourse(Alumno alumno) {

                String code = alumno.getNotas()[0].getCourseCode();
                tvMark.setText(alumno.getNotas()[0].getMark());
                tvCourseCode.setText(code);
                tvCourseName.setText(hm.get(code));


        }

        @Override
        public void onClick(View view) {
            if (listener != null) {
                listener.onClick(getAdapterPosition());
            }
        }

        public HashMap<String,String> initCourseName() {
            HashMap<String,String> hm = new HashMap<>();
            hm.put("AAD","Acceso a base de datos");
            hm.put("DDI","Desarrolo de interfaces");
            hm.put("PMDM","Programación multimedia y dispositivos móviles");
            hm.put("PSP","Progroamación de servicios y procesos");
            hm.put("SGE","Sistemas de gestión empresarial");
            hm.put("EIE","Empresa e iniciativa emprendedora");
            hm.put("ANG","Inglés técnico");
            return hm;
        }

    }

}

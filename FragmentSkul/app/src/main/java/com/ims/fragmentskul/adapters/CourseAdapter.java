package com.ims.fragmentskul.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ims.fragmentskul.Alumno;
import com.ims.fragmentskul.Asignatura;
import com.ims.fragmentskul.R;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {

    private Asignatura[] courses;
    private Alumno[] alumnos;

    public CourseAdapter(Asignatura[] courses, Alumno[] alumnos) {
        this.courses = courses;
        this.alumnos = alumnos;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.mark_detail,
                parent,false);
        return new CourseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        Asignatura course = courses[position];
        Alumno alumno = alumnos[position];
        holder.bindCourse(course,alumno);
    }

    @Override
    public int getItemCount() {
        return courses.length;
    }

    public static class CourseViewHolder extends RecyclerView.ViewHolder {

        private TextView tvCourseName;
        private TextView tvCourseCode;
        private TextView tvMark;

        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCourseCode = itemView.findViewById(R.id.tvCourseCode);
            tvCourseName = itemView.findViewById(R.id.tvCourseName);
            tvMark = itemView.findViewById(R.id.tvNota);
        }


        public void bindCourse(Asignatura course,Alumno alumno) {
            tvCourseCode.setText(course.getCourseCode());
            tvCourseName.setText(course.getCourseName());
            tvMark.setText(alumno.getNotas().get(0).getMark());
        }

    }

}

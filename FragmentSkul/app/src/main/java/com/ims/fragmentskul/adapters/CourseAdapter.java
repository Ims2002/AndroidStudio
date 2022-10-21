package com.ims.fragmentskul.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ims.fragmentskul.Asignatura;
import com.ims.fragmentskul.R;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {

    private Asignatura[] courses;

    public CourseAdapter(Asignatura[] courses) {
        this.courses = courses;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.l)
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class CourseViewHolder extends RecyclerView.ViewHolder {

        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);
        }

    }

}

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

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class AlumnoAdapter extends RecyclerView.Adapter<AlumnoAdapter.AlumnoViewHolder> {
    private Alumno[] alumnos;

    public AlumnoAdapter(Alumno[] alumnos) {
        this.alumnos = alumnos;
    }

    @NonNull
    @Override
    public AlumnoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_alumno,
                parent,false);
        return new AlumnoViewHolder(itemView);
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

    public static class AlumnoViewHolder extends RecyclerView.ViewHolder {

        //private TextView tvNia;
        private TextView tvName;
        private TextView tvSurname1;
        private TextView tvSurname2;
        private TextView tvEmail;
        private TextView tvBirthDate;


        public AlumnoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvSurname1 = itemView.findViewById(R.id.tvSurname1);
            tvSurname2 = itemView.findViewById(R.id.tvSurname2);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            tvBirthDate = itemView.findViewById(R.id.tvAge);

        }

        public void bindAlumno(Alumno alumno) {

            tvName.setText(alumno.getName());
            tvSurname1.setText(alumno.getSurname1());
            tvSurname2.setText(alumno.getSurname2());
            tvEmail.setText(alumno.getEmail());
            tvBirthDate.setText(calculoEdad(alumno.getBirthDate()));

        }

        public int calculoEdad(String fecha) {
            Date fechaNac=null;
            try {
                /**Se puede cambiar la mascara por el formato de la fecha
                 que se quiera recibir, por ejemplo año mes día "yyyy-MM-dd"
                 en este caso es día mes año*/
                fechaNac = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
            } catch (Exception ex) {
                System.out.println("Error:"+ex);
            }
            Calendar fechaNacimiento = Calendar.getInstance();
            //Se crea un objeto con la fecha actual
            Calendar fechaActual = Calendar.getInstance();
            //Se asigna la fecha recibida a la fecha de nacimiento.
            fechaNacimiento.setTime(fechaNac);
            //Se restan la fecha actual y la fecha de nacimiento
            int año = fechaActual.get(Calendar.YEAR)- fechaNacimiento.get(Calendar.YEAR);
            int mes =fechaActual.get(Calendar.MONTH)- fechaNacimiento.get(Calendar.MONTH);
            int dia = fechaActual.get(Calendar.DATE)- fechaNacimiento.get(Calendar.DATE);
            //Se ajusta el año dependiendo el mes y el día
            if(mes<0 || (mes==0 && dia<0)){
                año--;
            }
            //Regresa la edad en base a la fecha de nacimiento
            return año;
        }

    }
}

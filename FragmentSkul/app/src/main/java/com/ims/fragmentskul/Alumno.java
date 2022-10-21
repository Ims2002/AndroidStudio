package com.ims.fragmentskul;

import java.util.ArrayList;

public class Alumno {
    private String nia;
    private String name;
    private String surname1;
    private String surname2;
    private String birthDate;
    private String email;
    private ArrayList<Nota> notas;

    public Alumno(String nia, String name, String surname1, String surname2, String birthDate, String email, ArrayList<Nota> notas) {
        this.nia = nia;
        this.name = name;
        this.surname1 = surname1;
        this.surname2 = surname2;
        this.birthDate = birthDate;
        this.email = email;
        this.notas = notas;
    }


    public String getNia() {
        return nia;
    }

    public String getName() {
        return name;
    }

    public String getSurname1() {
        return surname1;
    }

    public String getSurname2() {
        return surname2;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Nota> getNotas() {
        return notas;
    }
}

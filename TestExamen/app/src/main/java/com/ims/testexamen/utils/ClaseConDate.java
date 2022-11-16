package com.ims.testexamen.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ClaseConDate {
    private final String name;
    private final String surname;
    private final String idCard;
    private final String address;
    private final String photo;
    private Calendar birthDate;


    public ClaseConDate(String name, String surname, String idCard, String address, String photo, String birthDate) {
        this.name = name;
        this.surname = surname;
        this.idCard = idCard;
        this.address = address;
        this.photo = photo;
        try {
            this.birthDate = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", new Locale("es", "ES"));
            Date date = sdf.parse(birthDate);
            assert date != null;
            this.birthDate.setTime(date);
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getIdCard() {
        return idCard;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoto() {
        return photo;
    }

    public String getBirthDate() {
        String date = "";
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", new Locale("es", "ES"));
        if (birthDate != null) {
            date = sdf.format(birthDate.getTime());
        }
        return date;
    }

    public int getEdad() {
        int age;
        Calendar today = Calendar.getInstance();
        int currentYear = today.get(Calendar.YEAR);
        int birthYear = birthDate.get(Calendar.YEAR);
        age = currentYear - birthYear;
        int currentMonth = today.get(Calendar.MONTH);
        int birthMonth = birthDate.get(Calendar.MONTH);
        //Si el mes de nacimiento es mayor que el actual restamos un año
        if(birthMonth > currentMonth) {
            age--;
        } else if(birthMonth == currentMonth) { //Si es el mismo mes debemos comparar el día de nacimiento
            int currentDay = today.get(Calendar.DAY_OF_MONTH);
            int birthDay = birthDate.get(Calendar.DAY_OF_MONTH);
            if(birthDay > currentDay) {
                age--;
            }
        }
        return age;
    }
}

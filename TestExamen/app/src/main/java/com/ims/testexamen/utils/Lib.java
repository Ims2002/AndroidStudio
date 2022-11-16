package com.ims.testexamen.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Lib {
    private final GregorianCalendar fechaNac;

    public Lib(GregorianCalendar fechaNac) {
        this.fechaNac = fechaNac;
    }

    public GregorianCalendar getFechaNac() {
        return fechaNac;
    }

    public int getEdadNum() {
        int anyoNacimiento = fechaNac.get(Calendar.YEAR);
        int mesNacimiento = fechaNac.get(Calendar.MONTH)+1;
        int diaNacimiento = fechaNac.get(Calendar.DAY_OF_MONTH);

        GregorianCalendar fecha = new GregorianCalendar();

        int anyoActual = fecha.get(Calendar.YEAR);
        int mesActual = fecha.get(Calendar.MONTH)+1;
        int diaActual = fecha.get(Calendar.DAY_OF_MONTH);

        int edad = anyoActual - anyoNacimiento;
        if(mesActual < mesNacimiento){
            edad--;
        }else if(mesActual==mesNacimiento){
            if(diaActual<diaNacimiento) {
                edad--;
            }
        }
        return edad;
    }

    public int getEdad2() {
        LocalDate fechaActual = LocalDate.now();//fecha actual en formato localdate
        int anyoNacimiento = fechaNac.get(Calendar.YEAR);
        int mesNacimiento = fechaNac.get(Calendar.MONTH)+1;
        int diaNacimiento = fechaNac.get(Calendar.DAY_OF_MONTH);
        LocalDate fechaNacimiento = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            fechaNacimiento = LocalDate.of(diaNacimiento,mesNacimiento,anyoNacimiento);
        }
        Period periodo = Period.between(fechaActual,fechaNacimiento);
        return periodo.getYears();
    }

    public static Scanner sc = new Scanner(System.in);

    public static void limpiarPantalla() {
        System.out.print("\u001B[H\u001B[2J");
        System.out.flush();
    }

    public static void pause() {
        System.out.println("Pulsa INTRO para continuar...");
        sc.nextLine();
    }

    public static int aleatorio() {
        Random r = new Random();
        return r.nextInt();
    }

    public static long randomLong(long max, long min){
        Random rnd = new Random();
        return min + (long) (Math.random() * (max - min));
    }

    public static int aleatorio(int min, int max) {
        Random r = new Random();
        return r.nextInt(max - min +1 ) + min;
    }

    public static double aleatorio(double min, double max) {
        Random r = new Random();
        return min + r.nextDouble() * (max - min);
    }

    public static float aleatorio(float min, float max) {
        Random r = new Random();
        return min + r.nextFloat() * (max - min);
    }

    public static double[] reverseArray(double[] a1) {
        double[] a2 = new double[a1.length];
        int cont = 0;
        for(int i = a1.length-1;i>=0;i--) {
            a2[cont++] = a1[i];
        }
        return a2;
    }
    public static void visualizarArray(double[] vector) {
        for(int i = 0; i<vector.length;i++) {
            System.out.printf("%.4f\n",vector[i]);
        }
    }
    public static void visualizarArrayInt(int[] vector) {
        for(int i = 0;i<vector.length;i++){
            System.out.println(vector[i]);
        }
    }

    public static int readInt(String message) {
        boolean isValid = false;
        int data = 0;
        do {
            try {
                System.out.println(message);
                data = Integer.parseInt(sc.nextLine());
                isValid = true;
            } catch (NumberFormatException nfe) {
                System.out.println("Solo numeros por favor");
                pause();
            }
        }while(!isValid);
        return data;
    }

    public static String readString(String message, int minLength, int maxLength) {
        boolean isValid = false;
        String data; //no lo inicializamos porque 100% se va a inicializar la variable
        do {         //con el try/catch no sabemos si se inicializaria la variable
            System.out.println(message);
            data = sc.nextLine();
            if(data.length()>=minLength && data.length()<=maxLength)
                //isValid = (data.length()>=minLength && data.length()<=maxLength);
                //if(!isValid){System.out.printf("Longitud minima %d, máxima %d\n", minLength, maxLength); pause();
                isValid = true;
            else {
                System.out.printf("Longitud minima %d, máxima %d\n", minLength, maxLength);
                pause();
            }
        }while(!isValid);
        return data;
    }

    public int getEdad(Calendar birthDate) throws ParseException {
        birthDate = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", new Locale("es", "ES"));
        Date date = sdf.parse(String.valueOf(birthDate));
        assert date != null;
        birthDate.setTime(date);
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

    public static float media( float [ ] v ) {
        float prom = 0.0f;
        for ( int i = 0; i < v.length; i++ )
            prom += v[i];

        return prom / v.length;
    }



}

package com.ims.contacts;

public class Contacts {

    private int id;
    private String name;
    private String firstSurname;
    private String secondSurname;
    private String photo;
    private String birth;
    private String company;
    private String email;
    private String phone1;
    private String phone2;
    private String adress;

    public Contacts(int id, String name, String firstSurname, String secondSurname, String photo,
                    String birth, String company, String email, String phone1, String phone2, String adress) {
        this.id = id;
        this.name = name;
        this.firstSurname = firstSurname;
        this.secondSurname = secondSurname;
        this.photo = photo;
        this.birth = birth;
        this.company = company;
        this.email = email;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.adress = adress;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFirstSurname() {
        return firstSurname;
    }

    public String getSecondSurname() {
        return secondSurname;
    }

    public String getPhoto() {
        return photo;
    }

    public String getBirth() {
        return birth;
    }

    public String getCompany() {
        return company;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone1() {
        return phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public String getAdress() {
        return adress;
    }

}

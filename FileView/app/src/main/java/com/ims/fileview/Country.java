package com.ims.fileview;

public class Country {

    private final String name;
    private final String population;
    private final String capital;
    private final String countryCode;
    private final String isoAlpha3;

    public Country(String name, String population, String capital, String countryCode, String isoAlpha3) {
        this.name = name;
        this.population = population;
        this.capital = capital;
        this.isoAlpha3 = isoAlpha3;
        this.countryCode = countryCode;
    }

    public Country(String name, String population, String capital, String countryCode) {
        this.name = name;
        this.population = population;
        this.capital = capital;
        this.countryCode = countryCode;
        isoAlpha3 = null;
    }

    public String getCountry() {
        return name;
    }

    public String getPopulation() {
        return population;
    }

    public String getCapital() {
        return capital;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getIsoAlpha3() {
        return isoAlpha3;
    }

}

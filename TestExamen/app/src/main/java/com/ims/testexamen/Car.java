package com.ims.testexamen;

import java.io.Serializable;

public class Car implements Serializable {

    private String carCode;
    private String carName;
    private String km;
    private String fabricadoEn;

    public Car(String carCode, String carName, String km, String fabricadoEn) {
        this.carCode = carCode;
        this.carName = carName;
        this.km = km;
        this.fabricadoEn = fabricadoEn;
    }

    public String getCarCode() {
        return carCode;
    }

    public String getCarName() {
        return carName;
    }

    public String getFabricadoEn() {
        return fabricadoEn;
    }

    public String getKm() {
        return km;
    }

}

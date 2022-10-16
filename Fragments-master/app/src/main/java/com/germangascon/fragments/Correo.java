package com.germangascon.fragments;
public class Correo {
    private final String de;
    private final String asunto;
    private final String texto;

    public Correo(String de, String asunto, String texto) {
        this.de = de;
        this.asunto = asunto;
        this.texto = texto;
    }

    public String getDe() {
        return de;
    }

    public String getAsunto() {
        return asunto;
    }

    public String getTexto() {
        return texto;
    }
}

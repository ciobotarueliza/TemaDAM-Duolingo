package com.example.duolingo_ciobotarueliza;

import androidx.room.Entity;

import java.io.Serializable;

public class Persoana implements Serializable {
    private String Varsta;
    private String nume;
    private String email;
    private String Parola;

    public Persoana(String varsta, String nume, String email, String parola) {
        Varsta = varsta;
        this.nume = nume;
        this.email = email;
        Parola = parola;
    }

    public Persoana() {
    }


    public String getVarsta() {
        return Varsta;
    }

    public void setVarsta(String varsta) {
        Varsta = varsta;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getParola() {
        return Parola;
    }

    public void setParola(String parola) {
        Parola = parola;
    }

    @Override
    public String toString() {
        return "Persoana{" +
                "Varsta='" + Varsta + '\'' +
                ", nume='" + nume + '\'' +
                ", email='" + email + '\'' +
                ", Parola='" + Parola + '\'' +
                '}';
    }
}

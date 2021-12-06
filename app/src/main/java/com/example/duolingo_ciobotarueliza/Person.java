package com.example.duolingo_ciobotarueliza;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName="person")
public class Person {

    @PrimaryKey(autoGenerate = true)
    private int idPerson;

    @ColumnInfo(name="nume_persoana")
    private String numePersoana;

    @ColumnInfo(name="parola")
    private String parola;

    @ColumnInfo(name="email")
    private String email;

    @ColumnInfo(name="varsta")
    private int varsta;

    public Person(String numePersoana, String parola, String email, int varsta) {
        this.numePersoana = numePersoana;
        this.parola = parola;
        this.email = email;
        this.varsta = varsta;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public String getNumePersoana() {
        return numePersoana;
    }

    public void setNumePersoana(String numePersoana) {
        this.numePersoana = numePersoana;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    @Override
    public String toString() {
        return "Person{" +
                "idPerson=" + idPerson +
                ", numePersoana='" + numePersoana + '\'' +
                ", parola='" + parola + '\'' +
                ", email='" + email + '\'' +
                ", varsta=" + varsta +
                '}';
    }
}

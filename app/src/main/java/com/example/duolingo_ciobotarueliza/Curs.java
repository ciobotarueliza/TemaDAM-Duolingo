package com.example.duolingo_ciobotarueliza;

public class Curs {
    private String limba;
    private String nivel;
    private int nrOre;

    @Override
    public String toString() {
        return "Curs{" +
                "limba='" + limba + '\'' +
                ", nivel='" + nivel + '\'' +
                ", nrOre=" + nrOre +
                '}';
    }

    public String getLimba() {
        return limba;
    }

    public void setLimba(String limba) {
        this.limba = limba;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public int getNrOre() {
        return nrOre;
    }

    public void setNrOre(int nrOre) {
        this.nrOre = nrOre;
    }

    public Curs(String limba, String nivel, int nrOre) {
        this.limba = limba;
        this.nivel = nivel;
        this.nrOre = nrOre;
    }
}

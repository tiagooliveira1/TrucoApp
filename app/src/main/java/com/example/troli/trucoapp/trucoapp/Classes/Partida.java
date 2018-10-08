package com.example.troli.trucoapp.trucoapp.Classes;

/**
 * Created by troli on 07/10/2018.
 */

public class Partida {
    private Dupla dupla1;
    private Dupla dupla2;
    private Dupla duplaVendedora;

    public Partida() {}

    public Partida(Dupla dupla1, Dupla dupla2, Dupla duplaVendedora)
    {
        this.dupla1 = dupla1;
        this.dupla2 = dupla2;
        this.duplaVendedora = duplaVendedora;
    }
    public Dupla getDupla1() {
        return dupla1;
    }

    public void setDupla1(Dupla dupla1) {
        this.dupla1 = dupla1;
    }

    public Dupla getDupla2() {
        return dupla2;
    }

    public void setDupla2(Dupla dupla2) {
        this.dupla2 = dupla2;
    }

    public Dupla getDuplaVendedora() {
        return duplaVendedora;
    }

    public void setDuplaVendedora(Dupla duplaVendedora) {
        this.duplaVendedora = duplaVendedora;
    }
}

package com.example.troli.trucoapp.trucoapp.Classes;

/**
 * Created by troli on 07/10/2018.
 */

public class Dupla {

    private Usuario usuario1;
    private Usuario usuario2;

    public Dupla() {}

    public Dupla(Usuario usuario1, Usuario usuario2)
    {
        this.usuario1 = usuario1;
        this.usuario2 = usuario2;
    }

    public Usuario getUsuario1() {
        return usuario1;
    }

    public void setUsuario1(Usuario usuario1) {
        this.usuario1 = usuario1;
    }

    public Usuario getUsuario2() {
        return usuario2;
    }

    public void setUsuario2(Usuario usuario2) {
        this.usuario2 = usuario2;
    }
}

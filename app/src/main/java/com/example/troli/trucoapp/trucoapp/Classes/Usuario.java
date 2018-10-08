package com.example.troli.trucoapp.trucoapp.Classes;

/**
 * Created by troli on 07/10/2018.
 */

public class Usuario {
    private String uuid;
    private String nome;
    private String email;

    public Usuario() {}

    public Usuario(String uuid)
    {

    }
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

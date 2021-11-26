package com.example.semana_14;

public class Usuario {
    private String ID;
    private String username;

    public Usuario() {
    }

    public Usuario(String username , String  ID) {
        this.ID = ID;
        this.username = username;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

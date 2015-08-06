package com.mycompany.myapp;

/**
 * Created by David on 05/08/2015.
 */
public class User {
    private int  idUsusario = 0;
    private String Nombre = "";
    private String Direccion = "";
    private String Telefono = "";
    private String Email = "";

    public User(int idUsusario, String Nombre, String Direccion, String Telefono, String Email){
        super();
        this.idUsusario = idUsusario;
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.Email = Email;
    }
    public int getIdUsusario(){
        return idUsusario;
    }
    public void setIdUsusario(int idUsusario){
        this.idUsusario = idUsusario;
    }

    public String getNombre(){
        return Nombre;
    }
    public void setNombre(String Nombre){
        this.Nombre = Nombre;
    }

    public String getDireccion(){
        return Direccion;
    }
    public void setDireccion(String Direccion){
        this.Direccion = Direccion;
    }

    public String getTelefono(){
        return Telefono;
    }
    public void setTelefono(String Telefono){
        this.Telefono = Telefono;
    }

    public String getEmail(){
        return Email;
    }
    public void setEmail(String Email){
        this.Email = Email;
    }

    @Override
    public String toString() {
        return "Usuario [id=" + idUsusario  + ", Nombre=" + Nombre + ", Direccion=" + Direccion +
                ", Telefono=" + Telefono + ", Email=" + Email + "]";
    }



}

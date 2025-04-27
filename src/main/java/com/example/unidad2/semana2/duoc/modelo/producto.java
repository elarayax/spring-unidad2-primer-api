package com.example.unidad2.semana2.duoc.modelo;

public class producto {
    private int ID;
    private String nombre;
    private int precio;

    public producto(int id, String nombre, int precio){
        this.ID = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getID(){
        return this.ID;
    }

    public void setID(int id){
        this.ID = id;
    }

    public int getPrecio(){
        return this.precio;
    }

    public void setPrecio(int precio){
        this.precio = precio;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
}

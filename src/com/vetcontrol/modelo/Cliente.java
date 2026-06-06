package com.vetcontrol.modelo;

public class Cliente {

    private int id;
    private String dni;
    private String nombres;
    private String telefono;
    private String direccion;

    public Cliente() {
    }

    public Cliente(int id, String dni, String nombres,
                   String telefono, String direccion) {
        this.id = id;
        this.dni = dni;
        this.nombres = nombres;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
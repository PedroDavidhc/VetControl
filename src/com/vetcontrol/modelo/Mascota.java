package com.vetcontrol.modelo;

public class Mascota {

    private int id;
    private int clienteId;
    private String nombre;
    private String sexo;
    private String especie;
    private String raza;
    private int edad;
    private double peso;

    public Mascota() {
    }

public Mascota(int id, int clienteId, String nombre,
               String sexo,
               String especie, String raza,
               int edad, double peso) {

        this.id = id;
        this.clienteId = clienteId;
        this.nombre = nombre;
        this.sexo = sexo;
        this.especie = especie;
        this.raza = raza;
        this.edad = edad;
        this.peso = peso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getSexo() {
    return sexo;
}

public void setSexo(String sexo) {
    this.sexo = sexo;
}

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}
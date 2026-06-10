package com.vetcontrol.modelo;

import java.sql.Date;

public class HistoriaClinica {

    private int id;
    private int mascotaId;
    private Date fecha;
    private double peso;
    private double temperatura;
    private String diagnostico;
    private String tratamiento;
    private String observaciones;

    public HistoriaClinica() {
    }

    public HistoriaClinica(
            int id,
            int mascotaId,
            Date fecha,
            double peso,
            double temperatura,
            String diagnostico,
            String tratamiento,
            String observaciones) {

        this.id = id;
        this.mascotaId = mascotaId;
        this.fecha = fecha;
        this.peso = peso;
        this.temperatura = temperatura;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.observaciones = observaciones;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMascotaId() {
        return mascotaId;
    }

    public void setMascotaId(int mascotaId) {
        this.mascotaId = mascotaId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
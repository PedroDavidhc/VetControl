package com.vetcontrol.modelo;

import java.sql.Date;

public class Factura {

    private int id;
    private int mascotaId;
    private Date fecha;
    private String concepto;
    private double monto;

    public Factura() {
    }

    public Factura(int id,
                   int mascotaId,
                   Date fecha,
                   String concepto,
                   double monto) {

        this.id = id;
        this.mascotaId = mascotaId;
        this.fecha = fecha;
        this.concepto = concepto;
        this.monto = monto;
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

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}
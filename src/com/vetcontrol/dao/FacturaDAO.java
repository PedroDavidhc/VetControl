package com.vetcontrol.dao;

import com.vetcontrol.modelo.Factura;
import java.util.List;

public interface FacturaDAO {

    boolean guardar(Factura factura);

    List<Factura> listar();
}
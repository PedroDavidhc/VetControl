package com.vetcontrol.dao;

import com.vetcontrol.modelo.HistoriaClinica;
import java.util.List;

public interface HistoriaClinicaDAO {

    boolean guardar(HistoriaClinica historia);

    List<HistoriaClinica> listar();
    int contar();
}
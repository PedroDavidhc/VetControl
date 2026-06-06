package com.vetcontrol.dao;

import com.vetcontrol.modelo.Mascota;
import java.util.List;

public interface MascotaDAO {

    boolean guardar(Mascota mascota);

    List<Mascota> listar();

}
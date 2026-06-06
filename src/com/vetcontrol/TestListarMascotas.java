package com.vetcontrol;

import com.vetcontrol.dao.MascotaDAO;
import com.vetcontrol.dao.MascotaDAOImpl;
import com.vetcontrol.modelo.Mascota;

public class TestListarMascotas {

    public static void main(String[] args) {

        MascotaDAO dao = new MascotaDAOImpl();

        for (Mascota m : dao.listar()) {

            System.out.println(
                    m.getId() + " - "
                    + m.getNombre() + " - "
                    + m.getEspecie()
            );
        }
    }
}
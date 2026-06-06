package com.vetcontrol;

import com.vetcontrol.dao.MascotaDAO;
import com.vetcontrol.dao.MascotaDAOImpl;
import com.vetcontrol.modelo.Mascota;

public class TestMascota {

    public static void main(String[] args) {

        Mascota mascota = new Mascota();

        mascota.setClienteId(1);

        mascota.setNombre("Firulais");

        mascota.setEspecie("Perro");

        mascota.setRaza("Labrador");

        mascota.setEdad(3);

        mascota.setPeso(18.5);

        MascotaDAO dao =
                new MascotaDAOImpl();

        if (dao.guardar(mascota)) {

            System.out.println(
                    "Mascota guardada correctamente"
            );

        } else {

            System.out.println(
                    "Error al guardar mascota"
            );
        }
    }
}
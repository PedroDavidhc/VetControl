package com.vetcontrol;

import com.vetcontrol.dao.ClienteDAO;
import com.vetcontrol.dao.ClienteDAOImpl;
import com.vetcontrol.modelo.Cliente;

public class TestCliente {

    public static void main(String[] args) {

        Cliente cliente = new Cliente();

        cliente.setDni("12345678");

        cliente.setNombres("Pedro Herrera");

        cliente.setTelefono("999888777");

        cliente.setDireccion("Av. Principal 123");

        ClienteDAO dao =
                new ClienteDAOImpl();

        if (dao.guardar(cliente)) {

            System.out.println(
                    "Cliente guardado correctamente"
            );

        } else {

            System.out.println(
                    "Error al guardar cliente"
            );

        }
    }
}
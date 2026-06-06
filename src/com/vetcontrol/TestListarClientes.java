package com.vetcontrol;

import com.vetcontrol.dao.ClienteDAO;
import com.vetcontrol.dao.ClienteDAOImpl;
import com.vetcontrol.modelo.Cliente;

public class TestListarClientes {

    public static void main(String[] args) {

        ClienteDAO dao = new ClienteDAOImpl();

        for (Cliente c : dao.listar()) {

            System.out.println(
                    c.getId() + " - "
                    + c.getDni() + " - "
                    + c.getNombres()
            );
        }
    }
}
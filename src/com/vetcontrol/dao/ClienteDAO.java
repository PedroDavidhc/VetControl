package com.vetcontrol.dao;

import com.vetcontrol.modelo.Cliente;
import java.util.List;

public interface ClienteDAO {

    boolean guardar(Cliente cliente);

    List<Cliente> listar();
    int contar();

}
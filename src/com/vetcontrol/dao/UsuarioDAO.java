package com.vetcontrol.dao;

import com.vetcontrol.modelo.Usuario;

public interface UsuarioDAO {

    Usuario login(String usuario, String password);

}
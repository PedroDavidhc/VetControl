package com.vetcontrol;

import com.vetcontrol.dao.UsuarioDAO;
import com.vetcontrol.dao.UsuarioDAOImpl;
import com.vetcontrol.modelo.Usuario;

public class TestLogin {

    public static void main(String[] args) {

        UsuarioDAO dao = new UsuarioDAOImpl();

        Usuario usuario = dao.login("admin", "123456");

        if (usuario != null) {
            System.out.println("Bienvenido " + usuario.getUsuario());
        } else {
            System.out.println("Usuario incorrecto");
        }
    }
}
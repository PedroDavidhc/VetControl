package com.vetcontrol.dao;

import com.vetcontrol.conexion.Conexion;
import com.vetcontrol.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAOImpl implements UsuarioDAO {

    @Override
    public Usuario login(String usuario, String password) {

        Usuario user = null;

        try {

            Connection cn = Conexion.conectar();

            String sql =
                    "SELECT * FROM usuarios "
                    + "WHERE usuario=? AND password=?";

            PreparedStatement ps =
                    cn.prepareStatement(sql);

            ps.setString(1, usuario);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                user = new Usuario();

                user.setId(rs.getInt("id"));
                user.setUsuario(rs.getString("usuario"));
                user.setPassword(rs.getString("password"));
                user.setRol(rs.getString("rol"));
            }

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        return user;
    }
}
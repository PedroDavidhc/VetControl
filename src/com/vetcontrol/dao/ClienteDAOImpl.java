package com.vetcontrol.dao;

import com.vetcontrol.conexion.Conexion;
import com.vetcontrol.modelo.Cliente;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class ClienteDAOImpl implements ClienteDAO {

@Override
public boolean guardar(Cliente cliente) {

    String sql = """
                 INSERT INTO clientes
                 (dni,nombres,telefono,direccion)
                 VALUES (?,?,?,?)
                 """;

    try {

        Connection con = Conexion.conectar();

        PreparedStatement ps =
                con.prepareStatement(sql);

        ps.setString(1, cliente.getDni());
        ps.setString(2, cliente.getNombres());
        ps.setString(3, cliente.getTelefono());
        ps.setString(4, cliente.getDireccion());

        return ps.executeUpdate() > 0;

    } catch (SQLException e) {

        System.out.println("Error al guardar cliente: "
                + e.getMessage());

    }

    return false;
}

@Override
public List<Cliente> listar() {

    List<Cliente> lista = new ArrayList<>();

    String sql = "SELECT * FROM clientes";

    try {

        Connection con = Conexion.conectar();

        PreparedStatement ps =
                con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            Cliente cliente = new Cliente();

            cliente.setId(rs.getInt("id"));
            cliente.setDni(rs.getString("dni"));
            cliente.setNombres(rs.getString("nombres"));
            cliente.setTelefono(rs.getString("telefono"));
            cliente.setDireccion(rs.getString("direccion"));

            lista.add(cliente);
        }

    } catch (SQLException e) {

        System.out.println(
                "Error al listar clientes: "
                + e.getMessage()
        );
    }

    return lista;
}

}
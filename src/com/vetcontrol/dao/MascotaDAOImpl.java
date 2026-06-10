package com.vetcontrol.dao;

import com.vetcontrol.modelo.Mascota;
import java.util.ArrayList;
import java.util.List;
import com.vetcontrol.conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class MascotaDAOImpl implements MascotaDAO {

@Override
public boolean guardar(Mascota mascota) {

String sql =
        "INSERT INTO mascotas "
        + "(cliente_id,nombre,sexo,especie,raza,edad,peso) "
        + "VALUES (?,?,?,?,?,?,?)";

    try {

        Connection con = Conexion.conectar();

        PreparedStatement ps =
                con.prepareStatement(sql);

            ps.setInt(1, mascota.getClienteId());
            ps.setString(2, mascota.getNombre());
            ps.setString(3, mascota.getSexo());
            ps.setString(4, mascota.getEspecie());
            ps.setString(5, mascota.getRaza());
            ps.setInt(6, mascota.getEdad());
            ps.setDouble(7, mascota.getPeso());
        return ps.executeUpdate() > 0;

    } catch (SQLException e) {

        System.out.println(
                "Error al guardar mascota: "
                + e.getMessage()
        );
    }

    return false;
}

@Override
public List<Mascota> listar() {

    List<Mascota> lista = new ArrayList<>();

    String sql = "SELECT * FROM mascotas";

    try {

        Connection con = Conexion.conectar();

        PreparedStatement ps =
                con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            Mascota mascota = new Mascota();

            mascota.setId(rs.getInt("id"));
            mascota.setClienteId(rs.getInt("cliente_id"));
            mascota.setNombre(rs.getString("nombre"));
            mascota.setSexo(rs.getString("sexo"));
            mascota.setEspecie(rs.getString("especie"));
            mascota.setRaza(rs.getString("raza"));
            mascota.setEdad(rs.getInt("edad"));
            mascota.setPeso(rs.getDouble("peso"));

            lista.add(mascota);
        }

    } catch (SQLException e) {

        System.out.println(
                "Error al listar mascotas: "
                + e.getMessage()
        );
    }

    return lista;
}
@Override
public int contar() {

    int total = 0;

    String sql = "SELECT COUNT(*) FROM mascotas";

    try {

        Connection con = Conexion.conectar();

        PreparedStatement ps =
                con.prepareStatement(sql);

        ResultSet rs =
                ps.executeQuery();

        if (rs.next()) {

            total = rs.getInt(1);
        }

    } catch (SQLException e) {

        System.out.println(
                "Error al contar: "
                + e.getMessage()
        );
    }

    return total;
}
}
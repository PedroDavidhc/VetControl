package com.vetcontrol.dao;

import com.vetcontrol.conexion.Conexion;
import com.vetcontrol.modelo.Factura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class FacturaDAOImpl implements FacturaDAO {

@Override
public boolean guardar(Factura factura) {

    String sql =
            "INSERT INTO facturas "
            + "(mascota_id,fecha,concepto,monto) "
            + "VALUES (?,?,?,?)";

    try {

        Connection con =
                Conexion.conectar();

        PreparedStatement ps =
                con.prepareStatement(sql);

        ps.setInt(
                1,
                factura.getMascotaId()
        );

        ps.setDate(
                2,
                factura.getFecha()
        );

        ps.setString(
                3,
                factura.getConcepto()
        );

        ps.setDouble(
                4,
                factura.getMonto()
        );

        return ps.executeUpdate() > 0;

    } catch (SQLException e) {

        System.out.println(
                "Error al guardar factura: "
                + e.getMessage()
        );
    }

    return false;
}

@Override
public List<Factura> listar() {

    List<Factura> lista =
            new ArrayList<>();

    String sql =
            "SELECT * FROM facturas";

    try {

        Connection con =
                Conexion.conectar();

        PreparedStatement ps =
                con.prepareStatement(sql);

        ResultSet rs =
                ps.executeQuery();

        while (rs.next()) {

            Factura factura =
                    new Factura();

            factura.setId(
                    rs.getInt("id")
            );

            factura.setMascotaId(
                    rs.getInt("mascota_id")
            );

            factura.setFecha(
                    rs.getDate("fecha")
            );

            factura.setConcepto(
                    rs.getString("concepto")
            );

            factura.setMonto(
                    rs.getDouble("monto")
            );

            lista.add(factura);
        }

    } catch (SQLException e) {

        System.out.println(
                "Error al listar facturas: "
                + e.getMessage()
        );
    }

    return lista;
}

@Override
public int contar() {

    int total = 0;

    String sql = "SELECT COUNT(*) FROM facturas";

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

package com.vetcontrol.dao;

import com.vetcontrol.conexion.Conexion;
import com.vetcontrol.modelo.HistoriaClinica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class HistoriaClinicaDAOImpl
        implements HistoriaClinicaDAO {

    @Override
    public boolean guardar(
            HistoriaClinica historia) {

        String sql =
                "INSERT INTO historia_clinica "
                + "(mascota_id,fecha,peso,"
                + "temperatura,diagnostico,"
                + "tratamiento,observaciones) "
                + "VALUES (?,?,?,?,?,?,?)";

        try {

            Connection con =
                    Conexion.conectar();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(
                    1,
                    historia.getMascotaId()
            );

            ps.setDate(
                    2,
                    historia.getFecha()
            );

            ps.setDouble(
                    3,
                    historia.getPeso()
            );

            ps.setDouble(
                    4,
                    historia.getTemperatura()
            );

            ps.setString(
                    5,
                    historia.getDiagnostico()
            );

            ps.setString(
                    6,
                    historia.getTratamiento()
            );

            ps.setString(
                    7,
                    historia.getObservaciones()
            );

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            System.out.println(
                    "Error al guardar historia clínica: "
                    + e.getMessage()
            );
        }

        return false;
    }

    @Override
    public List<HistoriaClinica> listar() {

        List<HistoriaClinica> lista =
                new ArrayList<>();

        String sql =
                "SELECT * FROM historia_clinica";

        try {

            Connection con =
                    Conexion.conectar();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ResultSet rs =
                    ps.executeQuery();

            while (rs.next()) {

                HistoriaClinica historia =
                        new HistoriaClinica();

                historia.setId(
                        rs.getInt("id")
                );

                historia.setMascotaId(
                        rs.getInt("mascota_id")
                );

                historia.setFecha(
                        rs.getDate("fecha")
                );

                historia.setPeso(
                        rs.getDouble("peso")
                );

                historia.setTemperatura(
                        rs.getDouble("temperatura")
                );

                historia.setDiagnostico(
                        rs.getString("diagnostico")
                );

                historia.setTratamiento(
                        rs.getString("tratamiento")
                );

                historia.setObservaciones(
                        rs.getString("observaciones")
                );

                lista.add(historia);
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error al listar historias: "
                    + e.getMessage()
            );
        }

        return lista;
    }
@Override
public int contar() {

    int total = 0;

    String sql = "SELECT COUNT(*) FROM historia_clinica";

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
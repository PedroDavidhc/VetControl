package com.vetcontrol.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    private static final String URL =
            "jdbc:mysql://localhost:3306/vetcontrol";

    private static final String USER = "root";

    private static final String PASSWORD = "Energycom25";

    public static Connection conectar() {

        Connection cn = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            cn = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );

            System.out.println("Conexión exitosa");

        } catch (Exception e) {

            System.out.println("Error de conexión: "
                    + e.getMessage());
        }

        return cn;
    }

    public static Connection getConexion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
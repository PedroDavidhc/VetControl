/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vetcontrol;

import com.vetcontrol.conexion.Conexion;
import java.sql.Connection;

public class TestConexion {

    public static void main(String[] args) {

        Connection cn = Conexion.conectar();

        if (cn != null) {
            System.out.println("Base de datos conectada correctamente");
        } else {
            System.out.println("No se pudo conectar a la base de datos");
        }
    }
}
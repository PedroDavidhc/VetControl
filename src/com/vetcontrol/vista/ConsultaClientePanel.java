package com.vetcontrol.vista;

import com.vetcontrol.dao.ClienteDAOImpl;
import com.vetcontrol.dao.MascotaDAOImpl;
import com.vetcontrol.modelo.Cliente;
import com.vetcontrol.modelo.Mascota;
import com.vetcontrol.util.MensajeUtil;

import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ConsultaClientePanel extends JPanel {

    private JTextField txtDni;

    private JButton btnBuscar;

    private JLabel lblNombre;

    private JLabel lblTelefono;

    private JLabel lblDireccion;

    private JTable tablaMascotas;

    private DefaultTableModel modelo;

    public ConsultaClientePanel() {

        setLayout(null);
        setBackground(
        new java.awt.Color(20,20,20)
);

JLabel lblDni =
        new JLabel("DNI:");

lblDni.setForeground(
        new java.awt.Color(0,255,102)
);

lblDni.setBounds(30, 30, 80, 25);

add(lblDni);

        txtDni = new JTextField();
        txtDni.setBackground(
        new java.awt.Color(40,40,40)
);

txtDni.setForeground(
        java.awt.Color.WHITE
);

txtDni.setCaretColor(
        new java.awt.Color(0,255,102)
);

txtDni.setBorder(
        BorderFactory.createLineBorder(
                new java.awt.Color(0,255,102)
        )
);

        txtDni.setBounds(80, 30, 150, 25);

        add(txtDni);

        btnBuscar =
                new JButton("Buscar");
        btnBuscar.setBackground(
        new java.awt.Color(40,40,40)
);

btnBuscar.setForeground(
        new java.awt.Color(0,255,102)
);

btnBuscar.setFocusPainted(false);

btnBuscar.setBorder(
        BorderFactory.createLineBorder(
                new java.awt.Color(130,140,150)
        )
);

        btnBuscar.setBounds(250, 30, 100, 25);

        add(btnBuscar);

        lblNombre =
                new JLabel("Nombre:");
        lblNombre.setForeground(
        new java.awt.Color(0,255,102)
);

        lblNombre.setBounds(30, 80, 500, 25);

        add(lblNombre);

        lblTelefono =
                new JLabel("Teléfono:");
        lblTelefono.setForeground(
        new java.awt.Color(0,255,102)
);

        lblTelefono.setBounds(30, 110, 500, 25);

        add(lblTelefono);

        lblDireccion =
                new JLabel("Dirección:");
        lblDireccion.setForeground(
        new java.awt.Color(0,255,102)
);

        lblDireccion.setBounds(30, 140, 500, 25);

        add(lblDireccion);

        modelo =
                new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Especie");
        modelo.addColumn("Raza");
        modelo.addColumn("Edad");

        tablaMascotas =
                new JTable(modelo);
       tablaMascotas.setBackground(
        new java.awt.Color(20,20,20)
);

tablaMascotas.setForeground(
        java.awt.Color.WHITE
);

tablaMascotas.setGridColor(
        new java.awt.Color(0,255,102)
);

tablaMascotas.setSelectionBackground(
        new java.awt.Color(0,120,60)
);

tablaMascotas.setSelectionForeground(
        java.awt.Color.WHITE
);

tablaMascotas.getTableHeader().setBackground(
        new java.awt.Color(40,40,40)
);

tablaMascotas.getTableHeader().setForeground(
        new java.awt.Color(0,255,102)
); 

        JScrollPane scroll =
                new JScrollPane(tablaMascotas);
        scroll.getViewport().setBackground(
        new java.awt.Color(20,20,20)
);

        scroll.setBounds(
                30,
                200,
                720,
                300
        );

        add(scroll);

        btnBuscar.addActionListener(
                e -> buscarCliente()
        );
    }

    private void buscarCliente() {

        String dni =
                txtDni.getText();

        ClienteDAOImpl clienteDAO =
                new ClienteDAOImpl();

        Cliente cliente =
                clienteDAO.buscarPorDni(dni);

        if (cliente == null) {

            MensajeUtil.info(
        this,
                    "Cliente no encontrado"
            );

            return;
        }

        lblNombre.setText(
                "Nombre: "
                + cliente.getNombres()
        );

        lblTelefono.setText(
                "Teléfono: "
                + cliente.getTelefono()
        );

        lblDireccion.setText(
                "Dirección: "
                + cliente.getDireccion()
        );

        modelo.setRowCount(0);

        MascotaDAOImpl mascotaDAO =
                new MascotaDAOImpl();

        List<Mascota> mascotas =
                mascotaDAO.listarPorCliente(
                        cliente.getId()
                );

        for (Mascota mascota : mascotas) {

            modelo.addRow(new Object[]{

                mascota.getId(),
                mascota.getNombre(),
                mascota.getEspecie(),
                mascota.getRaza(),
                mascota.getEdad()
            });
        }
    }
}
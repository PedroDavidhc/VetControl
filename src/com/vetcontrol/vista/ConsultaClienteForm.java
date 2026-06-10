package com.vetcontrol.vista;

import com.vetcontrol.dao.ClienteDAOImpl;
import com.vetcontrol.dao.MascotaDAOImpl;
import com.vetcontrol.modelo.Cliente;
import com.vetcontrol.modelo.Mascota;

import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ConsultaClienteForm extends JFrame {

    private JTextField txtDni;

    private JButton btnBuscar;

    private JLabel lblNombre;

    private JLabel lblTelefono;

    private JLabel lblDireccion;

    private JTable tablaMascotas;

    private DefaultTableModel modelo;

    public ConsultaClienteForm() {

        setTitle("Consulta de Clientes");

        setSize(800, 600);

        setLocationRelativeTo(null);

        setLayout(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel lblDni =
                new JLabel("DNI:");

        lblDni.setBounds(30, 30, 80, 25);

        add(lblDni);

        txtDni = new JTextField();

        txtDni.setBounds(80, 30, 150, 25);

        add(txtDni);

        btnBuscar =
                new JButton("Buscar");

        btnBuscar.setBounds(250, 30, 100, 25);

        add(btnBuscar);

        lblNombre =
                new JLabel("Nombre:");

        lblNombre.setBounds(30, 80, 500, 25);

        add(lblNombre);

        lblTelefono =
                new JLabel("Teléfono:");

        lblTelefono.setBounds(30, 110, 500, 25);

        add(lblTelefono);

        lblDireccion =
                new JLabel("Dirección:");

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

        JScrollPane scroll =
                new JScrollPane(tablaMascotas);

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

            JOptionPane.showMessageDialog(
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

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            new ConsultaClienteForm()
                    .setVisible(true);

        });
    }
}
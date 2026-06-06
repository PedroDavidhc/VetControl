package com.vetcontrol.vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AdmisionMenuForm extends JFrame {

    public AdmisionMenuForm() {

        setTitle("Admisión");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel lblTitulo =
                new JLabel("MÓDULO DE ADMISIÓN");

        lblTitulo.setBounds(120, 30, 200, 30);

        add(lblTitulo);

        JButton btnCliente =
                new JButton("Registrar Cliente");

        btnCliente.setBounds(90, 90, 200, 40);

        btnCliente.addActionListener(e -> {

            new AdmisionForm().setVisible(true);

        });

        add(btnCliente);

        JButton btnMascota =
                new JButton("Registrar Mascota");

        btnMascota.setBounds(90, 150, 200, 40);

        btnMascota.addActionListener(e -> {

            new MascotaForm().setVisible(true);

        });

        add(btnMascota);
    }
}
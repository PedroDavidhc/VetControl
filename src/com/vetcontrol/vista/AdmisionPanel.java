package com.vetcontrol.vista;

import javax.swing.*;

public class AdmisionPanel extends JPanel {

   public AdmisionPanel(JPanel panelContenido) {

    this.panelContenido =
            panelContenido;

        setLayout(null);

        JLabel lblTitulo =
                new JLabel("MÓDULO DE ADMISIÓN");

        lblTitulo.setBounds(
                350,
                50,
                250,
                30
        );

        add(lblTitulo);

        JButton btnClientes =
                new JButton("Registro de Clientes");

        btnClientes.setBounds(
                320,
                180,
                250,
                50
        );

        add(btnClientes);

        JButton btnMascotas =
                new JButton("Registro de Mascotas");

        btnMascotas.setBounds(
                320,
                280,
                250,
                50
        );

        add(btnMascotas);

        btnClientes.addActionListener(e -> {

            panelContenido.removeAll();

            ClientePanel panel =
                    new ClientePanel(panelContenido);

            panel.setBounds(
                    0,
                    0,
                    panelContenido.getWidth(),
                    panelContenido.getHeight()
            );

            panelContenido.add(panel);

            panelContenido.revalidate();

            panelContenido.repaint();

        });

                btnMascotas.addActionListener(e -> {

            panelContenido.removeAll();

            MascotaPanel panel =
                    new MascotaPanel(panelContenido);

            panel.setBounds(
                    0,
                    0,
                    panelContenido.getWidth(),
                    panelContenido.getHeight()
            );

            panelContenido.add(panel);

            panelContenido.revalidate();

            panelContenido.repaint();

});
    }
 private JPanel panelContenido;   
}
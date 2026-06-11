package com.vetcontrol.vista;

import javax.swing.*;
import java.awt.Font;
import javax.swing.BorderFactory;

public class AdmisionPanel extends JPanel {

   public AdmisionPanel(JPanel panelContenido) {
       setBackground(
        new java.awt.Color(20,20,20)
);

    this.panelContenido =
            panelContenido;

        setLayout(null);

        JLabel lblTitulo =
                new JLabel("MÓDULO DE ADMISIÓN");
        lblTitulo.setForeground(
        new java.awt.Color(0,255,102)
);

lblTitulo.setFont(
        new Font("Arial", Font.BOLD, 20)
);
        

        lblTitulo.setBounds(
                335,
                80,
                400,
                40
        );

        add(lblTitulo);

        JButton btnClientes =
                new JButton("Registro de Clientes");
        btnClientes.setBackground(
        new java.awt.Color(40,40,40)
);

btnClientes.setForeground(
        new java.awt.Color(0,255,102)
);

btnClientes.setFocusPainted(false);

btnClientes.setBorder(
        BorderFactory.createLineBorder(
                new java.awt.Color(130,140,150)
        )
);
        

        btnClientes.setBounds(
                320,
                180,
                250,
                50
        );

        add(btnClientes);

        JButton btnMascotas =
                new JButton("Registro de Mascotas");
        btnMascotas.setBackground(
        new java.awt.Color(40,40,40)
);

btnMascotas.setForeground(
        new java.awt.Color(0,255,102)
);

btnMascotas.setFocusPainted(false);

btnMascotas.setBorder(
        BorderFactory.createLineBorder(
                new java.awt.Color(130,140,150)
        )
);

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
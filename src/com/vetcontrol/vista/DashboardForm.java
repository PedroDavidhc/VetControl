package com.vetcontrol.vista;

import javax.swing.*;
import com.vetcontrol.vista.AdmisionForm;

public class DashboardForm extends JFrame {

    private JPanel panelMenu;
    private JPanel panelHeader;
    private JPanel panelContenido;

    public DashboardForm() {

        setTitle("VetControl - Dashboard");
        setSize(1200, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        crearPanelMenu();
        crearHeader();
        crearContenido();
    }

    private void crearPanelMenu() {

        panelMenu = new JPanel();
        panelMenu.setLayout(null);
        panelMenu.setBounds(0, 0, 220, 700);

        JButton btnDashboard = new JButton("Dashboard");
        btnDashboard.setBounds(20, 80, 170, 35);

        JButton btnAdmision = new JButton("Admisión");
        btnAdmision.setBounds(20, 130, 170, 35);
btnAdmision.addActionListener(e -> {

    AdmisionMenuForm admision =
            new AdmisionMenuForm();

    admision.setVisible(true);

});
        

        JButton btnHistoria = new JButton("Historia Clínica");
        btnHistoria.setBounds(20, 180, 170, 35);

        JButton btnFacturacion = new JButton("Facturación");
        btnFacturacion.setBounds(20, 230, 170, 35);

        JButton btnSalir = new JButton("Cerrar Sesión");
        btnSalir.setBounds(20, 550, 170, 35);

        panelMenu.add(btnDashboard);
        panelMenu.add(btnAdmision);
        panelMenu.add(btnHistoria);
        panelMenu.add(btnFacturacion);
        panelMenu.add(btnSalir);

        add(panelMenu);
    }

    private void crearHeader() {

        panelHeader = new JPanel();
        panelHeader.setLayout(null);
        panelHeader.setBounds(220, 0, 980, 80);

        JLabel lblTitulo = new JLabel("VETCONTROL");
        lblTitulo.setBounds(420, 20, 200, 30);

        panelHeader.add(lblTitulo);

        add(panelHeader);
    }

    private void crearContenido() {

        panelContenido = new JPanel();
        panelContenido.setLayout(null);
        panelContenido.setBounds(220, 80, 980, 620);

        JLabel lblBienvenida =
                new JLabel("Bienvenido al Sistema Veterinario");

        lblBienvenida.setBounds(320, 100, 300, 30);

        panelContenido.add(lblBienvenida);

        add(panelContenido);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new DashboardForm().setVisible(true);
        });

    }
}
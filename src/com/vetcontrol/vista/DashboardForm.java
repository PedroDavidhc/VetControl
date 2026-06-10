package com.vetcontrol.vista;

import javax.swing.*;
import com.vetcontrol.vista.AdmisionForm;
import com.vetcontrol.dao.ClienteDAOImpl;
import com.vetcontrol.dao.MascotaDAOImpl;
import com.vetcontrol.dao.HistoriaClinicaDAOImpl;
import com.vetcontrol.dao.FacturaDAOImpl;

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
        btnHistoria.addActionListener(e -> {

            HistoriaClinicaForm historia =
                    new HistoriaClinicaForm();

            historia.setVisible(true);

        });
        

        JButton btnFacturacion = new JButton("Facturación");
        btnFacturacion.setBounds(20, 230, 170, 35);
        btnFacturacion.addActionListener(e -> {

            FacturacionForm factura =
                    new FacturacionForm();

            factura.setVisible(true);

        });

                JButton btnSalir = new JButton("Cerrar Sesión");
                btnSalir.setBounds(20, 550, 170, 35);
                btnSalir.addActionListener(e -> {

            dispose();

            LoginForm login =
                    new LoginForm();

            login.setVisible(true);

        });

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

        lblBienvenida.setBounds(330, 30, 300, 30);

        panelContenido.add(lblBienvenida);

        ClienteDAOImpl clienteDAO =
                new ClienteDAOImpl();

        MascotaDAOImpl mascotaDAO =
                new MascotaDAOImpl();

        HistoriaClinicaDAOImpl historiaDAO =
                new HistoriaClinicaDAOImpl();

        FacturaDAOImpl facturaDAO =
                new FacturaDAOImpl();

        int totalClientes =
                clienteDAO.contar();

        int totalMascotas =
                mascotaDAO.contar();

        int totalHistorias =
                historiaDAO.contar();

        int totalFacturas =
                facturaDAO.contar();

        JLabel lblClientes =
                new JLabel(
                        "Total Clientes: "
                        + totalClientes
                );

        lblClientes.setBounds(
                100,
                120,
                250,
                30
        );

        panelContenido.add(lblClientes);

        JLabel lblMascotas =
                new JLabel(
                        "Total Mascotas: "
                        + totalMascotas
                );

        lblMascotas.setBounds(
                100,
                180,
                250,
                30
        );

        panelContenido.add(lblMascotas);

        JLabel lblHistorias =
                new JLabel(
                        "Total Historias Clínicas: "
                        + totalHistorias
                );

        lblHistorias.setBounds(
                100,
                240,
                300,
                30
        );

        panelContenido.add(lblHistorias);

        JLabel lblFacturas =
                new JLabel(
                        "Total Facturas: "
                        + totalFacturas
                );

        lblFacturas.setBounds(
                100,
                300,
                250,
                30
        );

        panelContenido.add(lblFacturas);

        add(panelContenido);
    }
}
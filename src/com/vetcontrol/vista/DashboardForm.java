package com.vetcontrol.vista;

import javax.swing.*;
import com.vetcontrol.vista.AdmisionForm;
import com.vetcontrol.dao.ClienteDAOImpl;
import com.vetcontrol.dao.MascotaDAOImpl;
import com.vetcontrol.dao.HistoriaClinicaDAOImpl;
import com.vetcontrol.dao.FacturaDAOImpl;
import java.awt.Font;

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
                JButton btnConsultaCliente =
                new JButton("Consulta Cliente");

        btnConsultaCliente.setBounds(
                20,
                280,
                170,
                35
        );

        btnConsultaCliente.addActionListener(e -> {

            ConsultaClienteForm consulta =
                    new ConsultaClienteForm();

            consulta.setVisible(true);

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
            panelMenu.add(btnConsultaCliente);
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

    lblBienvenida.setFont(
            new Font("Arial", Font.BOLD, 18)
    );

    lblBienvenida.setBounds(330, 30, 350, 30);

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

    // TARJETA CLIENTES

    JPanel cardClientes = new JPanel();

    cardClientes.setLayout(null);

    cardClientes.setBounds(40, 120, 200, 120);

    cardClientes.setBorder(
            BorderFactory.createTitledBorder("CLIENTES")
    );

    JLabel lblTotalClientes =
            new JLabel(String.valueOf(totalClientes));

    lblTotalClientes.setFont(
            new Font("Arial", Font.BOLD, 36)
    );

    lblTotalClientes.setBounds(75, 35, 100, 40);

    cardClientes.add(lblTotalClientes);

    panelContenido.add(cardClientes);

    // TARJETA MASCOTAS

    JPanel cardMascotas = new JPanel();

    cardMascotas.setLayout(null);

    cardMascotas.setBounds(270, 120, 200, 120);

    cardMascotas.setBorder(
            BorderFactory.createTitledBorder("MASCOTAS")
    );

    JLabel lblTotalMascotas =
            new JLabel(String.valueOf(totalMascotas));

    lblTotalMascotas.setFont(
            new Font("Arial", Font.BOLD, 36)
    );

    lblTotalMascotas.setBounds(75, 35, 100, 40);

    cardMascotas.add(lblTotalMascotas);

    panelContenido.add(cardMascotas);

    // TARJETA HISTORIAS

    JPanel cardHistorias = new JPanel();

    cardHistorias.setLayout(null);

    cardHistorias.setBounds(500, 120, 200, 120);

    cardHistorias.setBorder(
            BorderFactory.createTitledBorder("HISTORIAS")
    );

    JLabel lblTotalHistorias =
            new JLabel(String.valueOf(totalHistorias));

    lblTotalHistorias.setFont(
            new Font("Arial", Font.BOLD, 36)
    );

    lblTotalHistorias.setBounds(75, 35, 100, 40);

    cardHistorias.add(lblTotalHistorias);

    panelContenido.add(cardHistorias);

    // TARJETA FACTURAS

    JPanel cardFacturas = new JPanel();

    cardFacturas.setLayout(null);

    cardFacturas.setBounds(730, 120, 200, 120);

    cardFacturas.setBorder(
            BorderFactory.createTitledBorder("FACTURAS")
    );

    JLabel lblTotalFacturas =
            new JLabel(String.valueOf(totalFacturas));

    lblTotalFacturas.setFont(
            new Font("Arial", Font.BOLD, 36)
    );

    lblTotalFacturas.setBounds(75, 35, 100, 40);

    cardFacturas.add(lblTotalFacturas);

    panelContenido.add(cardFacturas);

    add(panelContenido);
}
}
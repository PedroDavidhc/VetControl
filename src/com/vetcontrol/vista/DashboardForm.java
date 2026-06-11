package com.vetcontrol.vista;

import javax.swing.*;

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
        getContentPane().setBackground(
        new java.awt.Color(25, 25, 25)
);

        crearPanelMenu();
        crearHeader();
        crearContenido();
    }

    private void crearPanelMenu() {

        panelMenu = new JPanel();
        panelMenu.setLayout(null);
        panelMenu.setBounds(0, 0, 220, 700);
        panelMenu.setBackground(
        new java.awt.Color(20, 20, 20)
);

        JButton btnDashboard = new JButton("Dashboard");
                    btnDashboard.setBackground(
                    new java.awt.Color(40, 40, 40)
            );

            btnDashboard.setForeground(
                    new java.awt.Color(0, 255, 102)
            );
        btnDashboard.setBounds(20, 80, 170, 35);
            btnDashboard.addActionListener(e -> {

        mostrarDashboard();

    });

        JButton btnAdmision = new JButton("Admisión");
                btnAdmision.setBackground(
                new java.awt.Color(40, 40, 40)
        );

        btnAdmision.setForeground(
                new java.awt.Color(0, 255, 102)
        );
                btnAdmision.setBounds(20, 130, 170, 35);
        btnAdmision.addActionListener(e -> {

            mostrarPanel(
                    new AdmisionPanel(panelContenido)
            );
        });
        

                JButton btnHistoria = new JButton("Historia Clínica");
                btnHistoria.setBackground(
        new java.awt.Color(40,40,40)
);
            btnHistoria.setForeground(
                    new java.awt.Color(0, 255, 102)
            );

            btnAdmision.setForeground(
                    new java.awt.Color(0, 255, 102)
            );
                btnHistoria.setBounds(20, 180, 170, 35);
                btnHistoria.addActionListener(e -> {

            mostrarPanel(
                    new HistoriaClinicaPanel()
            );
        });
        

        JButton btnFacturacion = new JButton("Facturación");
        btnFacturacion.setBackground(
        new java.awt.Color(40,40,40)
);
            btnFacturacion.setForeground(
                    new java.awt.Color(0, 255, 102)
            );

        btnAdmision.setForeground(
                new java.awt.Color(0, 255, 102)
        );
        btnFacturacion.setBounds(20, 230, 170, 35);
        btnFacturacion.addActionListener(e -> {

            mostrarPanel(
                    new FacturacionPanel()
            );
        });
                JButton btnConsultaCliente =
                new JButton("Consulta Cliente");
            btnConsultaCliente.setBackground(
                    new java.awt.Color(40,40,40)
            );

            btnConsultaCliente.setForeground(
                    new java.awt.Color(0,255,102)
            );

btnAdmision.setForeground(
        new java.awt.Color(0, 255, 102)
);

        btnConsultaCliente.setBounds(
                20,
                280,
                170,
                35
        );

btnConsultaCliente.addActionListener(e -> {

    mostrarPanel(
            new ConsultaClientePanel()
    );
});
        

                JButton btnSalir = new JButton("Cerrar Sesión");
                btnSalir.setBackground(
                        new java.awt.Color(40,40,40)
                );

                btnSalir.setForeground(
                        new java.awt.Color(0,255,102)
                );
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

    panelHeader.setBounds(
            220,
            0,
            980,
            80
    );

    panelHeader.setBackground(
            new java.awt.Color(15, 15, 15)
    );

    JLabel lblTitulo =
            new JLabel("VETCONTROL");

    lblTitulo.setFont(
            new Font("Arial", Font.BOLD, 22)
    );

    lblTitulo.setForeground(
            new java.awt.Color(0, 255, 102)
    );

    lblTitulo.setBounds(
            400,
            20,
            250,
            30
    );

    panelHeader.add(lblTitulo);

    add(panelHeader);
}

    private void crearContenido() {

            panelContenido = new JPanel();
            panelContenido.setLayout(null);
            panelContenido.setBounds(
                    220,
                    80,
                    980,
                    620
            );
            panelContenido.setBackground(
        new java.awt.Color(25, 25, 25)
);

            add(panelContenido);

            mostrarDashboard();
        }
private void mostrarPanel(JPanel panel) {

    panelContenido.removeAll();

    panel.setBounds(
            0,
            0,
            panelContenido.getWidth(),
            panelContenido.getHeight()
    );

    panelContenido.add(panel);

    panelContenido.revalidate();

    panelContenido.repaint();
} 
private void mostrarDashboard() {

    panelContenido.removeAll();

    JLabel lblBienvenida =
            new JLabel("Bienvenido al Sistema Veterinario");

    lblBienvenida.setFont(
            new Font("Arial", Font.BOLD, 18)
    );
    lblBienvenida.setForeground(
        new java.awt.Color(0, 255, 102)
);

    lblBienvenida.setBounds(
            330,
            30,
            350,
            30
    );

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
    
    JPanel cardClientes = new JPanel();
    
   
    cardClientes.setLayout(null);

    cardClientes.setBounds(
            40,
            120,
            200,
            120
    );

javax.swing.border.TitledBorder bordeClientes =
        BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(
                        new java.awt.Color(0,255,102),
                        2
                ),
                "CLIENTES"
        );

bordeClientes.setTitleColor(
        new java.awt.Color(180,180,180)
);

cardClientes.setBorder(bordeClientes);

    JLabel lblTotalClientes =
            new JLabel(
                    String.valueOf(totalClientes)
            );

    lblTotalClientes.setFont(
            new Font("Arial", Font.BOLD, 36)
    );
    lblTotalClientes.setForeground(
        new java.awt.Color(0,255,102)
);

    lblTotalClientes.setBounds(
            75,
            35,
            100,
            40
    );

    cardClientes.add(lblTotalClientes);

    panelContenido.add(cardClientes);

    JPanel cardMascotas = new JPanel();
    cardClientes.setBackground(
        new java.awt.Color(20, 20, 20)
);

    cardMascotas.setLayout(null);

    cardMascotas.setBounds(
            270,
            120,
            200,
            120
    );

javax.swing.border.TitledBorder bordeMascotas =
        BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(
                        new java.awt.Color(0,255,102),
                        2
                ),
                "MASCOTAS"
        );

bordeMascotas.setTitleColor(
        new java.awt.Color(180,180,180)
);

cardMascotas.setBorder(bordeMascotas);
    

    JLabel lblTotalMascotas =
            new JLabel(
                    String.valueOf(totalMascotas)
            );

    lblTotalMascotas.setFont(
            new Font("Arial", Font.BOLD, 36)
    );
    lblTotalMascotas.setForeground(
        new java.awt.Color(0,255,102)
);

    lblTotalMascotas.setBounds(
            75,
            35,
            100,
            40
    );

    cardMascotas.add(lblTotalMascotas);

    panelContenido.add(cardMascotas);

    JPanel cardHistorias = new JPanel();
    cardMascotas.setBackground(
        new java.awt.Color(20, 20, 20)
);
    cardHistorias.setBackground(
        new java.awt.Color(20,20,20)
);

    cardHistorias.setLayout(null);

    cardHistorias.setBounds(
            500,
            120,
            200,
            120
    );

javax.swing.border.TitledBorder bordeHistorias =
        BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(
                        new java.awt.Color(0,255,102),
                        2
                ),
                "HISTORIAS"
        );

bordeHistorias.setTitleColor(
        new java.awt.Color(180,180,180)
);

cardHistorias.setBorder(bordeHistorias);

    JLabel lblTotalHistorias =
            new JLabel(
                    String.valueOf(totalHistorias)
            );

    lblTotalHistorias.setFont(
            new Font("Arial", Font.BOLD, 36)
    );
    lblTotalHistorias.setForeground(
        new java.awt.Color(0,255,102)
);
    

    lblTotalHistorias.setBounds(
            75,
            35,
            100,
            40
    );

    cardHistorias.add(lblTotalHistorias);

    panelContenido.add(cardHistorias);

    JPanel cardFacturas = new JPanel();
    cardFacturas.setBackground(
        new java.awt.Color(20,20,20)
);

    cardFacturas.setLayout(null);

    cardFacturas.setBounds(
            730,
            120,
            200,
            120
    );

javax.swing.border.TitledBorder bordeFacturas =
        BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(
                        new java.awt.Color(0,255,102),
                        2
                ),
                "FACTURAS"
        );

bordeFacturas.setTitleColor(
        new java.awt.Color(180,180,180)
);

cardFacturas.setBorder(bordeFacturas);

    JLabel lblTotalFacturas =
            new JLabel(
                    String.valueOf(totalFacturas)
            );

    lblTotalFacturas.setFont(
            new Font("Arial", Font.BOLD, 36)
    );
    lblTotalFacturas.setForeground(
        new java.awt.Color(0,255,102)
);
   

    lblTotalFacturas.setBounds(
            75,
            35,
            100,
            40
    );

    cardFacturas.add(lblTotalFacturas);

    panelContenido.add(cardFacturas);

    panelContenido.revalidate();

    panelContenido.repaint();
}
}
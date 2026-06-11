package com.vetcontrol.vista;

import javax.swing.*;
import com.vetcontrol.dao.ClienteDAO;
import com.vetcontrol.dao.ClienteDAOImpl;
import com.vetcontrol.modelo.Cliente;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import com.vetcontrol.util.MensajeUtil;

public class ClientePanel extends JPanel {

    private JTextField txtDni;
    private JTextField txtNombres;
    private JTextField txtTelefono;
    private JTextField txtDireccion;

    private JButton btnGuardar;
    private JTable tablaClientes;
    private JButton btnVolver;
    private JPanel panelContenido;

private DefaultTableModel modeloTabla;

    public ClientePanel(JPanel panelContenido) {
    setBackground(
        new java.awt.Color(20,20,20)
);    

    this.panelContenido = panelContenido;

        setLayout(null);

JLabel lblDni = new JLabel("DNI:");

lblDni.setForeground(
        new java.awt.Color(0,255,102)
);

lblDni.setBounds(30, 30, 100, 25);

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

txtDni.setBounds(150, 30, 200, 25);

add(txtDni);

        JLabel lblNombres = new JLabel("Nombres:");
        lblNombres.setForeground(
        new java.awt.Color(0,255,102)
);
        lblNombres.setBounds(30, 80, 100, 25);
        add(lblNombres);

        txtNombres = new JTextField();
        txtNombres.setBackground(
        new java.awt.Color(40,40,40)
);

txtNombres.setForeground(
        java.awt.Color.WHITE
);

txtNombres.setCaretColor(
        new java.awt.Color(0,255,102)
);
txtNombres.setBorder(
        BorderFactory.createLineBorder(
                new java.awt.Color(0,255,102)
        )
);
        txtNombres.setBounds(150, 80, 200, 25);
        add(txtNombres);

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setForeground(
        new java.awt.Color(0,255,102)
);
        lblTelefono.setBounds(30, 130, 100, 25);
        add(lblTelefono);

        txtTelefono = new JTextField();
        txtTelefono.setBackground(
        new java.awt.Color(40,40,40)
);

txtTelefono.setForeground(
        java.awt.Color.WHITE
);

txtTelefono.setCaretColor(
        new java.awt.Color(0,255,102)
);
txtTelefono.setBorder(
        BorderFactory.createLineBorder(
                new java.awt.Color(0,255,102)
        )
);
        txtTelefono.setBounds(150, 130, 200, 25);
        add(txtTelefono);

        JLabel lblDireccion = new JLabel("Dirección:");
        lblDireccion.setForeground(
        new java.awt.Color(0,255,102)
);
        lblDireccion.setBounds(30, 180, 100, 25);
        add(lblDireccion);

        txtDireccion = new JTextField();
        txtDireccion.setBackground(
        new java.awt.Color(40,40,40)
);

txtDireccion.setForeground(
        java.awt.Color.WHITE
);

txtDireccion.setCaretColor(
        new java.awt.Color(0,255,102)
);
txtDireccion.setBorder(
        BorderFactory.createLineBorder(
                new java.awt.Color(0,255,102)
        )
);
        txtDireccion.setBounds(150, 180, 200, 25);
        add(txtDireccion);

        btnGuardar = new JButton("Guardar Cliente");
        btnGuardar.setBounds(150, 250, 150, 35);
        add(btnGuardar);
        modeloTabla = new DefaultTableModel();
        btnGuardar.setBackground(
        new java.awt.Color(40,40,40)
);

btnGuardar.setForeground(
        new java.awt.Color(0,255,102)
);

modeloTabla.addColumn("ID");
modeloTabla.addColumn("DNI");
modeloTabla.addColumn("Nombres");
modeloTabla.addColumn("Teléfono");

tablaClientes =
        new JTable(modeloTabla);

JScrollPane scroll =
        new JScrollPane(tablaClientes);
scroll.getViewport().setBackground(
        new java.awt.Color(20,20,20)
);
tablaClientes.setBackground(
        new java.awt.Color(30,30,30)
);

tablaClientes.setForeground(
        java.awt.Color.WHITE
);

tablaClientes.setGridColor(
        new java.awt.Color(0,255,102)
);

tablaClientes.setSelectionBackground(
        new java.awt.Color(0,120,60)
);

tablaClientes.setSelectionForeground(
        java.awt.Color.WHITE
);
tablaClientes.getTableHeader().setBackground(
        new java.awt.Color(40,40,40)
);

tablaClientes.getTableHeader().setForeground(
        new java.awt.Color(0,255,102)
);

scroll.setBounds(30, 300, 430, 150);

add(scroll);
cargarClientes();

        
        btnGuardar.addActionListener
        (e -> guardarCliente());
                    btnVolver = new JButton("Volver");
         btnVolver.setBackground(
        new java.awt.Color(40,40,40)
);

btnVolver.setForeground(
        new java.awt.Color(0,255,102)
);           

            btnVolver.setBounds(
                    320,
                    250,
                    120,
                    35
            );

            add(btnVolver);

            btnVolver.addActionListener(e -> {

                panelContenido.removeAll();

                AdmisionPanel panel =
                        new AdmisionPanel(panelContenido);

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

    
    private void guardarCliente() {
      if(txtDni.getText().trim().isEmpty() ||
   txtNombres.getText().trim().isEmpty() ||
   txtTelefono.getText().trim().isEmpty() ||
   txtDireccion.getText().trim().isEmpty()) {

    MensajeUtil.error(
            this,
            "Complete todos los campos"
    );
    return;
}  

    Cliente cliente = new Cliente();

    cliente.setDni(txtDni.getText());
    cliente.setNombres(txtNombres.getText());
    cliente.setTelefono(txtTelefono.getText());
    cliente.setDireccion(txtDireccion.getText());

    ClienteDAO dao = new ClienteDAOImpl();

    if (dao.guardar(cliente)) {

MensajeUtil.info(
        this,
        "Cliente registrado correctamente"
);

        limpiarCampos();
        cargarClientes();

    } else {

MensajeUtil.info(
        this,
        "Error al guardar cliente"
);
    }
}
   private void limpiarCampos() {

    txtDni.setText("");
    txtNombres.setText("");
    txtTelefono.setText("");
    txtDireccion.setText("");

    txtDni.requestFocus();
} 
  private void cargarClientes() {

    modeloTabla.setRowCount(0);

    ClienteDAO dao =
            new ClienteDAOImpl();

    for (Cliente cliente : dao.listar()) {

        modeloTabla.addRow(new Object[]{
            cliente.getId(),
            cliente.getDni(),
            cliente.getNombres(),
            cliente.getTelefono()
        });
    }
}
}


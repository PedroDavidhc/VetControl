package com.vetcontrol.backup;

import javax.swing.*;
import com.vetcontrol.dao.ClienteDAO;
import com.vetcontrol.dao.ClienteDAOImpl;
import com.vetcontrol.modelo.Cliente;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AdmisionForm extends JFrame {

    private JTextField txtDni;
    private JTextField txtNombres;
    private JTextField txtTelefono;
    private JTextField txtDireccion;

    private JButton btnGuardar;
    private JTable tablaClientes;

private DefaultTableModel modeloTabla;

    public AdmisionForm() {

        setTitle("Admisión de Clientes");
        setSize(500, 520);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel lblDni = new JLabel("DNI:");
        lblDni.setBounds(30, 30, 100, 25);
        add(lblDni);

        txtDni = new JTextField();
        txtDni.setBounds(150, 30, 200, 25);
        add(txtDni);

        JLabel lblNombres = new JLabel("Nombres:");
        lblNombres.setBounds(30, 80, 100, 25);
        add(lblNombres);

        txtNombres = new JTextField();
        txtNombres.setBounds(150, 80, 200, 25);
        add(txtNombres);

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setBounds(30, 130, 100, 25);
        add(lblTelefono);

        txtTelefono = new JTextField();
        txtTelefono.setBounds(150, 130, 200, 25);
        add(txtTelefono);

        JLabel lblDireccion = new JLabel("Dirección:");
        lblDireccion.setBounds(30, 180, 100, 25);
        add(lblDireccion);

        txtDireccion = new JTextField();
        txtDireccion.setBounds(150, 180, 200, 25);
        add(txtDireccion);

        btnGuardar = new JButton("Guardar Cliente");
        btnGuardar.setBounds(150, 250, 150, 35);
        add(btnGuardar);
        modeloTabla = new DefaultTableModel();

modeloTabla.addColumn("ID");
modeloTabla.addColumn("DNI");
modeloTabla.addColumn("Nombres");
modeloTabla.addColumn("Teléfono");

tablaClientes =
        new JTable(modeloTabla);

JScrollPane scroll =
        new JScrollPane(tablaClientes);

scroll.setBounds(30, 300, 430, 150);

add(scroll);
cargarClientes();

        
        btnGuardar.addActionListener(e -> guardarCliente());
    }

    
    private void guardarCliente() {

    Cliente cliente = new Cliente();

    cliente.setDni(txtDni.getText());
    cliente.setNombres(txtNombres.getText());
    cliente.setTelefono(txtTelefono.getText());
    cliente.setDireccion(txtDireccion.getText());

    ClienteDAO dao = new ClienteDAOImpl();

    if (dao.guardar(cliente)) {

        JOptionPane.showMessageDialog(
                this,
                "Cliente guardado correctamente"
        );

        limpiarCampos();
        cargarClientes();

    } else {

        JOptionPane.showMessageDialog(
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

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new AdmisionForm().setVisible(true);
        });

    }
}
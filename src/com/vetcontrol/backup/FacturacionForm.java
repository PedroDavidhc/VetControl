package com.vetcontrol.backup;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import com.vetcontrol.dao.MascotaDAOImpl;
import com.vetcontrol.modelo.Mascota;
import java.util.List;
import com.vetcontrol.dao.FacturaDAOImpl;
import com.vetcontrol.modelo.Factura;

import java.sql.Date;
import java.time.LocalDate;

import javax.swing.JOptionPane;

public class FacturacionForm extends JFrame {

private JComboBox<String> cboMascota;

private JTextField txtConcepto;

private JTextField txtMonto;

private JButton btnGenerar;

private JTable tabla;

private DefaultTableModel modelo;

public FacturacionForm() {

    setTitle("Facturación");

    setSize(900, 600);

    setLocationRelativeTo(null);

    setLayout(null);

    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    JLabel lblMascota =
            new JLabel("Mascota:");

    lblMascota.setBounds(
            50, 40, 100, 25);

    add(lblMascota);

    cboMascota =
            new JComboBox<>();

    cboMascota.setBounds(
            150, 40, 250, 25);

    add(cboMascota);

    JLabel lblConcepto =
            new JLabel("Concepto:");

    lblConcepto.setBounds(
            50, 90, 100, 25);

    add(lblConcepto);

    txtConcepto =
            new JTextField();

    txtConcepto.setBounds(
            150, 90, 250, 25);

    add(txtConcepto);

    JLabel lblMonto =
            new JLabel("Monto:");

    lblMonto.setBounds(
            50, 140, 100, 25);

    add(lblMonto);

    txtMonto =
            new JTextField();

    txtMonto.setBounds(
            150, 140, 250, 25);

    add(txtMonto);

    btnGenerar =
            new JButton("Generar Factura");

    btnGenerar.setBounds(
            150, 200, 180, 35);

    add(btnGenerar);

    modelo =
            new DefaultTableModel();

    modelo.addColumn("ID");
    modelo.addColumn("Mascota");
    modelo.addColumn("Fecha");
    modelo.addColumn("Concepto");
    modelo.addColumn("Monto");

    tabla =
            new JTable(modelo);

    JScrollPane spTabla =
            new JScrollPane(tabla);

    spTabla.setBounds(
            450, 40, 400, 400);

    add(spTabla);
    cargarMascotas();
    cargarFacturas();

btnGenerar.addActionListener(
        e -> guardarFactura()
);
}
private void cargarMascotas() {

    MascotaDAOImpl dao =
            new MascotaDAOImpl();

    List<Mascota> lista =
            dao.listar();

    cboMascota.removeAllItems();

    for (Mascota m : lista) {

        cboMascota.addItem(
                m.getId() + " - " + m.getNombre()
        );
    }
}
private void guardarFactura() {

    try {

        String mascotaSeleccionada =
                cboMascota.getSelectedItem().toString();

        int mascotaId =
                Integer.parseInt(
                        mascotaSeleccionada.split(" - ")[0]
                );

        Factura factura =
                new Factura();

        factura.setMascotaId(mascotaId);

        factura.setFecha(
                Date.valueOf(LocalDate.now())
        );

        factura.setConcepto(
                txtConcepto.getText()
        );

        factura.setMonto(
                Double.parseDouble(
                        txtMonto.getText()
                )
        );

        FacturaDAOImpl dao =
                new FacturaDAOImpl();

        if (dao.guardar(factura)) {

            JOptionPane.showMessageDialog(
                    this,
                    "Factura registrada correctamente"
            );

            limpiarCampos();

            cargarFacturas();

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "No se pudo registrar"
            );
        }

    } catch (Exception e) {

        JOptionPane.showMessageDialog(
                this,
                "Error: " + e.getMessage()
        );
    }
}
private void limpiarCampos() {

    txtConcepto.setText("");

    txtMonto.setText("");
}
private void cargarFacturas() {

    modelo.setRowCount(0);

    FacturaDAOImpl dao =
            new FacturaDAOImpl();

    List<Factura> lista =
            dao.listar();

    for (Factura f : lista) {

        modelo.addRow(new Object[]{

            f.getId(),

            f.getMascotaId(),

            f.getFecha(),

            f.getConcepto(),

            f.getMonto()
        });
    }
}

public static void main(String[] args) {

    java.awt.EventQueue.invokeLater(() -> {
        new FacturacionForm().setVisible(true);
    });
}

}

package com.vetcontrol.vista;

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
import javax.swing.BorderFactory;
import com.vetcontrol.util.MensajeUtil;

public class FacturacionPanel extends JPanel {

private JComboBox<String> cboMascota;

private JTextField txtConcepto;

private JTextField txtMonto;

private JButton btnGenerar;

private JTable tabla;

private DefaultTableModel modelo;

public FacturacionPanel() {

    setLayout(null);
    setBackground(
        new java.awt.Color(20,20,20)
);


    JLabel lblMascota =
            new JLabel("Mascota:");
    lblMascota.setForeground(
        new java.awt.Color(0,255,102)
);

    lblMascota.setBounds(
            50, 40, 100, 25);

    add(lblMascota);

    cboMascota =
            new JComboBox<>();
    cboMascota.setBackground(
        new java.awt.Color(40,40,40)
);

cboMascota.setForeground(
        java.awt.Color.WHITE
);

    cboMascota.setBounds(
            150, 40, 250, 25);

    add(cboMascota);

JLabel lblConcepto =
        new JLabel("Concepto:");

lblConcepto.setForeground(
        new java.awt.Color(0,255,102)
);

    lblConcepto.setBounds(
            50, 90, 100, 25);

    add(lblConcepto);

    txtConcepto =
            new JTextField();
    txtConcepto.setBackground(
        new java.awt.Color(40,40,40)
);

txtConcepto.setForeground(
        java.awt.Color.WHITE
);

txtConcepto.setCaretColor(
        new java.awt.Color(0,255,102)
);

txtConcepto.setBorder(
        BorderFactory.createLineBorder(
                new java.awt.Color(0,255,102)
        )
);

    txtConcepto.setBounds(
            150, 90, 250, 25);

    add(txtConcepto);

JLabel lblMonto =
        new JLabel("Monto:");

lblMonto.setForeground(
        new java.awt.Color(0,255,102)
);

    lblMonto.setBounds(
            50, 140, 100, 25);

    add(lblMonto);

    txtMonto =
            new JTextField();
    txtMonto.setBackground(
        new java.awt.Color(40,40,40)
);

txtMonto.setForeground(
        java.awt.Color.WHITE
);

txtMonto.setCaretColor(
        new java.awt.Color(0,255,102)
);

txtMonto.setBorder(
        BorderFactory.createLineBorder(
                new java.awt.Color(0,255,102)
        )
);

    txtMonto.setBounds(
            150, 140, 250, 25);

    add(txtMonto);

    btnGenerar =
            new JButton("Generar Factura");
    btnGenerar.setBackground(
        new java.awt.Color(40,40,40)
);

btnGenerar.setForeground(
        new java.awt.Color(0,255,102)
);

btnGenerar.setFocusPainted(false);

btnGenerar.setBorder(
        BorderFactory.createLineBorder(
                new java.awt.Color(130,140,150)
        )
);

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
    tabla.setBackground(
        new java.awt.Color(20,20,20)
);

tabla.setForeground(
        java.awt.Color.WHITE
);

tabla.setGridColor(
        new java.awt.Color(0,255,102)
);

tabla.setSelectionBackground(
        new java.awt.Color(0,120,60)
);

tabla.setSelectionForeground(
        java.awt.Color.WHITE
);

tabla.getTableHeader().setBackground(
        new java.awt.Color(40,40,40)
);

tabla.getTableHeader().setForeground(
        new java.awt.Color(0,255,102)
);

    JScrollPane spTabla =
            new JScrollPane(tabla);
    spTabla.getViewport().setBackground(
        new java.awt.Color(20,20,20)
);

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
    if(txtConcepto.getText().trim().isEmpty() ||
   txtMonto.getText().trim().isEmpty()) {

    MensajeUtil.error(
            this,
            "Complete todos los campos"
    );
    return;
}

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

            MensajeUtil.info(
        this,
                    "Factura registrada correctamente"
            );

            limpiarCampos();

            cargarFacturas();

        } else {

            MensajeUtil.info(
        this,
                    "No se pudo registrar"
            );
        }

    } catch (Exception e) {

        MensajeUtil.info(
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
}

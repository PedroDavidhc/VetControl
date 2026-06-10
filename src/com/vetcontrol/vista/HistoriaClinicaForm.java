package com.vetcontrol.vista;

import javax.swing.*;
import com.vetcontrol.dao.MascotaDAOImpl;
import com.vetcontrol.dao.HistoriaClinicaDAOImpl;
import com.vetcontrol.modelo.Mascota;
import com.vetcontrol.modelo.HistoriaClinica;
import java.util.List;
import java.sql.Date;
import java.time.LocalDate;
import javax.swing.table.DefaultTableModel;
//importaciones apache poi
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import java.io.FileOutputStream;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class HistoriaClinicaForm extends JFrame {

private JComboBox<String> cboMascota;

private JTextField txtPeso;

private JTextField txtTemperatura;

private JTextArea txtDiagnostico;

private JTextArea txtTratamiento;

private JTextArea txtObservaciones;

private JButton btnGuardar;

private JButton btnExportar;

private JTable tabla;

private DefaultTableModel modelo;

public HistoriaClinicaForm() {

    setTitle("Historia Clínica");

    setSize(900, 700);

    setLocationRelativeTo(null);

    setLayout(null);

    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    JLabel lblMascota = new JLabel("Mascota:");
    lblMascota.setBounds(50, 30, 100, 25);
    add(lblMascota);

    cboMascota = new JComboBox<>();
    cboMascota.setBounds(150, 30, 250, 25);
    add(cboMascota);

    JLabel lblPeso = new JLabel("Peso:");
    lblPeso.setBounds(50, 70, 100, 25);
    add(lblPeso);

    txtPeso = new JTextField();
    txtPeso.setBounds(150, 70, 250, 25);
    add(txtPeso);

    JLabel lblTemperatura = new JLabel("Temperatura:");
    lblTemperatura.setBounds(50, 110, 100, 25);
    add(lblTemperatura);

    txtTemperatura = new JTextField();
    txtTemperatura.setBounds(150, 110, 250, 25);
    add(txtTemperatura);

    JLabel lblDiagnostico = new JLabel("Diagnóstico:");
    lblDiagnostico.setBounds(50, 150, 100, 25);
    add(lblDiagnostico);

    txtDiagnostico = new JTextArea();

    JScrollPane spDiagnostico =
            new JScrollPane(txtDiagnostico);

    spDiagnostico.setBounds(150, 150, 300, 80);
    add(spDiagnostico);

    JLabel lblTratamiento =
            new JLabel("Tratamiento:");

    lblTratamiento.setBounds(50, 250, 100, 25);
    add(lblTratamiento);

    txtTratamiento = new JTextArea();

    JScrollPane spTratamiento =
            new JScrollPane(txtTratamiento);

    spTratamiento.setBounds(150, 250, 300, 80);
    add(spTratamiento);

    JLabel lblObservaciones =
            new JLabel("Observaciones:");

    lblObservaciones.setBounds(50, 350, 100, 25);
    add(lblObservaciones);

    txtObservaciones = new JTextArea();

    JScrollPane spObservaciones =
            new JScrollPane(txtObservaciones);

    spObservaciones.setBounds(150, 350, 300, 80);
    add(spObservaciones);

    btnGuardar = new JButton("Guardar Historia");

    btnGuardar.setBounds(180, 470, 180, 35);
    
                btnExportar = new JButton("Exportar Excel");

        btnExportar.setBounds(380, 470, 180, 35);

        add(btnExportar);

    add(btnGuardar);
    modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Mascota");
        modelo.addColumn("Fecha");
        modelo.addColumn("Peso");
        modelo.addColumn("Temperatura");

        tabla = new JTable(modelo);

        JScrollPane spTabla =
                new JScrollPane(tabla);

        spTabla.setBounds(500, 30, 350, 400);

        add(spTabla);

        limpiarCampos();

        cargarHistorias();
        cargarMascotas();

    btnGuardar.addActionListener(
            e -> guardarHistoria()
    );
    btnExportar.addActionListener(
        e -> exportarExcel()
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

private void guardarHistoria() {

    try {

        String mascotaSeleccionada =
                cboMascota.getSelectedItem().toString();

        int mascotaId =
                Integer.parseInt(
                        mascotaSeleccionada.split(" - ")[0]
                );

        HistoriaClinica historia =
                new HistoriaClinica();

        historia.setMascotaId(mascotaId);

        historia.setFecha(
                Date.valueOf(LocalDate.now())
        );

        historia.setPeso(
                Double.parseDouble(
                        txtPeso.getText()
                )
        );

        historia.setTemperatura(
                Double.parseDouble(
                        txtTemperatura.getText()
                )
        );

        historia.setDiagnostico(
                txtDiagnostico.getText()
        );

        historia.setTratamiento(
                txtTratamiento.getText()
        );

        historia.setObservaciones(
                txtObservaciones.getText()
        );

        HistoriaClinicaDAOImpl dao =
                new HistoriaClinicaDAOImpl();

        if (dao.guardar(historia)) {

            JOptionPane.showMessageDialog(
                    this,
                    "Historia clínica guardada correctamente"
            );

            limpiarCampos();
            cargarHistorias();
            
            
            

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "No se pudo guardar"
            );
        }

    } catch (Exception e) {

        JOptionPane.showMessageDialog(
                this,
                "Error: " + e.getMessage()
        );
    }
}
private void exportarExcel() {

    try {

        HistoriaClinicaDAOImpl dao =
                new HistoriaClinicaDAOImpl();

        List<HistoriaClinica> lista =
                dao.listar();

        Workbook libro =
                new XSSFWorkbook();

        Sheet hoja =
                libro.createSheet(
                        "Historias Clínicas"
                );

        Row encabezado =
                hoja.createRow(0);

        encabezado.createCell(0)
                .setCellValue("ID");

        encabezado.createCell(1)
                .setCellValue("Mascota");

        encabezado.createCell(2)
                .setCellValue("Fecha");

        encabezado.createCell(3)
                .setCellValue("Peso");

        encabezado.createCell(4)
                .setCellValue("Temperatura");

        encabezado.createCell(5)
                .setCellValue("Diagnóstico");

        encabezado.createCell(6)
                .setCellValue("Tratamiento");

        encabezado.createCell(7)
                .setCellValue("Observaciones");

        int fila = 1;

        for (HistoriaClinica h : lista) {

            Row row =
                    hoja.createRow(fila++);

            row.createCell(0)
                    .setCellValue(h.getId());

            row.createCell(1)
                    .setCellValue(h.getMascotaId());

            row.createCell(2)
                    .setCellValue(
                            h.getFecha().toString()
                    );

            row.createCell(3)
                    .setCellValue(h.getPeso());

            row.createCell(4)
                    .setCellValue(
                            h.getTemperatura()
                    );

            row.createCell(5)
                    .setCellValue(
                            h.getDiagnostico()
                    );

            row.createCell(6)
                    .setCellValue(
                            h.getTratamiento()
                    );

            row.createCell(7)
                    .setCellValue(
                            h.getObservaciones()
                    );
        }

File carpeta = new File("Excel");

if (!carpeta.exists()) {

    carpeta.mkdir();
}

String fechaHora =
        LocalDateTime.now()
                .format(
                        DateTimeFormatter.ofPattern(
                                "yyyy-MM-dd_HH-mm-ss"
                        )
                );

                    String nombreArchivo =
                            "Excel/historias_clinicas_"
                            + fechaHora
                            + ".xlsx";

                    FileOutputStream archivo =
                            new FileOutputStream(
                                    nombreArchivo
                            );
                            libro.write(archivo);

                            archivo.close();

                            libro.close();

                    JOptionPane.showMessageDialog(
                            this,
                            "Excel exportado correctamente:\n"
                            + nombreArchivo
                    );

                        } catch (Exception e) {

                            JOptionPane.showMessageDialog(
                                    this,
                                    "Error: " + e.getMessage()
                            );
                        }
                    }

private void limpiarCampos() {

    txtPeso.setText("");

    txtTemperatura.setText("");

    txtDiagnostico.setText("");

    txtTratamiento.setText("");

    txtObservaciones.setText("");
}
private void cargarHistorias() {

    modelo.setRowCount(0);

    HistoriaClinicaDAOImpl dao =
            new HistoriaClinicaDAOImpl();

    List<HistoriaClinica> lista =
            dao.listar();

    for (HistoriaClinica h : lista) {

        modelo.addRow(new Object[]{
            h.getId(),
            h.getMascotaId(),
            h.getFecha(),
            h.getPeso(),
            h.getTemperatura()
        });
    }
}
public static void main(String[] args) {

    java.awt.EventQueue.invokeLater(() -> {
        new HistoriaClinicaForm().setVisible(true);
    });
}

}

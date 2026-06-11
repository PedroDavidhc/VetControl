package com.vetcontrol.vista;

import javax.swing.JFrame;
import javax.swing.*;
import com.vetcontrol.dao.ClienteDAOImpl;
import com.vetcontrol.modelo.Cliente;
import java.util.List;
import com.vetcontrol.dao.MascotaDAOImpl;
import com.vetcontrol.modelo.Mascota;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.vetcontrol.util.MensajeUtil;

public class MascotaPanel extends JPanel {
    private JComboBox<String> cboCliente;
    
    private JComboBox<String> cboSexo;

    private JTextField txtNombre;

    private JTextField txtEspecie;

    private JTextField txtRaza;

    private JTextField txtEdad;

    private JTextField txtPeso;

    private JButton btnGuardar;

    private JTable tablaMascotas;

    private DefaultTableModel modelo;
    private JButton btnVolver;

private JPanel panelContenido;

private void cargarClientes() {
    setBackground(
        new java.awt.Color(20,20,20)
);
    

    ClienteDAOImpl dao = new ClienteDAOImpl();

    List<Cliente> lista = dao.listar();

    cboCliente.removeAllItems();

    for (Cliente c : lista) {

        cboCliente.addItem(
                c.getId() + " - " + c.getNombres()
        );

    }
}
private void cargarMascotas() {

    modelo.setRowCount(0);

    MascotaDAOImpl dao =
            new MascotaDAOImpl();

    List<Mascota> lista =
            dao.listar();

    for (Mascota m : lista) {

            modelo.addRow(new Object[]{
        m.getId(),
        m.getClienteId(),
        m.getNombre(),
        m.getSexo(),
        m.getEspecie(),
        m.getRaza(),
        m.getEdad()
    });
    }
}



public MascotaPanel(JPanel panelContenido) {

    this.panelContenido = panelContenido;

    setLayout(null);


JLabel lblCliente = new JLabel("Cliente:");
lblCliente.setForeground(
        new java.awt.Color(0,255,102)
);
lblCliente.setBounds(50, 50, 100, 25);
add(lblCliente);

JLabel lblSexo = new JLabel("Sexo:");
lblSexo.setForeground(
        new java.awt.Color(0,255,102)
);
lblSexo.setBounds(50, 100, 100, 25);
add(lblSexo);

JLabel lblNombre = new JLabel("Nombre:");
lblNombre.setForeground(
        new java.awt.Color(0,255,102)
);
lblNombre.setBounds(50, 150, 100, 25);
add(lblNombre);

JLabel lblEspecie = new JLabel("Especie:");
lblEspecie.setForeground(
        new java.awt.Color(0,255,102)
);
lblEspecie.setBounds(50, 200, 100, 25);
add(lblEspecie);

JLabel lblRaza = new JLabel("Raza:");
lblRaza.setForeground(
        new java.awt.Color(0,255,102)
);
lblRaza.setBounds(50, 250, 100, 25);
add(lblRaza);

JLabel lblEdad = new JLabel("Edad:");
lblEdad.setForeground(
        new java.awt.Color(0,255,102)
);
lblEdad.setBounds(50, 300, 100, 25);
add(lblEdad);

JLabel lblPeso = new JLabel("Peso:");
lblPeso.setForeground(
        new java.awt.Color(0,255,102)
);
lblPeso.setBounds(50, 350, 100, 25);
add(lblPeso);

cboCliente = new JComboBox<>();
cboCliente.setBackground(
        new java.awt.Color(40,40,40)
);

cboCliente.setForeground(
        java.awt.Color.WHITE
);
cboCliente.setBounds(150, 50, 250, 25);

add(cboCliente);
cboSexo = new JComboBox<>();
cboSexo.setBackground(
        new java.awt.Color(40,40,40)
);

cboSexo.setForeground(
        java.awt.Color.WHITE
);
cboSexo.addItem("Macho");
cboSexo.addItem("Hembra");

cboSexo.setBounds(150, 100, 250, 25);

add(cboSexo);

txtNombre = new JTextField();

txtNombre.setBackground(
        new java.awt.Color(40,40,40)
);

txtNombre.setForeground(
        java.awt.Color.WHITE
);

txtNombre.setCaretColor(
        new java.awt.Color(0,255,102)
);

txtNombre.setBounds(150, 150, 250, 25);

add(txtNombre);

txtEspecie = new JTextField();

txtEspecie.setBackground(
        new java.awt.Color(40,40,40)
);

txtEspecie.setForeground(
        java.awt.Color.WHITE
);

txtEspecie.setCaretColor(
        new java.awt.Color(0,255,102)
);

txtEspecie.setBounds(150, 200, 250, 25);

add(txtEspecie);

txtRaza = new JTextField();

txtRaza.setBackground(
        new java.awt.Color(40,40,40)
);

txtRaza.setForeground(
        java.awt.Color.WHITE
);

txtRaza.setCaretColor(
        new java.awt.Color(0,255,102)
);

txtRaza.setBounds(150, 250, 250, 25);

add(txtRaza);

txtEdad = new JTextField();

txtEdad.setBackground(
        new java.awt.Color(40,40,40)
);

txtEdad.setForeground(
        java.awt.Color.WHITE
);

txtEdad.setCaretColor(
        new java.awt.Color(0,255,102)
);

txtEdad.setBounds(150, 300, 250, 25);

add(txtEdad);

txtPeso = new JTextField();

txtPeso.setBackground(
        new java.awt.Color(40,40,40)
);

txtPeso.setForeground(
        java.awt.Color.WHITE
);

txtPeso.setCaretColor(
        new java.awt.Color(0,255,102)
);

txtPeso.setBounds(150, 350, 250, 25);

add(txtPeso);

btnGuardar = new JButton("Guardar Mascota");
btnGuardar.setBackground(
        new java.awt.Color(40,40,40)
);

btnGuardar.setForeground(
        new java.awt.Color(0,255,102)
);
btnGuardar.setBounds(200, 400, 180, 35);
add(btnGuardar);
cargarClientes();
btnGuardar.addActionListener(e -> guardarMascota());
btnVolver = new JButton("Volver");
btnVolver.setBackground(
        new java.awt.Color(40,40,40)
);

btnVolver.setForeground(
        new java.awt.Color(0,255,102)
);

btnVolver.setBounds(
        450,
        400,
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

modelo = new DefaultTableModel();
modelo.addColumn("ID");
modelo.addColumn("Cliente");
modelo.addColumn("Nombre");
modelo.addColumn("Sexo");
modelo.addColumn("Especie");
modelo.addColumn("Raza");
modelo.addColumn("Edad");

tablaMascotas = new JTable(modelo);
tablaMascotas.setBackground(
        new java.awt.Color(20,20,20)
);

tablaMascotas.setForeground(
        java.awt.Color.WHITE
);

tablaMascotas.setGridColor(
        new java.awt.Color(0,255,102)
);

tablaMascotas.getTableHeader().setBackground(
        new java.awt.Color(40,40,40)
);

tablaMascotas.getTableHeader().setForeground(
        new java.awt.Color(0,255,102)
);

JScrollPane scroll =
        new JScrollPane(tablaMascotas);
scroll.getViewport().setBackground(
        new java.awt.Color(20,20,20)
);

scroll.setBounds(430, 50, 240, 300);


add(scroll);

cargarMascotas();

    }
    private void guardarMascota() {
        if(txtNombre.getText().trim().isEmpty() ||
   txtEspecie.getText().trim().isEmpty() ||
   txtRaza.getText().trim().isEmpty() ||
   txtEdad.getText().trim().isEmpty() ||
   txtPeso.getText().trim().isEmpty()) {

    MensajeUtil.error(
            this,
            "Complete todos los campos"
    );
    return;
}

    try {

        String clienteSeleccionado =
                cboCliente.getSelectedItem().toString();

        int clienteId =
                Integer.parseInt(
                        clienteSeleccionado.split(" - ")[0]
                );

        Mascota mascota = new Mascota();

        mascota.setClienteId(clienteId);
        mascota.setNombre(txtNombre.getText());
        mascota.setSexo(
        cboSexo.getSelectedItem().toString()
);
        mascota.setEspecie(txtEspecie.getText());
        mascota.setRaza(txtRaza.getText());
        mascota.setEdad(
                Integer.parseInt(txtEdad.getText())
        );
        mascota.setPeso(
                Double.parseDouble(txtPeso.getText())
        );

        MascotaDAOImpl dao =
                new MascotaDAOImpl();

        if (dao.guardar(mascota)) {

MensajeUtil.info(
        this,
        "Mascota registrada correctamente"
);

            limpiarCampos();
            cargarMascotas();

        } else {

MensajeUtil.info(
        this,
                    "No se pudo guardar"
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

    txtNombre.setText("");
    txtEspecie.setText("");
    txtRaza.setText("");
    txtEdad.setText("");
    txtPeso.setText("");

}
}

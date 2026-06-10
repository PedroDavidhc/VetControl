package com.vetcontrol.backup;

import javax.swing.JFrame;
import javax.swing.*;
import com.vetcontrol.dao.ClienteDAOImpl;
import com.vetcontrol.modelo.Cliente;
import java.util.List;
import com.vetcontrol.dao.MascotaDAOImpl;
import com.vetcontrol.modelo.Mascota;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MascotaForm extends JFrame {
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

private void cargarClientes() {
    

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


    public MascotaForm() {

        setTitle("Registro de Mascotas");

        setSize(700, 500);

        setLocationRelativeTo(null);

        setLayout(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JLabel lblCliente = new JLabel("Cliente:");
lblCliente.setBounds(50, 50, 100, 25);
add(lblCliente);

JLabel lblSexo = new JLabel("Sexo:");
lblSexo.setBounds(50, 100, 100, 25);
add(lblSexo);

JLabel lblNombre = new JLabel("Nombre:");
lblNombre.setBounds(50, 150, 100, 25);
add(lblNombre);

JLabel lblEspecie = new JLabel("Especie:");
lblEspecie.setBounds(50, 200, 100, 25);
add(lblEspecie);

JLabel lblRaza = new JLabel("Raza:");
lblRaza.setBounds(50, 250, 100, 25);
add(lblRaza);

JLabel lblEdad = new JLabel("Edad:");
lblEdad.setBounds(50, 300, 100, 25);
add(lblEdad);

JLabel lblPeso = new JLabel("Peso:");
lblPeso.setBounds(50, 350, 100, 25);
add(lblPeso);

cboCliente = new JComboBox<>();
cboCliente.setBounds(150, 50, 250, 25);
add(cboCliente);
cboSexo = new JComboBox<>();

cboSexo.addItem("Macho");
cboSexo.addItem("Hembra");

cboSexo.setBounds(150, 100, 250, 25);

add(cboSexo);

txtNombre = new JTextField();
txtNombre.setBounds(150, 150, 250, 25);
add(txtNombre);

txtEspecie = new JTextField();
txtEspecie.setBounds(150, 200, 250, 25);
add(txtEspecie);

txtRaza = new JTextField();
txtRaza.setBounds(150, 250, 250, 25);
add(txtRaza);

txtEdad = new JTextField();
txtEdad.setBounds(150, 300, 250, 25);
add(txtEdad);

txtPeso = new JTextField();
txtPeso.setBounds(150, 350, 250, 25);
add(txtPeso);

btnGuardar = new JButton("Guardar Mascota");
btnGuardar.setBounds(200, 400, 180, 35);
add(btnGuardar);
cargarClientes();
btnGuardar.addActionListener(e -> guardarMascota());
modelo = new DefaultTableModel();

modelo.addColumn("ID");
modelo.addColumn("Cliente");
modelo.addColumn("Nombre");
modelo.addColumn("Sexo");
modelo.addColumn("Especie");
modelo.addColumn("Raza");
modelo.addColumn("Edad");

tablaMascotas = new JTable(modelo);

JScrollPane scroll =
        new JScrollPane(tablaMascotas);

scroll.setBounds(430, 50, 240, 300);

add(scroll);

cargarMascotas();

    }
    private void guardarMascota() {

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

            JOptionPane.showMessageDialog(
                    this,
                    "Mascota guardada correctamente"
            );

            limpiarCampos();
            cargarMascotas();

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
    private void limpiarCampos() {

    txtNombre.setText("");
    txtEspecie.setText("");
    txtRaza.setText("");
    txtEdad.setText("");
    txtPeso.setText("");

}

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(() -> {
            new MascotaForm().setVisible(true);
        });

    }
}

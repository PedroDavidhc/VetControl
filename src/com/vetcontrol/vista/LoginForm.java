package com.vetcontrol.vista;

import com.vetcontrol.dao.UsuarioDAO;
import com.vetcontrol.dao.UsuarioDAOImpl;
import com.vetcontrol.modelo.Usuario;
import com.vetcontrol.vista.DashboardForm;
import javax.swing.*;

public class LoginForm extends JFrame {

    private JTextField txtUsuario;
    private JPasswordField txtPassword;
    private JButton btnIngresar;

    public LoginForm() {

        setTitle("VetControl");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblTitulo = new JLabel("INICIO DE SESIÓN");
        lblTitulo.setBounds(130, 20, 200, 25);
        add(lblTitulo);

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setBounds(50, 70, 80, 25);
        add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(140, 70, 180, 25);
        add(txtUsuario);

        JLabel lblPassword = new JLabel("Contraseña:");
        lblPassword.setBounds(50, 110, 80, 25);
        add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(140, 110, 180, 25);
        add(txtPassword);

        btnIngresar = new JButton("Ingresar");
        btnIngresar.setBounds(140, 160, 120, 30);
        add(btnIngresar);

        // Evento del botón
        btnIngresar.addActionListener(e -> login());
    }

private void login() {

    String usuario = txtUsuario.getText();

    String password =
            String.valueOf(txtPassword.getPassword());

    UsuarioDAO dao = new UsuarioDAOImpl();

    Usuario user = dao.login(usuario, password);

    if (user != null) {

        JOptionPane.showMessageDialog(
                this,
                "Bienvenido " + user.getUsuario()
        );

        DashboardForm dashboard =
                new DashboardForm();

        dashboard.setVisible(true);

        dispose();

    } else {

        JOptionPane.showMessageDialog(
                this,
                "Usuario o contraseña incorrectos"
        );
    }
}
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new LoginForm().setVisible(true);
        });

    }
}
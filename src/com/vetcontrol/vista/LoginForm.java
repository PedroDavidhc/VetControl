package com.vetcontrol.vista;

import com.vetcontrol.dao.UsuarioDAO;
import com.vetcontrol.dao.UsuarioDAOImpl;
import com.vetcontrol.modelo.Usuario;
import com.vetcontrol.util.MensajeUtil;
import com.vetcontrol.vista.DashboardForm;
import javax.swing.*;
import java.awt.Font;
import javax.swing.BorderFactory;


public class LoginForm extends JFrame {

    private JTextField txtUsuario;
    private JPasswordField txtPassword;
    private JButton btnIngresar;

    public LoginForm() {

    setTitle("VetControl");
    setSize(500, 320);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setLayout(null);

    getContentPane().setBackground(
            new java.awt.Color(20,20,20)
    );

    JLabel lblTitulo =
            new JLabel("INICIO DE SESIÓN");

    lblTitulo.setForeground(
            new java.awt.Color(0,255,102)
    );

    lblTitulo.setFont(
            new Font("Arial", Font.BOLD, 22)
    );

    lblTitulo.setBounds(
            140,
            25,
            250,
            30
    );

    add(lblTitulo);

    JLabel lblUsuario =
            new JLabel("Usuario:");

    lblUsuario.setForeground(
            new java.awt.Color(0,255,102)
    );

    lblUsuario.setFont(
            new Font("Arial", Font.BOLD, 14)
    );

    lblUsuario.setBounds(
            50,
            90,
            100,
            25
    );

    add(lblUsuario);

    txtUsuario = new JTextField();

    txtUsuario.setBackground(
            new java.awt.Color(40,40,40)
    );

    txtUsuario.setForeground(
            java.awt.Color.WHITE
    );

    txtUsuario.setCaretColor(
            new java.awt.Color(0,255,102)
    );

    txtUsuario.setBorder(
            BorderFactory.createLineBorder(
                    new java.awt.Color(0,255,102)
            )
    );

    txtUsuario.setBounds(
            160,
            90,
            220,
            30
    );

    add(txtUsuario);

    JLabel lblPassword =
            new JLabel("Contraseña:");

    lblPassword.setForeground(
            new java.awt.Color(0,255,102)
    );

    lblPassword.setFont(
            new Font("Arial", Font.BOLD, 14)
    );

    lblPassword.setBounds(
            50,
            140,
            100,
            25
    );

    add(lblPassword);

    txtPassword =
            new JPasswordField();

    txtPassword.setBackground(
            new java.awt.Color(40,40,40)
    );

    txtPassword.setForeground(
            java.awt.Color.WHITE
    );

    txtPassword.setCaretColor(
            new java.awt.Color(0,255,102)
    );

    txtPassword.setBorder(
            BorderFactory.createLineBorder(
                    new java.awt.Color(0,255,102)
            )
    );

    txtPassword.setBounds(
            160,
            140,
            220,
            30
    );

    add(txtPassword);

    btnIngresar =
            new JButton("Ingresar");

    btnIngresar.setBackground(
            new java.awt.Color(40,40,40)
    );

    btnIngresar.setForeground(
            new java.awt.Color(0,255,102)
    );

    btnIngresar.setFocusPainted(false);

    btnIngresar.setBorder(
            BorderFactory.createLineBorder(
                    new java.awt.Color(130,140,150)
            )
    );

    btnIngresar.setFont(
            new Font("Arial", Font.BOLD, 14)
    );

    btnIngresar.setBounds(
            170,
            210,
            150,
            40
    );

    add(btnIngresar);

    btnIngresar.addActionListener(
            e -> login()
    );
}
private void login() {

    String usuario = txtUsuario.getText();

    String password =
            String.valueOf(txtPassword.getPassword());

    UsuarioDAO dao = new UsuarioDAOImpl();

    Usuario user = dao.login(usuario, password);

    if (user != null) {

MensajeUtil.info(
        this,
        "Bienvenido " + user.getUsuario()
);

        DashboardForm dashboard =
                new DashboardForm();

        dashboard.setVisible(true);

        dispose();

    } else {

MensajeUtil.error(
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
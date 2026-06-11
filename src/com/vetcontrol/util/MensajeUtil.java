package com.vetcontrol.util;

import javax.swing.*;
import java.awt.*;

public class MensajeUtil {

    public static void info(Component parent, String mensaje) {

        UIManager.put(
                "OptionPane.background",
                new Color(20,20,20)
        );

        UIManager.put(
                "Panel.background",
                new Color(20,20,20)
        );

        UIManager.put(
                "OptionPane.messageForeground",
                new Color(0,255,102)
        );

        JOptionPane.showMessageDialog(
                parent,
                mensaje,
                "VetControl",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static void error(Component parent, String mensaje) {

        UIManager.put(
                "OptionPane.background",
                new Color(20,20,20)
        );

        UIManager.put(
                "Panel.background",
                new Color(20,20,20)
        );

        UIManager.put(
                "OptionPane.messageForeground",
                Color.RED
        );

        JOptionPane.showMessageDialog(
                parent,
                mensaje,
                "VetControl",
                JOptionPane.ERROR_MESSAGE
        );
    }
}
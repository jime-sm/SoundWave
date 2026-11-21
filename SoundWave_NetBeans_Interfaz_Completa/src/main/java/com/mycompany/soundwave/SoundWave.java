package com.mycompany.soundwave;

import com.mycompany.soundwave.db.InicializadorDB;
import com.mycompany.soundwave.ui.MainFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class SoundWave {
    public static void main(String[] args) {
        try {
            // Crea las tablas si hacen falta y carga el CSV solo si la tabla de canciones está vacía.
            InicializadorDB.iniciar();
            SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "No se pudo iniciar SoundWave.\n" + e.getMessage(),
                    "Error al iniciar", JOptionPane.ERROR_MESSAGE);
        }
    }
}

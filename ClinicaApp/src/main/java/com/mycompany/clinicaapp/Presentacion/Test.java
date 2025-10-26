/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.clinicaapp.Presentacion;

/**
 *
 * @author johan
 */

public class Test {

    public static void main(String[] args) {
        // Configurar el estilo visual (opcional)
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Mostrar la ventana de inicio de sesión
        java.awt.EventQueue.invokeLater(() -> {
            VentanaIniciarSesion ventanaLogin = new VentanaIniciarSesion();
            ventanaLogin.setVisible(true);
            ventanaLogin.setLocationRelativeTo(null);
        });
    }
}

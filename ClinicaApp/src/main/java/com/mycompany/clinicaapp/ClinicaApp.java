/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinicaapp;


/**
 *
 * @author hecto
 */
import com.mycompany.clinicaapp.Presentacion.VentanaIniciarSesion;
import java.awt.Dimension;
import java.awt.Toolkit;

public class ClinicaApp {
    public static void main(String[] args) {
        VentanaIniciarSesion ventana = new VentanaIniciarSesion();
        // Centrar la ventana en la pantalla
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (pantalla.width - ventana.getWidth()) / 2;
        int y = (pantalla.height - ventana.getHeight()) / 2;
        ventana.setLocation(x, y);
        ventana.setVisible(true);
    }
}

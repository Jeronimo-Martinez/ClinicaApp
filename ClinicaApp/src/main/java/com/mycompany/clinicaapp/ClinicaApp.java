/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinicaapp;

import com.mycompany.clinicaapp.Presentacion.VentanaPrincipal;
import java.awt.Dimension;
import java.awt.Toolkit;


/**
 *
 * @author hecto
 */
public class ClinicaApp {
    private static VentanaPrincipal main;
    public static void main(String[] args) {
    main = new VentanaPrincipal();
    main.setVisible(true);
    Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (pantalla.width - main.getWidth()) / 2;
    int y = (pantalla.height - main.getHeight()) / 2;

    main.setLocation(x, y);
    
}
}

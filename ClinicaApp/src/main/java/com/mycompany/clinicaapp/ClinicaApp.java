/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinicaapp;
//import com.mycompany.clinicaapp.Interfaces.IMedicoService;
import com.mycompany.clinicaapp.Interfaces.IMedicoService;
import com.mycompany.clinicaapp.LogicaDelNegocio.GestorMedico;
import com.mycompany.clinicaapp.Presentacion.VentanaIniciarSesion;
//import java.awt.Dimension;
//import java.awt.Toolkit;


/**
 *
 * @author hecto
 */
public class ClinicaApp {
    public static void main(String[] args) { 
        VentanaIniciarSesion ventana = new VentanaIniciarSesion();
        ventana.setLocationRelativeTo(null); // Esto centra la ventana en la pantalla
        ventana.setVisible(true);
    
    }
}

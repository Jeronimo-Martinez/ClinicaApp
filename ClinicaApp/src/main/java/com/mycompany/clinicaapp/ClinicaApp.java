/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinicaapp;

import com.mycompany.clinicaapp.LogicaDelNegocio.GestorMedico;
import com.mycompany.clinicaapp.LogicaDelNegocio.IInterfazAdminMedica;
import com.mycompany.clinicaapp.LogicaDelNegocio.IMedicoService;
import com.mycompany.clinicaapp.LogicaDelNegocio.InterfazAdminMedica;
import javax.swing.SwingUtilities;


/**
 *
 * @author hecto
 */
public class ClinicaApp {
    public static void main(String[] args){
     SwingUtilities.invokeLater(() -> {
            // Instancia del servicio de médicos (puede ser tu GestorMedico singleton o una implementación)
            IMedicoService medicoService = GestorMedico.getInstancia();

            // Crea la interfaz de administración y la muestra
            IInterfazAdminMedica interfazAdmin = new InterfazAdminMedica(medicoService);
            interfazAdmin.mostrarVentanaMedica();
        });
    
    
    }
}

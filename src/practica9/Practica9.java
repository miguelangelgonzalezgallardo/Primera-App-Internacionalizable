/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica9;

import java.util.ArrayList;
import practica9.gui.Principal;

/**
 *
 * @author Miguel Angel Gonzalez Gallardo
 */
public class Practica9 {

    //EEDD globales de la aplicacion
    public static ArrayList<Usuario> usuarios;
    public static ArrayList<Registro> registros;
    public static boolean sonido;
    public static String lenguajeActivo;

    public static void main(String[] args) throws Exception {
        GestionIO.cargarConfiguracion(); //Cargo datos configuracion
        GestionIO.cargarDatos();//Cargo datos de usuarios y registros
        Internacionalizacion idioma = new Internacionalizacion(); //Genero instancia para manejar la internacionalizacion
        Principal p = new Principal(idioma);//Empieza la GUI
    }

}

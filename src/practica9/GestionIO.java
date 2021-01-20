/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import jdk.nashorn.internal.objects.NativeString;

/**
 *
 * @author Miguel Angel Gonzalez Gallardo
 */
public class GestionIO {

    private static final String URL_FICHERO_CONFIGURACION = "src/config/config.conf";
    private static String URL_FICHERO_IDIOMAS;
    private static String URL_FICHERO_USUARIOS;
    private static String URL_FICHERO_REGISTROS;

    //Se usa para sacar los parametros del fichero de configuracion
    private static String getDato(String cad) {
        String ret = "";
        boolean escribir = false;
        for (int i = 0; i < cad.length(); i++) {
            if (!escribir) {
                if (cad.charAt(i) == '=') {
                    escribir = true;
                }
            } else {
                ret += cad.charAt(i);
            }
        }
        return ret;
    }

    //Carga los datos de los usuarios y de los registros preguardados
    public static void cargarDatos() {
        String linea;
        //Cargo datos usuarios
        Practica9.usuarios = new ArrayList<>();
        File archivo = new File(URL_FICHERO_USUARIOS);
        try {
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);

            do {
                linea = br.readLine();
                if (linea != null) {
                    Practica9.usuarios.add(new Usuario(linea));
                }
            } while (linea != null);

        } catch (IOException e) {
            e.printStackTrace();
        }
        //Cargo datos registros
        Practica9.registros = new ArrayList<>();
        archivo = new File(URL_FICHERO_REGISTROS);
        try {
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);

            do {
                linea = br.readLine();
                if (linea != null) {
                    Practica9.registros.add(new Registro(linea));
                }
            } while (linea != null);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Persistencia de los datos de los usuarios y sus registros
    public static void guardarDatos() {
        //Guardo datos usuarios
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(URL_FICHERO_USUARIOS);
            pw = new PrintWriter(fichero);

            for (int i = 0; i < Practica9.usuarios.size(); i++) {
                pw.println(Practica9.usuarios.get(i).toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        //Guardo datos registros
        try {
            fichero = new FileWriter(URL_FICHERO_REGISTROS);
            pw = new PrintWriter(fichero);

            for (int i = 0; i < Practica9.registros.size(); i++) {
                pw.println(Practica9.registros.get(i).toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static String[] fromCSV(String cad) {
        ArrayList<String> l = new ArrayList<>();
        String aux = "";
        for (int i = 0; i < cad.length(); i++) {
            if (cad.charAt(i) == ';') {
                l.add(l.size(), aux);
                aux = "";
            } else {
                aux += cad.charAt(i);
            }
        }
        String[] ret = new String[l.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = l.get(i);
        }
        return ret;
    }

    //Se extraen los parametros del fichero de configuracion
    public static void cargarConfiguracion() {
        File archivo = new File(URL_FICHERO_CONFIGURACION);
        try {
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            Practica9.lenguajeActivo = getDato(br.readLine());
            if (NativeString.toLowerCase(getDato(br.readLine())).equals("on")) {
                Practica9.sonido = true;
            } else {
                Practica9.sonido = false;
            }
            URL_FICHERO_IDIOMAS = getDato(br.readLine());
            URL_FICHERO_USUARIOS = getDato(br.readLine());
            URL_FICHERO_REGISTROS = getDato(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Se guardan la configuracion en el fichero de configuracion, de esta forma
    //si cambiamos el idioma, a la siguiente ejecucion del programa, se ejecuta
    //con el idioma deseado
    public static void guardarConfiguracion() {
        String uno = "DEFAULT LANGUAGE=" + Practica9.lenguajeActivo;
        String dos;
        if (Practica9.sonido) {
            dos = "SOUND=on";
        } else {
            dos = "SOUND=off";
        }
        String tres = "LANGUAGE FILE=" + URL_FICHERO_IDIOMAS;
        String cuatro = "USER DATA FILE=" + URL_FICHERO_USUARIOS;
        String cinco = "RECORD DATA FILE=" + URL_FICHERO_REGISTROS;

        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(URL_FICHERO_CONFIGURACION);
            pw = new PrintWriter(fichero);

            pw.println(uno);
            pw.println(dos);
            pw.println(tres);
            pw.println(cuatro);
            pw.println(cinco);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    //Extrae los nombres de los idiomas disponibles en el fichero de idiomas
    private static String[] getIdiomas() {
        File archivo = new File(URL_FICHERO_IDIOMAS);
        ArrayList<String> l = new ArrayList<>();
        try {
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            br.readLine();
            br.readLine();
            br.readLine();
            l.add(br.readLine());
            int c = 0, max = 49;//max-> Nº de lineas entre idioma e idioma
            do {
                linea = br.readLine();
                ++c;
                if (c == max) {
                    l.add(linea);
                    c = 0;
                }
            } while (linea != null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] ret = new String[l.size()];
        for (int i = 0; i < ret.length - 1; i++) {
            ret[i] = l.get(i);
        }
        return ret;
    }

    //Aqui se extraen los cadenas de su idioma correspondiente
    public static String[] cargarDatosIdioma() {
        //Los voy a meter en distintos arrays segun el tipo de cadena por razones de una posible depuracion
        String frases[] = null, imagenes[] = null, sonidos[] = null, idiomas[] = getIdiomas();
        File archivo = new File(URL_FICHERO_IDIOMAS);
        try {
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            do {
                linea = br.readLine();
            } while (linea != null && !linea.equals(Practica9.lenguajeActivo));//Nos situamos donde empiecen las cadenas del idioma activo
            //Pongo las frases
            frases = new String[Integer.parseInt(br.readLine())];//Guardo el número de cadenas de texto
            for (int i = 0; i < frases.length; i++) {
                frases[i] = br.readLine();
            }
            //Pongo las imagenes
            imagenes = new String[Integer.parseInt(br.readLine())];//Guardo el número de cadenas de url imagenes
            for (int i = 0; i < imagenes.length; i++) {
                imagenes[i] = br.readLine();
            }
            //Pongo los sonidos
            sonidos = new String[Integer.parseInt(br.readLine())];//Guardo el número de cadenas de url audio
            for (int i = 0; i < sonidos.length; i++) {
                sonidos[i] = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Junto los arrays
        String[] ret = new String[frases.length + imagenes.length + sonidos.length + idiomas.length];
        int c = 0;
        for (int i = 0; i < frases.length; i++) {
            ret[c++] = frases[i];
        }
        for (int i = 0; i < imagenes.length; i++) {
            ret[c++] = imagenes[i];
        }
        for (int i = 0; i < sonidos.length; i++) {
            ret[c++] = sonidos[i];
        }
        for (int i = 0; i < idiomas.length; i++) {
            ret[c++] = idiomas[i];
        }
        //for(int i=0;i<ret.length;i++)
        //  System.out.println(ret[i]);
        return ret;
    }
}

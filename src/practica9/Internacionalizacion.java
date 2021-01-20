/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica9;

import jdk.nashorn.internal.objects.NativeString;

/**
 *
 * @author Miguel Angel Gonzalez Gallardo
 */
public class Internacionalizacion {

    //Variables
    public String nombreIdiomaActual;
    public String nombreAplicacion;
    public String urlWarningAlertImage;
    public String urlNotificarAlertImage;
    public String urlErrorAlertImage;
    public String titulosAlertError[];
    public String mensajesAlertError[];
    public String titulosAlertNotificar[];
    public String mensajesAlertNotificar[];
    public String fraseOK;
    public String fraseCancelar;
    public String urlIconoHome;
    public String urlIconoRegistros;
    public String urlIconoAjustes;
    public String urlNuevoRegistro;
    public String nombreHome;
    public String nombreRegistros;
    public String nombreAjustes;
    public String fraseNSS;
    public String urlIconoNuevoUser;
    public String urlIconoEliminarUser;
    public String urlIconoModificarUser;
    public String fraseAnadirUser;
    public String fraseModificarUser;
    public String fraseContrasena;
    public String fraseBotonBorrarUser;
    public String fraseAdvertenciaBorrado;
    public String fraseConfirmacionBorrado;
    public String fraseDNI;
    public String fraseModificar;
    public String fraseNombre;
    public String fraseApellidos;
    public String fraseCargo;
    public String fraseLlegada;
    public String fraseSalida;
    public String fraseNuevoRegistro;
    public String fraseEvento;
    public String fraseObservaciones;
    public String nombresIdiomas[];
    public String siglasIdiomas[];
    public String fraseElegirIdioma;
    public String fraseAplicar;
    public String urlSonidoAlerta;
    public String urlSonidoError;
    public String fraseSonido;
    public String fraseRepetirContrasena;
    public String fraseFechaIni;
    public String fraseFechaFin;

    //Constructor
    public Internacionalizacion() {
        this.inicializarVariables();
    }

    //Para determinar el "lenguaje activo" nos quedamos con las dos primeras letras del idioma que determinan la abreviatura
    public void elegirIdioma(String nombre) {
        char[] aux = nombre.toCharArray();
        Practica9.lenguajeActivo = NativeString.toLowerCase(String.copyValueOf(aux, 0, 2));
        inicializarVariables();
    }

    //Inicializamos las variables con el idioma deseado
    public void inicializarVariables() {
        String[] v = GestionIO.cargarDatosIdioma();
        nombreIdiomaActual = v[0];
        nombreAplicacion = v[1];
        titulosAlertError = GestionIO.fromCSV(v[2]);
        mensajesAlertError = GestionIO.fromCSV(v[3]);
        titulosAlertNotificar = GestionIO.fromCSV(v[4]);
        mensajesAlertNotificar = GestionIO.fromCSV(v[5]);
        fraseOK = v[6];
        fraseCancelar = v[7];
        nombreHome = v[8];
        nombreRegistros = v[9];
        nombreAjustes = v[10];
        fraseRepetirContrasena = v[11];
        fraseNSS = v[12];
        fraseContrasena = v[13];
        fraseBotonBorrarUser = v[14];
        fraseAdvertenciaBorrado = v[15];
        fraseConfirmacionBorrado = v[16];
        fraseDNI = v[17];
        fraseModificar = v[18];
        fraseNombre = v[19];
        fraseApellidos = v[20];
        fraseCargo = v[21];
        fraseLlegada = v[22];
        fraseSalida = v[23];
        fraseNuevoRegistro = v[24];
        fraseEvento = v[25];
        fraseObservaciones = v[26];
        fraseElegirIdioma = v[27];
        fraseAplicar = v[28];
        fraseSonido = v[29];
        fraseFechaIni = v[30];
        fraseFechaFin = v[31];
        urlWarningAlertImage = v[32];
        urlNotificarAlertImage = v[33];
        urlErrorAlertImage = v[34];
        urlIconoHome = v[36];
        urlIconoAjustes = v[37];
        urlIconoRegistros = v[38];
        urlIconoNuevoUser = v[39];
        urlIconoEliminarUser = v[40];
        urlIconoModificarUser = v[41];
        urlNuevoRegistro = v[42];
        urlSonidoAlerta = v[43];
        urlSonidoError = v[44];
        nombresIdiomas = new String[v.length - 46];
        int c = 0;
        for (int i = 45; c < nombresIdiomas.length; i++) {
            nombresIdiomas[c++] = v[i];
        }
    }

    //Excepciones (No deberian lanzarse)
    public String getAlertNotificacion(int codigo) throws Exception {
        if (codigo >= mensajesAlertNotificar.length) {
            throw new Exception("Internacionalizacion.java getAlertNotificacion() Codigo de notificacion no encontrado");
        }
        return mensajesAlertNotificar[codigo];
    }

    public String getTitleAlertNotificacion(int codigo) throws Exception {
        if (codigo >= titulosAlertNotificar.length) {
            throw new Exception("Internacionalizacion.java getTitleAlertNotificacion() Codigo de notificacion no encontrado");
        }
        return titulosAlertNotificar[codigo];
    }

    public String getAlertError(int codigoError) throws Exception {
        if (codigoError >= mensajesAlertError.length) {
            throw new Exception("Internacionalizacion.java getAlertError() Codigo de error no encontrado");
        }
        return mensajesAlertError[codigoError];
    }

    public String getTitleAlertError(int codigoError) throws Exception {
        if (codigoError >= titulosAlertError.length) {
            throw new Exception("Internacionalizacion.java getTitleAlertError() Codigo de error no encontrado");
        }
        return titulosAlertError[codigoError];
    }

}

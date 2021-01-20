/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica9;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Miguel Angel Gonzalez Gallardo
 */
public class Registro {

    public final int hora, min, dia, mes, anio;
    public final char modo; //l -> Llegada s -> salida
    public final String user; //DNI
    public final String observaciones;

    //Constructor
    public Registro(Usuario us, String obser, char Modo) {
        this.user = us.getDNI();
        this.observaciones = obser;
        Calendar d = Calendar.getInstance();
        modo = Modo;
        dia = d.get(Calendar.DATE);
        mes = d.get(Calendar.MONTH) + 1;
        anio = d.get(Calendar.YEAR);
        hora = d.get(Calendar.HOUR) + 12;
        min = d.get(Calendar.MINUTE);
    }

    //Constructor fromCSV
    public Registro(String cad) {
        //formato: USER;OBSERVACIONES;HORA;MIN;DIA;MES;ANIO;
        String aux = "";
        int i = 0;
        while (cad.charAt(i) != ';') {
            aux += cad.charAt(i);
            ++i;
        }
        ++i;
        user = aux;
        aux = "";
        while (cad.charAt(i) != ';') {
            aux += cad.charAt(i);
            ++i;
        }
        ++i;
        observaciones = aux;
        aux = "";
        while (cad.charAt(i) != ';') {
            aux += cad.charAt(i);
            ++i;
        }
        ++i;
        hora = Integer.parseInt(aux);
        aux = "";
        while (cad.charAt(i) != ';') {
            aux += cad.charAt(i);
            ++i;
        }
        ++i;
        min = Integer.parseInt(aux);
        aux = "";
        while (cad.charAt(i) != ';') {
            aux += cad.charAt(i);
            ++i;
        }
        ++i;
        dia = Integer.parseInt(aux);
        aux = "";
        while (cad.charAt(i) != ';') {
            aux += cad.charAt(i);
            ++i;
        }
        ++i;
        mes = Integer.parseInt(aux);
        aux = "";
        while (cad.charAt(i) != ';') {
            aux += cad.charAt(i);
            ++i;
        }
        ++i;
        anio = Integer.parseInt(aux);
        aux = "";
        while (cad.charAt(i) != ';') {
            aux += cad.charAt(i);
            ++i;
        }
        modo = aux.charAt(0);
    }

    //Devuelve true si la fecha de la instancia esta entre las dos fechas dadas (en milisengundos)
    public boolean estaEnIntervalo(long fMenor, long fMayor) {
        Date d = new Date(anio, mes, dia);
        if (fMenor <= d.getTime() && d.getTime() <= fMayor) {
            return true;
        }
        return false;
    }

    //Formatea los datos para presentarlos en un jList
    public String presentar(Internacionalizacion idioma) {
        if (modo == 'l') {
            return "[" + idioma.fraseLlegada + "] " + dia + "/" + mes + "/" + anio + " " + hora + ":" + min + " (" + observaciones + ")";
        }
        return "[" + idioma.fraseSalida + "] " + dia + "/" + mes + "/" + anio + " " + hora + ":" + min + " (" + observaciones + ")";
    }

    //toCSV
    public String toString() {
        return user + ";" + observaciones + ";" + hora + ";" + min + ";" + dia + ";" + mes + ";" + anio + ";" + modo + ";";
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica9;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Miguel Angel Gonzalez Gallardo
 */
public class Usuario {

    private final String DNI, NUMSS; //Tanto el DNI como el Nº de la seg. social no se cambian, el dni se usa como clave
    private String nombre, apellidos, cargo, passwd; //Estos datos se pueden modifica

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDNI() {
        return DNI;
    }

    public String getNUMSS() {
        return NUMSS;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCargo() {
        return cargo;
    }

    //Constructor
    public Usuario(String DNI, String NumSS, String Nombre, String Apellidos, String Cargo, String pass) {
        this.DNI = DNI;
        this.NUMSS = NumSS;
        this.nombre = Nombre;
        this.apellidos = Apellidos;
        this.cargo = Cargo;
        setPassword(pass);

    }

    //Devuelve bool si el hash de la contraseña guardada coincide con la contraseña pasado por parámetro
    public boolean comprobarContraseña(String pass) {
        return passwd.equals(hashPassword(pass));
    }

    //Igual que el anterior pero sobrecargado
    public boolean comprobarContraseña(char[] pass) {
        String aux = "";
        for (int i = 0; i < pass.length; i++) {
            aux += pass[i];
        }
        return comprobarContraseña(aux);
    }

    public void setPassword(String pass) {
        passwd = hashPassword(pass);//Saco el hash de la contraseña (MD5)
    }

    public String toString() {
        return DNI + ";" + NUMSS + ";" + nombre + ";" + apellidos + ";" + cargo + ";" + passwd + ";";
    }

    //Constructor fromCSV
    public Usuario(String cad) {
        String aux = "";
        int i = 0;
        while (cad.charAt(i) != ';') {
            aux += cad.charAt(i);
            ++i;
        }
        ++i;
        DNI = aux;
        aux = "";
        while (cad.charAt(i) != ';') {
            aux += cad.charAt(i);
            ++i;
        }
        ++i;
        NUMSS = aux;
        aux = "";
        while (cad.charAt(i) != ';') {
            aux += cad.charAt(i);
            ++i;
        }
        ++i;
        nombre = aux;
        aux = "";
        while (cad.charAt(i) != ';') {
            aux += cad.charAt(i);
            ++i;
        }
        ++i;
        apellidos = aux;
        aux = "";
        while (cad.charAt(i) != ';') {
            aux += cad.charAt(i);
            ++i;
        }
        ++i;
        cargo = aux;
        aux = "";
        while (cad.charAt(i) != ';') {
            aux += cad.charAt(i);
            ++i;
        }
        passwd = aux;
    }

    //Código para para hashear la contraseña cogido de internet
    public static String hashPassword(String password) {
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(password.getBytes());
            //Get the hash's bytes 
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

}

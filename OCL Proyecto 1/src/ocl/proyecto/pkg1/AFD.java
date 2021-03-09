/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocl.proyecto.pkg1;

/**
 *
 * @author home
 */
public class AFD {
    public String nombre;
    public String alfabeto;
    public String transicion;

    public AFD(String nombre, String alfabeto, String transicion) {
        this.nombre = nombre;
        this.alfabeto = alfabeto;
        this.transicion = transicion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAlfabeto() {
        return alfabeto;
    }

    public void setAlfabeto(String alfabeto) {
        this.alfabeto = alfabeto;
    }

    public String getTransicion() {
        return transicion;
    }

    public void setTransicion(String transicion) {
        this.transicion = transicion;
    }
    
    
}

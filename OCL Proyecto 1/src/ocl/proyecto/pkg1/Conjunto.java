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
public class Conjunto {
    public String nombre;
    public String rango;

    public Conjunto(String nombre, String rango) {
        this.nombre = nombre;
        this.rango = rango;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }
    
    
}

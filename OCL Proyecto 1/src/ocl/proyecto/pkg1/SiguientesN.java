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
public class SiguientesN {
    public int numHoja;
    public String nombreHoja;
    public String siguiente;

    public SiguientesN(int numHoja, String nombreHoja, String siguiente) {
        this.numHoja = numHoja;
        this.nombreHoja = nombreHoja;
        this.siguiente = siguiente;
    }

    public int getNumHoja() {
        return numHoja;
    }

    public void setNumHoja(int numHoja) {
        this.numHoja = numHoja;
    }

    public String getNombreHoja() {
        return nombreHoja;
    }

    public void setNombreHoja(String nombreHoja) {
        this.nombreHoja = nombreHoja;
    }

    public String getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(String siguiente) {
        this.siguiente = siguiente;
    }
    
    
}

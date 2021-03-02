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
public class Nodo {
    
    public Nodo hizq;
    public Nodo hder;
    public String valor;
    public int id;
    public String anulable;
    public int numNodo;
    public String primeros;
    public String ultimos;

    public Nodo(Nodo hizq, Nodo hder, String valor, int id, String anulable, int numNodo, String primeros, String ultimos) {
        this.hizq = hizq;
        this.hder = hder;
        this.valor = valor;
        this.id = id;
        this.anulable = anulable;
        this.numNodo = numNodo;
        this.primeros = primeros;
        this.ultimos = ultimos;
    }

    public Nodo getHizq() {
        return hizq;
    }

    public void setHizq(Nodo hizq) {
        this.hizq = hizq;
    }

    public Nodo getHder() {
        return hder;
    }

    public void setHder(Nodo hder) {
        this.hder = hder;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getAnulable() {
        return anulable;
    }

    public void setAnulable(String anulable) {
        this.anulable = anulable;
    }
    
     public int getNumNodo() {
        return numNodo;
    }

    public void setNumNodo(int numNodo) {
        this.numNodo = numNodo;
    }
    
    public String getPrimeros() {
        return primeros;
    }

    public void setPrimeros(String primeros) {
        this.primeros = primeros;
    }
    public String getUltimos() {
        return ultimos;
    }

    public void setUltimos(String ultimos) {
        this.ultimos = ultimos;
    }
    
    public String getCodigoInterno() {
        String etiqueta;
        if (hizq == null && hder == null) {
            //[shape=record, label ="a|{1|2|3}|6"]
            etiqueta = "nodo" + id + " [ shape=record, label =\""+primeros+"|" +"{"+anulable+"|"+valor+"| id:"+numNodo+"}|"+ultimos+"\"];\n";
        } else {
            etiqueta = "nodo" + id + " [ shape=record, label =\""+primeros+"|" +"{"+anulable+"|"+valor+"| id:"+numNodo+"}|"+ultimos+"\"];\n";
        }
        if (hizq != null) {
            etiqueta = etiqueta + hizq.getCodigoInterno()
                    + "nodo" + id + "->nodo" + hizq.id + "\n";
        }
        if (hder != null) {
            etiqueta = etiqueta + hder.getCodigoInterno()
                    + "nodo" + id + "->nodo" + hder.id + "\n";
        }
        return etiqueta;
        
    }
    
}
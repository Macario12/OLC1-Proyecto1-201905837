/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocl.proyecto.pkg1;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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
    
public static ArrayList<Nodo> ArbolesPreOrden = new ArrayList<Nodo>();
    public static void preOrden(Nodo nodo){
        if(nodo != null){
            ArbolesPreOrden.add(nodo);
            preOrden(nodo.hizq);
            preOrden(nodo.hder);
        }
       
    }
    
     public static int contador = 0;
     public static int valorCon = 0;
     public static ArrayList arrayaux;
     
     public static String getTableInterna(int valorcontador){
         sigN = new ArrayList<SiguientesN>();
        String etiqueta="";
    
        while (ArbolesPreOrden.size() != contador){
            String siguiente = "";
                if(ArbolesPreOrden.get(contador).getNumNodo() != 0){
                    int contadorSiguientes = valorcontador;
                    while(ArbolesPreOrden.size() != contadorSiguientes){
                        if(ArbolesPreOrden.get(contadorSiguientes).getNumNodo() == 0){
                            if(ArbolesPreOrden.get(contadorSiguientes).getValor().equals("*") || ArbolesPreOrden.get(contadorSiguientes).getValor().equals("+")){
                                String[] sepa = ArbolesPreOrden.get(contadorSiguientes).getHizq().getUltimos().split(",");
                                for(int i = 0; i <sepa.length; i++){
                                    if(Integer.toString(ArbolesPreOrden.get(contador).getNumNodo()).equals(sepa[i])){
                                        
                                        siguiente += ","+ArbolesPreOrden.get(contadorSiguientes).getHizq().getPrimeros();
                                    }
                                }
                            }
                            
                            if(ArbolesPreOrden.get(contadorSiguientes).getValor().equals(".")){
                                String[] sepa = ArbolesPreOrden.get(contadorSiguientes).getHizq().getUltimos().split(",");
                                for(int i = 0; i <sepa.length; i++){
                                    if(Integer.toString(ArbolesPreOrden.get(contador).getNumNodo()).equals(sepa[i])){
                                        siguiente += ","+ArbolesPreOrden.get(contadorSiguientes).getHder().getPrimeros();
                                    }
                                }
                            }
                        }
                        contadorSiguientes++;
                    }
                    arrayaux = new ArrayList<>();
                    siguiente  = siguiente.replaceFirst(",", "");
                    String[] cadenaSig = siguiente.split(",");
                    
                    for(int v = 0; v <cadenaSig.length;v++){
                         arrayaux.add(cadenaSig[v]);
                    }
                    Collections.sort(arrayaux);
                    String sigaux = "";
                    for(int v = 0; v <arrayaux.size();v++){
                        sigaux +=","+arrayaux.get(v);
                    }
                    siguiente  = sigaux.replaceFirst(",", "");
                    etiqueta += " <tr><td>"+ArbolesPreOrden.get(contador).numNodo+"-"+ArbolesPreOrden.get(contador).valor+"</td><td>"+siguiente+"</td></tr>";
                    SiguientesN siguNodo = new SiguientesN(ArbolesPreOrden.get(contador).numNodo,ArbolesPreOrden.get(contador).valor,siguiente);
                    sigN.add(siguNodo);
                }
                contador ++;
                valorCon = contador;
        }
        
        return etiqueta;
    }
     
     public static int contadorEn = 0;
     public static ArrayList<String> 
         encabezado;
     public static ArrayList<SiguientesN> sigN;
     
     public static ArrayList<TransicionN> transN;
     public static ArrayList<AFD> arrayAFD;
     
     public static String getEncabezado(){
         String etiqueta="";
         encabezado = new ArrayList<>();
         
            while (ArbolesPreOrden.size() != contadorEn){
                    if(ArbolesPreOrden.get(contadorEn).getNumNodo() != 0){
                            if(ArbolesPreOrden.get(contadorEn).getValor().equals("#")){
                                }else{
                                 boolean encontrado = false;
                                 for(int x = 0; x <encabezado.size();x++){
                                     String e = encabezado.get(x);
                                        if(ArbolesPreOrden.get(contadorEn).valor.equals(e)){
                                            encontrado = true;
                                            break;
                                        }
                                 }  
                                 
                                 if(encontrado == false){
                                    encabezado.add(ArbolesPreOrden.get(contadorEn).getValor());
                                 }
                                    
                            }   
                    }       
                    contadorEn ++;
            }
            
         for(int x = 0; x <encabezado.size();x++){
            String e = encabezado.get(x);
                etiqueta +="<td>"+e+"</td>";   
           }   
         
         return etiqueta;
    }
     public static int contadorpa = 0;
     public static int contador2 = 0;
     public static int contadorparalacadena = 0;
     public static String getTableTransiciones(int countN){
         
         arrayAFD = new ArrayList<>();

        contadorpa = 0;
        String etiqueta="";
        transN = new ArrayList<>();
        transN.add(new TransicionN("S0",ArbolesPreOrden.get(countN).getPrimeros()));
        
        for(int x = 0; x <sigN.size();x++){
            if(estadosarray(sigN.get(x).siguiente,sigN)){
                contadorpa++;
                transN.add(new TransicionN("S"+contadorpa,sigN.get(x).siguiente));
            }
        }


        for(int x = 0; x <transN.size()-1;x++){
            String [] cadenaTrans = transN.get(x).transicionT.split(",");
            String [] posicionesTra = new String[encabezado.size()];
            for(int v = 0; v < posicionesTra.length; v++){
                posicionesTra[v] = "<td>...</td>";
            }
            String alfAFD = "";
            String tranAFD = "";
            int contadordentro = 0;
            String column = "<tr><td>"+transN.get(x).nombreT+" {"+transN.get(x).transicionT+"} "+"</td>";
            for(int j = 0; j<cadenaTrans.length;j++){
                String num = cadenaTrans[j];
                for(int w=0; w<encabezado.size();w++){
                    String alfabeto = encabezado.get(w);
                    for(int y = 0; y<sigN.size();y++){
                            if(sigN.get(y).nombreHoja.equals(alfabeto)){
                            if(Integer.parseInt(num)== sigN.get(y).numHoja ){
                                for(int i = 1; i <transN.size();i++){
                                    if(sigN.get(y).siguiente.equals(transN.get(i).transicionT)){
                                        contadordentro = w+1;
                                        posicionesTra[w] = "<td>"+transN.get(i).nombreT+"</td>";
                                        alfAFD += ","+alfabeto;
                                        tranAFD += ","+transN.get(i).nombreT;
                                        
                                    }
                                        
                                }
                            }
                        }
                   }
            }
            }
            for(int v = 0; v < posicionesTra.length; v++){
                column += posicionesTra[v];
            }
            alfAFD = alfAFD.replaceFirst(",", "");
            tranAFD = tranAFD.replaceFirst(",", "");
            arrayAFD.add(new AFD(transN.get(x).nombreT,alfAFD,tranAFD));
            column += "</tr>";
            etiqueta += column;
        }
        
        
        return etiqueta;
    }
     
     public static String getAFD(){
         String etiqueta = "";
         etiqueta += "node [shape = doublecircle];"+arrayAFD.get(arrayAFD.size()-1).nombre+";";
         etiqueta += "node [shape=circle]";
         for(int x = 0; x <arrayAFD.size();x++){
             System.out.println("array "+ arrayAFD.get(x).nombre);
             System.out.println("array "+ arrayAFD.get(x).transicion);
             etiqueta += arrayAFD.get(x).nombre+" [ label =\" "+ arrayAFD.get(x).nombre+"\"];";
         }
         
         for(int x = 0; x <arrayAFD.size()-1;x++){
             String[] tranAFD = arrayAFD.get(x).transicion.split(",");
             String[] alfaAFD = arrayAFD.get(x).alfabeto.split(",");
             
                for(int y = 0; y <tranAFD.length;y++){
                    etiqueta += arrayAFD.get(x).nombre+"->"+tranAFD[y]+"[ label = \""+alfaAFD[y]+"\"]"+"\n";
                }    
         }
         
         if(arrayAFD.get(arrayAFD.size()-1).transicion.equals("")){
             
         }else{
             
             String[] tranAFD = arrayAFD.get(arrayAFD.size()-1).transicion.split(",");
             String[] alfaAFD = arrayAFD.get(arrayAFD.size()-1).alfabeto.split(",");
             for(int y = 0; y <tranAFD.length;y++){
                    etiqueta += arrayAFD.get(arrayAFD.size()-1).nombre+"->"+tranAFD[y]+"[ label = \""+alfaAFD[y]+"\"]"+"\n";
                } 
         }
         
         return etiqueta;
     }
     
     public static boolean estadosarray(String dato,ArrayList trans){
         int contadorpro = 0;
         
         for(int x = 0; x <transN.size();x++){
             if(transN.get(x).transicionT.equals(dato)){
                 
                contadorpro++;
             }else{
                contadorpro=1;
                
             
             }
         }
         return contadorpro == 1;
     }
     
     public static int contadorArc = 0;
     public static void graficarTablaSiguientes(String nombre){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("C:\\Users\\home\\Desktop\\Documentos Escritorio\\Universidad\\Quinto Semestre\\Compiladores 1\\Laboratorio\\OLC1-Proyecto1-201905837\\OCL Proyecto 1\\SIGUIENTES_201905837\\" + nombre + ".dot");
            pw = new PrintWriter(fichero);
            pw.println("digraph G{");
            pw.println("graph [pad=\"0.5\", nodesep=\"0.5\", ranksep=\"2\"];");
            pw.println("node [shape=plain]");
            pw.println("rankdir=LR;");
            pw.println("Foo [label=< <table border=\"0\" cellborder=\"1\" cellspacing=\"0\"> <tr><td>Hoja</td><td>Siguiente</td></tr>"+ getTableInterna(valorCon)+ " </table>>];");
            pw.println("}");
        } catch (Exception e) {
            System.out.println("error, no se realizo el archivo");
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        //para compilar el archivo dot y obtener la imagen
        try {
            //dirección doonde se ecnuentra el compilador de graphviz
            String dotPath = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";
            //dirección del archivo dot
            String fileInputPath = "C:\\Users\\home\\Desktop\\Documentos Escritorio\\Universidad\\Quinto Semestre\\Compiladores 1\\Laboratorio\\OLC1-Proyecto1-201905837\\OCL Proyecto 1\\SIGUIENTES_201905837\\" + nombre + ".dot";
            //dirección donde se creara la magen
            String fileOutputPath = "C:\\Users\\home\\Desktop\\Documentos Escritorio\\Universidad\\Quinto Semestre\\Compiladores 1\\Laboratorio\\OLC1-Proyecto1-201905837\\OCL Proyecto 1\\SIGUIENTES_201905837\\" +nombre  + ".jpg";
            //tipo de conversón
            String tParam = "-Tjpg";
            String tOParam = "-o";
            contadorArc++;
            String[] cmd = new String[5];
            cmd[0] = dotPath;
            cmd[1] = tParam;
            cmd[2] = fileInputPath;
            cmd[3] = tOParam;
            cmd[4] = fileOutputPath;

            Runtime rt = Runtime.getRuntime();

            rt.exec(cmd);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }
    }
     
     public static void graficarTablaransciones(String nombre){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("C:\\Users\\home\\Desktop\\Documentos Escritorio\\Universidad\\Quinto Semestre\\Compiladores 1\\Laboratorio\\OLC1-Proyecto1-201905837\\OCL Proyecto 1\\TRANSICIONES_201905837\\" + nombre + ".dot");
            pw = new PrintWriter(fichero);
            pw.println("digraph G{");
            pw.println("graph [pad=\"0.5\", nodesep=\"0.5\", ranksep=\"2\"];");
            pw.println("node [shape=plain]");
            pw.println("rankdir=LR;");
            pw.println("Foo [label=< <table border=\"0\" cellborder=\"1\" cellspacing=\"0\"> <tr><td>Estado</td>"+getEncabezado()+"</tr>"+ getTableTransiciones(contador2)+ "</table>>];");
            pw.println("}");
        } catch (Exception e) {
            System.out.println("error, no se realizo el archivo");
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        //para compilar el archivo dot y obtener la imagen
        try {
            //dirección doonde se ecnuentra el compilador de graphviz
            String dotPath = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";
            //dirección del archivo dot
            String fileInputPath = "C:\\Users\\home\\Desktop\\Documentos Escritorio\\Universidad\\Quinto Semestre\\Compiladores 1\\Laboratorio\\OLC1-Proyecto1-201905837\\OCL Proyecto 1\\TRANSICIONES_201905837\\" + nombre + ".dot";
            //dirección donde se creara la magen
            String fileOutputPath = "C:\\Users\\home\\Desktop\\Documentos Escritorio\\Universidad\\Quinto Semestre\\Compiladores 1\\Laboratorio\\OLC1-Proyecto1-201905837\\OCL Proyecto 1\\TRANSICIONES_201905837\\" +nombre + ".jpg";
            //tipo de conversón
            String tParam = "-Tjpg";
            String tOParam = "-o";
            contadorArc++;
            String[] cmd = new String[5];
            cmd[0] = dotPath;
            cmd[1] = tParam;
            cmd[2] = fileInputPath;
            cmd[3] = tOParam;
            cmd[4] = fileOutputPath;

            Runtime rt = Runtime.getRuntime();

            rt.exec(cmd);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }
    }
     
      public static void graficarAFD(String nombre){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("C:\\Users\\home\\Desktop\\Documentos Escritorio\\Universidad\\Quinto Semestre\\Compiladores 1\\Laboratorio\\OLC1-Proyecto1-201905837\\OCL Proyecto 1\\AFD_201905837\\" + nombre + ".dot");
            pw = new PrintWriter(fichero);
            pw.println("digraph G{");
            pw.println("graph [pad=\"0.5\", nodesep=\"0.5\", ranksep=\"2\"];");
            
            pw.println("rankdir=LR;");
            pw.println(""+getAFD()+"");
            pw.println("}");
        } catch (Exception e) {
            System.out.println("error, no se realizo el archivo");
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        //para compilar el archivo dot y obtener la imagen
        try {
            //dirección doonde se ecnuentra el compilador de graphviz
            String dotPath = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";
            //dirección del archivo dot
            
            String fileInputPath = "C:\\Users\\home\\Desktop\\Documentos Escritorio\\Universidad\\Quinto Semestre\\Compiladores 1\\Laboratorio\\OLC1-Proyecto1-201905837\\OCL Proyecto 1\\AFD_201905837\\" + nombre + ".dot";
            //dirección donde se creara la magen
            String fileOutputPath = "C:\\Users\\home\\Desktop\\Documentos Escritorio\\Universidad\\Quinto Semestre\\Compiladores 1\\Laboratorio\\OLC1-Proyecto1-201905837\\OCL Proyecto 1\\AFD_201905837\\" +nombre+ ".jpg";
            //tipo de conversón
            String tParam = "-Tjpg";
            String tOParam = "-o";
            contadorArc++;
            String[] cmd = new String[5];
            cmd[0] = dotPath;
            cmd[1] = tParam;
            cmd[2] = fileInputPath;
            cmd[3] = tOParam;
            cmd[4] = fileOutputPath;

            Runtime rt = Runtime.getRuntime();

            rt.exec(cmd);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


/**
 *
 * @author Roberto Cruz Leija
 */
public class Tokenizador {
    public static ArrayList<Patron> inst;
    
   
    public static void leerInstancias(){
     String texto, aux;
     LinkedList<String> lista = new LinkedList();
     inst = new ArrayList<>();
     //ArrayList<Patron> patrones = new ArrayList<>();
        try {
            //llamamos el metodo que permite cargar la ventana
            JFileChooser file = new JFileChooser();
            file.showOpenDialog(file);
            //abrimos el archivo seleccionado
            File abre = file.getSelectedFile();

            //recorremos el archivo y lo leemos
            if (abre != null) {
                FileReader archivos = new FileReader(abre);
                BufferedReader lee = new BufferedReader(archivos);

                while ((aux = lee.readLine()) != null) {
                    texto = aux;
                    lista.add(texto);
                }
                lee.close();
                //System.out.println(lista.size());

                ArrayList<String> lista2 = new ArrayList<>();
                String clase = "";
                for (int i = 0; i < lista.size(); i++) {
                    StringTokenizer st = new StringTokenizer(lista.get(i), ",");

                    while (st.hasMoreTokens()) {
                        lista2.add(st.nextToken());
                    }

                    double[] vector = new double[lista2.size() - 1];

                    for (int x = 0; x < lista2.size() - 1; x++) {
                        vector[x] = Double.parseDouble(lista2.get(x));
                    }

                    clase = lista2.get(lista2.size()-1);
                    // a la coleccion de patrones se agrega un nuevo patron
                    inst.add(new Patron(vector, clase));
                   // patrones.add();
                    lista2.clear();

                }
          
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex + ""
                    + "\nNo se ha encontrado el archivo",
                    "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
            
        }
       
       Individuo.dimGenotipo = inst.get(0).getVectorCa().length;
     
    }
    
    public static ArrayList<Patron> filtrarInstancias(int[] genotipo){
    ArrayList<Patron> aux = new ArrayList<>();
    Random ran = new Random();
        for(Patron p: inst){
        int dim = obtenerDim(genotipo);
        double gAux[];
        int y=0;
        if (dim!=0){
             gAux = new double[dim];
        for(int x=0; x<genotipo.length;x++){
            if(genotipo[x]==1){
            gAux[y]=p.getVectorCa()[x];
            y++;
            }
        }
        }else{
         int pos = ran.nextInt(genotipo.length);
         gAux = new double[1];
         gAux[0]=p.getVectorCa()[pos];
        }
        
        aux.add(new Patron(gAux, p.getClase()));
              
        }
        return aux;
    }

    private static int obtenerDim(int[] genotipo) {
        int c = 0;
        for(int x=0;x<genotipo.length;x++){
          if(genotipo[x]==1)c++;
        }
        return c;  
    }
}

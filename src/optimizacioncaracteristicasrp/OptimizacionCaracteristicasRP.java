/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optimizacioncaracteristicasrp;

import java.util.ArrayList;
import java.util.Random;
import modelos.Individuo;
import modelos.MinimaDistancia;
import modelos.Patron;
import modelos.Tokenizador;

/**
 *
 * @author Roberto Cruz Leija
 */
public class OptimizacionCaracteristicasRP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tokenizador.leerInstancias();
//        Individuo aux = null;
//        for(int x=0;x<10000;x++){
//         aux = new Individuo();
//         System.out.println(x+": "+aux.getFitness());
//        
//        }
       Individuo in = new Individuo(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0});
        
        System.out.println(in.getFitness());
    }

    private static int[] generaArreglo(int i) {
     int arreglo[] = new int[i];
     Random r = new Random();
     for(int x=0; x<i;x++)
         arreglo[x] = r.nextInt(2);
      return arreglo;
    }
  
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Roberto Cruz Leija
 */
public class Individuo {
    
    public static int dimGenotipo;
    private int[] genotipo;
   
    private double fitness;
    
    // contructor con un criterio aleatorio 

    public Individuo() {
        this.genotipo = new int[dimGenotipo];
        // generar de forma aleatoria el genotipo del ind
        generarAleatorio();
         calcularFitness();
       // calculamos fitness
        
    }
    public Individuo(int[] genotipo){
        this.genotipo = genotipo.clone();
         calcularFitness();
       // calculamos fitness
    
    }
    private void generarAleatorio() {
       Random ran = new Random();
      
       // asignar 0 o 1 a cada uno de los genes
       for (int x=0; x<dimGenotipo;x++)
           this.genotipo[x]= ran.nextInt(2);
      
    }

    /**
     * @return the genotipo
     */
    public int[] getGenotipo() {
        return genotipo;
    }

    /**
     * @param genotipo the genotipo to set
     */
    public void setGenotipo(int[] genotipo) {
        this.genotipo = genotipo;
    }

    /**
     * @return the fitness
     */
    public double getFitness() {
       
        
        return fitness;
    }

    
    private void calcularFitness() {
       ArrayList<Patron> l = Tokenizador.filtrarInstancias(genotipo);
        
        MinimaDistancia md = new MinimaDistancia();
        md.entrenar(l);
        md.clasificaConjunto(l);
        this.fitness =md.getRendimiento();
    }

 
    
    
    
}

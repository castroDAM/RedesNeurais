/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Neuronio;

import Neuronio.Interfaces.NeuronioInterface;
import Functions.Interfaces.*;
import Functions.Enums.*;

/**
 *
 * @author Douglas
 */
public class Neuronio implements NeuronioInterface{

    double PotencialDeAtivação = 0;
    
    GeneralFunction Function;
    
    public Neuronio(TypeFunct funcAtiv) {
        Function = funcAtiv.getFunction();
    }
    
    @Override
    public void setInputs(double[] entradas, double[] pesos) {
        
        if ( entradas.length > pesos.length ){
            System.err.println("Mais entradas do que pesos. As entradas que não tiverem um peso na posição correspondente terão o valor zero");
        } else if ( entradas.length < pesos.length ){
            System.err.println("Mais Pesos do que entradas. Os pesos que não tiverem uma entrada na posição correspondente multiplicam uma entrada nula");
        }
        
        double PotencialDeAtivação = 0;
        for(int i=0; i<entradas.length; i++){
            PotencialDeAtivação +=entradas[i]*pesos[i];
        }
    }

    @Override
    public double getOutput() {
        return Function.setPotencialGetOutput(this.PotencialDeAtivação);
    }
    
}

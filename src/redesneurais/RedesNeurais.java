/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redesneurais;

import RNA.Camada;
import Functions.Enums.TypeFunct;

/**
 *
 * @author Douglas
 */
public class RedesNeurais {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Camada camada = new Camada(2, 5, TypeFunct.Linear);
        for(int i=0; i<camada.getNumNeuronio(); i++){
            System.out.println("");
            System.out.println(camada.getNeuronioByIndex(i).toString());
        }
    }
    
}

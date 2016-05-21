/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redesneurais;

import RNA.Camada;
import Functions.Enums.TypeFunct;
import RNA.MLP;
import java.util.ArrayList;

/**
 *
 * @author Douglas
 */
public class RedesNeurais {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int entradas = 4;
        int camadas = 4;
        int[] neuronios = {1,2,3,4};
        ArrayList<TypeFunct> func = new ArrayList<>();
        
        func.add(TypeFunct.Sign);
        func.add(TypeFunct.Sigm);
        func.add(TypeFunct.TanHip);
        func.add(TypeFunct.Linear);
        
        MLP mlp = new MLP(entradas, camadas, neuronios, func);
        System.out.println(mlp.toString());
        
        mlp.getWeightByIndex(2);
        mlp.getWeightByIndex(2, 2);
        mlp.getWeightByIndex(2, 2, 1);
    }
    
}

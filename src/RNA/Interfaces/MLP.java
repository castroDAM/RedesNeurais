/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RNA.Interfaces;

import Functions.Enums.TypeFunct;
import RNA.Camada;
import java.util.ArrayList;

/**
 *
 * @author Douglas
 */
public class MLP implements NeuronioInterface{

    ArrayList<Camada> listOfCamadas = new ArrayList<>();
    
    private final int numEntradas;
    private final int numSaidas;
    private final int numCamadas;
    private final int[] numNeuronioCamada;

    public MLP(int numEntradas, int numCamadas, int[] numNeuronioCamada, ArrayList<TypeFunct> FcnPorCamada) {
        this.numEntradas = numEntradas;
        this.numCamadas = numCamadas;
        this.numNeuronioCamada = numNeuronioCamada;
        this.numSaidas = numNeuronioCamada[numCamadas-1];
        
        this.listOfCamadas.add(new Camada(this.numEntradas, this.numNeuronioCamada[0], FcnPorCamada.get(0)));

        for (int i = 1; i < this.numCamadas; i++) {
            this.listOfCamadas.add(new Camada(this.listOfCamadas.get(i - 1).getNumNeuronio(), this.numNeuronioCamada[i], FcnPorCamada.get(i)));
        }
    }
    
    @Override
    public void setInputs(double[] entradas) {
        
        double[] entrada = entradas;
        
        for(int i=0; i<numCamadas; i++){
            this.listOfCamadas.get(i).setInputs(entrada);
            entrada = this.listOfCamadas.get(i).getOutput();
        }
    }

    @Override
    public double[] getOutput() {
        return this.listOfCamadas.get(this.numCamadas-1).getOutput();
    }
    
}

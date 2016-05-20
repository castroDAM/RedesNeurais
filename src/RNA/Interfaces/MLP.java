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
    private int numCamadas;
    private int[] numNeuronioCamada;

    public MLP(int numEntradas, int numCamadas, int[] numNeuronioCamada, ArrayList<TypeFunct> FcnPorCamada) {
        this.numEntradas = numEntradas;
        this.numCamadas = numCamadas;
        this.numNeuronioCamada = numNeuronioCamada;

        this.listOfCamadas.add(new Camada(this.numEntradas, this.numNeuronioCamada[0], FcnPorCamada.get(0)));

        for (int i = 1; i < numCamadas; i++) {
            this.listOfCamadas.add(new Camada(this.listOfCamadas.get(i - 1).getNumNeuronio(), this.numNeuronioCamada[i], FcnPorCamada.get(i)));
        }
    }
    
    
    
    
    @Override
    public void setInputs(double[] entradas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double[] getOutput() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

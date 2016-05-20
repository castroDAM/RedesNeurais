/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RNA;

import Functions.Enums.TypeFunct;
import Functions.Interfaces.GeneralFunction;
import RNA.Interfaces.NeuronioInterface;
import java.util.ArrayList;
        
/**
 *
 * @author Douglas
 */
public class Camada implements NeuronioInterface{
    
    ArrayList<Neuronio> listOfNeuronios = new ArrayList<>();
    
    int numEntradas;
    int numNeuronios;
    TypeFunct FcnAtv;

    public Camada(int numEntradas, int numNeuronios, TypeFunct FcnAtv) {
        this.numEntradas = numEntradas;
        this.numNeuronios = numNeuronios;
        this.FcnAtv = FcnAtv;
        
        for(int i=0; i<this.numNeuronios; i++){
            this.listOfNeuronios.add(new Neuronio(numEntradas, FcnAtv));
        }
    }
    
    public int getNumEntradas(){
        return this.numEntradas;
    }
    
    public int getNumNeuronio(){
        return this.numNeuronios;
    }
    
    public Neuronio getNeuronioByIndex(int index){
        return this.listOfNeuronios.get(index);
    }
    

    @Override
    public void setInputs(double[] entradas) {
        for(int i=0;  i<numNeuronios; i++){
            this.listOfNeuronios.get(i).setInputs(entradas);
        }
    }

    @Override
    public double[] getOutput() {
        double[] retorno = new double[this.numNeuronios];
        for(int i=0; i<retorno.length; i++){
            retorno[i] = this.listOfNeuronios.get(i).getOutput()[0];
        }
        return retorno;
    }
    
}

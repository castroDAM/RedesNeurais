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
import java.util.Arrays;
        
/**
 *
 * @author Douglas
 */
public class Camada implements NeuronioInterface{
    
    ArrayList<Neuronio> listOfNeuronios = new ArrayList<>();
    
    int numEntradas;
    int ID;
    int numNeuronios;
    TypeFunct FcnAtv;

    public Camada(int numEntradas, int numNeuronios, TypeFunct FcnAtv, int ID) {
        this.numEntradas = numEntradas;
        this.numNeuronios = numNeuronios;
        this.FcnAtv = FcnAtv;
        this.ID = ID;
        
        for(int i=0; i<this.numNeuronios; i++){
            this.listOfNeuronios.add(new Neuronio(numEntradas, FcnAtv, i));
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
    
    @Override
    public String toString(){
        String retorno = "\n";
        retorno += "----------------- Camada " + this.ID + " -----------------";
        
        for(int i=0; i<listOfNeuronios.size(); i++){
            retorno += "\n\t" + listOfNeuronios.get(i).toString();
        }
        
        return retorno;
    }
    
    /**
     * Pegar os pesos sinápticos correspondentes a camada. A ordem do retorno é dado pelos neurônios. Ex: Uma camada com 4 neurônios e 2 entradas. O retorno 
     * será dado na seguinte ordem : 2 Pesos do primeiro Neuronio, 2 Pesos do segundo neurônio, 2 Pesos do terceiro neurônio e 2 Pesos do quarto neurônio,  
     * @return Pesos Sinápticos correspondentes da camada
     */
    public ArrayList getWeights(){
        ArrayList pesos = new ArrayList();
        for(int i=0; i<this.numNeuronios; i++){
            pesos.add(this.listOfNeuronios.get(i).getWeights());
        }
        
        return pesos;
    }
    
    /**
     *  Seta todos os neuronios da camada especificada. A ordem do retorno é dado pelos neurônios. Ex: Uma camada com 4 neurônios e 2 entradas, a atribuição 
     * será dada na seguinte ordem : 2 Pesos do primeiro Neuronio, 2 Pesos do segundo neurônio, 2 Pesos do terceiro neurônio e 2 Pesos do quarto neurônio,
     * @param pesos Lista de Pesos Sinapticos
     */
    public void setWeights(ArrayList pesos){
        for(int i=0; i<this.listOfNeuronios.size(); i++){
            this.listOfNeuronios.get(i).setWeights((double[]) pesos.get(i));
        }
            
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RNA;

import RNA.Interfaces.NeuronioInterface;
import Functions.Interfaces.*;
import Functions.Enums.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Douglas
 */
public class Neuronio implements NeuronioInterface{

    private double PotencialDeAtivação;
    private double[] Pesos = null;
    private int numEntradas;
    private int ID;
    
    private GeneralFunction Function;
    
    /**
     * Método construtor do objeto Neurônio. Os Pesos são inicializados de forma aleatória
     * @param numEntradas Quantidade de Entradas que o neurônio receberá
     * @param Function Função de Ativação
     * @param ID ID do Neuroônio
     */
    public Neuronio(int numEntradas, TypeFunct Function, int ID) {
        this.numEntradas = numEntradas;
        this.Pesos = new double[numEntradas];
        this.ID = ID;
        for(int i=0; i<numEntradas; i++){
            this.Pesos[i] = Math.random();
        }
        this.Function = Function.getFunction();
    }
    
    /**
     * Método construtor do objeto Neurônio.
     * @param numEntradas Quantidade de Entradas que o neurônio receberá
     * @param Pesos Pesos Sinápticos Iniciais
     * @param Function Função de Ativação
     */
    public Neuronio(int numEntradas, double[] Pesos, TypeFunct Function) {
        this.numEntradas = numEntradas;
        this.Pesos = Pesos;
        this.ID = -1;
        this.Function = Function.getFunction();
    }
    
    @Override
    public String toString(){
        String retorno = "";
        retorno += "Neurônio " + this.ID;
        retorno += "\nNumero de entradas = " + this.numEntradas;
        retorno += "\nFunção de Ativação = " + Function.getNameFunction();
        retorno += "\n[ ";
        for(int i=0; i<this.numEntradas; i++){
            retorno += "  Entrada " + i + " = " + this.Pesos[i] + ";  ";
        }
        retorno +="]";
        
        return retorno;
    }
    
    /**
     * 
     * @param entradas Vetor de entrada do Neurônio.
     */
    @Override
    public void setInputs(double[] entradas) {
        
        if ( entradas.length > this.Pesos.length ){
            System.err.println("Mais entradas do que pesos. As entradas que não tiverem um peso na posição correspondente terão o valor zero");
        } else if ( entradas.length < this.Pesos.length ){
            System.err.println("Mais Pesos do que entradas. Os pesos que não tiverem uma entrada na posição correspondente multiplicam uma entrada nula");
        }
        
        for(int i=0; i<entradas.length; i++){
            PotencialDeAtivação +=entradas[i]*this.Pesos[i];
        }
    }

    /**
     * 
     * @return O resultado da função de ativação dada a última entrada armazenada no neurônio
     */
    @Override
    public double[] getOutput() {
        double[] retorno = new double[1];
        retorno[0] = Function.setPotencialGetOutput(this.PotencialDeAtivação);
        return retorno;
    }
    
    public double getWeightByInput(int input){
        return this.Pesos[input];
    }
    
    public ArrayList getWeights(){
        ArrayList retorno = new ArrayList();
        for(int i=0; i<this.numEntradas; i++){
            retorno.add(this.Pesos[i]);
        }
        
        return retorno;
    }
    
    public void setWeights(double[] pesos){
        this.Pesos = pesos;
    }
    
}

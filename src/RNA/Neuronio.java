/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RNA;

import RNA.Interfaces.NeuronioInterface;
import Functions.Interfaces.*;
import Functions.Enums.*;

/**
 *
 * @author Douglas
 */
public class Neuronio implements NeuronioInterface{

    private double PotencialDeAtivação;
    private double[] Pesos = null;
    private int numEntradas;
    
    private GeneralFunction Function;

    /**
     * Método construtor do objeto Neurônio. Os Pesos são inicializados de forma aleatória e a função de ativação é Linear
     * @param numEntradas Quantidade de Entradas que o neurônio receberá
     */
    public Neuronio(int numEntradas) {
        this.numEntradas = numEntradas;
        this.Pesos = new double[numEntradas];
        for(int i=0; i<numEntradas; i++){
            this.Pesos[i] = Math.random();
        }
        this.Function = TypeFunct.Linear.getFunction();
    }
    
    /**
     * Método construtor do objeto Neurônio. Os Pesos são inicializados de forma aleatória
     * @param numEntradas Quantidade de Entradas que o neurônio receberá
     * @param Function Função de Ativação
     */
    public Neuronio(int numEntradas, TypeFunct Function) {
        this.numEntradas = numEntradas;
        this.Pesos = new double[numEntradas];
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
        this.Function = Function.getFunction();
    }
    
    @Override
    public String toString(){
        String retorno = "";
        retorno += "Neurônio Criado";
        retorno += "\nNumero de entradas = " + this.numEntradas;
        retorno += "\nFunção de Ativação = " + Function.getNameFunction();
        
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
    
    public double[] getWeights(){
        return this.Pesos;
    }
    
    public void setWeights(double[] pesos){
        this.Pesos = pesos;
    }
    
}

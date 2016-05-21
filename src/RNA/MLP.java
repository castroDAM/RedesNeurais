/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RNA;

import Functions.Enums.TypeFunct;
import RNA.Camada;
import RNA.Interfaces.NeuronioInterface;
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
        
        this.listOfCamadas.add(new Camada(this.numEntradas, this.numNeuronioCamada[0], FcnPorCamada.get(0),0));

        for (int i = 1; i < this.numCamadas; i++) {
            this.listOfCamadas.add(new Camada(this.listOfCamadas.get(i - 1).getNumNeuronio(), this.numNeuronioCamada[i], FcnPorCamada.get(i),i));
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
    
    @Override
    public String toString(){
        String retorno = "";
        for(int i=0; i<listOfCamadas.size(); i++){
            retorno += listOfCamadas.get(i).toString();
        }
        return retorno;
    }
    
    public Camada getCamada(int ID){
        return this.listOfCamadas.get(ID);
    }
    
    /**
     * Retorna Um peso específico
     * @param Camada Camada em que o peso está
     * @param neuronio Neurônio em que o peso está
     * @param entrada Entrada correspondente ao peso
     * @return peso da entrada "entrada" do neuronio "neuronio", na camada "Camada"
     */
    public double getWeightByIndex(int Camada, int neuronio, int entrada){
        return this.listOfCamadas.get(Camada).getNeuronioByIndex(neuronio).getWeightByInput(entrada);
    }
    
    /**
     *  Retorna um Conjunto de Pesos específicos de um neurônio
     * @param Camada Camada em que os pesos estão
     * @param neuronio Neurônio que possui o conjunto de pesos
     * @return pesos do neuronio "neuronio", na camada "Camada"
     */
    public ArrayList getWeightByIndex(int Camada, int neuronio){
        return this.listOfCamadas.get(Camada).getNeuronioByIndex(neuronio).getWeights();
    }
    
    /**
     *  Retorna um Conjunto de Pesos específicos de uma Camada
     * @param Camada Camada na qual os pesos estão
     * @return Todos os neuronios da camada especificada. A ordem do retorno é dado pelos neurônios. Ex: Uma camada com 4 neurônios e 2 entradas. O retorno 
     * será dado na seguinte ordem : 2 Pesos do primeiro Neuronio, 2 Pesos do segundo neurônio, 2 Pesos do terceiro neurônio e 2 Pesos do quarto neurônio,
     */
    public ArrayList getWeightByIndex(int Camada) {
        return this.listOfCamadas.get(Camada).getWeights();
    }
    
    /**
     *  Seta os pesos sinápticos em uma entrada de um neuronio de uma camada específica
     * @param Camada Camada em que o peso irá
     * @param neuronio Neurônio em que o peso irá
     * @param entrada Entrada correspondente ao peso
     * @param peso Valor do peso sináptico
     */
    public void setWeightByIndex(int Camada, int neuronio, int entrada, double peso){
        this.listOfCamadas.get(Camada).getNeuronioByIndex(neuronio).setWeightByInput(entrada, peso);
    }
    
    /**
     *  Seta os pesos sinápticos de um neuronio específico em uma camada específica
     * @param Camada Camada em que o peso irá
     * @param neuronio Neurônio em que o peso irá
     * @param peso Valor do peso sináptico
     */
    public void setWeightByIndex(int Camada, int neuronio, double[] peso){
        this.listOfCamadas.get(Camada).getNeuronioByIndex(neuronio).setWeights(peso);
    }
    
    /**
     *  Seta os pesos sinápticos de uma Camada específico
     * @param Camada Camada em que o peso irá
     * @param peso Valor do peso sináptico
     */
    public void setWeightByIndex(int Camada, ArrayList peso){
        this.listOfCamadas.get(Camada).setWeights(peso);
    }
    
}

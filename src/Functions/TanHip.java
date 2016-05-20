/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functions;

import Functions.Interfaces.GeneralFunction;

/**
 *
 * @author Douglas
 */
public class TanHip implements GeneralFunction{

    @Override
    public double setPotencialGetOutput(double potencial) {
        return Math.tanh(potencial);
    }

    @Override
    public String getNameFunction() {
        return "Tangente Hiperbólica";
    }
    
}

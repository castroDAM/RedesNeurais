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
public class Sign implements GeneralFunction{

    @Override
    public double setPotencialGetOutput(double potencial) {
        return potencial/Math.abs(potencial);
    }

    @Override
    public String getNameFunction() {
        return "Signal";
    }
    
}

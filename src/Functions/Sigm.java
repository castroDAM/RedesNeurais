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
public class Sigm implements GeneralFunction{

    private double alpha = 1;

    public void setAlpha(double alpha) {
        this.alpha = alpha;
    }

    public double getAlpha() {
        return alpha;
    }
    
    @Override
    public double setPotencialGetOutput(double potencial) {
        return (1/(1+Math.exp(-this.alpha*potencial)));
    }

    @Override
    public String getNameFunction() {
        return "Sigmóide";
    }
    
}

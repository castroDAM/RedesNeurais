/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functions;

import Functions.Interfaces.*;

/**
 *
 * @author Douglas
 */
public class Linear implements GeneralFunction{

    @Override
    public double setPotencialGetOutput(double potencial) {
        return potencial;
    }

    @Override
    public String getNameFunction() {
        return "Linear";
    }
    
    
}

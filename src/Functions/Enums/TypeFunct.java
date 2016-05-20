/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functions.Enums;

import Functions.*;
import Functions.Interfaces.*;
        

/**
 *
 * @author Douglas
 */
public enum TypeFunct {
    Linear {

        @Override
        public GeneralFunction getFunction() {
            return new Linear();
        }
    }, Sigm {

        @Override
        public GeneralFunction getFunction() {
            return new Sigm();
        }
    }, TanHip {

        @Override
        public GeneralFunction getFunction() {
            return new TanHip();
        }
    }, Sign{

        @Override
        public GeneralFunction getFunction() {
            return new Sign();
        }
        
    };
    
    public abstract GeneralFunction getFunction();
}

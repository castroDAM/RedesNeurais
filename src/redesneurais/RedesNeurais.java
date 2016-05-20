/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redesneurais;

import Functions.*;
import Functions.Enums.TypeFunct;
import Neuronio.*;

/**
 *
 * @author Douglas
 */
public class RedesNeurais {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Neuronio neuronio = new Neuronio(2,TypeFunct.TanSig);
        System.out.println(neuronio.toString());
    }
    
}

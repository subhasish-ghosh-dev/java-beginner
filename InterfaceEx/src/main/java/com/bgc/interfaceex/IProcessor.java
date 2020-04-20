/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bgc.interfaceex;

/**
 *
 * @author subhasish
 */
public interface IProcessor extends IRequest, IResponse { //multiple inheritance
    
   /*static final*/ int constantvalue=567;//constant
    
    int calculate();   //public 
    double calculate(float x1, float x2);
    void display(String result);
    
    default int operate(){
        return 90;
    }
    
}

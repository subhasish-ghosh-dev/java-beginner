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
public class Processor implements IProcessor{
    
    
    @Override
    public int calculate(){
        int a=90;
        int result = a+IProcessor.constantvalue;
        return result;
        
    }

    @Override
    public double calculate(float x1, float x2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void display(String result) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

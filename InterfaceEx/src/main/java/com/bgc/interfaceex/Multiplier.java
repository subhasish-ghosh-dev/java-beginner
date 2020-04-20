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
public class Multiplier implements IProcessor{
    
    private int a=0;
    private int result=0;
    
    
    private void display(){
        System.out.println(this.calculate());
    }  

    @Override
    public int calculate() {
        
        this.result=a*IProcessor.constantvalue;
        return this.result;    
    }
    
    @Override
    public double calculate(float x1, float x2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void display(String result) {
        this.display();
    }
    
    
}

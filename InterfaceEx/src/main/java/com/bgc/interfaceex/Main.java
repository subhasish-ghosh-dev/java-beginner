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
public class Main {
    public static void main(String[] rgas){
        
        //polymorphism
        IProcessor obj1=new Processor();
        
        
        IProcessor obj2=new Multiplier();
        
        System.out.println(obj1.calculate());//addition
        obj2.display("welcome");//multiplication
        
    }
    
}

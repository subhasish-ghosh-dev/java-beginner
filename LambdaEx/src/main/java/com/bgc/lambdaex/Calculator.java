/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bgc.lambdaex;

/**
 *
 * @author subhasish
 */
public class Calculator {//implements IEquation {
    
    private static void display(double result){
        System.out.println(result);
    }
    /*
    @Override
    public double calculate(double[] values, String type){
        double result = 0;
        switch(type){
            case "ADD":
                for(double v: values){
                    result+=v;
                }
                return result;
            case "DIVIDE":
                return result;
            default:
                System.out.println("NO TYPE DEFIEND");
        }
        
        return result;
    }
    */
    
    public static void main(String[] args){
        //IEquation iq= new Calculator();
        double[] values={12.3,45.9, 234.678};
        IEquation iq=(double[] values1,String type)-> {            
            double result=0;
            for(double v: values1){
                    result+=v;
             }
            
            return result;            
        };
        Calculator.display(iq.calculate(values, "ADD")); 
    }
    
    
}

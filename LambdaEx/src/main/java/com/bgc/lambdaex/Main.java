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
public class Main {
    private int operate(int a, int b, Function fobj) { 
	return fobj.operation(a, b); 
    } 

    public static void main(String args[]) {
        Main m =new Main();
        Function func = new Function(){
            int result=0;
            @Override
            public int operation(int x, int y){
                result= x+y;
                return result;
            }
            @Override
            public void print(String msg){
                System.out.println(msg+result);
            }
        };
    
        
	func.operation(12, 12);
        func.print("RESULT: ");
        int r = m.operate(12, 13, func);
        func.print("RESULT: ");
    } 
} 

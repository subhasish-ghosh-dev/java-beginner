/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bgc.innerclassex;

/**
 *
 * @author subhasish
 */
public class InnerExample {
    
    static class InnerClassOuter{
        public void calculate(){
            System.out.println("A+b="+(10+20));
        }
    }
    
    public void show(){
        
        class InnerClass{
            int month=12;
            public void display(){
                System.out.println("I am from inner class");
            }
        }
        //Annonymous Inner Class
        IFinance f=new IFinance(){
            long pvt=Long.parseLong("3000000000");
            long gros=Long.parseLong("2300000000");
            long govt=Long.parseLong("723000000000");
            long govtspending=Long.parseLong("45200000000");
            long exports=Long.parseLong("2000000000000");
            long imports=Long.parseLong("3000000000000");
            //private consumption + gross investment + 
            //government investment + government spending + (exports – imports)
            @Override
            public long calculateGDP() {
                return pvt+gros+govt+govtspending + (exports - imports);
            }
            
        };
        InnerClass in = new InnerClass();
        in.display();
        InnerClassOuter obj2=new InnerClassOuter();
        obj2.calculate();
        System.out.println(f.calculateGDP());
    }
    
    public static void main(String[] args){
        InnerExample obj = new InnerExample();
        obj.show();
    }
    
}

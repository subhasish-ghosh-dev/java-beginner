/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bgc.abstractex;

/**
 *Subhasish Bike
 * @author subhasish
 */
public abstract class Bike implements ICarMonitor  {
   Bike(){
       System.out.println("bike is created");
   }  
   abstract void run();  
   protected void changeGear(){
       System.out.println("gear changed");
   }  
}

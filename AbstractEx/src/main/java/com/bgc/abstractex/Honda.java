/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bgc.abstractex;

/**
 *
 * @author subhasish
 */
public class Honda extends Bike {

    @Override
    void run() {
        System.out.println("running safely..");
    }

    @Override
    public void a() {
        System.out.println("I am a");
    }

    @Override
    public void b() {
        System.out.println("I am b");
    }

    @Override
    public void brake() {
        System.out.println("I am brake");
    }

    @Override
    public void d() {
        System.out.println("I am d");
    }
    
}

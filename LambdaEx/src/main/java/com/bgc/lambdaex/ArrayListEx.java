/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bgc.lambdaex;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author subhasish
 */
public class ArrayListEx {
    
    private ArrayList<Integer> lists = new ArrayList<Integer>();
    
    public ArrayListEx(){
        
    }
    
    public static void main(String args[]){
        ArrayListEx obj1= new ArrayListEx();
        obj1.lists.add(190);
        obj1.lists.add(100);
        obj1.lists.add(173);
        obj1.lists.add(238);
        obj1.lists.add(561);
        obj1.lists.add(592);
        
        System.out.println("LIST BEFORE SORTING");
        obj1.lists.forEach(x -> {
            System.out.println(x);
        });
        
        System.out.println("LIST AFTER SORTING");        
        
        Collections.sort(obj1.lists);
        
        obj1.lists.forEach(x -> {
            System.out.println(x);
        });
    }
    
}

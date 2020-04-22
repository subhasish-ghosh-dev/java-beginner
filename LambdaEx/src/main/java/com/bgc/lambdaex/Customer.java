/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bgc.lambdaex;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author subhasish
 */
public class Customer implements Comparator<Entry<String, Customer>>{
    private String id;
    private String mobileNo;
    private String city;
    
    public Customer(String i, String m, String c){
        this.id=i;
        this.mobileNo=m;
        this.city=c;
    }

    public String getId(){
        return this.id;
    }
    
    public String getMobileNo(){
        return this.mobileNo;
    }
    
    public String getCity(){
        return this.city;
    }
    
    @Override
    public int compare(Entry<String,Customer> o1, Entry<String,Customer> o2) {  

        return o1.getValue().getId().compareTo(o2.getValue().getId());
    }   
}

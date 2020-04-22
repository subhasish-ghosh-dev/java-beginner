/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bgc.lambdaex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.*;
/**
 *
 * @author subhasish
 */
public class SortedStudent {
    public static void main(String[] args){
        TreeSet<Student> students=new TreeSet<Student>();
        students.add(new Student(23, "3rd C", "Abrar"));
        students.add(new Student(22, "3rd C", "Likhon"));
        students.add(new Student(21, "3rd C", "Abhishek"));
        students.add(new Student(24, "3rd C", "Panna"));
        students.add(new Student(20, "3rd C", "Munna"));
        
        students.forEach(st->
        {
            System.out.println(st.getName()+"  "+st.getAge());
        }        
        );
        
        HashMap<String, Customer> customers=new HashMap<String, Customer>(); 
        customers.put("abrar",new Customer("A123456","abrar@bgctub.ac.bd", "chittagong" ));
        customers.put("likhon",new Customer("A133456","likhon@bgctub.ac.bd", "goplagonj" ));
        customers.put("tareq",new Customer("A103456","tareq@bgctub.ac.bd", "kishoregonj" ));
        
        Set<Entry<String, Customer>> entry = customers.entrySet();
        List<Entry<String, Customer>> entryList=new ArrayList<Entry<String, Customer>>(entry);        
        /*Comparator<Entry<String,Customer>> com=new Comparator<Entry<String,Customer>>(){
            @Override
            public int compare(Entry<String,Customer> o1, Entry<String,Customer> o2) {  

                return o1.getValue().getId().compareTo(o2.getValue().getId());
            }    
        };  */             
        Collections.sort(entryList,entryList.get(0).getValue());               
        entryList.forEach(e ->{
            System.out.println(e.getValue().getId());
        }); 
       
    }
}

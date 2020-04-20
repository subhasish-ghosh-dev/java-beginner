/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bgc.lambdaex;

import java.util.TreeSet;

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
    }
}

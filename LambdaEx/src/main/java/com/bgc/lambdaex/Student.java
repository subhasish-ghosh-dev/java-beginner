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
public class Student implements Comparable{
    private int age;
    private String semester;
    private String name;
    
    public Student(int a, String sem, String n){
        this.age=a;
        this.semester=sem;
        this.name=n;
    }
    
    public int getAge(){
        return this.age;
    }
    
    public String getSemester(){
        return this.semester;
    }
    
    public String getName(){
        return this.name;
    }

    @Override
    public int compareTo(Object o) {
        /*Student s= (Student)o;
        if(this.name.compareTo(s.name)==0){
            return 0;
        } 
        else if(this.name.compareTo(s.name)>0){
            return 1;
        }        
        else{
            return -1;
        } */
        
        Student s= (Student)o;
        if(this.age==s.age){
            return 0;
        } 
        else if(this.age>s.age){
            return this.age-s.age;
        }        
        else{
            return this.age-s.age;
        }

    }
}

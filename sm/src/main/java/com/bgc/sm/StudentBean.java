/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bgc.sm;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author subhasish
 */
public class StudentBean {
    private IntegerProperty rollNo=new SimpleIntegerProperty();
    private StringProperty name=new SimpleStringProperty();
    private StringProperty semester=new SimpleStringProperty();
    private StringProperty email=new  SimpleStringProperty();
    private StringProperty dob=new SimpleStringProperty();
    
    
    public void setRollNo(int roll){
        rollNo.set(roll);
    }
    
    
    public int getRollNo(){
        return this.rollNo.get();
    }
    
    public void setName(String name){
        this.name.set(name);
    }
    
    
    public String getName(){
        return this.name.get();
    }
    
    public void setSemester(String sem){
        this.semester.set(sem);
    }
    
    
    public String getSemester(){
        return this.semester.get();
    }
    
    public void setEmail(String email){
        this.email.set(email);
    }
    
    
    public String getEmail(){
        return this.email.get();
    }
    
    public void setDob(String dob){
        this.dob.set(dob);
    }
    
    
    public String getDob(){
        return this.dob.get();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bgc.sm;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author subhasish
 */
public class Student {
    private int rollno;
    private String name;
    private String semester;
    private String email;
    private Date dob;
    
    public Student(int i, String n, String sem, String em, Date d){
        this.rollno=i;
        this.name=n;
        this.semester=sem;
        this.email=em;
        this.dob=d;
    }

    /**
     * @return the rollno
     */
    public int getRollno() {
        return rollno;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the semester
     */
    public String getSemester() {
        return semester;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the dob
     */
    public Date getDob() {
        return dob;
    }
    
    
    public static void main(String[] rags){
        DataAccess da=new DataAccess();
        DateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Student st;
        try {
            st = new Student(123456, "fasdfdasf","fsdfsdf", "dfsdfsdf", 
                    sdf.parse("2020-03-29"));
            da.insertStudent(st);

        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bgc.sm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author subhasish
 */
public class DataAccess {
    Connection con=null;
    
    //subhasish@bgctub.ac.bd
    
    
    public void insertStudent(Student st){
        con=DBConnection.getConnection();
        if(con!=null){
            String sql="insert into student(rollno,name,semester,email,dob) values(?,?,?,?,?)";
            try {
                PreparedStatement pstmt=con.prepareStatement(sql);
                pstmt.setInt(1,st.getRollno());
                pstmt.setString(2, st.getName());
                pstmt.setString(3, st.getSemester());
                pstmt.setString(4, st.getEmail());
                pstmt.setDate(5, new java.sql.Date(st.getDob().getTime()));
                pstmt.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            finally{
                try{
                    if(con!=null){
                        DBConnection.getConnection().close();
                        DBConnection.closeConnection();
                        con.close();
                        con=null;                    
                    }                    
                }
                catch(SQLException  s){
                    s.printStackTrace();
                }                
            }
            
        }
    }
    
}

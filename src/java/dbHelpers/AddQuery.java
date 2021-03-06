/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbHelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.FAMILY;

/**
 *
 * @author sfishman
 */
public class AddQuery {
    
    private Connection conn;
    private ResultSet results;
    
    public AddQuery(){
        
        try {
            Properties props = new Properties(); //MWC
InputStream instr = getClass().getResourceAsStream("dbConn.properties");
            try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(AddQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(AddQuery.class.getName()).log(Level.SEVERE, null, ex);
        }

String driver = props.getProperty("driver.name");
String url = props.getProperty("server.name");
String username = props.getProperty("user.name");
String passwd = props.getProperty("user.password");
Class.forName(driver);
       conn = DriverManager.getConnection(url, username, passwd);
    } catch (ClassNotFoundException | SQLException ex) {
    Logger.getLogger(AddQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
}

   public void doRead(){
       
       String query = "Select * from FAMILY";
       
        try {
            
            
            PreparedStatement ps = conn.prepareStatement(query);
            this.results = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(AddQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public void doAdd (FAMILY family){
        
        try {
            String query = "INSERT INTO Family (NAME, RELATION, AGE, GENDER) VALUES (?, ?, ?, ?)";
            
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setString(1, family.getNAME());
            ps.setString(2, family.getRELATION());
            ps.setInt(3, family.getAGE());
            ps.setString(4, family.getGENDER());
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(AddQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}

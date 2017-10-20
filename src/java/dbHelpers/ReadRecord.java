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
public class ReadRecord {
    
    private Connection conn;
    private ResultSet results;
    
    private FAMILY family = new FAMILY();
    private int ID;
    
    
   public ReadRecord (int ID) {
    
    try {
            Properties props = new Properties(); //MWC
InputStream instr = getClass().getResourceAsStream("dbConn.properties");
            try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }

String driver = props.getProperty("driver.name");
String url = props.getProperty("server.name");
String username = props.getProperty("user.name");
String passwd = props.getProperty("user.password");

this.ID = ID;

Class.forName(driver);
       conn = DriverManager.getConnection(url, username, passwd);
    } catch (ClassNotFoundException | SQLException ex) {
    Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
}

  
    public void doRead() {
    
        try {
            //set up a string to hold our query
            String query = "SELECT * FROM family WHERE ID = ?";
            //create a preparedstatement using our query string
            PreparedStatement ps = conn.prepareStatement(query);
            //fill in the preparedstatement
            ps.setInt(1, ID);
            //execute the query
            this.results = ps.executeQuery();
            
            this.results.next();
            
            family.setID(this.results.getInt("ID"));
            family.setNAME(this.results.getString("NAME"));
            family.setRELATION(this.results.getString("RELATION"));
            family.setAGE(this.results.getInt("AGE"));
            family.setGENDER(this.results.getString("GENDER"));
            
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
 
    
    public FAMILY getFAMILY(){
        
        return this.family;
    }
}

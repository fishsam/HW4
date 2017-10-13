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
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sfishman
 */
public class DeleteQuery {
    
    private Connection conn;
    
    public DeleteQuery(){
      
      try {
            Properties props = new Properties(); //MWC
InputStream instr = getClass().getResourceAsStream("dbConn.properties");
            try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(DeleteQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(DeleteQuery.class.getName()).log(Level.SEVERE, null, ex);
        }

String driver = props.getProperty("driver.name");
String url = props.getProperty("server.name");
String username = props.getProperty("user.name");
String passwd = props.getProperty("user.password");
Class.forName(driver);
       conn = DriverManager.getConnection(url, username, passwd);
    } catch (ClassNotFoundException | SQLException ex) {
    Logger.getLogger(DeleteQuery.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
    }
    
    public void doDelete(int ID){
        
        try {
            //set up a string to hold our query
            String query = "DELETE FROM family WHERE ID = ?";
            
            //create a preparedstatement using our query string
            PreparedStatement ps = conn.prepareStatement(query);
            //fill in the preparedstatement
            ps.setInt(1, ID);
            //execute the query
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DeleteQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void doDelete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

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
import model.FAMILY;

public class UpdateQuery {
    
        private Connection conn;
        
        public UpdateQuery() {
    
          try {
            Properties props = new Properties(); //MWC
InputStream instr = getClass().getResourceAsStream("dbConn.properties");
            try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        }

String driver = props.getProperty("driver.name");
String url = props.getProperty("server.name");
String username = props.getProperty("user.name");
String passwd = props.getProperty("user.password");
Class.forName(driver);
       conn = DriverManager.getConnection(url, username, passwd);
    } catch (ClassNotFoundException | SQLException ex) {
    Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        }   
       
          
    }
        
        public void doUpdate (FAMILY family){
        
            try {
                String query = "UPDATE family SET NAME = ?, RELATION = ?, AGE = ?, GENDER = ? WHERE ID = ?";
        
                PreparedStatement ps = conn.prepareStatement(query);
                
                ps.setString(1, family.getNAME());
                ps.setString(2, family.getRELATION());
                ps.setInt(3, family.getAGE());
                ps.setString(4, family.getGENDER());
                ps.setInt(5, family.getID());
                
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
                
            }
        }


}
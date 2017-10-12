
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

public class ReadQuery {
  
    private Connection conn;
    private ResultSet results;
    
    public ReadQuery() {
    
Properties props = new Properties(); //MWC
InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }

String driver = props.getProperty("driver.name");
String url = props.getProperty("server.name");
String username = props.getProperty("user.name");
String passwd = props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
}

   public void doRead(){
       
        try {
            String query = "Select * from FAMILY";
            
            PreparedStatement ps = conn.prepareStatement(query);
            this.results = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
    
  public String getHTMLTable(){
   
      String table = "";
      table += "<table border=1>";
      
        try {
            while(this.results.next()){
                
                FAMILY family = new FAMILY();
                family.setID(this.results.getInt("ID"));
                family.setNAME(this.results.getString("NAME"));
                family.setRELATION(this.results.getString("RELATION"));
                family.setAGE(this.results.getInt("AGE"));
                family.setGENDER(this.results.getString("GENDER"));
                
                table += "<tr>";
                table += "<td>";
                table += family.getID();
                table += "</td>";
                
                table += "<td>";
                table += family.getNAME();
                table += "</td>";
                
                table += "<td>";
                table += family.getRELATION();
                table += "</td>";
                
                table += "<td>";
                table += family.getAGE();
                table += "</td>";
                
                table += "<td>";
                table += family.getGENDER();
                table += "</td>";
                
                
                
                table += "</tr>";
                 
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        
          
      
      
      
      table += "</table>";
              return table;
}

    
}
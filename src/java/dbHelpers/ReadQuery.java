
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
InputStream instr = getClass().getResourceAsStream("dbconn.properties");
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
            
            PreparedStatement ps= conn.prepareStatement(query);
            this.results = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
    
  public String getHTMLtable(){
   
      String table = "";
      table += "<table border=1>";
      
        try {
            while(this.results.next()){
                
                FAMILY family = new FAMILY();
                family.setID(this.results.getInt("id"));
                family.setNAME(this.results.getString("name"));
                family.setRELATION(this.results.getString("relation"));
                family.setAGE(this.results.getInt("age"));
                family.setGENDER(this.results.getString("gender"));
                
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
                 
            } } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        
          
      
      
      
      table += "</table>";
              return table;
}
}
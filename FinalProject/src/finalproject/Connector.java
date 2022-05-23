/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mac
 */
public class Connector {
    
    public static Connection getConnection() {
        Connection conn = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/fp_pbo?useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            System.out.println("Connection Success");
        }catch(Exception ex){
            System.out.println("Connection Failed" + ex.getMessage());
        }
        return conn;
    }
}

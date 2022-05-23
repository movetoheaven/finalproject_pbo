/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mfaja
 */
public class Model {
    public Connection connections;
    public Statement statement;
    
    static final String DBurl = "jdbc:mysql://localhost/fp_pbo";
    static final String DBusername = "root";
    static final String DBpassword = "";
    
    public void Connector() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connections = (Connection) DriverManager.getConnection(DBurl,DBusername,DBpassword);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            System.out.println("Koneksi gagal");
        }
    }
    
    public void table(Dashboard_Admin da){
        try{
            this.Connector();
            statement = connections.createStatement();
            String query = "SELECT * FROM `data_user`";
            ResultSet resultSet = statement.executeQuery(query);
            DefaultTableModel model = (DefaultTableModel) Dashboard_Admin.table.getModel();
            model.setRowCount(0);
            while (resultSet.next()){
                model.addRow(new String[]{resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8)});

            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e, "Message", JOptionPane.WARNING_MESSAGE);
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;
import com.mysql.jdbc.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Manuel
 */
public class Conexion {
    
    private String direccion="jdbc:mysql://tucomunidadcolombia.co:3306/tucomuni_comunidad";
    private String user="tucomuni_manuel";
    private String password="1090479041";
    private java.sql.Connection con;
    
    public Conexion(){}
    
    public void conectar(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        try {
            this.con=DriverManager.getConnection(direccion, user, password);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public void desconectar(){
        try {
            this.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public java.sql.Connection getConexion(){
        return con;
    }
    
}
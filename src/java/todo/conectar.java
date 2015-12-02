/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todo;

/**
 *
 * @author Manuel
 */
public class conectar {
    
    public conectar(){
    
    
    }
    
    public String establecer(){
        ConexionMysql.conectar();
        String co = ConexionMysql.hayConexion()+"     Conecto";
        System.out.println(co);
        
        //String sql = "INSERT INTO comunidad (nombre,apellido,correo,contrasenia) VALUES ('manuel','saravia','manuel@gmail.com','1234');";
        //ConexionMysql.ejecutarActualizacionSQL(sql);
        ConexionMysql.desconectar();
        return co;
    }
    
}

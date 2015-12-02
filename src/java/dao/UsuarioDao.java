/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import dto.Asesoria;
import dto.Usuario;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import util.ServicioEmail;
/**
 *
 * @author Manuel
 */
public class UsuarioDao {
    
    private Connection co;
    private ResultSet rs;
    private PreparedStatement ps;
    
    public UsuarioDao(Connection c){
        co = c;
    }

    public String registrarUsuario(Usuario user){
        try{
            this.ps = this.co.prepareStatement("INSERT INTO Usuario (correo,nombre,apellido,contrasenia,fechaNacimiento,ciudad,telefono,movil,visitas,tipo)"+
                    " VALUES (?,?,?,?,?,?,?,?,?,?);");
            this.ps.setString(1,user.getCorreo());
            this.ps.setString(2,user.getNombre());
            this.ps.setString(3,user.getApellido());
            this.ps.setString(4,user.getContrasenia());
            this.ps.setString(5,user.getFechaNacimiento());
            this.ps.setString(6,user.getCiudad());
            this.ps.setInt(7,user.getTelefono());
            this.ps.setString(8,user.getMovil());
            this.ps.setInt(9,0);
            this.ps.setString(10,"Regular");
            System.out.println(this.ps.toString());
            this.ps.execute();
            
        }catch(Exception e){
            return "error";
        }
        finally{
            try {
                this.ps.close();
                this.ps = null;
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return "Registro Exitoso";
    }

    public String validarSesion(Usuario user) {
        String mensaje = "";
        String visitas="";
        String id="";
        System.out.println("datos en dao:   "+user.getCorreo()+"    "+user.getContrasenia());
        try {
            this.ps = this.co.prepareStatement("SELECT idUsuario,nombre,apellido,visitas,tipo FROM Usuario WHERE correo=? AND contrasenia=?;");
            this.ps.setString(1, user.getCorreo());
            this.ps.setString(2, user.getContrasenia());
            System.out.println(this.ps.toString());
            this.rs=this.ps.executeQuery();
            if(rs!=null){
                if(rs.next()){
                    mensaje+=this.rs.getString("idUsuario");
                    id=this.rs.getString("idUsuario");
                    mensaje+=";";
                    mensaje+=this.rs.getString("nombre");
                    mensaje+=";";
                    mensaje+=this.rs.getString("apellido");
                    mensaje+=";";
                    mensaje+=this.rs.getString("visitas");
                    visitas = this.rs.getString("visitas");
                    mensaje+=";";
                    mensaje+=this.rs.getString("tipo");
                    System.out.println(id);
                    System.out.println(visitas);
                    
                }
            }
            
        } catch (SQLException ex) {
            mensaje = "error";
        } finally {
            try {
                this.ps.close();
                this.ps = null;
                this.rs = null;
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        String a = this.actualizarVisitas(id,visitas);
        if(a.equals("error")){
            mensaje="error";
        }
        return mensaje;
    }

    private String actualizarVisitas(String id, String visitas) {
        String mensaje ="";
        try {
            this.ps = this.co.prepareStatement("UPDATE Usuario SET visitas=? WHERE idUsuario=?;");
            this.ps.setInt(1, Integer.parseInt(visitas)+1);
            this.ps.setInt(2, Integer.parseInt(id));
            System.out.println(this.ps.toString());
            this.ps.execute();
                       
        } catch (SQLException ex) {
            mensaje = "error";
        } finally {
            try {
                this.ps.close();
                this.ps = null;
                this.rs = null;
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return "ok";
    }

    public String registrarAsesoria(Usuario user, Asesoria ase) {
        String mensaje="";
        String id="";
        String nombre="";
        String apellido="";
        String telefono="";
        String movil="";
        String ciudad="";
        System.out.println("datos en dao:   "+user.getCorreo()+"    "+user.getContrasenia());
        try {
            this.ps = this.co.prepareStatement("SELECT idUsuario,nombre,apellido,ciudad,telefono,movil FROM Usuario WHERE correo=?;");
            this.ps.setString(1, user.getCorreo());
            
            System.out.println(this.ps.toString());
            this.rs=this.ps.executeQuery();
            if(rs!=null){
                System.out.println("entro al if del null");
                if(rs.next()){
                    System.out.println("entro al if del next");
                    id=this.rs.getString("idUsuario");
                    nombre=this.rs.getString("nombre");
                    apellido=this.rs.getString("apellido");
                    ciudad=this.rs.getString("ciudad");
                    telefono = this.rs.getString("telefono");
                    movil=this.rs.getString("movil");
                    
                    user.setId(Integer.parseInt(id));
            user.setApellido(apellido);
            user.setNombre(nombre);
            user.setTelefono(Integer.parseInt(telefono));
            user.setMovil(movil);
            user.setCiudad(ciudad);
            mensaje= this.regAsesoria(user,ase);
                }
            }
            System.out.println("mensaje al llegar de asesoria "+mensaje);
            //
            
        } catch (SQLException ex) {
            mensaje = "error";
        } finally {
            try {
                this.ps.close();
                this.ps = null;
                this.rs = null;
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        System.out.println("mensaje antes de enviarse "+mensaje);
        return mensaje;
    }
    
    private String regAsesoria(Usuario user,Asesoria ase){
        String msg="";
        try{
            this.ps=this.co.prepareStatement("INSERT INTO Asesoria (solicitud,descripcion,evidencia,estado,idUsuario) VALUES (?,?,?,?,?);");
            this.ps.setString(1,ase.getSolicitud());
            this.ps.setString(2,ase.getDescripcion());
            this.ps.setString(3, "vacio");
            this.ps.setString(4,"pendiente");
            this.ps.setString(5, user.getId()+"");
            System.out.println(this.ps.toString());
            this.ps.execute();
            msg ="ok";
        }catch(SQLException e){
            msg = "error";
        }
        System.out.println("mensaje desde asesoria "+msg);
        return msg;
    }
    

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;
import dto.*;
import controller.AdministrarUsuario;
/**
 *
 * @author Manuel
 */
public class Facade {
    
    public Facade(){}
    
    public String registrarUsuario(Usuario user){
        AdministrarUsuario au = new AdministrarUsuario();
        return au.registrarUsuario(user);
    }
    
    public String validarSesion(Usuario user){
        AdministrarUsuario au = new AdministrarUsuario();
        return au.validarSesion(user);
    }
    
    public boolean validarSesionAdmin(Usuario user){
        AdministrarUsuario au = new AdministrarUsuario();
        return au.validarSesionAdmin(user);
    }
    
    public String registrarAsesoria(Usuario user, Asesoria ase){
        AdministrarUsuario au = new AdministrarUsuario();
        return au.registrarAsesoria(user,ase);
    }
    
    public String agregarArchivo(String comentario, String archivo, String tabla){
        AdministrarUsuario au = new AdministrarUsuario();
        return au.agregarArchivo(comentario,archivo,tabla);
    }
    
    public String contarUsuarios(){
        AdministrarUsuario au = new AdministrarUsuario();
        return au.contarUsuarios();
    }
    
    public String cargarTabla(String tabla,String carpeta){
        AdministrarUsuario au = new AdministrarUsuario();
        return au.cargarTabla(tabla,carpeta);
    }
    
    public String cargarSolicitudes(){
        AdministrarUsuario au = new AdministrarUsuario();
        return au.cargarSolicitudes();
    }
    public String cargarSolicitudes2(){
        AdministrarUsuario au = new AdministrarUsuario();
        return au.cargarSolicitudes2();
    }
    
    public String cambiarEstado(String id, String btn){
        AdministrarUsuario au = new AdministrarUsuario();
        return au.cambiarEstado(id,btn); 
    }
    
    public String cargarMensajes(){
        AdministrarUsuario au = new AdministrarUsuario();
        return au.cargarMensajes();
    }
    public String cargarMensajesUser(String id){
        AdministrarUsuario au = new AdministrarUsuario();
        return au.cargarMensajesUser(id);
    }
    
    public String cargarConversacion(String id){
        AdministrarUsuario au = new AdministrarUsuario();
        return au.cargarConversacion(id);
    }
    
    public void leerConversacion(String id, String msg){
        AdministrarUsuario au = new AdministrarUsuario();
        au.leerConversacion(id,msg);
        return;
    }
    public void leerConversacionUser(String id, String msg){
        AdministrarUsuario au = new AdministrarUsuario();
        au.leerConversacionUser(id,msg);
        return;
    }
}

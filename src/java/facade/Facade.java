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
    
    public String registrarAsesoria(Usuario user, Asesoria ase){
        AdministrarUsuario au = new AdministrarUsuario();
        return au.registrarAsesoria(user,ase);
    }
}

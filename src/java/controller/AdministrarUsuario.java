/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import dao.UsuarioDao;
import dto.Asesoria;
import dto.Usuario;
import util.Conexion;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import util.ServicioEmail;
/**
 *
 * @author Manuel
 */
public class AdministrarUsuario {
    private Conexion c;
    private Connection co;
    
    public AdministrarUsuario(){}
    
    /**
     * Metodo que establece la conexion con la base de datos
     */
    private void conectar() {
        this.c = new Conexion();
        this.c.conectar();
        this.co = this.c.getConexion();

    }

    /**
     * Metodo que finaliza la conexion con la base de datos
     */
    private void desconectar() {
        try {
            this.co.close();
            this.co = null;
            this.c.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(AdministrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String registrarUsuario(Usuario user) {
        String mensaje="";
        this.conectar();
        try {
            this.co.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(AdministrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        UsuarioDao ud = new UsuarioDao(this.co);
        mensaje = ud.registrarUsuario(user);
        if(mensaje.equals("error")){
            try {
                    co.rollback();
                    mensaje = "Ha ocurrido un error a la hora de registrar el usuario, Verifique los datos registrados";
                } catch (SQLException ex) {
                    Logger.getLogger(AdministrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
        }else {
            try {
                System.out.println(user.getCorreo());
                ServicioEmail e = new ServicioEmail("asistencia.tucomunidadcolombia@gmail.com","tucomunidadcolombia");
                e.enviarEmail(user.getCorreo(), "Bienvenido", "Bienvenido a Tu Comunidad, el lugar donde podras encontrar todas las asesorias juridicas que necesites. \n\nRecuerda siempre acceder a traves de: http://tucomunidadcolombia.co");
                
                    co.commit();
                } catch (SQLException ex) {
                    Logger.getLogger(AdministrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        this.desconectar();

        return mensaje;
    }

    public String validarSesion(Usuario user) {
        String mensaje="";
        this.conectar();
        try {                                   
            this.co.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(AdministrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        UsuarioDao ud = new UsuarioDao(this.co);
        mensaje = ud.validarSesion(user);
        System.out.println("mensaeje en controller   "+mensaje);
        if(mensaje.equals("error")){
            try {
                    co.rollback();
                    //mensaje = "Ha ocurrido un error a la hora de iniciar sesion, Verifique los datos registrados";
                } catch (SQLException ex) {
                    Logger.getLogger(AdministrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
        }else {
            try {
                
                co.commit();
                } catch (SQLException ex) {
                    Logger.getLogger(AdministrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        this.desconectar();

        return mensaje;
    }

    public String registrarAsesoria(Usuario user, Asesoria ase) {
        String mensaje="";
        this.conectar();
        try {
            this.co.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(AdministrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        UsuarioDao ud = new UsuarioDao(this.co);
        mensaje = ud.registrarAsesoria(user,ase);
        System.out.println("mensaeje en controller   "+mensaje);
        if(mensaje.equals("error")){
            try {
                    co.rollback();
                    //mensaje = "Ha ocurrido un error a la hora de iniciar sesion, Verifique los datos registrados";
                } catch (SQLException ex) {
                    Logger.getLogger(AdministrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
        }else {
            System.out.println("else");
            try {
                ServicioEmail se = new ServicioEmail("asistencia.tucomunidadcolombia@gmail.com","tucomunidadcolombia");
                se.enviarEmail("manuel.saravia.bulla@gmail.com", "Tu Comunidad - Nueva Asistencia", "El usuario \""+user.getNombre()+" "+user.getApellido()+"\" de la ciudad de \""+user.getCiudad()+
                        "\" tiene una solicitud sobre \""+ase.getSolicitud()+"\" diciendo que \""+ase.getDescripcion()+"\"\n\n"+"Datos de Contacto: \n\t - "+user.getCorreo()+
                        "\n\t - "+user.getTelefono()+"\n\t - "+user.getMovil()+"\n\n\nUsted esta recibiendo este correo debido a que es el Administrador de Tu Comunidad Colombia");
                co.commit();
                } catch (SQLException ex) {
                    Logger.getLogger(AdministrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        this.desconectar();

        return mensaje;
        
        //ServicioEmail e = new ServicioEmail(user.getCorreo(),"jasonsaraviab");
        //e.enviarEmail("manuel.saravia.bulla@gmail.com",ase.getSolicitud(),ase.getDescripcion());
        //return "ok";
    }
    
    
}

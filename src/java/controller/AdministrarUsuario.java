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
                ServicioEmail e = new ServicioEmail("tucomunidad@tucomunidadcolombia.co","Direccion2015");
                e.enviarEmail(user.getCorreo(), "Bienvenido", "Bienvenido a Tu Comunidad, el lugar donde podras encontrar todas las asesorias juridicas que necesites. \n\nRecuerda siempre acceder a traves de: http://tucomunidadcolombia.co");
                e.enviarEmail("asistencia@tucomunidadcolombia.co", "Nuevo Registro", "El usuario "+user.getNombre()+" "+user.getApellido()+" se ha registrado en el sistema");
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
                //ServicioEmail e = new ServicioEmail("desarrollo@tucomunidadcolombia.co","jasonsaravia726");
                //e.enviarEmail(user.getCorreo(), "Bienvenido", "Bienvenido a Tu Comunidad, el lugar donde podras encontrar todas las asesorias juridicas que necesites. \n\nRecuerda siempre acceder a traves de: http://tucomunidadcolombia.co");
                co.commit();
                } catch (SQLException ex) {
                    Logger.getLogger(AdministrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        this.desconectar();

        return mensaje;
    }
    
    public boolean validarSesionAdmin(Usuario user) {
        String mensaje="";
        this.conectar();
        try {                                   
            this.co.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(AdministrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        UsuarioDao ud = new UsuarioDao(this.co);
        mensaje = ud.validarSesionAdmin(user);
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
                //ServicioEmail e = new ServicioEmail("desarrollo@tucomunidadcolombia.co","jasonsaravia726");
                //e.enviarEmail(user.getCorreo(), "Bienvenido", "Bienvenido a Tu Comunidad, el lugar donde podras encontrar todas las asesorias juridicas que necesites. \n\nRecuerda siempre acceder a traves de: http://tucomunidadcolombia.co");
                co.commit();
                } catch (SQLException ex) {
                    Logger.getLogger(AdministrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        this.desconectar();

        if(mensaje.equals("error")){
            return false;
        }
        return true;
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
                ServicioEmail se = new ServicioEmail("tucomunidad@tucomunidadcolombia.co","Direccion2015");
                se.enviarEmail("serviciosjuridicos@tucomunidadcolombia.co", "Tu Comunidad - Nueva Asistencia", "El usuario \""+user.getNombre()+" "+user.getApellido()+"\" de la ciudad de \""+user.getCiudad()+
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

    public String agregarArchivo(String comentario, String archivo, String tabla) {
        String mensaje="";
        this.conectar();
        try {
            this.co.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(AdministrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        UsuarioDao ud = new UsuarioDao(this.co);
        mensaje = ud.agregarArchivo(comentario, archivo, tabla);
        System.out.println("mensaeje en controller   "+mensaje);
        if(mensaje.equals("error")){
            try {
                    co.rollback();
                    //mensaje = "Ha ocurrido un error a la hora de iniciar sesion, Verifique los datos registrados";
                } catch (SQLException ex) {
                    Logger.getLogger(AdministrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
        }else {
            //System.out.println("else");
            try {
                co.commit();
                } catch (SQLException ex) {
                    Logger.getLogger(AdministrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        this.desconectar();

        return mensaje;
        
    }

    public String contarUsuarios() {
        int mensaje=0;
        this.conectar();
        try {                                   
            this.co.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(AdministrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        UsuarioDao ud = new UsuarioDao(this.co);
        mensaje = ud.contarUsuarios();
        System.out.println("mensaeje en controller   "+mensaje);
        if(mensaje<0){
            try {
                    co.rollback();
                    //mensaje = "Ha ocurrido un error a la hora de iniciar sesion, Verifique los datos registrados";
                } catch (SQLException ex) {
                    Logger.getLogger(AdministrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
        }else {
            try {
                //ServicioEmail e = new ServicioEmail("desarrollo@tucomunidadcolombia.co","jasonsaravia726");
                //e.enviarEmail(user.getCorreo(), "Bienvenido", "Bienvenido a Tu Comunidad, el lugar donde podras encontrar todas las asesorias juridicas que necesites. \n\nRecuerda siempre acceder a traves de: http://tucomunidadcolombia.co");
                co.commit();
                } catch (SQLException ex) {
                    Logger.getLogger(AdministrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        this.desconectar();
        String res = mensaje+"";

        return res;
    }

    public String cargarTabla(String tabla,String carpeta) {
        String mensaje="";
        this.conectar();
        try {                                   
            this.co.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(AdministrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        UsuarioDao ud = new UsuarioDao(this.co);
        mensaje = ud.cargarTabla(tabla,carpeta);
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
                //ServicioEmail e = new ServicioEmail("desarrollo@tucomunidadcolombia.co","jasonsaravia726");
                //e.enviarEmail(user.getCorreo(), "Bienvenido", "Bienvenido a Tu Comunidad, el lugar donde podras encontrar todas las asesorias juridicas que necesites. \n\nRecuerda siempre acceder a traves de: http://tucomunidadcolombia.co");
                co.commit();
                } catch (SQLException ex) {
                    Logger.getLogger(AdministrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        this.desconectar();
        String res = mensaje;

        return res;
    }

    public String cargarSolicitudes() {
        String mensaje="";
        this.conectar();
        try {                                   
            this.co.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(AdministrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        UsuarioDao ud = new UsuarioDao(this.co);
        mensaje = ud.cargarSolicitudes();
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
                //ServicioEmail e = new ServicioEmail("desarrollo@tucomunidadcolombia.co","jasonsaravia726");
                //e.enviarEmail(user.getCorreo(), "Bienvenido", "Bienvenido a Tu Comunidad, el lugar donde podras encontrar todas las asesorias juridicas que necesites. \n\nRecuerda siempre acceder a traves de: http://tucomunidadcolombia.co");
                co.commit();
                } catch (SQLException ex) {
                    Logger.getLogger(AdministrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        this.desconectar();
        String res = mensaje;

        return res;
    }
    public String cargarSolicitudes2() {
        String mensaje="";
        this.conectar();
        try {                                   
            this.co.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(AdministrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        UsuarioDao ud = new UsuarioDao(this.co);
        mensaje = ud.cargarSolicitudes2();
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
                //ServicioEmail e = new ServicioEmail("desarrollo@tucomunidadcolombia.co","jasonsaravia726");
                //e.enviarEmail(user.getCorreo(), "Bienvenido", "Bienvenido a Tu Comunidad, el lugar donde podras encontrar todas las asesorias juridicas que necesites. \n\nRecuerda siempre acceder a traves de: http://tucomunidadcolombia.co");
                co.commit();
                } catch (SQLException ex) {
                    Logger.getLogger(AdministrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        this.desconectar();
        String res = mensaje;

        return res;
    }

    public String cambiarEstado(String id, String btn) {
        String mensaje="";
        this.conectar();
        try {                                   
            this.co.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(AdministrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        UsuarioDao ud = new UsuarioDao(this.co);
        mensaje = ud.cambiarEstado(id,btn);
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
                //ServicioEmail e = new ServicioEmail("desarrollo@tucomunidadcolombia.co","jasonsaravia726");
                //e.enviarEmail(user.getCorreo(), "Bienvenido", "Bienvenido a Tu Comunidad, el lugar donde podras encontrar todas las asesorias juridicas que necesites. \n\nRecuerda siempre acceder a traves de: http://tucomunidadcolombia.co");
                co.commit();
                } catch (SQLException ex) {
                    Logger.getLogger(AdministrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        this.desconectar();
        String res = mensaje;

        return res;
    }

    public String cargarMensajes() {
        String users = this.cargarUsuarios();
        String mensajes = this.cargarMensajesAdmin();
        return users+";"+mensajes;
    }
    
    private String cargarUsuarios(){
        String mensaje="";
        this.conectar();
        try {                                   
            this.co.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(AdministrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        UsuarioDao ud = new UsuarioDao(this.co);
        mensaje = ud.cargarUsuarios();
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
                //ServicioEmail e = new ServicioEmail("desarrollo@tucomunidadcolombia.co","jasonsaravia726");
                //e.enviarEmail(user.getCorreo(), "Bienvenido", "Bienvenido a Tu Comunidad, el lugar donde podras encontrar todas las asesorias juridicas que necesites. \n\nRecuerda siempre acceder a traves de: http://tucomunidadcolombia.co");
                co.commit();
                } catch (SQLException ex) {
                    Logger.getLogger(AdministrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        this.desconectar();
        String res = mensaje;

        return res;
    }
    
    private String cargarMensajesAdmin(){
        String mensaje="";
        this.conectar();
        try {                                   
            this.co.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(AdministrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        UsuarioDao ud = new UsuarioDao(this.co);
        mensaje = ud.cargarMensajesAdmin();
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
                //ServicioEmail e = new ServicioEmail("desarrollo@tucomunidadcolombia.co","jasonsaravia726");
                //e.enviarEmail(user.getCorreo(), "Bienvenido", "Bienvenido a Tu Comunidad, el lugar donde podras encontrar todas las asesorias juridicas que necesites. \n\nRecuerda siempre acceder a traves de: http://tucomunidadcolombia.co");
                co.commit();
                } catch (SQLException ex) {
                    Logger.getLogger(AdministrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        this.desconectar();
        String res = mensaje;

        return res;
    }

    public String cargarConversacion(String id) {
        String mensaje="";
        this.conectar();
        try {                                   
            this.co.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(AdministrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        UsuarioDao ud = new UsuarioDao(this.co);
        mensaje = ud.cargarConversacion(id);
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
                //ServicioEmail e = new ServicioEmail("desarrollo@tucomunidadcolombia.co","jasonsaravia726");
                //e.enviarEmail(user.getCorreo(), "Bienvenido", "Bienvenido a Tu Comunidad, el lugar donde podras encontrar todas las asesorias juridicas que necesites. \n\nRecuerda siempre acceder a traves de: http://tucomunidadcolombia.co");
                co.commit();
                } catch (SQLException ex) {
                    Logger.getLogger(AdministrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        this.desconectar();
        String res = mensaje;

        return res;
    }
    
    public void leerConversacion(String id, String msg) {
        String mensaje="";
        this.conectar();
        try {                                   
            this.co.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(AdministrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        UsuarioDao ud = new UsuarioDao(this.co);
        mensaje = ud.leerConversacion(id,msg);
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
                //ServicioEmail e = new ServicioEmail("desarrollo@tucomunidadcolombia.co","jasonsaravia726");
                //e.enviarEmail(user.getCorreo(), "Bienvenido", "Bienvenido a Tu Comunidad, el lugar donde podras encontrar todas las asesorias juridicas que necesites. \n\nRecuerda siempre acceder a traves de: http://tucomunidadcolombia.co");
                co.commit();
                } catch (SQLException ex) {
                    Logger.getLogger(AdministrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        this.desconectar();
        String res = mensaje;

        return;
    }
    public void leerConversacionUser(String id, String msg) {
        String mensaje="";
        this.conectar();
        try {                                   
            this.co.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(AdministrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        UsuarioDao ud = new UsuarioDao(this.co);
        mensaje = ud.leerConversacionUser(id,msg);
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
                //ServicioEmail e = new ServicioEmail("desarrollo@tucomunidadcolombia.co","jasonsaravia726");
                //e.enviarEmail(user.getCorreo(), "Bienvenido", "Bienvenido a Tu Comunidad, el lugar donde podras encontrar todas las asesorias juridicas que necesites. \n\nRecuerda siempre acceder a traves de: http://tucomunidadcolombia.co");
                co.commit();
                } catch (SQLException ex) {
                    Logger.getLogger(AdministrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        this.desconectar();
        String res = mensaje;

        return;
    }

    public String cargarMensajesUser(String id) {
        String mensaje="";
        this.conectar();
        try {                                   
            this.co.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(AdministrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        UsuarioDao ud = new UsuarioDao(this.co);
        mensaje = ud.cargarMensajesUser(id);
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
                //ServicioEmail e = new ServicioEmail("desarrollo@tucomunidadcolombia.co","jasonsaravia726");
                //e.enviarEmail(user.getCorreo(), "Bienvenido", "Bienvenido a Tu Comunidad, el lugar donde podras encontrar todas las asesorias juridicas que necesites. \n\nRecuerda siempre acceder a traves de: http://tucomunidadcolombia.co");
                co.commit();
                } catch (SQLException ex) {
                    Logger.getLogger(AdministrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        this.desconectar();
        String res = mensaje;

        return res;
    }
    
}

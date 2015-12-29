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
            if(mensaje.isEmpty()){
                return "error";
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
        int b = this.contarProcesos(id);
        String a = this.actualizarVisitas(id,visitas);
        System.out.println(a+" "+b);
        mensaje += ";"+b;
        if(a.equals("error") || b<0){
            mensaje="error";
        }
        return mensaje;
    }
    private int contarProcesos(String id) {
        //SELECT COUNT(*) FROM colores WHERE numero = 4 
        System.out.println("llego a contar");
        int ret = 0;
        try {
            this.ps = this.co.prepareStatement("SELECT COUNT(idUsuario) as veces FROM Asesoria WHERE idUsuario = ?;");
            this.ps.setString(1, id);
            
            System.out.println(this.ps.toString());
            this.rs=this.ps.executeQuery();
            if(rs!=null){
                System.out.println("entro al if del null");
                if(rs.next()){
                    ret = this.rs.getInt("veces");
                    System.out.println("entro al if del next");
                }
            }
            //System.out.println("mensaje al llegar de asesoria "+mensaje);
            //
            
        } catch (SQLException ex) {
            ret = -1;
        } finally {
            try {
                this.ps.close();
                this.ps = null;
                this.rs = null;
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        //System.out.println("mensaje antes de enviarse "+mensaje);
        return ret;
    }

    private String actualizarVisitas(String id, String visitas) {
        String mensaje ="ok";
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
        return mensaje;
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

    public String agregarArchivo(String comentario, String archivo, String tabla) {
        String msg="";
        if(comentario.isEmpty() || archivo.isEmpty()){
            return "error";
        }
        try{
            
            this.ps=this.co.prepareStatement("INSERT INTO "+tabla+" (comentario,archivo) VALUES (?,?);");
            this.ps.setString(1,comentario);
            this.ps.setString(2,archivo);
            
            System.out.println(this.ps.toString());
            this.ps.execute();
            msg ="Archivo agregado Exitosamente";
        }catch(SQLException e){
            msg = "error";
        }
        
        return msg;
    }

    public int contarUsuarios() {
        int ret = 0;
        try {
            this.ps = this.co.prepareStatement("SELECT COUNT(idUsuario) as veces FROM Usuario;");
            
            
            System.out.println(this.ps.toString());
            this.rs=this.ps.executeQuery();
            if(rs!=null){
                System.out.println("entro al if del null");
                if(rs.next()){
                    ret = this.rs.getInt("veces");
                    System.out.println("entro al if del next");
                }
            }
            //System.out.println("mensaje al llegar de asesoria "+mensaje);
            //
            
        } catch (SQLException ex) {
            ret = -1;
        } finally {
            try {
                this.ps.close();
                this.ps = null;
                this.rs = null;
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        //System.out.println("mensaje antes de enviarse "+mensaje);
        return ret;
    }

    public String validarSesionAdmin(Usuario user) {
        String mensaje = "";
        
        System.out.println("datos en dao:   "+user.getCorreo()+"    "+user.getContrasenia());
        try {
            this.ps = this.co.prepareStatement("SELECT idAdministrador FROM Administrador WHERE correo=? AND contrasenia=?;");
            this.ps.setString(1, user.getCorreo());
            this.ps.setString(2, user.getContrasenia());
            System.out.println(this.ps.toString());
            this.rs=this.ps.executeQuery();
            if(rs!=null){
                System.out.println("no es nulooo");
                if(rs.next()){
                    System.out.println("hay un next!!");
                    mensaje=this.rs.getString("idAdministrador");
                    System.out.println("men: "+mensaje);
                }
            }
            if(mensaje.isEmpty()){
                return "error";
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
        
        return mensaje;
    }

    public String cargarTabla(String tabla,String carpeta) {
        String orden = "";
        orden = "id"+tabla;
        if(tabla.equals("Inter_Publicos")){
            orden = "idPublicos";
        }
        if(tabla.equals("Inter_Privados")){
            orden = "idPrivados";
        }
        if(tabla.equals("NotiImagen")){
            orden = "idNoti";
        }
        
        String ini = "<div class=\"panel panel-info\">\n" +
"                                    <div class=\"panel-heading\">\n" +
"                                        <h3 class=\"panel-title\">Noticia</h3>\n" +
"                                    </div>\n" +
"                                    <div class=\"panel-body text-justify\">\n";                                    
        String end ="</div></div>";
        String mensaje ="";
        //System.out.println("datos en dao:   "+user.getCorreo()+"    "+user.getContrasenia());
        try {
            this.ps = this.co.prepareStatement("SELECT comentario,archivo FROM "+tabla+" ORDER BY "+orden+" DESC;");
            
            System.out.println(this.ps.toString());
            this.rs=this.ps.executeQuery();
            if(rs!=null){
                
                while(rs.next()){
                    String comentario=this.rs.getString("comentario");
                    String archivo=this.rs.getString("archivo");
                    String condicion ="";
                    if(carpeta.equals("noticias")){
                        condicion = "<a href=\"../archivos/"+carpeta+"/"+archivo+"\" target=\"_blank\"><img class=\"img-responsive\" src=\"../archivos/"+carpeta+"/"+archivo+"\" width=100%></a>";
                    }
                    else{
                        condicion = "<a href=\"../../archivos/"+carpeta+"/"+archivo+"\" target=\"_blank\"><img class=\"img-responsive\" src=\"../../archivos/"+carpeta+"/"+archivo+"\" width=100%></a>";
                    }
                    mensaje+= ini+"<p>"+comentario+"</p>"+condicion+end;
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
        
        return mensaje;
    }

    public String cargarSolicitudes() {
        String mensaje="<div class=\"table-responsive\"><table class=\"table table-hover\">\n" +
"                                            <th>Usuario</th>\n" +
"                                            <th>Solicitud</th>\n" +
"                                            <th>Descripcion</th>\n" +
"                                            <th>Cambiar estado</th>\n";                                                                                    
        
        
        try {
            this.ps = this.co.prepareStatement("SELECT a.idAsesoria,u.nombre,a.solicitud,a.descripcion FROM Usuario u,Asesoria a WHERE u.idUsuario=a.idUsuario AND a.estado='pendiente';");
            
            
            System.out.println(this.ps.toString());
            this.rs=this.ps.executeQuery();
            if(rs!=null){
                
                while(rs.next()){
                    
                    String id="<form action=\"cambiarEstado.jsp\" method=\"post\"><tr><input type=\"hidden\" name=\"idAsesoria\" value=\""+this.rs.getString("idAsesoria")+"\">";
                    String nombre="<td>"+this.rs.getString("nombre")+"</td>";
                    String solicitud="<td>"+this.rs.getString("solicitud")+"</td>";
                    String descripcion="<td>"+this.rs.getString("descripcion")+"</td>";
                    String boton = "<td><button class=\"btn btn-info\" name=\"boton\" value=\"resuelto\" type=\"submit\"><span class=\"glyphicon glyphicon-ok\"></span></button>"
                            + "<button class=\"btn btn-warning\" name=\"boton\" value=\"eliminado\" type=\"submit\"><span class=\"glyphicon glyphicon-remove\"></span></button></td></tr></form>";
                    mensaje+=id+nombre+solicitud+descripcion+boton;
                }
            }
            mensaje+="</table></div>";
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
        
        return mensaje;
    }
    public String cargarSolicitudes2() {
        String mensaje="<div class=\"table-responsive\"><table class=\"table table-hover\">\n" +
"                                            <th>Usuario</th>\n" +
"                                            <th>Solicitud</th>\n" +
"                                            <th>Descripcion</th>\n";                                                                                    
        
        
        try {
            this.ps = this.co.prepareStatement("SELECT a.idAsesoria,u.nombre,u.apellido,a.solicitud,a.descripcion FROM Usuario u,Asesoria a WHERE u.idUsuario=a.idUsuario AND a.estado='resuelto';");
            
            
            System.out.println(this.ps.toString());
            this.rs=this.ps.executeQuery();
            if(rs!=null){
                
                while(rs.next()){
                    
                    String id="<form action=\"cambiarEstado.jsp\" method=\"post\"><tr><input type=\"hidden\" name=\"idAsesoria\" value=\""+this.rs.getString("idAsesoria")+"\">";
                    String nombre="<td>"+this.rs.getString("nombre")+" "+this.rs.getString("apellido")+"</td>";
                    String solicitud="<td>"+this.rs.getString("solicitud")+"</td>";
                    String descripcion="<td>"+this.rs.getString("descripcion")+"</td>";
                    String boton = "</tr></form>";
                    mensaje+=id+nombre+solicitud+descripcion+boton;
                }
            }
            mensaje+="</table></div>";
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
        
        return mensaje;
    }

    public String cambiarEstado(String id,String btn) {
        String mensaje ="";
        try {
            this.ps = this.co.prepareStatement("UPDATE Asesoria SET estado=? WHERE idAsesoria=?;");
            this.ps.setString(1, btn);
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

    public String cargarUsuarios() {
        String mensaje = "<option value=\"nulo\">-</option>";
        
        //System.out.println("datos en dao:   "+user.getCorreo()+"    "+user.getContrasenia());
        try {
            this.ps = this.co.prepareStatement("SELECT idUsuario,nombre,apellido FROM Usuario;");
            
            System.out.println(this.ps.toString());
            this.rs=this.ps.executeQuery();
            if(rs!=null){
                //System.out.println("no es nulooo");
                while(rs.next()){
                    //System.out.println("hay un next!!");
                    mensaje+="<option value=\""+this.rs.getString("idUsuario")+"\">"+this.rs.getString("nombre")+" "+this.rs.getString("apellido")+"</option>";
                    //System.out.println("men: "+mensaje);
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
        
        return mensaje;
    }

    public String cargarMensajesAdmin() {
        String mensaje="<div class=\"table-responsive\"><table class=\"table table-hover\">\n" +
"                                            <th>Usuario</th>"
                + "\n"+                      "<th>Accion</th>";                                                                                    
        
        ArrayList<Integer> ides = new ArrayList();
        try {
            this.ps = this.co.prepareStatement("SELECT u.idUsuario,u.nombre,u.apellido FROM Usuario u,Mensajes m WHERE u.idUsuario=m.idUsuario ORDER BY m.idMensaje DESC;");
            
            
            System.out.println(this.ps.toString());
            this.rs=this.ps.executeQuery();
            if(rs!=null){
                
                while(rs.next()){
                    String auxid=this.rs.getString("idUsuario");
                    boolean b = this.esta(ides,auxid);
                    if(!b){
                        String id="<form action=\"cargarConversacion.jsp\" method=\"post\"><tr><input type=\"hidden\" name=\"idUsuario\" value=\""+this.rs.getString("idUsuario")+"\">";
                        String nombre="<td>"+this.rs.getString("nombre")+" "+this.rs.getString("apellido")+"</td>";
                    
                        String boton = "<td><button class=\"btn btn-info\" type=\"submit\">Responder</button></td></tr></form>";
                        mensaje+=id+nombre+boton;
                    }
                }
            }
            mensaje+="</table></div>";
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
        
        return mensaje;
    }

    public String cargarConversacion(String id) {
        String mensaje="<div class=\"table-responsive\"><table class=\"table table-hover\">\n";                                                                                    
        boolean n = false;
        
        try {
            this.ps = this.co.prepareStatement("SELECT u.nombre,u.apellido,m.mensajeUsuario,m.mensajeAdministrador FROM Usuario u, Mensajes m WHERE '"+id+"'=m.idUsuario AND '"+id+"'=u.idUsuario ORDER BY m.idMensaje ASC;");
            
            
            System.out.println(this.ps.toString());
            this.rs=this.ps.executeQuery();
            if(rs!=null){
                
                while(rs.next()){
                    n = true;
                    String nombre="<th class=\"text-left warning\">"+this.rs.getString("nombre")+" "+this.rs.getString("apellido")+"</th><th  class=\"warning\"></th>";
                    String admin="<th class=\"active\"></th><th class=\"text-right active\">Administrador</th>";
                    String msgu = this.rs.getString("mensajeUsuario");
                    String msga = this.rs.getString("mensajeAdministrador");
                    if(msgu.equals("nulo")){
                        mensaje+=admin+"<tr><td></td><td class=\"text-right\">"+msga+"</td></tr>";
                    }
                    else if(msga.equals("nulo")){
                        mensaje+=nombre+"<tr><td class=\"text-left\">"+msgu+"</td><td></td></tr>";
                    }
                }
            }
            
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
        String name="";
        name = this.buscarNombre(id);
        
        mensaje+="</table></div>";
        mensaje+=";"+name;
        return mensaje;
    }

    private boolean esta(ArrayList<Integer> ides, String auxid) {
        int id = Integer.parseInt(auxid);
        for(int i:ides){
            if(i==id){
                return true;
            }
        }
        ides.add(id);
        return false;
    }

    private String buscarNombre(String id) {
        String mensaje = "";
        
        
        try {
            this.ps = this.co.prepareStatement("SELECT nombre,apellido FROM Usuario WHERE idUsuario=?;");
            this.ps.setString(1, id);
            
            System.out.println(this.ps.toString());
            this.rs=this.ps.executeQuery();
            if(rs!=null){
                if(rs.next()){
                    
                    mensaje+=this.rs.getString("nombre");
                    mensaje+=" ";
                    mensaje+=this.rs.getString("apellido");
                    
                    
                }
            }
            if(mensaje.isEmpty()){
                return "error";
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
        
        return mensaje;
    }

    public String leerConversacion(String id, String msg) {
        try{
            this.ps = this.co.prepareStatement("INSERT INTO Mensajes (idUsuario,mensajeUsuario,mensajeAdministrador,dia)"+
                    " VALUES (?,?,?,?);");
            this.ps.setInt(1, Integer.parseInt(id));
            this.ps.setString(2,"nulo");
            this.ps.setString(3,msg);
            this.ps.setInt(4,0);
            
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
        
        return "ok";
    }
    public String leerConversacionUser(String id, String msg) {
        try{
            this.ps = this.co.prepareStatement("INSERT INTO Mensajes (idUsuario,mensajeUsuario,mensajeAdministrador,dia)"+
                    " VALUES (?,?,?,?);");
            this.ps.setInt(1, Integer.parseInt(id));
            this.ps.setString(2,msg);
            this.ps.setString(3,"nulo");
            this.ps.setInt(4,0);
            
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
        
        return "ok";
    }

    public String cargarMensajesUser(String id) {
        String mensaje="<div class=\"table-responsive\"><table class=\"table table-hover\">\n";                                                                                    
        boolean n = false;
        
        try {
            this.ps = this.co.prepareStatement("SELECT u.nombre,u.apellido,m.mensajeUsuario,m.mensajeAdministrador FROM Usuario u, Mensajes m WHERE '"+id+"'=m.idUsuario AND '"+id+"'=u.idUsuario ORDER BY m.idMensaje ASC;");
            
            
            System.out.println(this.ps.toString());
            this.rs=this.ps.executeQuery();
            if(rs!=null){
                
                while(rs.next()){
                    n = true;
                    String nombre="<th class=\"text-left warning\">"+this.rs.getString("nombre")+" "+this.rs.getString("apellido")+"</th><th  class=\"warning\"></th>";
                    String admin="<th class=\"active\"></th><th class=\"text-right active\">Administrador</th>";
                    String msgu = this.rs.getString("mensajeUsuario");
                    String msga = this.rs.getString("mensajeAdministrador");
                    if(msgu.equals("nulo")){
                        mensaje+=admin+"<tr><td></td><td class=\"text-right\">"+msga+"</td></tr>";
                    }
                    else if(msga.equals("nulo")){
                        mensaje+=nombre+"<tr><td class=\"text-left\">"+msgu+"</td><td></td></tr>";
                    }
                }
            }
            
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
        
        mensaje+="</table></div>";
        mensaje+=";Administrador";
        return mensaje;
    }

    
    

}

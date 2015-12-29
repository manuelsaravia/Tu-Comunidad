<%-- 
    Document   : cargarImagenConstitucional
    Created on : 12/12/2015, 06:52:17 PM
    Author     : Manuel
--%>

<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletRequestContext"%>

<%@page import="com.sun.org.apache.xpath.internal.NodeSet"%>
<%@page import="org.w3c.dom.NodeList"%>
<!DOCTYPE html>
<%@ page import="java.io.*" %> 
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"
        import="java.util.*"
        import="org.apache.commons.fileupload.*"
        import="org.apache.commons.fileupload.servlet.*"
        import="org.apache.commons.fileupload.disk.*"

        import="java.io.*"
        %>

<%     
    String salida="Imagen cargada: ";
    String ruta = getServletContext().getRealPath("/archivos/constitucionales/").replace("./", "/");
                        String dir = ruta + "\\";
                        System.out.println(ruta);
                        try {
                            File destino = new File(ruta);
                            ServletRequestContext src = new ServletRequestContext(request);
                            String name = "";
                            System.out.println("src :  "+src.toString());
                            if (ServletFileUpload.isMultipartContent(src)) {
                                System.out.println("dentro del primer if");
                                DiskFileItemFactory factory = new DiskFileItemFactory((1024 * 1024), destino);
                                ServletFileUpload upload = new ServletFileUpload(factory);

                                java.util.List lista = upload.parseRequest(src);
                                File file = null;
                                java.util.Iterator it = lista.iterator();

                                while (it.hasNext()) {
                                    FileItem item = (FileItem) it.next();
                                    if (item.isFormField()) {
                                        out.println(item.getFieldName() + "<br>");
                                    } else {
                                        file = new File(item.getName());
                                        name = item.getName();
                                        item.write(new File(destino, file.getName()));

                                    } // end if
                                } // end while
                            } // end if
                            System.out.println("name== \""+ name+"\"");
                            if (!name.equals("")) {

                                dir += name;
                                session.setAttribute("nombreArchivo", name);
                                //session.setAttribute("rutaImagen", dir);
                                

                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        String msg = "<a class=\"green\">"+salida+"</a>"+"<a class=\"blue\">"+session.getAttribute("nombreArchivo")+"</a>";
                        session.setAttribute("mensajeImagen", msg);
                        response.sendRedirect("constitucionales.jsp");
%>

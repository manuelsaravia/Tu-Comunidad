<%-- 
    Document   : cargarAdministrador
    Created on : 26/12/2015, 04:29:22 PM
    Author     : Manuel
--%>

<jsp:useBean id="facade" class="facade.Facade" scope="session"></jsp:useBean>
<%
    String x = request.getParameter("req");
    String tabla = x.split("-")[0];
    String ruta = x.split("-")[1];
    String carpeta = x.split("-")[2];
    String res = facade.cargarTabla(tabla,carpeta);
    if(res.equals("error")){
        res="";
    }
    session.setAttribute("tabla", res);
    response.sendRedirect(ruta+".jsp");
    
    %>

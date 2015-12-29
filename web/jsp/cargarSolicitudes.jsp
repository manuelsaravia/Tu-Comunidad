<%-- 
    Document   : cargarSolicitudes
    Created on : 28/12/2015, 08:09:08 PM
    Author     : Manuel
--%>

<jsp:useBean id="facade" class="facade.Facade" scope="session"></jsp:useBean>
<%
    String res = facade.cargarSolicitudes();
    String res2 = facade.cargarSolicitudes2();
    if(res.equals("error")){
        res="";
    }
    if(res2.equals("error")){
        res2="";
    }
    session.setAttribute("solicitudesPendientes", res);
    session.setAttribute("solicitudesResueltas", res2);
    response.sendRedirect("solicitudes.jsp");
    %>
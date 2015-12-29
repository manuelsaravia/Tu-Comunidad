<%-- 
    Document   : cambiarEstado
    Created on : 28/12/2015, 09:08:28 PM
    Author     : Manuel
--%>

<jsp:useBean id="facade" class="facade.Facade" scope="session"></jsp:useBean>
<%
    String id = request.getParameter("idAsesoria");
    String btn = request.getParameter("boton");
    String res = facade.cambiarEstado(id,btn);
    
    response.sendRedirect("cargarSolicitudes.jsp");
    %>

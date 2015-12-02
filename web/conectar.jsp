<%-- 
    Document   : conectar
    Created on : 20/11/2015, 10:05:40 AM
    Author     : Manuel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="clase" class="todo.conectar"></jsp:useBean>
<%
    String c = clase.establecer();
    out.println(c);
    %>

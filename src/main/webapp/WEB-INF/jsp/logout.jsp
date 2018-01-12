<%@ page import="java.util.*" %>
<% 
	session.removeAttribute("iduser");
	String redirectURL = "login";
	response.sendRedirect(redirectURL);
%>
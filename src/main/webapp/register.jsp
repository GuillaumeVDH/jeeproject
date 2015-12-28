<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" 
	import="org.flst.entity.User"
	import="org.flst.entity.Playlist"
	import="java.util.List"%>
 
<%@include file="layout.jsp" %>

<html>
<head>
	<title>Register</title>
	
</head>

<%
	StringBuffer url = request.getRequestURL();
	String uri = request.getRequestURI();
	String ctx = request.getContextPath();
	String baseurl = url.substring(0, url.length() - uri.length() + ctx.length()) + "/";
	
%>

<body>

   <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
        	<% // Affichage du message d'erreur s'il existe
			String erreur = (String) request.getAttribute("erreur");
			if (erreur != null) { %>
				<b>Erreur : <%=erreur %> </b><br/> 
			<%}%>
            <div class="account-wall">
                <img class="profile-img" src="http://cichocki.fr/flst/projet-jee/img/register_img.png"
                    alt="">
                <form class="form-signin" method="post" action="register">
	                <input class="form-control" placeholder="Email" type="email" name="email" id="email" required autofocus>
	                <br>
	                <input type="password" name="password" id="password" class="form-control" placeholder="Password" required>
	                <br>
	                <button class="btn btn-lg btn-primary btn-block" type="submit">Créer mon compte</button>
                </form>
            </div>
            <a href="<%= baseurl %>" class="text-center new-account">Déjà inscrit ? Se connecter.</a>
        </div>
    </div>


</body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<%@include file="layout.jsp" %>

<html>
<head>
	
	<title>Formulaire de connexion</title>

</head>
<body>
	<% // Affichage du message d'erreur s'il existe
	String erreur = (String) request.getAttribute("erreur");
	if (erreur != null) { %>
		<b>Erreur : <%=erreur %> </b><br/> 
	<%}%>
    
    
	    <div class="row">
	        <div class="col-sm-6 col-md-4 col-md-offset-4">
	            <div class="account-wall">
	                <img class="profile-img" src="http://cichocki.fr/flst/projet-jee/img/login_img.png"
	                    alt="">
	                <form class="form-signin" method="post" action="login">
		                <input class="form-control" placeholder="Email" type="email" name="loginSaisi" id="loginSaisi" required autofocus>
		                <br>
		                <input type="password" name="passSaisi" id="passSaisi" class="form-control" placeholder="Password" required>
		                <br>
		                <button class="btn btn-lg btn-primary btn-block" type="submit">Se connecter</button>
	                </form>
	            </div>
	            <a href="register" class="text-center new-account">Créer un compte</a>
	        </div>
	    </div>
	
	
</body>
</html>
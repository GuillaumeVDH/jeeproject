<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: franckmahieu
  Date: 13/01/16
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../../layout.jsp" %>
<html>
<head>
  <title>Impossible de créer le rayon</title>
</head>
<body>
<div class="background container-full">
  <div class="row">
    <div class="col-lg-12 text-center v-center">
      <h1>Ouups, une erreur s'est produite lors de la création du rayon.</h1>
      <p class="lead">Erreur: </p>
      <c:if test="${not empty error}">
        <p>${error}</p>
      </c:if>
    </div>
  </div> <!-- /row -->
  <div class="row">
      <br><br><br>
      <center>
        <span class="input-group-btn">
          <a href="<c:url value="home"/>" class="btn btn-lg btn-primary"
             style="border-radius: 6px;border-top-right-radius: 0;border-bottom-right-radius: 0;">
            Retourner sur la page d'accueil
          </a>
          <a href="<c:url value="admin-create-shelf"/>" class="btn btn-lg btn-primary"
             style="border-radius: 6px;border-bottom-left-radius: 0;border-top-left-radius: 0;">Retourner à la création de rayon</a>
        </span>
      </center>
    </div>
  </div> <!-- /row -->
</div> <!-- /container full -->

</body>

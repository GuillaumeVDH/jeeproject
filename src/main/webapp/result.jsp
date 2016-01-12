<%--
  Created by IntelliJ IDEA.
  User: guillaumevdh
  Date: 12/01/16
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="layout.jsp" %>
<html>
<head>
    <title>Resultat de la recherche</title>
</head>
<body>
<div class="background container-full">
  <c:choose>
    <c:when test="${not empty articleException}">
      <div class="row">
        <div class="col-lg-12 text-center v-center">
          <h1>Désolé, impossible de trouver le produit "${requestedProduct}" dans notre base de données.</h1>
          <br><br><br>
          <span class="input-group-btn"><a href="<c:url value="home"/>" class="btn btn-lg btn-primary">Effectuer une autre recherche?</a></span>
        </div>
      </div> <!-- /row -->
    </c:when>
    <c:otherwise>
      <div class="row">
        <div class="col-lg-12 text-center v-center">
          <h1>Le produit "${requestedProduct}" se trouve au rayon "${article.shelf.name}".</h1>
          <p class="lead">Encore une victoire de canard!</p>
          <br><br><br>
          <span class="input-group-btn"><a href="<c:url value="home"/>" class="btn btn-lg btn-primary">Effectuer une autre recherche?</a></span>
        </div>
      </div> <!-- /row -->
    </c:otherwise>
  </c:choose>

</div> <!-- /container full -->

</body>
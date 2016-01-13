<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: franckmahieu
  Date: 13/01/16
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../../layout.jsp" %>
<html>
<head>
  <title>Article crée!</title>
</head>
<body>
<div class="background container-full">
  <div class="row">
    <div class="col-lg-12 text-center v-center">
      <h1>Votre rayon a été correctement crée!</h1>
    </div>
  </div> <!-- /row -->
  <div class="container-fluid" style="padding-bottom: 40px;">
    <div class="col-lg-12 text-center v-center">
      <span class="input-group-btn">
        <a href="<c:url value="home"/>" class="btn btn-lg btn-primary" style="border-radius: 6px;">Retourner à l'accueil</a>
      </span>
    </div>
  </div> <!-- /row -->
</div>
</body>
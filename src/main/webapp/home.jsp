<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: guillaumevdh
  Date: 12/01/16
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<%@include file="layout.jsp" %>
<html>
<head>
  <title>Which shelf?</title>
</head>
<body>
  <div class="background container-full">
    <div class="row">
      <div class="col-lg-12 text-center v-center">
        <h1>Bienvenue sur Which-Shelf</h1>
        <p class="lead">Quel produit cherchez-vous?</p>
        <br><br><br>
        <form name="searchProductForm" action="<c:url value="result"/>" class="col-lg-12" method="POST">
          <div class="input-group" style="width:640px;text-align:center;margin:0 auto;">
            <input name="product" class="form-control input-lg" title="Taper le nom du produit dont vous cherchez le rayon" placeholder="Entrez le produit dont vous cherchez le rayon" type="text">
            <span class="input-group-btn"><input type="submit" value="Trouver le rayon correspondant" class="btn btn-lg btn-primary"></span>
          </div>
        </form>
      </div>
    </div> <!-- /row -->
  </div> <!-- /container full -->

</body>
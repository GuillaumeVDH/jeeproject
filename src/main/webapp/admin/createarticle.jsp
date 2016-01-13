<%--
  Created by IntelliJ IDEA.
  User: guillaumevdh
  Date: 13/01/16
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../layout.jsp" %>
<html>
<head>
  <title>Créer un article</title>
</head>
<body>
<div class="background container-full">
  <div class="row">
    <div class="col-lg-12 text-center v-center">
      <h1>Créer votre article</h1>
      <br><br><br>
      <form name="createArticleForm" action="<c:url value="admin-create-article"/>" class="col-lg-12" method="POST">
        <div class="input-group" style="width:640px;text-align:center;margin:0 auto;">
          <input name="productName" class="form-control input-md" title="" placeholder="Entrez le nom du produit" type="text">
          <input name="productBrand" class="form-control input-md" title="" placeholder="Entrez la marque" type="text">
          <input name="productImage" class="form-control input-md" title="" placeholder="Entrez l'url vers l'image produit" type="text">
          <input name="productPrice" class="form-control input-md" title="" placeholder="Prix" type="number" step="0.01">
          <c:if test="${not empty shelfs}">
                <select name="shelfName" class="form-control input-md">
                  <c:forEach items="${shelfs}" var="shelfs">
                    <option value="${shelfs.id}">${shelfs.name}</option>
                  </c:forEach>
                </select>
          </c:if>
        </div>
        <span class="input-group-btn">
          <input type="submit" value="Créer le produit" class="btn btn-lg btn-primary">
        </span>
      </form>
    </div>
  </div> <!-- /row -->
</div> <!-- /container full -->

</body>

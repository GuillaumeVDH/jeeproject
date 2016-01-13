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
      <c:if test="${not empty errors}">
        <c:forEach items="${errors}" var="error">
          <c:if test="${error.getPropertyPath() eq 'name'}">
            <c:set var="errorName" scope="session" value="${error.getMessage()}"/>
          </c:if>
          <c:if test="${error.getPropertyPath() eq 'brand'}">
            <c:set var="errorBrand" scope="session" value="${error.getMessage()}"/>
          </c:if>
          <c:if test="${error.getPropertyPath() eq 'picturelink'}">
            <c:set var="errorPicturelink" scope="session" value="${error.getMessage()}"/>
          </c:if>
          <c:if test="${error.getPropertyPath() eq 'prix'}">
            <c:set var="errorPrix" scope="session" value="${error.getMessage()}"/>
          </c:if>
          <c:if test="${error.getPropertyPath() eq 'shelf'}">
            <c:set var="errorShelf" scope="session" value="${error.getMessage()}"/>
          </c:if>
        </c:forEach>
      </c:if>
      <br><br><br>
      <form name="createArticleForm" action="<c:url value="admin-create-article"/>" class="col-lg-12" method="POST">
        <div class="input-group" style="width:640px;text-align:center;margin:0 auto;">
          <input name="productName" class="form-control input-md" title="" placeholder="Entrez le nom du produit" type="text">
          <c:if test="${not empty errorName}"><p>${errorName}</p></c:if>

          <input name="productBrand" class="form-control input-md" title="" placeholder="Entrez la marque" type="text">
          <c:if test="${not empty errorBrand}"><p>${errorBrand}</p></c:if>
          <input name="productImage" class="form-control input-md" title="" placeholder="Entrez l'url vers l'image produit" type="text">
          <c:if test="${not empty errorPicturelink}"><p>${errorPicturelink}</p></c:if>
          <input name="productPrice" class="form-control input-md" title="" placeholder="Prix" type="number" step="0.01">
          <c:if test="${not empty errorPrix}"><p>${errorPrix}</p></c:if>

          <c:if test="${not empty shelfs}">
            <select name="productShelf" class="form-control input-md">
              <c:forEach items="${shelfs}" var="shelfs">
                <option value="${shelfs.id}">${shelfs.name}</option>
              </c:forEach>
            </select>
          </c:if>
          <c:if test="${not empty errorShelf}"><p>${errorShelf}</p></c:if>
        </div>
        <span class="input-group-btn">
          <input type="submit" value="Créer le produit" class="btn btn-lg btn-primary" style="border-radius: 6px; margin-top: 20px;">
        </span>
      </form>
    </div>
  </div> <!-- /row -->
</div> <!-- /container full -->

</body>

<%--
  Created by IntelliJ IDEA.
  User: franckmahieu
  Date: 13/01/16
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../layout.jsp" %>
<html>
<head>
  <title>Créer un rayon</title>
</head>
<body>
<div class="background container-full">
  <div class="row">
    <div class="col-lg-12 text-center v-center">
      <h1>Créer votre rayon</h1>
      <c:if test="${not empty errors}">
        <c:forEach items="${errors}" var="error">
          <c:if test="${error.getPropertyPath() eq 'name'}">
            <c:set var="errorName" scope="session" value="${error.getMessage()}"/>
          </c:if>
        </c:forEach>
      </c:if>
      <br><br><br>
      <form name="createArticleForm" action="<c:url value="admin-create-shelf"/>" class="col-lg-12" method="POST">
        <div class="input-group" style="width:640px;text-align:center;margin:0 auto;">
          <input name="shelfName" class="form-control input-md" title="" placeholder="Entrez le nom du rayon" type="text">
          <c:if test="${not empty errorName}"><p>${errorName}</p></c:if>
        </div>
        <span class="input-group-btn">
          <input type="submit" value="Créer le rayon" class="btn btn-lg btn-primary" style="border-radius: 6px; margin-top: 20px;">
        </span>
      </form>
    </div>
  </div> <!-- /row -->
</div> <!-- /container full -->

</body>

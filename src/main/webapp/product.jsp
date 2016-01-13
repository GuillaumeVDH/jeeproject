<%--
  Created by IntelliJ IDEA.
  User: guillaumevdh
  Date: 30/12/15
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="layout.jsp" %>

<html>
<head>
  <title></title>
</head>
<body class="background">
<div class="container-fluid">
    <div class="content-wrapper">
        <div class="item-container">
          <div class="container">
            <div class="col-md-5">
              <div class="col-md-12 service-image-left">
                <center>
                  <img id="item-display" src="${article.picturelink}" alt=""/>
                </center>
              </div>
            </div>
            <div class="col-md-7">
              <div class="product-title">${article.name}</div>
              <div class="product-rayon">(Rayon ${article.shelf.name})</div>
              <hr>
              <div class="product-price">${article.prix} EUR</div>
              <div class="product-stock">In Stock</div>
              <hr>
            </div>
          </div>
        </div>
        <div class="container-fluid">
          <div class="col-md-12 product-info">
            Description
            <hr>
          </div>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12 text-center v-center">
          <span class="input-group-btn">
            <a href="<c:url value="home"/>" class="btn btn-lg btn-primary" style="border-radius: 6px;">Effectuer une nouvelle recherche</a>
          </span>
        </div>
    </div> <!-- /row -->
</div>
</body>
</html>
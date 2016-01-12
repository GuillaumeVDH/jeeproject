<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: guillaumevdh
  Date: 30/12/15
  Time: 18:14
  To change this template use File | Settings | File Templates.
--%>
<%@include file="layout.jsp" %>

<html>
<head>
    <title>Home page</title>
</head>
<body>
    <form NAME="listShelfs">
        <select NAME="shelfs" SIZE=1>
                <c:forEach items="${shelfs}" var="shelfs">
                    <option VALUE="${shelfs.id}">${shelfs.name}</option>
                </c:forEach>
        </select>
    </form>
    </div>
    <div class="row">
        <c:forEach items="${articles}" var="article">
            <div class="col-sm-6 col-md-4">
                <div class="thumbnail" >
                    <h4 class="text-center"><span class="label label-info">${article.brand}</span></h4>
                    <img src="${article.picturelink}" class="img-responsive">
                    <div class="caption">
                        <div class="row">
                            <div class="col-md-6 col-xs-6">
                                <h3>${article.name}</h3>
                            </div>
                            <div class="col-md-6 col-xs-6 price">
                                <h3>
                                    <label>${article.prix} EUR</label></h3>
                            </div>
                        </div>
                        <p>Id: ${article.id}</p>
                        <div class="row">
                            <div class="col-md-6">
                                <a class="btn btn-primary btn-product" href="<c:url value="product?id=${article.id}"/>">Fiche produit</a>
                            </div>
                            <div class="col-md-6">
                                <a href="#" class="btn btn-success btn-product"><span class="glyphicon glyphicon-shopping-cart"></span>Acheter</a></div>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</body>
</html>

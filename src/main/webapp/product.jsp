<%--
  Created by IntelliJ IDEA.
  User: guillaumevdh
  Date: 30/12/15
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@include file="layout.jsp" %>

<html>
<head>
  <title></title>
</head>
<body>
<div class="container-fluid">
  <div class="content-wrapper">
    <div class="item-container">
      <div class="container">
        <div class="col-md-12">
          <div class="product col-md-3 service-image-left">

            <center>
              <img id="item-display" src="${article.picturelink}" alt=""/>
            </center>
          </div>

          <div class="container service1-items col-sm-2 col-md-2 pull-left">
            <center>
              <a id="item-1" class="service1-item">
                <img src="${article.picturelink}" alt=""/>
              </a>
              <a id="item-2" class="service1-item">
                <img src="${article.picturelink}" alt=""/>
              </a>
              <a id="item-3" class="service1-item">
                <img src="${article.picturelink}" alt=""/>
              </a>
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
          <div class="btn-group cart">
            <button type="button" class="btn btn-success">
              Acheter
            </button>
          </div>
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
</div>
</body>
</html>
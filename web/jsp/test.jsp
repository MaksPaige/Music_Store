<%--
    Document   : products
    Created on : 07-Aug-2015, 15:37:08
    Author     : Michal Goly
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/header.jsp" />

<div class="container">
    <c:choose>
        <c:when test="${products == null}">
            <div class="page-header">
                <h1>No products found</h1>
            </div>
            <p>
                Unfortunately there are no product available for purchase right now.
                Please visit our shop later.
            </p>
        </c:when>
        <c:otherwise>
            <div class="page-header centre-align">
                <h1>The Music Store Catalog</h1>
            </div>
            <div class="row">
                <c:forEach var="product" items="${products}">
                    <div class="col-sm-6 col-md-4">
                        <div class="thumbnail">
                            <img src="<c:url value='${product.imageUrl}' />" alt="Cover Image" />
                            <div class="caption">
                                <h3>${product.artistName}</h3>
                                <p>${product.albumName}</p>
                                <a href="<c:url value='catalog/product/${product.code}' />" class="btn btn-primary btn-block">More</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </c:otherwise>
    </c:choose>
</div>

<jsp:include page="/footer.jsp" />

<%--
    Document   : single_product
    Created on : 08-Aug-2015, 16:34:37
    Author     : Michal Goly
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/header.jsp" />

<div class="container push_down">
    <div class="row">
        <div class="col-sm-8">
            <h1>${product.artistName}</h1>
            <h3>${product.albumName}</h3>
            <p class="larger_p">${product.albumInformation}</p>
        </div>
        <div class="col-sm-4">
            <img class="img-thumbnail" src="<c:url value='${product.imageUrl}' />" alt="Cover Image" />
        </div>
    </div>
    <div class="row push_down">
        <div class="col-sm-8">
        </div>
        <div class="col-sm-4">
            <p class="price">${product.priceCurrencyFormat}</p>
            <form method="post" action="<c:url value='/order/addItem'/>" class="float-left">
                <input type="hidden" name="productCode" value="<c:out value='${product.code}' />" />
                <input type="submit" class="btn btn-primary" value="Add to Cart" />
            </form>
            <a href="<c:url value='/catalog/product/${product.code}/listen' />" class="btn btn-default">Listen to Samples</a>
        </div>
    </div>
</div>

<jsp:include page="/footer.jsp" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<!DOCTYPE html>
<html>

<head>
    <title>Da Nang</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/logo.png"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/javascript/source/jquery-3.1.1.slim.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/javascript/source/bootstrap.min.js"></script>

    <link type="text/css" href="${pageContext.request.contextPath}/css/lib/bootstrap.css" rel="stylesheet" />
    <link type="text/css" href="${pageContext.request.contextPath}/css/source/common.css" rel="stylesheet"/>
</head>

<body class="body-fixed">
<%-- Main Menu --%>
<jsp:include page="common/header.jsp"/>
<%-- Main content --%>
<div class="container-fluid">
    <div class = "row">
        <div id="map" class="col-lg-9 map"></div>
        <div id="infor-tab" class="col-lg-3 infor-tab single-tab">

        </div>
    </div>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/javascript/source/openlayer/ol.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/javascript/source/map/map.js"></script>
</body>
</html>
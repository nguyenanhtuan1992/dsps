<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <title>Da Nang</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/logo.png"/>
</head>

<body class="body-fixed">
<%-- Main Menu --%>
<jsp:include page="common/masterPage.jsp"/>
<jsp:include page="common/header.jsp"/>
<%-- Main content --%>
<div class="container-fluid">
    <div class="row">
        <div id="map" class="col-lg-9 map"></div>
        <div id="infor-tab" class="col-lg-3 infor-tab single-tab">
        </div>
    </div>
</div>
</body>
</html>
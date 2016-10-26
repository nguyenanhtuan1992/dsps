<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<!DOCTYPE html>
<html>

<head>
    <title>Thông tin đoàn</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/logo.png"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/javascript/source/jquery-3.1.1.slim.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/javascript/source/bootstrap.min.js"></script>

    <link type="text/css" href="${pageContext.request.contextPath}/css/lib/bootstrap.css" rel="stylesheet" />
    <link type="text/css" href="${pageContext.request.contextPath}/css/source/common.css" rel="stylesheet"/>
</head>

<body class="body-fixed">
<%-- Main Menu --%>
<jsp:include page="../common/header.jsp"/>
<%-- Main content --%>
<div class="container-fluid">
    <div class = "row">
        <div id="map" class="col-lg-9 map"></div>
        <div id="infor-tab" class="col-lg-3 infor-tab multi-tab">
            <ul class="nav nav-tabs" id="com-menu-sidebar">
                <li id="tabPolices" class="active"><a id="tabListPolices" href="#tabDelegation-police" data-toggle="tab" style="font: bold;">Danh sách bảo vệ</a></li>
                <li id="tabSubEvents"><a id="tabListSubEvents" href="#tabDelegation-subEvent" data-toggle="tab" style="font: bold;" aria-expanded="true">Danh sách sự kiện</a></li>
            </ul>
            <div class="tab-content">
                <div id="tabListPoliceContent">
                    <div class="panel-group" id="accordion">
                        <c:forEach var="i" items="${listEvents}">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h4 class="panel-title">
                                        <a data-toggle="collapse" data-parent="#accordion" href="#collapse${i.id}">Đơn vị ${i.id}</a>
                                    </h4>
                                </div>
                                <div id="collapse${i.id}" class="panel-collapse collapse">
                                    <div class="panel-body">List Polices in here</div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
                <div id="tabListEventContent">
                    <nav>
                        <div class="panel-group" id="accordion2">
                            <c:forEach var="i" items="${listEvents}">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title">
                                            <a data-toggle="collapse" data-parent="#accordion" href="#collapse${i.id}">${i.name}</a>
                                        </h4>
                                    </div>
                                    <div id="collapse${i.id}" class="panel-collapse collapse">
                                        <div class="panel-body">Description for Event ${i.name} here</div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </nav>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
$(document).ready(function(){
    $('#tabListEventContent').hide();
});
</script>

<script type="text/javascript" src="${pageContext.request.contextPath}/javascript/source/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/javascript/source/openlayer/ol.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/javascript/source/map/map.js"></script>
</body>
</html>
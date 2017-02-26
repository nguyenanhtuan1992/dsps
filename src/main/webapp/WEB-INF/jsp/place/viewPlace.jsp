<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <title>Thông tin địa điểm</title>
    <jsp:include page="../common/masterPage.jsp"/>
</head>

<body class="body-fixed">
<%-- Main Menu --%>
<jsp:include page="../common/header.jsp"/>
<%-- Main content --%>
<div class="container-fluid">
    <div class = "row">
        <div id="map" class="col-lg-9 map"></div>
        <div id="infor-tab" class="col-lg-3 infor-tab multi-tab">
            <ul class="nav nav-tabs">
                <li class="active" style="width: 33%;"><a data-toggle="tab" href="#tabDelegationSubEvent">Danh sách sự kiện</a></li>
                <li style="width: 33%;"><a data-toggle="tab" href="#tabDelegationPolice">Lực lượng bảo vệ</a></li>
                <li style="width: 34%;"><a data-toggle="tab" href="#tabPlaceDetail">Thông tin địa điểm</a></li>
            </ul>
            <div class="tab-content">
                <div id="tabDelegationSubEvent" class="tab-pane fade in active panel-group">
                    <div class="panel-group"  id="accordionSubEvent">
                        <c:forEach var="i" items="${place.events}">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h4 class="panel-title">
                                        <a data-toggle="collapse" data-parent="#accordionSubEvent" href="#collapseSubEvent${i.id}">${i.name}</a>
                                    </h4>
                                </div>
                                <div id="collapseSubEvent${i.id}" class="panel-collapse collapse">
                                    <div class="panel-body">${i.description}</div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
                <div id="tabDelegationPolice" class="tab-pane fade in panel-group">
                    <div class="panel-group" id="accordionPolice">
                        <h4>Current Event's Name</h4>
                        <c:forEach var="i" items="${place.events}">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h4 class="panel-title">
                                        <a data-toggle="collapse" data-parent="#accordionPolice" href="#collapsePolice${i.id}">Đơn vị ${i.id}</a>
                                    </h4>
                                </div>
                                <div id="collapsePolice${i.id}" class="panel-collapse collapse">
                                    <div class="panel-body">List Polices in here</div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
                <div id="tabPlaceDetail" class="tab-pane fade in panel-group">
                    <table class="table table-bordered qp-table-infor">
                        <colgroup>
                            <col width="40%">
                            <col width="60%">
                        </colgroup>
                        <tr>
                            <th><label>Tên địa diểm</label></th>
                            <td>${place.name}</td>
                        </tr>
                        <tr>
                            <th><label>Địa chỉ</label></th>
                            <td>${place.address}</td>
                        </tr>
                        <tr>
                            <th><label>Hotline</label></th>
                            <td>${place.hotline}</td>
                        </tr>
                        <tr>
                            <th><label>Quản lý</label></th>
                            <td>${place.managerName}</td>
                        </tr>
                        <tr>
                            <th><label>Liên hệ quản lý</label></th>
                            <td><a href="#">${place.managerPhone}</a></td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/source/map/map.js"></script>
</body>
</html>
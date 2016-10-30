<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <title>Thông tin đoàn</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/logo.png"/>
</head>

<body>
<%-- Main Menu --%>
<jsp:include page="../common/masterPage.jsp"/>
<jsp:include page="../common/header.jsp"/>
<%-- Main content --%>
<div class="container-fluid">
    <div class = "row">
        <div id="map" class="col-lg-9 map"></div>
        <div id="infor-tab" class="col-lg-3 infor-tab multi-tab">
            <ul class="nav nav-tabs">
                <li class="active"><a data-toggle="tab" href="#tabDelegationPolice">Danh sách bảo vệ</a></li>
                <li><a data-toggle="tab" href="#tabDelegationSubEvent">Danh sách sự kiện</a></li>
            </ul>
            <div class="tab-content">
                <div id="tabDelegationPolice" class="tab-pane fade in active panel-group">
                    <div class="panel-group" id="accordionPolice">
                        <c:forEach var="i" items="${listEvents}">
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
                <div id="tabDelegationSubEvent" class="tab-pane fade in panel-group">
                        <div class="panel-group"  id="accordionSubEvent">
                            <c:forEach var="i" items="${listEvents}">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title">
                                            <a data-toggle="collapse" data-parent="#accordionSubEvent" href="#collapseSubEvent${i.id}">${i.name}</a>
                                        </h4>
                                    </div>
                                    <div id="collapseSubEvent${i.id}" class="panel-collapse collapse">
                                        <div class="panel-body">Description for Event ${i.name} here</div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                </div>
            </div>
        </div>
    </div>
    <div id="delegationDetail" class="row mgt10">
        <div class="col-lg-9">
            <div class="panel panel-default">
                <div class="panel-heading qp-panel-heading">
                    <span aria-hidden="true" class="glyphicon qp-heading-icon">&nbsp;</span>
                    <span class="qp-heading-text">Thông tin đoàn</span>
                </div>
                <div class="panel-body">
                    <table class="table table-bordered qp-table-infor">
                        <colgroup>
                            <col width="20%">
                            <col width="30%">
                            <col width="20%">
                            <col width="30%">
                        </colgroup>
                        <tbody>
                        <tr>
                            <th><label>Tên đoàn</label></th>
                            <td>${delegation.name}</td>
                            <th><label>Ngày đến</label></th>
                            <td>25/09/2017</td>
                        </tr>
                        <tr>
                            <th><label>Trưởng đoàn</label></th>
                            <td><a href="#">Leader</a></td>
                            <th><label>Ngày đi</label></th>
                            <td>03/11/2017</td>
                        </tr>
                        <tr>
                            <th><label>Quốc gia</label></th>
                            <td>${delegation.nation.name}</td>
                            <th><label>Thông tin liên hệ</label></th>
                            <td>Contact them</td>
                        </tr>
                        <tr>
                            <th><label>Tổng số thành viên</label></th>
                            <td><a href="#">9 thành viên</a></td>
                            <th><label>Nơi cư trú</label></th>
                            <td>Khách sạn Bông Hồng Vàng</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
        </div>
    </div>
</div>
<script>
$(document).ready(function(){
    $('#tabListEventContent').hide();
});
</script>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/source/map/map.js"></script>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <title>Thông tin đoàn</title>
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
                <li style="width: 33%;"><a data-toggle="tab" href="#tabDelegationPolice">Lực lượng bảo vệ</a></li>
                <li style="width: 33%;"><a data-toggle="tab" href="#tabDelegationSubEvent">Danh sách sự kiện</a></li>
                <li class="active" style="width: 34%;"><a data-toggle="tab" href="#tabDelegationDetail">Thông tin đoàn</a></li>
            </ul>
            <div class="tab-content">
                <div id="tabDelegationPolice" class="tab-pane fade in active panel-group">
                    <div class="panel-group" id="accordionPolice">
                        <h4>${currentEvent.name}</h4>
                            <c:forEach var="i" items="${listOrganizationEvent}">
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <h4 class="panel-title">
                                                <a data-toggle="collapse" data-parent="#accordionPolice" href="#collapsePolice<c:out value="${i.id}"/>"><c:out value="${i.name}"/></a>
                                            </h4>
                                        </div>
                                        <div id="collapsePolice${i.id}" class="panel-collapse collapse">
                                            <div class="panel-body">
                                                <c:if test="${currentEvent.polices != null}">
                                                    <table class="table table-hover" style="width: 100%;">
                                                        <colgroup>
                                                            <col width="85%">
                                                            <col width="15%">
                                                        </colgroup>
                                                        <c:forEach var="police" items="${currentEvent.polices}">
                                                            <c:if test="${i.id == police.organization.id}">
                                                                    <tr>
                                                                        <td><a href="#">${police.name}</a></td>
                                                                        <td style="text-align: center"><a href="#"><span title="Thông tin" class="glyphicon glyphicon-info-sign"></span></a></td>
                                                                    </tr>
                                                            </c:if>
                                                        </c:forEach>
                                                    </table>
                                                </c:if>
                                            </div>
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
                <div id="tabDelegationDetail" class="tab-pane fade in panel-group">
                    <table class="table table-bordered qp-table-infor">
                        <colgroup>
                            <col width="40%">
                            <col width="60%">
                        </colgroup>
                        <tr>
                            <th><label>Tên đoàn</label></th>
                            <td>${delegation.name}</td>
                        </tr>
                        <tr>
                            <th><label>Quốc gia</label></th>
                            <td>${delegation.nation.name}</td>
                        </tr>
                        <tr>
                            <th><label>Trưởng đoàn</label></th>
                            <td><a href="#">Leader's Name</a></td>
                        </tr>
                        <tr>
                            <th><label>Thời gian lưu trú</label></th>
                            <td>25/09/2017 - 03/11/2017</td>
                        </tr>
                        <tr>
                            <th><label>Tổng số thành viên</label></th>
                            <td><a href="#">9 thành viên</a></td>
                        </tr>
                        <tr>
                            <th><label>Nơi cư trú</label></th>
                            <td>Khách sạn Bông Hồng Vàng</td>
                        </tr>
                        <tr>
                            <th><label>Thông tin liên hệ</label></th>
                            <td><a href="#">Contact them</a></td>
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
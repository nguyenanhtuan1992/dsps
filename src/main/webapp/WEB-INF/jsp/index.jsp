<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<head>
    <title>Trang Chủ</title>
    <jsp:include page="common/masterPage.jsp"/>
</head>

<body class="body-fixed">
<%-- Main Menu --%>
<jsp:include page="common/header.jsp"/>
<%-- Main content --%>
<div class="container-fluid">
    &nbsp;
    <div class="row">
        <div class="col-sm-2"></div>
        <div class="col-sm-8">
            <form id="settingSuperEvent" action="../superevent/displaySuperEvent" method="post">
                <div class="panel panel-default qp-div-select">
                    <div class="panel-heading qp-panel-heading">
                        <span aria-hidden="true" class="glyphicon qp-heading-icon">&nbsp;</span>
                        <span class="qp-heading-text">Danh sách sự kiện</span>
                    </div>
                    <div class="panel-body">
                        <table class="table table-bordered qp-table-list">
                            <colgroup>
                                <col width="30%">
                                <col width="50%">
                                <col width="20%">
                            </colgroup>
                            <tbody>
                            <tr>
                                <th><label>Tên sự kiện</label></th>
                                <th><label>Thời gian diễn ra</label></th>
                                <th><label>Tùy chọn</label></th>
                            </tr>
                            <c:forEach var="i" items="${listSuperEvents}">
                                <tr>
                                    <td>${i.name}</td>
                                    <td>
                                        <fmt:formatDate pattern="dd/MM/yyyy" value="${i.startTime}"/> - <fmt:formatDate pattern="dd/MM/yyyy" value="${i.endTime}"/>
                                    <td>
                                        <form:radiobutton path="superEventInputForm.id" value="${i.id}" />
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="qp-div-action">
                    <input type="submit" class="btn qp-button" value="Bắt đầu"/>
                </div>
            </form>
        </div>
        <div class="col-sm-2"></div>
    </div>
</div>
</body>
</html>
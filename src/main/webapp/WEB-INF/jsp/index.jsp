<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<!DOCTYPE html>
<html>

<head>
    <title>Trang Chủ</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/logo.png"/>
    <script src="http://cdn.polyfill.io/v2/polyfill.min.js?features=requestAnimationFrame,Element.prototype.classList,URL"></script>
    <script src="http://openlayers.org/en/v3.18.2/build/ol.js"></script>
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
    &nbsp;
    <div class="row">
        <div class="col-sm-2"></div>
        <div class="col-sm-8">
            <form id="settingSuperEvent" action="home" method="post">
                <div class="panel panel-default qp-div-select">
                    <div class="panel-heading">
                        <span aria-hidden="true" class="glyphicon qp-heading-icon">&nbsp;</span>
                        <span class="qp-heading-text">Danh sách sự kiện</span>
                    </div>
                    <div class="panel-body">
                        <table class="table table-bordered qp-table-infor">
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
                            <tr>
                                <td><label>APEC</label></td>
                                <td>01/10/2017 - 30/10/2017</td>
                                <td>
                                    <input type="radio" name="superEventSetting" value="1" checked>
                                </td>
                            </tr>
                            <tr>
                                <td><label>Phao Hoa</label></td>
                                <td>01/04/2017 - 02/05/2017</td>
                                <td>
                                    <input type="radio" name="superEventSetting" value="2">
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="qp-div-action">
                    <button type="submit" class="btn qp-button">Bắt đầu</button>
                </div>
            </form>
        </div>
        <div class="col-sm-2"></div>
    </div>
</div>
</body>
</html>
<%@ tag pageEncoding="UTF-8" language="java" %>
<%@attribute name="title"%>
<%@attribute name="head_area" fragment="true" %>
<%@attribute name="body_area" fragment="true" %>

<html>
<head>
    <title>${title}</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/logo.png"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/javascript/lib/jquery-3.1.1.slim.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/javascript/lib/bootstrap.min.js"></script>

    <link type="text/css" href="${pageContext.request.contextPath}/css/lib/bootstrap.css" rel="stylesheet" />
    <link type="text/css" href="${pageContext.request.contextPath}/css/source/common.css" rel="stylesheet"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/javascript/source/openlayer/ol.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/javascript/source/map/map.js"></script>
    <jsp:invoke fragment="head_area"/>
</head>
<body>
<jsp:include page="../jsp/common/header.jsp"/>
<jsp:invoke fragment="body_area"/>
</body>
</html>
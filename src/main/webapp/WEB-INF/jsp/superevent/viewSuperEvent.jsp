<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>

<head>
    <title>Da Nang</title>
    <jsp:include page="../common/masterPage.jsp"/>
</head>

<body class="body-fixed">
<%-- Main Menu --%>
<jsp:include page="../common/header.jsp"/>
<%-- Main content --%>
<div class="container-fluid">
    <div class = "row">
        <div id="map" class="col-lg-9 map"></div>
        <div id="infor-tab" class="col-lg-3 infor-tab single-tab">
            <table id = "super-event-info" class="table table-striped table-info-vertical">
                <colgroup>
                    <col width="40%"/>
                    <col width="60%"/>
                </colgroup>
                <tr>
                    <th>Tên</th>
                    <td>${superEventOutputForm.name}</td>
                </tr>
                <tr>
                    <th>Thời gian</th>
                    <td>
                        <fmt:formatDate pattern="dd/MM/yyyy" value="${superEventOutputForm.startTime}"/> - <fmt:formatDate pattern="dd/MM/yyyy" value="${superEventOutputForm.endTime}"/>
                    </td>
                </tr>
                <tr>
                    <th colspan="2">Thông tin chi tiết</th>
                </tr>
                <tr>
                    <td colspan="2">
                        There's A Place In
                        Your Heart
                        And I Know That It Is Love
                        And This Place Could
                        Be Much
                        Brighter Than Tomorrow
                        And If You Really Try
                        You'll Find There's No Need
                        To Cry
                        In This Place You'll Feel
                        There's No Hurt Or Sorrow
                        <br>
                        There Are Ways
                        To Get There
                        If You Care Enough
                        For The Living
                        Make A Little Space
                        Make A Better Place...
                        <br>
                        Heal The World
                        Make It A Better Place
                        For You And For Me
                        And The Entire Human Race
                        There Are People Dying
                        If You Care Enough
                        For The Living
                        Make A Better Place
                        For You And For Me
                        <br>
                        If You Want To Know Why
                        There's A Love That
                        Cannot Lie
                        Love Is Strong
                        It Only Cares For
                        Joyful Giving
                        If We Try
                        We Shall See
                        In This Bliss
                        We Cannot Feel
                        Fear Or Dread
                        We Stop Existing And
                        Start Living
                        <br>
                        Then It Feels That Always
                        Love's Enough For
                        Us Growing
                        So Make A Better World
                        Make A Better World...
                        <br>
                        Heal The World
                        Make It A Better Place
                        For You And For Me
                        And The Entire Human Race
                        There Are People Dying
                        If You Care Enough
                        For The Living
                        Make A Better Place
                        For You And For Me
                        <br>
                        And The Dream We Were
                        Conceived In
                        Will Reveal A Joyful Face
                        And The World We
                        Once Believed In
                        Will Shine Again In Grace
                        Then Why Do We Keep
                        Strangling Life
                        Wound This Earth
                        Crucify Its Soul
                        Though It's Plain To See
                        This World Is Heavenly
                        Be God's Glow
                        <br>
                        We Could Fly So High
                        Let Our Spirits Never Die
                        In My Heart
                        I Feel You Are All
                        My Brothers
                        Create A World With
                        No Fear
                        Together We'll Cry
                        Happy Tears
                        See The Nations Turn
                        Their Swords
                        Into Plowshares
                        <br>
                        We Could Really Get There
                        If You Cared Enough
                        For The Living
                        Make A Little Space
                        To Make A Better Place...
                        <br>
                        Heal The World
                        Make It A Better Place
                        For You And For Me
                        And The Entire Human Race
                        There Are People Dying
                        If You Care Enough
                        For The Living
                        Make A Better Place
                        For You And For Me
                        <br>
                        Heal The World
                        Make It A Better Place
                        For You And For Me
                        And The Entire Human Race
                        There Are People Dying
                        If You Care Enough
                        For The Living
                        Make A Better Place
                        For You And For Me
                        <br>
                        Heal The World
                        Make It A Better Place
                        For You And For Me
                        And The Entire Human Race
                        There Are People Dying
                        If You Care Enough
                        For The Living
                        Make A Better Place
                        For You And For Me
                        <br>
                        There Are People Dying
                        If You Care Enough
                        For The Living
                        Make A Better Place
                        For You And For Me
                        <br>
                        There Are People Dying
                        If You Care Enough
                        For The Living
                        Make A Better Place
                        For You And For Me
                        <br>
                        You And For Me
                        You And For Me
                        You And For Me
                        You And For Me
                        You And For Me
                        You And For Me
                        You And For Me
                        You And For Me
                        You And For Me
                        You And For Me
                        You And For Me
                        <br>
                        Heal the world we live in, save it for our children
                        Heal the world we live in, save it for our children
                        Heal the world we live in, save it for our children
                        Heal the world we live in, save it for our children
                    </td>
                </tr>

            </table>
        </div>
    </div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/source/map/map.js"></script>
</body>
</html>
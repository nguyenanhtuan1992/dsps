<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<!DOCTYPE html>
<html>

<head>
    <title>Localized OpenStreetMap</title>
    <!--     <link rel="stylesheet" href="http://openlayers.org/en/v3.18.2/css/ol.css" type="text/css"> -->
    <!-- The line below is only needed for old environments like Internet Explorer and Android 4.x -->
    <script src="http://cdn.polyfill.io/v2/polyfill.min.js?features=requestAnimationFrame,Element.prototype.classList,URL"></script>
    <script src="http://openlayers.org/en/v3.18.2/build/ol.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/javascript/source/jquery-3.1.1.slim.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/javascript/source/bootstrap.min.js"></script>

    <link type="text/css" href="${pageContext.request.contextPath}/css/lib/bootstrap.css" rel="stylesheet" />
    <!--     <link type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.theme.css" rel="stylesheet" /> -->
    <link type="text/css" href="${pageContext.request.contextPath}/css/source/common.css" rel="stylesheet"/>
</head>

<body>
<%-- Main Menu --%>
<jsp:include page="common/header.jsp"/>
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
                        <td>Hội Nghị APEC</td>
                    </tr>
                    <tr>
                        <th>Thời gian</th>
                        <td>01/09/2017 - 30/09/2017</td>
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
<script>
    function transformExtent(extent) {
        return ol.proj.transformExtent(extent, 'EPSG:4326', 'EPSG:3857');
    }

    function transform(coordinate) {
        return ol.proj.transform(coordinate, 'EPSG:4326', 'EPSG:3857');
    }

    var vectorSource = new ol.source.Vector({
        //create empty vector
    });

    var iconFeature = new ol.Feature({
        geometry: new ol.geom.Point(transform([108.187916, 16.053292])),
        name: 'Null Island',
        population: 4000,
        rainfall: 500
    });

    vectorSource.addFeature(iconFeature);

    //create the style
    var iconStyle = new ol.style.Style({
        image: new ol.style.Icon(/** @type {olx.style.IconOptions} */ ({
            anchor: [0.5, 46],
            anchorXUnits: 'fraction',
            anchorYUnits: 'pixels',
            opacity: 0.75,
            src: 'http://openlayers.org/en/v3.9.0/examples/data/icon.png'
        }))
    });

    //add the feature vector to the layer vector, and apply a style to whole layer
    var vectorLayer = new ol.layer.Vector({
        source: vectorSource,
        style: iconStyle
    });

    var mapLayer = new ol.layer.Tile({
        source: new ol.source.XYZ({
            attributions: [
                'All maps © <a href="http://www.openseamap.org/">OpenSeaMap</a>',
                ol.source.OSM.ATTRIBUTION
            ],
            url: '${mapUrl}/{z}/{x}/{y}.png'
        })
    });

    var map = new ol.Map({
        // extent: transformExtent([107.8164, 15.9151, 108.3417, 16.2180]),
        maxResolution: 'auto',
        layers: [mapLayer, vectorLayer],
        target: 'map',
        view: new ol.View({
            center: transform([108.187916, 16.053292]),
            minZoom: 12,
            maxZoom: 17,
            zoom: 12
        })
    });
    map.getView().fit(transformExtent([107.8164, 15.9151, 108.3417, 16.2180]), map.getSize());
    map.on('click', function(evt){
        console.info(evt.coordinate);
        console.info(transformExtent([107.8164, 15.9151, 108.3417, 16.2180]));
        console.info(transform([108.21701, 16.04931]));
        console.info(ol.proj.transform(evt.coordinate, 'EPSG:3857', 'EPSG:4326'));
    });
</script>
</body>
</html>
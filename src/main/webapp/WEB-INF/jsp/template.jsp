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
    <script type="text/javascript" src="${pageContext.request.contextPath}/javascript/jquery-3.1.1.slim.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/javascript/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/javascript/customnavbar/bootstrap-submenu.js" ></script>

    <link type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" />
<!--     <link type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.theme.css" rel="stylesheet" /> -->
    <link type="text/css" href="${pageContext.request.contextPath}/javascript/customnavbar/bootstrap-submenu.css" rel="stylesheet">
    <link type="text/css" href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet"/>
</head>

<body>
    <%-- Main Menu --%>
    <jsp:include page="common/header.jsp"/>
    <%-- Main content --%>
    <div class="qp-body-container">
        <div class = "div-full-width">
            <div id="map" class="map"></div>
            <div id="infor-tab" class="infor-tab single-tab">
                <table id = "super-event-info" class="table table-striped table-info-vertical">
                    <colgroup>
                        <col width="40%"/>
                        <col width="60%"/>
                    </colgroup>
                    <tr>
                        <th>Title</th>
                        <td>Data display</td>
                    </tr>
                </table>
            </div>
        </div>
        <div class = "div-full-width"></div>
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
    <%-- Footer --%>
    <jsp:include page="common/footer.jsp"/>
</body>
</html>
/**
 * Created by Cicada on 10/25/2016.
 */
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
        /*url: '${mapUrl}/tiles/{z}/{x}/{y}.png'*/
        url: 'http://localhost:8080/osm/tiles/{z}/{x}/{y}.png'
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

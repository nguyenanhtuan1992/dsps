/**
 * Created by Cicada on 10/25/2016.
 */

/* Change Tab */
$('#tabPolices').click(function() {
    $('#tabListPoliceContent').show();
    $('#tabListEventContent').hide();
});

$('#tabSubEvents').click(function() {
    $('#tabListPoliceContent').hide();
    $('#tabListEventContent').show();
});

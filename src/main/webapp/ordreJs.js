$(document).ready(function(){
    // Bind opp tabellen mot rest-ressursen '/kunder'
    $("#myTable").DataTable( {
        ajax: {
            url: 'rest/bistro',
            dataSrc: ''
        },                  
        columns: [
            { data: 'navn' },
            { data: 'bestilling'}
        ]
    });
    
});
$(document).ready(function(){
    var retter = ["Dessert", "Hovedrett", "Forett"];
    var meny = 0;
    
    $.ajax({
       url:"rest/bistro/tid",
       type: 'GET',
       success:function(data){
           for(var i = 0; i<data.length; i++){
               $("#vDato").append(new Option(data[i], i));
           }
       }
    });
    
    $.ajax({
       url:"rest/bistro/retter",
       type: 'GET',
       success:function(data){
           for(var i = 0; i<data.length; i++){
                $("#tTable").append([
                '<tr>',
                '<td>'+data[i][0]+'</td>',
                '<td>'+data[i][1]+'</td>',
                '<td><input id=inp'+i+' type="number" value="0"></td>',
                '</tr>'
                ]);
            }
       }
    });

});
$(document).ready(function(){
    $("#myButton").click(function(){

        $.ajax({
            url:'rest/bistro',
            type: 'PUT',
            data: JSON.stringify({
                navn: $("#navn").val(),
                bestilling: [
                    $("#vDato").val(),
                    $("#inp0").val(),
                    $("#inp1").val(),
                    $("#inp2").val(),
                    $("#inp3").val(),
                    $("#inp4").val(),
                    $("#inp5").val(),
                    $("#inp6").val(),
                    $("#inp7").val(),
                    $("#inp8").val(),
                    $("#inp9").val(),
                    $("#inp10").val()
                ],
                kortnummer:$("#kort").val(),
                utløpsdato:$("#uDato").val(),
                kontrollsiffer:$("#kSiffer").val()
            }),
            contentType:'application/json; charset=utf-8',
            dataType: 'json',
            success:function(result){
                $("#myTable").DataTable().ajax.reload();
                alert("Bestilling gjennomført");
            }
        });
    });
});
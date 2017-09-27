$(document).ready(function(){
    $.ajax({
        url: "rest/bistro/retter",
        type: 'PUT'
    });
    $("#bestilling").click(function(){
        window.location.href='bestilling.html';
    });
    $("#ordre").click(function(){
        window.location.href='ordre.html';
    });
});

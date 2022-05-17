$(function() {

    $(".toggle").on("click", function() {

        if ($(".item").hasClass("active")) { 
            $(".item").removeClass("active"); //elimina la clase active a cada elemento
            $(this).find("a").html("<i class='fas fa-bars'></i>"); //reemplaza el icono de cierre con el icono de de hamburguesa

        } else {

            $(".item").addClass("active"); //añade la clase active a cada elemento
            $(this).find("a").html("<i class='fas fa-times'></i>"); //reemplaza el icono de hamburguesa con el icono de cierrre fa-times
        }
    });

});
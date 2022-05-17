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

var exampleModal = document.getElementById('exampleModal')
exampleModal.addEventListener('show.bs.modal', function (event) {
  // Button that triggered the modal
  var button = event.relatedTarget
  // Extract info from data-bs-* attributes
  var recipient = button.getAttribute('data-bs-whatever')
  // If necessary, you could initiate an AJAX request here
  // and then do the updating in a callback.
  //
  // Update the modal's content.
  var modalTitle = exampleModal.querySelector('.modal-title')
  var modalBodyInput = exampleModal.querySelector('.modal-body input')

  modalTitle.textContent = 'Editar actividad: ' + recipient
  modalBodyInput.value = recipient
})
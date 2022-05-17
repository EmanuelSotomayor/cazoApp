const stepCircle = document.querySelectorAll(".progress-step");
const btnNextFirst = document.querySelector(".btnNext");
const btnNextAll = document.querySelectorAll(".next");
const btnPrevAll = document.querySelectorAll(".prev");
const allForms = document.querySelectorAll(".form-step");

let cantFormActual = 0;
let cantFormActualPrev = 0;
/*
Lo inicializamos en 1, porque la primer posición del step debe iniciar pintada
a penas aparece el formulario
*/
let cantBtnActual = 1;

btnNextAll.forEach((button) => {
    button.addEventListener('click', () => {
        cantFormActual++;
        allForms.forEach((formStep) => {
            /*
                Si un formulario contiene la clase form-step-active el contains
                devuelve un true y por lo tanto aplicará el método remove
            */
            formStep.classList.contains("form-step-active") &&
                formStep.classList.remove("form-step-active");
        });

        allForms[cantFormActual].classList.add("form-step-active");
    });
});

const paintProgressSteps = () => {

    stepCircle[0].classList.add("progress-step-active");

    btnNextAll.forEach((button) => {
        button.addEventListener('click', () => {
            stepCircle[(cantBtnActual)].classList.add("progress-step-active");
            cantBtnActual++;
        });
    });
    
}

btnPrevAll.forEach((button) => {
    button.addEventListener('click', () => {
        /*Queda con el valor actual del cantFormActual cuando presionamos en un botón
        siguiente y este botón lo único que hace es decrementarlo para volver hacía atrás*/
        cantFormActual--;

        allForms.forEach((formStep) => {
            /*
                Si un formulario contiene la clase form-step-active el contains
                devuelve un true y por lo tanto aplicará el método remove
            */
            formStep.classList.contains("form-step-active") &&
                formStep.classList.remove("form-step-active");

        });

        allForms[cantFormActual].classList.add("form-step-active");
    });
});

const nPaintProgressSteps = () => {


    btnPrevAll.forEach((button) => {
        button.addEventListener('click', () => {
            stepCircle[(cantBtnActual-1)].classList.remove("progress-step-active");
            cantBtnActual--;
        });
    });
}

//Llamada a la función para pintar los step del progress bar
paintProgressSteps();
//Llamada a la función para despintar los step del progress bar
nPaintProgressSteps();



const allInputs = document.querySelectorAll(".textInput");
allInputs.forEach((item) =>{
	item.addEventListener('click', ()=>{
		item.value = "";
	});
});
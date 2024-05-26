//ESTABLECIENDO LIMITE DEL FRONT
let today = new Date();
let dd = String(today.getDate()).padStart(2, '0');
let mm = String(today.getMonth() + 1).padStart(2, '0'); //Enero es 0!
let yyyy = today.getFullYear();

today = yyyy + '-' + mm + '-' + dd;
document.getElementById('').max = today;
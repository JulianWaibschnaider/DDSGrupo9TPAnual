function onInit() {
    loadContent('sidebar.html', 'sidebar');
    loadContent('navbar.html', 'navbar');
    loadContent('blank.html', 'main-content');
    ponerNombre();
    // Código a ejecutar cuando la página se inicializa
}

document.addEventListener('DOMContentLoaded', onInit);

function loadContent(url, target) {
    const targetElement = document.getElementById(target);
    fetch(url)
        .then(response => response.text())
        .then(data => {
            targetElement.innerHTML = data;
        });
}

function navigateToPage(page) {
    loadContent(page, 'main-content');
}

function irAIncidente(){
navigateToPage('incidente.html');
onInitIncidente();
}

function irAOrgYEnti(){
    navigateToPage('organismosyentes.html');
} 

function sugerencia(){
    navigateToPage('sugerencia.html');
} 

function misComunidades(){
    navigateToPage('adminusuarios.html');
    onInitRoles();
} 
function ranking(){
    navigateToPage('ranking.html');
    onInitRanking();
} 

function cerrarSesion(){
    localStorage.clear();
    window.location.href = "login.html";
}

function ponerNombre(){
    var nombre = localStorage.getItem('nombre');

    // Buscamos el elemento donde queremos mostrar el nombre y lo actualizamos
    var userNameElement = document.getElementById('nombreusuario');
    if (nombre && userNameElement) {
        userNameElement.textContent = nombre;
    }
}

function notificacionIncidente(){
    fetch('http://localhost:8080/SugerenciaIncidente');
}
function onInit() {
    loadContent('sidebar.html', 'sidebar');
    loadContent('navbar.html', 'navbar');
    loadContent('blank.html', 'main-content');
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
} 
function ranking(){
    navigateToPage('ranking.html');
} 


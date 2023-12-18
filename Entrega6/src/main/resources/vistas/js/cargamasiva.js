
var paginaActual1;
let tamanoPagina1 = 5; // Cantidad de elementos por página
let totalPaginas1 = 1;
function CargarArchivo() {
    const fileInput = document.getElementById('fileInput');
    const selectedFile = fileInput.files[0];
    if (selectedFile) {
        const fileName = selectedFile.name;
        const fileExtension = fileName.split('.').pop();
        if (fileExtension.toLowerCase() !== 'csv') {
            alert('Por favor selecciona un archivo con extensión .csv');
            return; // Detener la función si no es un archivo CSV
        }
        document.getElementById('fileNameLabel').innerText = selectedFile.name; // Muestra el nombre del archivo seleccionado en el label
        console.log("Archivo seleccionado:", selectedFile.name);
    }
    enviarArchivoAlBackend(selectedFile);
}

function enviarArchivoAlBackend(file) {
    paginaActual1 = 1;
    const formData = new FormData();
    formData.append('file', file);
    fetch('http://localhost:8080/CargarArchivo', {
        method: 'POST',
        body: formData
    })
        .then(response => response.text())
        .then(html => {
            const elementoHTML = document.getElementById('ponertabla');
            elementoHTML.innerHTML = html;
            const tabla = elementoHTML.querySelector('table');
            const filas = tabla.getElementsByTagName('tr').length - 1; // Excluir la fila de encabezado
            totalPaginas1 = Math.ceil(filas / tamanoPagina1);
            document.getElementById('paginacion').hidden = false;
            mostrarPagina(paginaActual1);
        })
        .catch(error => {
            console.error('Error al obtener el HTML:', error);
        });
}


function mostrarPagina(numeroPagina1) {
    const tabla = document.getElementById('ponertabla').querySelector('table');
    const filas = tabla.getElementsByTagName('tr');
    const totalFilas = filas.length - 1; // Excluir la fila de encabezado

    const inicio = (numeroPagina1 - 1) * tamanoPagina1;
    const fin = Math.min(inicio + tamanoPagina1, totalFilas + 1);

    for (let i = 0; i <= totalFilas; i++) {
        if (i >= inicio && i <= fin) {
            filas[i].style.display = 'table-row';
        } else {
            filas[i].style.display = 'none';
        }
    }

    // Actualizar la información de paginación
    document.getElementById('paginacionInfoorg').innerText = `Página ${numeroPagina1} de ${totalPaginas1}`;
}

function Anterior1() {
    if (paginaActual1 > 1) {
        paginaActual1--;
        mostrarPagina(paginaActual1);
    }
}

function Siguiente1() {
    if (paginaActual1 < totalPaginas1) {
        paginaActual1++;
        mostrarPagina(paginaActual1);
    }
}

function obtenerRolesliviano() {
    const idPersona = Number(localStorage.getItem('idPersona'));
    fetch('http://localhost:8080/ObtenerRolComunidadXPersonaLiviano',
    {
        method: 'POST',
        body: JSON.stringify({
            IdPersona: idPersona
        })
    }
    )
    .then(response => response.text())
    .then(html => {
            const divtabla = document.getElementById('tablacomunidadliviano');
            divtabla.innerHTML = html;
        })
        .catch(error => console.error('Error al obtener los roles:', error));
}

// Evento que se ejecuta al cargar la página
//window.addEventListener('load', obtenerIncidentes);

function onInitRolesliviano() {
    //loadContent('sidebar.html', 'sidebar');
    obtenerRolesliviano();

    //cargarSelectLinea();
    // Código a ejecutar cuando la página se inicializa
}



var comuElegida = 0;
function AbrirModalliviano(element) {
    comuElegida = element.getAttribute('data-incident-id'); ;
    $('#modalAbrirRolUsuarioliviano').modal('show');
}

function ModificarRolliviano() {
    const rol = +document.getElementById('rol').value;
    const idPersona = localStorage.getItem('idPersona');
    const idComunidad = comuElegida;
    const data = {
        IdPersona: idPersona,
        IdComunidad: idComunidad,
        rol: rol === 1 // si es 1 es afectado
    };
    fetch('http://localhost:8080/DefinirRol', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    }).then(response => response.json())
        .then(result => {
            misComunidadesliviano();
            console.log(result);
        })
}
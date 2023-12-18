function llenarTablaRoles(comunidades) {
    // Obtener referencia a la tabla
    const tabla = document.getElementById('tablarol');
  
    // Limpiar la tabla
    tabla.innerHTML = `<tr>
    <th>Editar rol</th>
    <th>Comunidad</th>
    <th>Mi rol</th>
    </tr>` ;
  
  
    // Recorrer los incidentes y agregar filas a la tabla
    comunidades.forEach(comunidad => {
      const fila = document.createElement('tr');
      fila.innerHTML = `
        <td><a href="#" class="btn btn-info btn-circle btn-sm" data-toggle="modal" data-incident-id=${comunidad.idComunidad} onclick="AbrirModal(${comunidad.idComunidad})">
        <i class="fas fa-pen"></i>
    </a></td>
        <td>${comunidad.nombre}</td>
        <td>${comunidad.rol}</td>
    </a></td>`;
      tabla.appendChild(fila);
    });
  
  
  }
  
  
  // Función para obtener los incidentes del endpoint
  function obtenerRoles() {
    const idPersona = Number(localStorage.getItem('idPersona'));
    fetch('http://localhost:8080/ObtenerRolComunidadXPersona',
      {
        method: 'POST',
        body: JSON.stringify({
          IdPersona: idPersona
        })
      }
      )
      .then(response => response.json())
      .then(data => llenarTablaRoles(data))
      .catch(error => console.error('Error al obtener los roles:', error));
  }
  
  // Evento que se ejecuta al cargar la página
  //window.addEventListener('load', obtenerIncidentes);
  
  function onInitRoles() {
    //loadContent('sidebar.html', 'sidebar');
    obtenerRoles();
  
    //cargarSelectLinea();
    // Código a ejecutar cuando la página se inicializa
  }
  
  var comuElegida = 0; 
  function AbrirModal(comunidadId){
    comuElegida = comunidadId;
    $('#modalAbrirRolUsuario').modal('show');
  }
  
function ModificarRol() {
  const rol = +document.getElementById('rol').value;
  const idPersona = localStorage.getItem('idPersona');
  const idComunidad =  comuElegida;
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
      misComunidades();
      console.log(result);
    })
}
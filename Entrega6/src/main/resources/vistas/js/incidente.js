var incidentes;
var rowsPorPagina = 5;
let modificacionHecha = false;
// Función para llenar la tabla con los datos obtenidos del endpoint
function llenarTablaIncidentes(pagina) {
  // Obtener referencia a la tabla
  const paginacionInfo = document.getElementById('paginacionInfo');
  const tabla = document.getElementById('tabla-incidentes');
  let incidentesUnicos = {};
  var rowsPorPagina = 5;

  incidentes.forEach(incidente => {
    if(!modificacionHecha){
    if (incidente.servicio.tipoBanio != null) {
      incidente.servicio.tipoServicio = incidente.servicio.tipoServicio + " " + incidente.servicio.tipoBanio;
    } else if (incidente.servicio.tipoElevacion != null) {
      incidente.servicio.tipoServicio = incidente.servicio.tipoServicio + " " + incidente.servicio.tipoElevacion;
    }}
    incidentesUnicos[incidente.id] = incidente;

  });
      modificacionHecha = true;
  incidentes = Object.values(incidentesUnicos);
  const inicio = (pagina - 1) * rowsPorPagina;
  const fin = inicio + rowsPorPagina;
  const incidentesPagina = incidentes.slice(inicio, fin);
  // Limpiar la tabla
  tabla.innerHTML = `<tr>
  <th>Fecha Apertura</th>
  <th>Servicio</th>
  <th>Transporte</th>
  <th>Linea</th>
  <th>Estacion</th>
  <th>Descripcion</th>
  <th>Estado</th>
  <th>Fecha Cierre</th>
  <th>Cerrar</th>
  </tr>` ;


  // Recorrer los incidentes y agregar filas a la tabla
  //el html lo esta armando el front con los datos que le llegaron del back (PESADO)
  incidentesPagina.forEach(incidente => {
   
    const fila = document.createElement('tr');
    fila.innerHTML = `
      <td>${incidente.fechaApertura}</td>
      <td>${incidente.servicio.tipoServicio}</td>
      <td>${incidente.servicio.entidad.linea.tipoTransporte}</td>
      <td>${incidente.servicio.entidad.linea.nombre}</td>
      <td>${incidente.servicio.entidad.estacion.nombre}</td>
      <td>${incidente.observaciones}</td>
      <td>${incidente.estado ? "Abierto" : "Cerrado"}</td>
      <td>${incidente.fechaCierre==null ? "No disponible" :  incidente.fechaCierre}</td>
      <th><a href="#" class="btn btn-danger btn-circle btn-sm" onclick="CerrarIncidente(${incidente.id})" data-incident-id="${incidente.id}">
            <i class="fas fa-trash"></i>
        </a></th>`;
    tabla.appendChild(fila);
  });
  paginacionInfo.textContent = `Página ${pagina} de ${Math.ceil(incidentes.length / rowsPorPagina)}`;
}



function Anterior() {
  if (paginaActual > 1) {
    paginaActual--;
    llenarTablaIncidentes(paginaActual);
  }
}

// Función para cambiar a la página siguiente
function Siguiente() {
  if (paginaActual < Math.ceil(incidentes.length / rowsPorPagina)) {
    paginaActual++;
    llenarTablaIncidentes(paginaActual);
  }
}


var paginaActual;
// Función para obtener los incidentes del endpoint
function obtenerIncidentes() {
  modificacionHecha = false;
  const idPersona = Number(localStorage.getItem('idPersona'));
  paginaActual = 1;
  fetch('http://localhost:8080/ObtenerIncidentes',
    {
      method: 'POST',
      body: JSON.stringify({
        IdPersona: idPersona
      })
    }
  )
    .then(response => response.json())
    .then(data => {
      incidentes = data,
        llenarTablaIncidentes(paginaActual)
    })
    .catch(error => console.error('Error al obtener los incidentes:', error));
}

// Evento que se ejecuta al cargar la página
//window.addEventListener('load', obtenerIncidentes);

document.addEventListener('DOMContentLoaded', onInitIncidente);
var modal;
function onInitIncidente() {
  loadContent('sidebar.html', 'sidebar');
  obtenerIncidentes();
  ponerNombre()
  //cargarSelectLinea();
  // Código a ejecutar cuando la página se inicializa
}

var itemsLinea;

function cargarSelectLinea() {

  const selectLinea = document.getElementById('idLinea');
  selectLinea.innerHTML = '';

  const optionDefault = document.createElement('option');
  optionDefault.value = '';
  optionDefault.text = 'Seleccione una Linea';
  selectLinea.appendChild(optionDefault);
  fetch('http://localhost:8080/ObtenerLineas')
    .then(response => response.json())
    .then(data => {
      itemsLinea = data;
      data.forEach(linea => {
        const option = document.createElement('option');
        option.value = linea.idLinea;
        option.text = linea.nombre;
        selectLinea.appendChild(option);
      });
    })
    .catch(error => console.error('Error al obtener las lineas:', error));

}

function cargarSelectEstaciones() {
  const selectLinea = document.getElementById('idLinea');
  const selectEstacion = document.getElementById('idEstacion');
  selectEstacion.innerHTML = '';
  const lineaSeleccionadaId = selectLinea.value;
  const lineaSeleccionada = itemsLinea.find(linea => linea.idLinea == lineaSeleccionadaId);
  const estacionesConformantes = lineaSeleccionada.estacionesConformantes;

  const optionDefault = document.createElement('option');
  optionDefault.value = '';
  optionDefault.text = 'Seleccione una estación';
  selectEstacion.appendChild(optionDefault);

  estacionesConformantes.forEach(estacion => {
    const option = document.createElement('option');
    option.value = estacion.idEstacion;
    option.text = estacion.nombre;
    selectEstacion.appendChild(option);
  });
}

function cargarSelectServicio() {
  const selectLinea = document.getElementById('idLinea');
  const selectEstacion = document.getElementById('idEstacion');
  const selectServicio = document.getElementById('idServicio');
  const lineaSeleccionadaId = selectLinea.value;
  const selectEstacionId = selectEstacion.value;
  selectServicio.innerHTML = '';


  const optionDefault = document.createElement('option');
  optionDefault.value = '';
  optionDefault.text = 'Seleccione un servicio';
  selectServicio.appendChild(optionDefault);

  fetch('http://localhost:8080/ObtenerServicios', {
    method: 'POST',
    body: JSON.stringify({
      idLinea: lineaSeleccionadaId,
      idEstacion: selectEstacionId
    })
  })
    .then(response => response.json())
    .then(data => {
      data.forEach(servicio => {
        if (servicio.tipoBanio != null) {
          servicio.tipoServicio = servicio.tipoServicio + " " + servicio.tipoBanio;
        } else if (servicio.tipoElevacion) {
          servicio.tipoServicio = servicio.tipoServicio + " " + servicio.tipoElevacion;
        }
        const option = document.createElement('option');
        option.value = servicio.idServicio;
        option.text = servicio.tipoServicio;
        selectServicio.appendChild(option);
      });
    })
    .catch(error => console.error('Error al obtener las lineas:', error));
}

function AbrirIncidente() {
  const selectServicio = document.getElementById('idServicio');
  const Descripcion = document.getElementById('Descripcion');
  const descripcionValue = Descripcion.value;
  const servicioSeleccionadoId = selectServicio.value;
  const emailPersona = localStorage.getItem('email');
  const data = {
    Email: emailPersona,
    id: servicioSeleccionadoId,
    observacion: descripcionValue
  };
  fetch('http://localhost:8080/CrearIncidente', {//se hace el envio (llamada al backend)
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(data)
  }).then(response => response.json())
    .then(result => {//json
      irAIncidente();
      console.log(result);
    })
}

function CerrarIncidente(id) {
  var idIncidente = id;
  if(idIncidente==null){
    idIncidente = event.target.getAttribute('data-incident-id');
  }
  const data = {
    IdIncidente: idIncidente,
  };
  fetch('http://localhost:8080/CerrarIncidente', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(data)
  }).then(response => response.json())
    .then(result => {
      irAIncidente();
      alert("Incidente cerrado");
      console.log(result);
    })
  // Hacer algo con el idIncidente, como eliminar el incidente con ese ID
  console.log('ID del incidente a eliminar:', idIncidente);
}

document.querySelectorAll('.delete-incident').forEach(btn => {
  btn.addEventListener('click', function (event) {
    event.preventDefault();
    const idIncidente = this.getAttribute('data-incident-id');
    const data = {
      IdIncidente: idIncidente,
    };
    fetch('http://localhost:8080/CerrarIncidente', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(data)
    }).then(response => response.json())
      .then(result => {
        irAIncidente();
        console.log(result);
      })
    // Hacer algo con el idIncidente, como eliminar el incidente con ese ID
    console.log('ID del incidente a eliminar:', idIncidente);
  });
});


function ObtenerIncidenteXestado() {
  const selectEstado = document.getElementById('estadoSelect');
  const divtabla = document.getElementById('tablainc');
  const elementoHTML = document.getElementById('tablaestado');

  if (selectEstado.value === '') {
    divtabla.hidden = false;
  elementoHTML.hidden=true;
    obtenerIncidentes();
  } else {
    const estadoSeleccionado = selectEstado.value === 'abierto';
    const idPersona = Number(localStorage.getItem('idPersona'));

    fetch('http://localhost:8080/ObtenerIncidentePorEstado', {
      method: 'POST',
      body: JSON.stringify({
        idPersona: idPersona,
        EstadoIncidente: estadoSeleccionado
      })
    })
      .then(response => response.text()) // Parsear la respuesta como texto
      .then(html => {
        divtabla.hidden = true;
        elementoHTML.hidden=false;
        elementoHTML.innerHTML = html; // Mostrar el HTML directamente en el elemento
        console.log(html);
      })
      .catch(error => console.error('Error al obtener los incidentes:', error));
  }
}

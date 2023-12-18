function llenarTablaRanking(rankings) {
    // Obtener referencia a la tabla
    const tabla = document.getElementById('tablaranking');
    var seleccion = +document.getElementById('rankear').value;
    var lista;
    var i = 1;
    // Limpiar la tabla
    tabla.innerHTML = `<tr>
    <th>Puesto</th>
    <th>Entidad</th>
      </tr>` ;
  
    if(seleccion == 0){
        lista = rankings.rankingMayorTiempoPromedio;
      };
    if(seleccion == 1){
        lista = rankings.rankingMayorGradoDeImpacto;
      }
    if(seleccion == 2){
        lista = rankings.rankingMayorCantidadIncidentes;
      }
    // Recorrer los incidentes y agregar filas a la tabla
    lista.forEach(ran => {
      const fila = document.createElement('tr');
      fila.innerHTML = `
        <td>${i}</td>
        <td>${ran.linea.tipoTransporte+ ' '+  ran.linea.nombre + ' ' + ran.estacion.nombre }</td>`;
      tabla.appendChild(fila);
        i++;
    });
  }
  
  
  // Función para obtener los incidentes del endpoint
  function obtenerRankings() {
    const fecha = document.getElementById('idFecha').value;
    // Divide la fecha original por los guiones '-' para obtener sus partes (año, mes, día)
    const partesFecha = fecha.split('-');
    const fechaNueva = partesFecha[2] + '/' + partesFecha[1] + '/' + partesFecha[0];

console.log(fechaNueva); // Esto imprimirá la fecha en el nuevo formato 'dd-mm-yyyy'

    fetch('http://localhost:8080/ObtenerRankingByFecha',
      {
        method: 'POST',
        body: JSON.stringify({
          Fecha: fechaNueva
        })
      }
      )
      .then(response => response.json())
      .then(data => llenarTablaRanking(data))
      .catch(error => console.error('Error al obtener los rannkings:', error));
  }
  
  // Evento que se ejecuta al cargar la página
  //window.addEventListener('load', obtenerIncidentes);
  

  function onInitRanking() {
    loadContent('sidebar.html', 'sidebar');
    //obtenerRankings();
    //llenarFechas();
    //cargarSelectLinea();
    // Código a ejecutar cuando la página se inicializa
  }

  function llenarFechas(){
    const tabla = document.getElementById('tablaranking');
    tabla.innerHTML = '';
    const selectFechas = document.getElementById('idFecha');
    selectFechas.disabled = false;
    selectFechas.innerHTML = '';
    const optionDefault = document.createElement('option');
  optionDefault.value = '';
  optionDefault.text = 'Seleccione una fecha';
  selectFechas.appendChild(optionDefault);

  fetch('http://localhost:8080/ObtenerFechasRanking')
    .then(response => response.json())
    .then(data => {
      data.forEach(fecha => {
        const option = document.createElement('option');
        option.value = fecha;
        option.text = fecha;
        selectFechas.appendChild(option);
      });
    })
    .catch(error => console.error('Error al obtener las fechas:', error)); 
  }
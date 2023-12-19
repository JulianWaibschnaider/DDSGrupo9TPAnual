function obtenerRankingsliviano() {
    const fecha = document.getElementById('idFecha').value;
    var seleccion = +document.getElementById('rankear').value;
    const tabla = document.getElementById('tablarankingliviano');
    // Divide la fecha original por los guiones '-' para obtener sus partes (año, mes, día)
    const partesFecha = fecha.split('-');
    const fechaNueva = partesFecha[2] + '/' + partesFecha[1] + '/' + partesFecha[0];

console.log(fechaNueva); // Esto imprimirá la fecha en el nuevo formato 'dd-mm-yyyy'

const elementoHTML = document.getElementById('divtablaliviana');
    fetch('http://localhost:8080/ObtenerRankingByFechaLiviano',
      {
        method: 'POST',
        body: JSON.stringify({
          Fecha: fechaNueva,
          TipoRanking: seleccion
        })
      }
      )
      .then(response => response.text())
      .then(html =>{
        elementoHTML.innerHTML = html;
      })
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

  function llenarFechasliviano(){

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
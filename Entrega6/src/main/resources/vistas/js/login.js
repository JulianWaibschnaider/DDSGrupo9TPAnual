
// Get the form and button elements
const form = document.querySelector('.user');
const button = document.querySelector('.btn-primary');

// Add event listener to the button
button.addEventListener('click', (event) => {
  event.preventDefault(); // Prevent form submission

  // Get the input values
  const email = document.getElementById('exampleInputEmail').value;
  const password = document.getElementById('exampleInputPassword').value;

  // Create a JSON object with the form data
  const data = {
    email: email,
    contrasenia: password
  };

  // Send the JSON data to the specified endpoint
  fetch('http://localhost:8080/Iniciar', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': '*' // Add this line
    },
    body: JSON.stringify(data)
  })
  .then(response => response.json())
  .then(result => { 
    if (result.email != null) {
      window.location.href = "index.html";
      localStorage.setItem('email', result.email);
      localStorage.setItem('idPersona', result.idPersona);
      localStorage.setItem('nombre', result.nombre);
      localStorage.setItem('apellido', result.apellido);
      onInit();
    }else{
      alert(result.message);
    }
    console.log(result);
  })
  .catch(error => {
    console.error(error);
    alert(error.JSON.message);
  });
});

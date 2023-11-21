
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
    password: password
  };

  // Send the JSON data to the specified endpoint
  fetch('http://localhost:8080/iniciar', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(data)
  })
  .then(response => response.json())
  .then(result => {
    // Handle the response from the server
    console.log(result);
  })
  .catch(error => {
    // Handle any errors that occur during the request
    console.error(error);
  });
});

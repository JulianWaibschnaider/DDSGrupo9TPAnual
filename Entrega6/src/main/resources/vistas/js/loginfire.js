import { signInWithEmailAndPassword, GoogleAuthProvider, signInWithPopup } from "https://www.gstatic.com/firebasejs/10.4.0/firebase-auth.js"
import { signOut } from "https://www.gstatic.com/firebasejs/10.4.0/firebase-auth.js";
import { auth } from "./firebaseconfig.js";



document.getElementById('loginButton').addEventListener('click', (event) => {
    event.preventDefault(); // Prevenir el envío del formulario

    const email = document.getElementById('exampleInputEmail').value;
    const password = document.getElementById('exampleInputPassword').value;

    // Iniciar sesión con Firebase Authentication
    signInWithEmailAndPassword(auth, email, password)
        .then(async (userCredential) => {
            // Usuario autenticado correctamente
            const user = userCredential.user;
            await obtenerPersona(user);
            console.log("Usuario autenticado:", user);
         // Redirigir a la página de inicio
        })
        .catch((error) => {
            // Si hay un error durante la autenticación
            const errorCode = error.code;
            const errorMessage = error.message;
            console.error("Error de autenticación:", errorMessage);
            alert(errorMessage); // Mostrar mensaje de error
        });
});




async function obtenerPersona(user) {
    const data = {
        email: user.email
    };
    fetch('http://localhost:8080/ObtenerPersona', {
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
                localStorage.setItem('email', result.email);
                localStorage.setItem('idPersona', result.idPersona);
                localStorage.setItem('nombre', result.nombre);
                localStorage.setItem('apellido', result.apellido);
                window.location.href = "index.html";
            } else {
                alert(result.message);
            }
            console.log(result);
        })
        .catch(error => {
            console.error(error);
            alert(error.JSON.message);
        });
}


export async function cerrarSesionfire() {
    await signOut(auth).then(() => {
        localStorage.clear();
        window.location.href = "loginfire.html";
    }).catch((error) => {
        console.log(error);
    });
}

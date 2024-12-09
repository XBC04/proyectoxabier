// Función para validar la fortaleza de la contraseña y mostrar mensajes de error
function validarContraseña() {
    var password = document.getElementById('password').value;
    var caracteresInfo = document.getElementById('caracteres');

    // Verificar si la contraseña tiene al menos 6 caracteres
    if (password.length < 6) {
        caracteresInfo.textContent = 'La contraseña debe tener 6 caracteres como mínimo';
    } else {
        caracteresInfo.textContent = '';
    }
}

// Función principal para validar el formulario al ser enviado
function validarFormulario() {
    // Obtener referencias a los elementos del formulario
    var nombreElement = document.getElementById('nombre');
    var passwordElement = document.getElementById('password');

    // Restablecer clases de error antes de cada validación
    nombreElement.classList.remove('error');
    passwordElement.classList.remove('error');

    // Obtener valores de los campos del formulario
    var nombre = nombreElement.value.trim(); // Obtener el valor del campo "nombre" eliminando los espacios en blanco al inicio y al final
    var password = passwordElement.value;

    // Array para acumular campos con errores
    var camposConErrores = [];

    // Validar que todos los campos obligatorios estén completos
    if (nombre === '' || /^\s+$/.test(nombre) || password === '') {
        alert('Todos los campos son obligatorios. Por favor, completa todos los campos.');

        // Acumular campos con errores
        if (nombre === '' || /^\s+$/.test(nombre)) {
            camposConErrores.push(nombreElement);
        }
        if (password === '') {
            camposConErrores.push(passwordElement);
        }

        // Aplicar clase de error a todos los campos con errores
        camposConErrores.forEach(function (campo) {
            campo.classList.add('error');
        });

        return false;
    }

    // Validar el formato del nombre (solo letras y espacios)
    var nombreRegex = /^[A-Za-z\s]+$/;
    if (!nombreRegex.test(nombre)) {
        alert('El nombre no puede contener números ni caracteres especiales.');
        nombreElement.classList.add('error');
        camposConErrores.push(nombreElement);
        return false;
    }

    // Validar la fortaleza de la contraseña (mínimo 6 caracteres) y que coincida con la confirmación
    if (password.length < 6) {
        alert('La contraseña debe tener al menos 6 caracteres.');
        passwordElement.classList.add('error');
        camposConErrores.push(passwordElement);
        return false;
    }

    // Si todas las validaciones pasan, se considera el formulario válido
    return true;
}

// Agregar un oyente de eventos para interceptar el envío del formulario
document.addEventListener('DOMContentLoaded', function () {
    var form = document.getElementById('form');
    form.addEventListener('submit', function (event) {
        // Si la validación del formulario no pasa, prevenir el envío
        if (!validarFormulario()) {
            event.preventDefault(); 
        }
    });
});
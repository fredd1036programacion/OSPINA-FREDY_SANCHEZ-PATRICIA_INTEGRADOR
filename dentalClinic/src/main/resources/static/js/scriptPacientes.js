
/* -------------------------------------------------------------------------- */
/*                    FUNCION: formularioRegistrar a la API                   */
/* -------------------------------------------------------------------------- */

window.addEventListener('load', function () {

    const formulario = document.querySelector('.formularioPacienteRegistrar')

    formulario.addEventListener('submit', function (event) {
        event.preventDefault();

        postearComentario();
    })
})


function capturarDatos() {
    const nombrePaciente = document.querySelector ('#nombrePaciente');
    const apellidoPaciente = document.querySelector ('#apellidoPaciente');
    const dniPaciente = document.querySelector ('#dniPaciente');
    const fechaIngresoPaciente = document.querySelector ('#fechaIngresoPaciente');
    const callePaciente = document.querySelector ('#callePaciente');
    const numeroPaciente = document.querySelector ('#numeroPaciente');
    const localidadPaciente = document.querySelector ('#localidadPaciente');
    const provinciaPaciente = document.querySelector ('#provinciaPaciente');

    console.log(nombrePaciente);

    let objeto = {
        nombre : nombrePaciente.value,
        apellido : apellidoPaciente.value,
        dni : parseInt(dniPaciente.value),
        fechaIngreso : fechaIngresoPaciente.value,
        domicilio: {
            calle : callePaciente.value,
            numero : parseInt(numeroPaciente.value),
            localidad : localidadPaciente.value,
            provincia : provinciaPaciente.value,
            }       
        }

    return objeto;
    
}


function postearComentario() {
    // 👇 usamos nuestra funcion para capturar los datos y guardarlos como objeto
    const datos = capturarDatos();

    // 👇 armamos las configuraciones
    // la api acepta JSON, por eso stringuificamos los datos
    const configuraciones = {
        method: 'POST',
        body: JSON.stringify(datos),
        headers: {
            'Content-type': 'application/json; charset=UTF-8',
        },
    }

    fetch('http://localhost:8081/pacientes/registrar', configuraciones)
    .then(response => {
        console.log(response);

        if (response.ok != true) {
            alert("Alguno de los datos es incorrecto.")
        }

        return response.json();

    })
        .then((data) => {
            console.log(data);
            renderizarRespuesta(data);
        }).catch(err => {
            console.log("Promesa rechazada:");
            console.log(err);
        })
}

function renderizarRespuesta(datos) {
    const div = document.querySelector('.registrarPacienteFormrespuesta')
    
    const template = `
        <p>✅ Datos cargados en el servidor</p>
        <p>
        nombre : ${datos.nombre}
        </p>
        <p>
        apellido : ${datos.apellido}
        </p>
        <p>
        dni : ${datos.dni}
        </p>
        <p>
        fechaIngreso : ${datos.fechaIngreso}
        </p>
        <p>
        calle : ${datos.domicilio.calle}
        </p>
        <p>
        numero : ${datos.domicilio.numero}
        </p>
        <p>
        localidad : ${datos.domicilio.localidad}
        </p>
        <p>
        provincia : ${datos.domicilio.provincia}
        </p>

    `;

    div.innerHTML = template;

}

/* -------------------------------------------------------------------------- */
/*                    fin FUNCION: formularioRegistrar a la API               */
/* -------------------------------------------------------------------------- */


/* -------------------------------------------------------------------------- */
/*                    FUNCION: formulariobuscar a la API                   */
/* -------------------------------------------------------------------------- */






    window.addEventListener('load', function () {

        const formulario = document.querySelector('.formularioPacienteBuscar')
    
        formulario.addEventListener('submit', function (event) {
            event.preventDefault();
    
            /* postearComentario();*/

            const idPacienteBuscar = document.querySelector ('#idPacienteBuscar');
            const endpoint = 'http://localhost:8081/pacientes/consultaPaciente/' + parseInt(idPacienteBuscar.value);
            console.log(endpoint)
            consultaApi(endpoint)

        })
    })

    function consultaApi(endpoint) {

        fetch(endpoint)
            .then(objetoRespuesta => {
                console.log(objetoRespuesta);
                const promesaJson = objetoRespuesta.json();
                return promesaJson;
            })
            .then(datosJs => {
                console.log(datosJs);
                renderizarElementos(datosJs);
            })
        }
    
 
function renderizarElementos(datos) {
    const comentarios = document.querySelector('.buscarPacienteFormrespuesta');

        const template = `
        <p>✅ Datos cargados en el servidor</p>
        <p>
        nombre : ${datos.nombre}
        </p>
        <p>
        apellido : ${datos.apellido}
        </p>
        <p>
        dni : ${datos.dni}
        </p>
        <p>
        fechaIngreso : ${datos.fechaIngreso}
        </p>
        <p>
        calle : ${datos.domicilio.calle}
        </p>
        <p>
        numero : ${datos.domicilio.numero}
        </p>
        <p>
        localidad : ${datos.domicilio.localidad}
        </p>
        <p>
        provincia : ${datos.domicilio.provincia}
        </p>

    `;

    comentarios.innerHTML = template;

}

/* -------------------------------------------------------------------------- */
/*                    fin FUNCION: formulariobuscar    a la API               */
/* -------------------------------------------------------------------------- */


/* -------------------------------------------------------------------------- */
/*                    FUNCION: listar todos        a la API                   */
/* -------------------------------------------------------------------------- */


window.addEventListener('load', function () {

    const formulario = document.querySelector('.formularioPacienteListar')

    formulario.addEventListener('submit', function (event) {
        event.preventDefault();

        /* postearComentario();*/

        const endpoint = 'http://localhost:8081/pacientes';
        console.log(endpoint)
        consultaApi2(endpoint)

    })
})

function consultaApi2(endpoint) {

    fetch(endpoint)
        .then(objetoRespuesta => {
            console.log(objetoRespuesta);
            const promesaJson = objetoRespuesta.json();
            return promesaJson;
        })
        .then(datosJs => {
            console.log(datosJs);
            renderizarElementos2(datosJs);
        })
    }

    function renderizarElementos2(listado) {
        const comentarios = document.querySelector('.formularioPacienteListartodos');
    
        comentarios.innerHTML = listado.map(item => {
            return`<div class="formularioPacienteListartodoss">
            <fieldset>
                <h2>Paciente : ${item.nombre}</h2>
                <p>ID: ${item.id}</p>
                <p>Apellido: ${item.apellido}</p>
                <p>DNI: ${item.dni}</p>
                <p>Fecha de ingreso: ${item.fechaIngreso}</p>
                <p>Calle: ${item.domicilio.calle}</p>
                <p>Numero: ${item.domicilio.numero}</p>
                <p>Localidad: ${item.domicilio.localidad}</p>
                <p>Provincia: ${item.domicilio.provincia}</p>
                <h2>Proximo paciente</h2>
            </fieldset>
            </div>`
        }).join('');
    }

/* -------------------------------------------------------------------------- */
/*                    fin FUNCION: listar todos    a la API                   */
/* -------------------------------------------------------------------------- */


/* -------------------------------------------------------------------------- */
/*                    FUNCION: Eliminar            a la API                   */
/* -------------------------------------------------------------------------- */

window.addEventListener('load', function () {

    const formulario = document.querySelector('.formularioPacienteEliminar')

    formulario.addEventListener('submit', function (event) {
        event.preventDefault();

        /* postearComentario();*/

        const idPacienteBuscar = document.querySelector ('#idPacienteEliminar');
        const endpoint = 'http://localhost:8081/pacientes/eliminarPaciente/' + parseInt(idPacienteBuscar.value);
        console.log(endpoint)
        consultaApi3(endpoint)

    })
})

function consultaApi3(endpoint) {

    const configuraciones = {
        method: 'DELETE',
    }

    fetch(endpoint,configuraciones)
    .then(response => {
        if (!response.ok) {
          throw new Error(`Error - ${response.status}`);
        }
        console.log('Solicitud DELETE exitosa');
        renderizarElementos3();
        // Realizar acciones adicionales después de la eliminación exitosa
      })
      .catch(error => {
        console.error('Error:', error);
        // Error
      });
    }

    function renderizarElementos3() {
        const comentarios = document.querySelector('.formularioPacienteeliminardato');
    
            const template = `
            <p>✅ Paciente eliminado del servidor</p>
        `;
    
        comentarios.innerHTML = template;
    
    }

    
/* -------------------------------------------------------------------------- */
/*                   fin FUNCION: Eliminar         a la API                   */
/* -------------------------------------------------------------------------- */
    



/* -------------------------------------------------------------------------- */
/*                    FUNCION: modificar           a la API                   */
/* -------------------------------------------------------------------------- */

window.addEventListener('load', function () {

    const formulario = document.querySelector('.formularioPacienteModificar')

    formulario.addEventListener('submit', function (event) {
        event.preventDefault();

        postearComentario5();
    })
})


function capturarDatos5() {
const idPacienteModificar = document.querySelector ('#idPacienteModificar');
const nombrePacienteModificar = document.querySelector ('#nombrePacienteModificar');
const apellidoPacienteModificar = document.querySelector ('#apellidoPacienteModificar');
const dniPacienteModificar = document.querySelector ('#dniPacienteModificar');
const fechaIngresoPacienteModificar = document.querySelector ('#fechaIngresoPacienteModificar');
const callePacienteModificar = document.querySelector ('#callePacienteModificar');
const numeroPacienteModificar = document.querySelector ('#numeroPacienteModificar');
const localidadPacienteModificar = document.querySelector ('#localidadPacienteModificar');
const provinciaPacienteModificar = document.querySelector ('#provinciaPacienteModificar');



    let objeto = {
        id : parseInt(idPacienteModificar.value),
        nombre : nombrePacienteModificar.value,
        apellido : apellidoPacienteModificar.value,
        dni : parseInt(dniPacienteModificar.value),
        fechaIngreso : fechaIngresoPacienteModificar.value,
        domicilio: {
            calle : callePacienteModificar.value,
            numero : parseInt(numeroPacienteModificar.value),
            localidad : localidadPacienteModificar.value,
            provincia : provinciaPacienteModificar.value,
            }       
        }


    return objeto;
    
}


function postearComentario5() {
    // 👇 usamos nuestra funcion para capturar los datos y guardarlos como objeto
    const datos = capturarDatos5();

    // 👇 armamos las configuraciones
    // la api acepta JSON, por eso stringuificamos los datos
    const configuraciones = {
        method: 'PUT',
        body: JSON.stringify(datos),
        headers: {
            'Content-type': 'application/json; charset=UTF-8',
        },
    }

    fetch('http://localhost:8081/pacientes/actualizar', configuraciones)
    .then(response => {
        console.log(response);

        if (response.ok != true) {
            alert("Alguno de los datos es incorrecto.")
        }

        return response.json();

    })
        .then((data) => {
            console.log(data);
            renderizarRespuesta5(data);
        }).catch(err => {
            console.log("Promesa rechazada:");
            console.log(err);
        })
}

function renderizarRespuesta5(datos) {
    const div = document.querySelector('.formularioPacientemodificar')
    
    const template = `
        <H2>✅ EL ID MODIFICADO FUE: ${datos.id} </H2>
        <p>
        nombre : ${datos.nombre}
        </p>
        <p>
        apellido : ${datos.apellido}
        </p>
        <p>
        dni : ${datos.dni}
        </p>
        <p>
        fechaIngreso : ${datos.fechaIngreso}
        </p>
        <p>
        calle : ${datos.domicilio.calle}
        </p>
        <p>
        numero : ${datos.domicilio.numero}
        </p>
        <p>
        localidad : ${datos.domicilio.localidad}
        </p>
        <p>
        provincia : ${datos.domicilio.provincia}
        </p>

    `;

    div.innerHTML = template;

}

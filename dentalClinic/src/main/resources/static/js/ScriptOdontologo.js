
/* -------------------------------------------------------------------------- */
/*                    FUNCION: formularioRegistrar a la API                   */
/* -------------------------------------------------------------------------- */

window.addEventListener('load', function () {

    const formulario = document.querySelector('.formularioOdontologoRegistrar')

    formulario.addEventListener('submit', function (event) {
        event.preventDefault();

        postearComentarioOdon1();
    })
})


function capturarDatosOdon1() {
    const matriculaOdontologo = document.querySelector ('#matriculaOdontologo');
    const nombreOdontologo = document.querySelector ('#nombreOdontologo');
    const apellidoOdontologo = document.querySelector ('#apellidoOdontologo');

    let objeto = {
        matricula : matriculaOdontologo.value,
        nombre : nombreOdontologo.value,
        apellido : apellidoOdontologo.value,
               
        }

    return objeto;
    
}


function postearComentarioOdon1() {
    // 👇 usamos nuestra funcion para capturar los datos y guardarlos como objeto
    const datos = capturarDatosOdon1();

    // 👇 armamos las configuraciones
    // la api acepta JSON, por eso stringuificamos los datos
    const configuraciones = {
        method: 'POST',
        body: JSON.stringify(datos),
        headers: {
            'Content-type': 'application/json; charset=UTF-8',
        },
    }

    fetch('http://localhost:8081/odontologos/registrar', configuraciones)
    .then(response => {
        console.log(response);

        if (response.ok != true) {
            alert("Alguno de los datos es incorrecto.")
        }

        return response.json();

    })
        .then((data) => {
            console.log(data);
            renderizarRespuestaOdon1(data);
        }).catch(err => {
            console.log("Promesa rechazada:");
            console.log(err);
        })
}

function renderizarRespuestaOdon1(datos) {
    const div = document.querySelector('.registrarOdontologoFormrespuesta')
    
    const template = `
        <p>✅ Datos cargados en el servidor</p>
        <h2>
        nombre : ${datos.nombre}
        </h2>
        <p>
        matricula : ${datos.matricula}
        </p>
        <p>
        apellido : ${datos.apellido}
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

        const formulario = document.querySelector('.formularioOdontologoBuscar')
    
        formulario.addEventListener('submit', function (event) {
            event.preventDefault();
    
            /* postearComentario();*/

            const idPacienteBuscar = document.querySelector ('#idOdontologoBuscar');
            const endpoint = 'http://localhost:8081/odontologos/consultaOdontologo/' + parseInt(idPacienteBuscar.value);
            console.log(endpoint)
            consultaApiOdont2(endpoint)

        })
    })

    function consultaApiOdont2(endpoint) {

        fetch(endpoint)
            .then(objetoRespuesta => {
                console.log(objetoRespuesta);
                const promesaJson = objetoRespuesta.json();
                return promesaJson;
            })
            .then(datosJs => {
                console.log(datosJs);
                renderizarElementosodon2(datosJs);
            })
        }
    
 
function renderizarElementosodon2(datos) {
    const comentarios = document.querySelector('.buscarOdontologoFormrespuesta');

        const template = `
        <h2>✅ Datos buscados son del id  ${datos.id} </h2>
        <p>
        nombre : ${datos.matricula}
        </p>
        <p>
        apellido : ${datos.nombre}
        </p>
        <p>
        dni : ${datos.apellido}
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

    const formulario = document.querySelector('.formularioOdontologoListar')

    formulario.addEventListener('submit', function (event) {
        event.preventDefault();

        /* postearComentario();*/

        const endpoint = 'http://localhost:8081/odontologos/consultarTodo';
        console.log(endpoint)
        consultaApiOdont3(endpoint)

    })
})

function consultaApiOdont3(endpoint) {

    fetch(endpoint)
        .then(objetoRespuesta => {
            console.log(objetoRespuesta);
            const promesaJson = objetoRespuesta.json();
            return promesaJson;
        })
        .then(datosJs => {
            console.log(datosJs);
            renderizarElementosodont3(datosJs);
        })
    }

    function renderizarElementosodont3(listado) {
        const comentarios = document.querySelector('.formularioOdontologoListartodos');
    
        comentarios.innerHTML = listado.map(item => {
            return`<div class="formularioOdontologoListartodoss">
            <fieldset>
                <h2>Odontologo : ${item.nombre}</h2>
                <p>ID: ${item.id}</p>
                <p>Apellido: ${item.apellido}</p>
                <p>DNI: ${item.matricula}</p>
                <h2>Proximo odontologo</h2>
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

    const formulario = document.querySelector('.formularioOdontologoEliminar')

    formulario.addEventListener('submit', function (event) {
        event.preventDefault();

        /* postearComentario();*/

        const idPacienteBuscar = document.querySelector ('#idOdontologoEliminar');
        const endpoint = 'http://localhost:8081/odontologos/eliminarOdontologo/' + parseInt(idPacienteBuscar.value);
        console.log(endpoint)
        consultaApiOdont4(endpoint)

    })
})

function consultaApiOdont4(endpoint) {

    const configuraciones = {
        method: 'DELETE',
    }

    fetch(endpoint,configuraciones)
    .then(response => {
        if (!response.ok) {
          throw new Error(`Error - ${response.status}`);
        }
        console.log('Solicitud DELETE exitosa');
        renderizarElementosOdon4();
        // Realizar acciones adicionales después de la eliminación exitosa
      })
      .catch(error => {
        console.error('Error:', error);
        // Error
      });
    }

    function renderizarElementosOdon4() {
        const comentarios = document.querySelector('.formularioOdontologoeliminardato');
    
            const template = `
            <p>✅ Odontologo eliminado del servidor</p>
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

    const formulario = document.querySelector('.formularioOdontologoModificar')

    formulario.addEventListener('submit', function (event) {
        event.preventDefault();

        postearComentarioOdotont6();
    })
})


function capturarDatosOdont6() {
const idOdontooloModificar = document.querySelector ('#idOdontologoModificar');
const nombreOdontooloModificar = document.querySelector ('#nombreOdontologoModificar');
const apellidoOdontooloModificar = document.querySelector ('#apellidoOdontologoModificar');
const matriculaOdontooloModificar = document.querySelector ('#matriculaOdontologoModificar');



    let objeto = {
        id : parseInt(idOdontooloModificar.value),
        matricula : matriculaOdontooloModificar.value,
        nombre : nombreOdontooloModificar.value,
        apellido : apellidoOdontooloModificar.value,
         
        }


    return objeto;
    
}


function postearComentarioOdotont6() {
    // 👇 usamos nuestra funcion para capturar los datos y guardarlos como objeto
    const datos = capturarDatosOdont6();

    // 👇 armamos las configuraciones
    // la api acepta JSON, por eso stringuificamos los datos
    const configuraciones = {
        method: 'PUT',
        body: JSON.stringify(datos),
        headers: {
            'Content-type': 'application/json; charset=UTF-8',
        },
    }

    fetch('http://localhost:8081/odontologos/actualizar', configuraciones)
    .then(response => {
        console.log(response);

        if (response.ok != true) {
            alert("Alguno de los datos es incorrecto.")
        }

        return response.json();

    })
        .then((data) => {
            console.log(data);
            renderizarRespuestaOdont6(data);
        }).catch(err => {
            console.log("Promesa rechazada:");
            console.log(err);
        })
}

function renderizarRespuestaOdont6(datos) {
    const div = document.querySelector('.formularioOdontologomodificar')
    
    const template = `
        <H2>✅ EL ID MODIFICADO FUE: ${datos.id} </H2>
        <p>
        nombre : ${datos.nombre}
        </p>
        <p>
        apellido : ${datos.apellido}
        </p>
        <p>
        dni : ${datos.matricula}
        </p>

    `;

    div.innerHTML = template;

}

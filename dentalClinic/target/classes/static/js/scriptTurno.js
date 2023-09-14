
/* -------------------------------------------------------------------------- */
/*                    FUNCION: formularioRegistrar a la API                   */
/* -------------------------------------------------------------------------- */

window.addEventListener('load', function () {

    const formulario = document.querySelector('.formularioTurnoRegistrar')

    formulario.addEventListener('submit', function (event) {
        event.preventDefault();

        postearComentarioturno1();
    })
})


function capturarDatosTurno1() {
    const odontologoIdTurno = document.querySelector ('#odontologoIdTurno');
    const pacienteIdTurno = document.querySelector ('#pacienteIdTurno');
    const LocalDateTimeTurno = document.querySelector ('#LocalDateTimeTurno');

    let objeto = {
        odontologoId : odontologoIdTurno.value,
        pacienteId : pacienteIdTurno.value,
        fechaYHora : LocalDateTimeTurno.value,
               
        }

    return objeto;
    
}


function postearComentarioturno1() {
    // 👇 usamos nuestra funcion para capturar los datos y guardarlos como objeto
    const datos = capturarDatosTurno1();

    // 👇 armamos las configuraciones
    // la api acepta JSON, por eso stringuificamos los datos
    const configuraciones = {
        method: 'POST',
        body: JSON.stringify(datos),
        headers: {
            'Content-type': 'application/json; charset=UTF-8',
        },
    }

    fetch('http://localhost:8081/turnos/registrar', configuraciones)
    .then(response => {
        console.log(response);

        if (response.ok != true) {
            alert("Alguno de los datos es incorrecto.")
        }

        return response.json();

    })
        .then((data) => {
            console.log(data);
            renderizarRespuestaTurno1(data);
        }).catch(err => {
            console.log("Promesa rechazada:");
            console.log(err);
        })
}

function renderizarRespuestaTurno1(datos) {
    const div = document.querySelector('.registrarTurnoFormrespuesta')
    
    const template = `
        <p>✅ Datos cargados en el servidor</p>

        <p>
        Fecha y Hora : ${datos.fechaYHora}
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

        const formulario = document.querySelector('.formularioTurnoBuscar')
    
        formulario.addEventListener('submit', function (event) {
            event.preventDefault();
    
            /* postearComentario();*/

            const idPacienteBuscar = document.querySelector ('#idTurnoBuscar');
            const endpoint = 'http://localhost:8081/turnos/consultaturno/' + parseInt(idPacienteBuscar.value);
            console.log(endpoint)
            consultaApiTurno2(endpoint)

        })
    })

    function consultaApiTurno2(endpoint) {

        fetch(endpoint)
            .then(objetoRespuesta => {
                console.log(objetoRespuesta);
                const promesaJson = objetoRespuesta.json();
                return promesaJson;
            })
            .then(datosJs => {
                console.log(datosJs);
                renderizarElementosTurno2(datosJs);
            })
        }
    
 
function renderizarElementosTurno2(datos) {
    const comentarios = document.querySelector('.buscarTurnoFormrespuesta');
        
        const template = `
        <h2>✅ Datos buscados son del id  ${datos.id} </h2>
        <p>
        nombre odontologo : ${datos.odontologoTurnoSalidaDto.nombre}
        </p>
        <p>
        nombre paciente : ${datos.pacienteTurnoSalidaDto.nombre}
        </p>
        <p>
        fecha y hora : ${datos.fechaYHora}
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

    const formulario = document.querySelector('.formularioTurnoListar')

    formulario.addEventListener('submit', function (event) {
        event.preventDefault();

        /* postearComentario();*/

        const endpoint = 'http://localhost:8081/turnos/';
        console.log(endpoint)
        consultaApiTurno3(endpoint)

    })
})

function consultaApiTurno3(endpoint) {

    fetch(endpoint)
        .then(objetoRespuesta => {
            console.log(objetoRespuesta);
            const promesaJson = objetoRespuesta.json();
            return promesaJson;
        })
        .then(datosJs => {
            console.log(datosJs);
            renderizarElementosTurno3(datosJs);
        })
    }

    function renderizarElementosTurno3(listado) {
        const comentarios = document.querySelector('.formularioTurnoListartodos');
    
        comentarios.innerHTML = listado.map(item => {
            return`<div class="formularioTurnoListartodoss">
            <fieldset>
                <h2>Paciente : ${item.pacienteTurnoSalidaDto.nombre}</h2>
                <p>ID: ${item.id}</p>
                <p>Odontologo: ${item.odontologoTurnoSalidaDto.nombre}</p>
            <h2>Proximo Turno</h2>
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

    const formulario = document.querySelector('.formularioTurnoEliminar')

    formulario.addEventListener('submit', function (event) {
        event.preventDefault();

        /* postearComentario();*/

        const idPacienteBuscar = document.querySelector ('#idTurnoEliminar');
        const endpoint = 'http://localhost:8081/turnos/eliminarTurno/' + parseInt(idPacienteBuscar.value);
        console.log(endpoint)
        consultaApiTurno4(endpoint)

    })
})

function consultaApiTurno4(endpoint) {

    const configuraciones = {
        method: 'DELETE',
    }

    fetch(endpoint,configuraciones)
    .then(response => {
        if (!response.ok) {
          throw new Error(`Error - ${response.status}`);
        }
        console.log('Solicitud DELETE exitosa');
        renderizarElementosturno4();
        // Realizar acciones adicionales después de la eliminación exitosa
      })
      .catch(error => {
        console.error('Error:', error);
        // Error
      });
    }

    function renderizarElementosturno4() {
        const comentarios = document.querySelector('.formularioTurnoeliminardato');
    
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

    const formulario = document.querySelector('.formularioTurnoModificar')

    formulario.addEventListener('submit', function (event) {
        event.preventDefault();

        postearComentarioTurno6();
    })
})


function capturarDatosTurno6() {
const idTurnoModificar = document.querySelector ('#idTurnoModificar');
const IdPacienteTurnoModificar = document.querySelector ('#IdPacienteTurnoModificar');
const IdOdontologoTurnoModificar = document.querySelector ('#IdOdontologoTurnoModificar');
const fechaYHoraTurnoModificar = document.querySelector ('#fechaYHoraTurnoModificar');



    let objeto = {
        id : parseInt(idTurnoModificar.value),
        idPaciente : parseInt(IdPacienteTurnoModificar.value),
        idOdontologo : parseInt(IdOdontologoTurnoModificar.value),
        fechaYHora : fechaYHoraTurnoModificar.value,
         
        }


    return objeto;
    
}


function postearComentarioTurno6() {
    // 👇 usamos nuestra funcion para capturar los datos y guardarlos como objeto
    const datos = capturarDatosTurno6();

    // 👇 armamos las configuraciones
    // la api acepta JSON, por eso stringuificamos los datos
    const configuraciones = {
        method: 'PUT',
        body: JSON.stringify(datos),
        headers: {
            'Content-type': 'application/json; charset=UTF-8',
        },
    }

    fetch('http://localhost:8081/turnos/actualizar', configuraciones)
    .then(response => {
        console.log(response);

        if (response.ok != true) {
            alert("Alguno de los datos es incorrecto.")
        }

        return response.json();

    })
        .then((data) => {
            console.log(data);
            renderizarRespuestaTurno6(data);
        }).catch(err => {
            console.log("Promesa rechazada:");
            console.log(err);
        })
}

function renderizarRespuestaTurno6(datos) {
    const div = document.querySelector('.formularioTurnomodificar')
    
    const template = `
        <H2>✅ EL ID MODIFICADO FUE: ${datos.id} </H2>
        <p>
        nombre paciente actualizado : ${datos.pacienteTurnoSalidaDto.nombre}
        </p>
        <p>
        nombre odontologo actualizado : ${datos.odontologoTurnoSalidaDto.nombre}
        </p>
        <p>
   `;

    div.innerHTML = template;

}

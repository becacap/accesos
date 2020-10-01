generarTabla();

//tomarSelector("api/empleados","#empleados","selecciona empleado...","${dato.nombre} ${dato.apellidos}","${empleado.id}");

obtenerDatos("api/empleados").then(function (empleados) {

    var campoEmpleados = document.querySelector("#empleados");

    var optionCabecera = document.createElement("option");
    optionCabecera.text = "selecciona empleado..."
    optionCabecera.value = 0;

    campoEmpleados.add(optionCabecera);

    empleados.forEach(function (empleado) {
        var option = document.createElement("option");
        //option.text = empleado.nombre;
        option.text = `${empleado.nombre} ${empleado.apellidos}`
        option.value = empleado.id;
        campoEmpleados.add(option)
    })
})

obtenerDatos("estados").then(function (estados) {

    var campoEstados = document.querySelector("#estados");

    var optionCabecera = document.createElement("option");
    optionCabecera.text = "selecciona estado..."
    optionCabecera.value = 0;

    campoEstados.add(optionCabecera);

    estados.forEach(function (estado) {
        var option = document.createElement("option");
        option.text = estado.descripcion;
        option.value =/* "estado" + */estado.id;
        campoEstados.add(option)

    })
})

obtenerDatos("api/calendario/").then(function (calendarios) {

    var campoCalendarios = document.querySelector("#calendarios");

    var optionCabecera = document.createElement("option");
    optionCabecera.text = "selecciona dia..."
    optionCabecera.value = 0;

    campoCalendarios.add(optionCabecera);

    calendarios.forEach(function (calendario) {
        var option = document.createElement("option");
        option.text = calendario.fecha;
        option.value =/* "calendario" + */calendario.id;
        campoCalendarios.add(option)

    })
})

obtenerDatos("api/jornada").then(function (jornadas) {

    var campoJornadas = document.querySelector("#jornadas");

    var optionCabecera = document.createElement("option");
    optionCabecera.text = "selecciona jornada..."
    optionCabecera.value = 0;

    campoJornadas.add(optionCabecera);

    jornadas.forEach(function (jornada) {
        var option = document.createElement("option");
        option.text = jornada.descripcion;
        option.value =/* "jornada" + */jornada.id;
        campoJornadas.add(option)

    })
})

function grabarDatos(url, dato) {

    return new Promise(function (resolve, reject) {
        var headers = new Headers();
        headers.append("Content-Type", "application/json");
        fetch(url,
            {
                "headers": headers,
                "method": "POST",
                "body": JSON.stringify(dato)
            }).then(response => response.json())
            .then(data => { return resolve(data) });
    })
}

function obtenerDatos(url) {

    return new Promise(function (resolve, reject) {
        var headers = new Headers();
        headers.append("Content-Type", "application/json");
        fetch(url, { "headers": headers }).then(response => response.json())
            .then(data => { return resolve(data) });
    })
}

function borrarDatos(url) {
    return new Promise(function (resolve, reject) {
        fetch(url, { method: 'DELETE' }).then(data => { return resolve(data) })
    })
}

function generarTabla() {
    obtenerDatos("/api/usuario-estado").then(function (usuariosEmpleados) {

        var table = document.createElement("table");
        table.id = "tabla";
        table.classList = "table table-hover"

        var tr = document.createElement("tr");
        var th1 = document.createElement("th");
        var th2 = document.createElement("th");
        var th3 = document.createElement("th");
        var th4 = document.createElement("th");
        var th5 = document.createElement("th");
        th1.appendChild(document.createTextNode("Empleado"));
        th2.appendChild(document.createTextNode("Estado"));
        th3.appendChild(document.createTextNode("Calendario"));
        th4.appendChild(document.createTextNode("Jornada"));
        th5.appendChild(document.createTextNode("Accion"));

        tr.appendChild(th1)
        tr.appendChild(th2)
        tr.appendChild(th3)
        tr.appendChild(th4)
        tr.appendChild(th5)
        table.appendChild(tr);



        usuariosEmpleados.forEach(function (usuarioEmpleado) {

            let tr = document.createElement("tr");

            let td1 = document.createElement("td");
            let td2 = document.createElement("td");
            let td3 = document.createElement("td");
            let td4 = document.createElement("td");
            let td5 = document.createElement("td");

            let modificar = document.createElement("button");
            modificar.innerText = "Modificar";
            modificar.onclick = function () {
                modificarRegistro(usuarioEmpleado.id, usuarioEmpleado.empleado.id,
                    usuarioEmpleado.estado.id, usuarioEmpleado.calendario.id, usuarioEmpleado.jornada.id)
            };
            let eliminar = document.createElement("button");
            eliminar.innerText = "Eliminar";
            eliminar.onclick = function () { eliminarRegistro(usuarioEmpleado.id) }

            td1.appendChild(document.createTextNode(`${usuarioEmpleado.empleado.nombre} ${usuarioEmpleado.empleado.apellidos}`));
            td2.appendChild(document.createTextNode(usuarioEmpleado.estado.descripcion));
            td3.appendChild(document.createTextNode(usuarioEmpleado.calendario.fecha));
            td4.appendChild(document.createTextNode(usuarioEmpleado.jornada.descripcion));
            td5.appendChild(modificar);
            td5.appendChild(eliminar);

            tr.appendChild(td1)
            tr.appendChild(td2)
            tr.appendChild(td3)
            tr.appendChild(td4)
            tr.appendChild(td5)
            table.appendChild(tr);
        })

        document.querySelector("#capa").appendChild(table)
    })
}
/*
function llenarFormulario(){

}

function tomarSelector(url,idComponenteSelector,textoCabecera,textoOpcion,textoOpcionValue){
    obtenerDatos(url).then(function (datos) {

        var selector = document.querySelector(idComponenteSelector);
    
        var optionCabecera = document.createElement("option");
        optionCabecera.text = textoCabecera
        optionCabecera.value = 0;
    
        selector.add(optionCabecera);
    
        datos.forEach(function (dato) {
            var option = document.createElement("option");
            option.text = `${textoOpcion}`;
            option.value = textoOpcionValue;
            selector.add(option)
    
        })
    })
}*/

function modificarRegistro(idRegistro, idEmpleado, idEstado, idCalendario, idJornada) {

    document.getElementById("idRegistro").value = idRegistro;
    document.getElementById("empleados").value =/* "empleado" +*/ idEmpleado;
    document.getElementById("estados").value = /*"estado" + */idEstado;
    document.getElementById("calendarios").value = /*"calendario" + */idCalendario;
    document.getElementById("jornadas").value = /*"jornada" + */idJornada;

}

function recogerFormulario() {
    idEmpleado = document.getElementById("empleados").value;
    idEstado = document.getElementById("estados").value;
    idCalendario = document.getElementById("calendarios").value;
    idJornada = document.getElementById("jornadas").value;
    id = document.getElementById("idRegistro").value

    var empleado = new Empleado(idEmpleado, null, null, null, null, null, null, null);
    var estado = new Estado(idEstado, null, null);
    var calendario = new Calendario(idCalendario, null, null);
    var jornada = new Jornada(idJornada, null, null, null, null, null, null, null);

    var usuario_estado = new Usuario_Estado(id, empleado, estado, calendario, jornada)

    grabarDatos("/api/calendario-empleado", usuario_estado).then(function () {
        document.querySelector('#tabla').parentNode.removeChild(document.querySelector('#tabla'))
        generarTabla();
        document.getElementById("idRegistro").value = 0;
        document.getElementById("empleados").value = 0;
        document.getElementById("estados").value = 0;
        document.getElementById("calendarios").value = 0;
        document.getElementById("jornadas").value = 0;
        document.getElementById("idRegistro").value = 0

    })
}

function eliminarRegistro(idRegistro) {
    //fetch("/usuario-estado/"+idRegistro,{method:'DELETE'});
    borrarDatos("/api/usuario-estado/delete/" + idRegistro).then(function () {
        //console.log(document.querySelector('#table'))
        document.querySelector('#tabla').parentNode.removeChild(document.querySelector('#tabla'))
        generarTabla();
    })

}
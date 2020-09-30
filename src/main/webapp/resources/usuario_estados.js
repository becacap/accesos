class Estado {
    constructor(id, descripcion, tipo) {
        this.id = id;
        this.descripcion = descripcion
        this.tipo = tipo;
    }
}

class Empleado {
    constructor(id, nombre, apellidos, dni, identificador, fecha_alta, fecha_baja, jornada) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.identificador = identificador;
        this.fecha_alta = fecha_alta;
        this.fecha_baja = fecha_baja;
        this.jornada = jornada;
    }
}

class Jornada {
    constructor(id, lunes, martes, miercoles, jueves, viernes, descripcion, especial) {
        this.id = id;
        this.lunes = lunes;
        this.martes = martes;
        this.miercoles = miercoles;
        this.jueves = jueves;
        this.viernes = viernes;
        this.descripcion = descripcion;
        this.especial = especial;
    }
}

class Calendario {
    constructor(id, fecha, estado) {
        this.id = id;
        this.fecha = fecha;
        this.estado = estado;
    }
}

class Usuario_estados {
    constructor(empleado, estado, calendario, jornada) {
        this.empleado = empleado;
        this.estado = estado;
        this.calendario = calendario;
        this.jornada = jornada;
    }
}

class Registro {
    constructor(idEmpleado, idJornada, idEstado, idCalendario) {
        this.idEmpleado = idEmpleado;
        this.idJornada = idJornada;
        idEstado = idCalendario;
    }
}

function obtenerDatos(url) {
    return new Promise(function(resolve, reject) {
        var headers = new Headers();
        headers.append("Content-Type", "application/json");
        fetch(url, { "headers": headers }).then(response => response.json())
            .then(data => { return resolve(data) });
    })
}

function grabarDatos(url, dato) {
    return new Promise(function(resolve, reject) {
        var headers = new Headers();
        headers.append("Content-Type", "application/json");
        fetch(url, {
                "headers": headers,
                "method": "POST",
                "body": JSON.stringify(dato)
            }).then(response => response.json())
            .then(data => { return resolve(data) });
    })
}

function cargarEstados() {
    obtenerDatos("/estados").then(function(estados) {

        var componente = document.querySelector("#estados");

        estados.forEach(function(estado) {
            var option = document.createElement("option");
            option.value = estado.id;
            option.text = estado.descripcion;
            componente.appendChild(option)
        })

    })
}

function cargarEmpleados() {
    obtenerDatos("/api/empleados").then(function(empleados) {

        var componente = document.querySelector("#empleados");

        empleados.forEach(x => {
            var option = document.createElement("option");
            option.value = x.id;
            option.text = `${x.apellidos}, ${x.nombre}`;
            componente.appendChild(option);
        })

    })
}

function cargarJornadas() {
    obtenerDatos("/api/jornada").then(function(jornadas) {

        var componente = document.querySelector("#jornadas");

        jornadas.forEach(x => {
            var option = document.createElement("option");
            option.value = x.id;
            option.text = x.descripcion;
            componente.appendChild(option);
        })

    })
}

function cargarCalendarios() {
    obtenerDatos("/api/calendario/").then(function(calendarios) {

        var componente = document.querySelector("#calendarios");

        calendarios.forEach(x => {
            var option = document.createElement("option");
            option.value = x.id;
            option.text = x.fecha;
            componente.appendChild(option);
        })

    })
}

function cargarUsuarioEstados() {
    obtenerDatos("/api/cuadrante").then(function(lineaCuadrante) {

        var componente = document.querySelector("#mi-table");

        lineaCuadrante.forEach(x => {
            var tr = document.createElement("tr");

            var tdUsuario = document.createElement("td");
            tdUsuario.appendChild(document.createTextNode(`${x.empleado.apellidos}, ${x.empleado.nombre}`))
            tr.appendChild(tdUsuario)

            var tdJornada = document.createElement("td");
            tdJornada.appendChild(document.createTextNode(x.jornada.descripcion))
            tr.appendChild(tdJornada);

            var tdEstado = document.createElement("td");
            tdEstado.appendChild(document.createTextNode(x.estado.descripcion))
            tr.appendChild(tdEstado)

            var tdCalendario = document.createElement("td");
            tdCalendario.appendChild(document.createTextNode(x.calendario.fecha))
            tr.appendChild(tdCalendario)

            componente.appendChild(tr);
        })

    })
}

function guardarRegistro() {
    alert("HACEMOS COSAS")

    var listaEmpleados = document.getElementById("empleados")
    var empleadoSelected = listaEmpleados.options[listaEmpleados.selectedIndex].value;
    console.log(empleadoSelected)

    var listaEstados = document.getElementById("estados")
    var estadoSelected = listaEstados.options[listaEstados.selectedIndex].value;
    console.log(estadoSelected)

    var listaJornadas = document.getElementById("jornadas")
    var jornadaSelected = listaJornadas.options[listaJornadas.selectedIndex].value;
    console.log(jornadaSelected)

    var listaCalendarios = document.getElementById("calendarios")
    var calendarioSelected = listaCalendarios.options[listaCalendarios.selectedIndex].value;
    console.log(calendarioSelected)


}

window.onload = function() {
    cargarEstados();
    cargarEmpleados();
    cargarJornadas();
    cargarCalendarios();
    cargarUsuarioEstados();
}
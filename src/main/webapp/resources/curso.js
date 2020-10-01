
const urlUsuariosEstados = "api/usuariosEstados"
const urlEmpleados="api/empleados"
const urlEstados="estados"
const urlJornadas="api/jornadas"
const urlCalendario="api/calendario/2020"


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

class Empleado {
    constructor(id, nombre, apellidos, dni, identificador, jornada, fecha_alta, fecha_baja) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.identificador = identificador;
        this.jornada = jornada;
        this.fecha_alta = fecha_alta;
        this.fecha_baja = fecha_baja;
    }

}

class Jornada {
    constructor(id, descripcion, especial, lunes, martes, miercoles, jueves, viernes) {
        this.id = id;
        this.descripcion = descripcion;
        this.especial = especial
        this.lunes = lunes
        this.martes = martes
        this.miercoles = miercoles
        this.jueves = jueves
        this.viernes = viernes
    }
}

class Estado {
    constructor(id, descripcion, tipo) {
        this.id = id;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }
}

class Calendario {
    constructor(id, estado, fecha) {
        this.id = id;
        this.estado = estado;
        this.fecha = fecha;
    }

}
class UsuariosEstados {
    constructor(id, empleado, estado, jornada, calendario) {
        this.id = id
        this.empleado = empleado
        this.estado = estado
        this.jornada = jornada
        this.calendario = calendario
    }
}
function cargarPagina() {
    crearTabla()
    crearSelect()
    crearBotonGrabar()
    
    
    cargarTabla();
    cargarSelect(urlEmpleados,"#sEmpleados","empleado","nombre", "apellidos")
    cargarSelect(urlJornadas,"#sJornadas","jornadas","descripcion")
    cargarSelect(urlEstados,"#sEstados","estados","descripcion")
    cargarSelect(urlCalendario,"#sCalendario","calendario","fecha")
}

function crearBotonGrabar(){
    var botonGrabar = document.createElement("button")
    if (document.querySelector("#botonGrabar") != null)
        document.querySelector("#botonGrabar").remove
    botonGrabar.classList.add("button")
    botonGrabar.classList.add("bg-success")
    botonGrabar.id = "botonGrabar"
    botonGrabar.textContent = "GRABAR"
    botonGrabar.click(grabaActualizaDato())
    document.querySelector("#capaBoton").appendChild(botonGrabar)
}

function crearBotonModificar(id,idEmpleado,idJornada,idEstado,idCalendario){
    var botonModificar = document.createElement("button")
    botonModificar.classList.add("button")
    botonModificar.classList.add("bg-success")
    botonModificar.click(grabaActualizaDato(id,idEmpleado,idJornada,idEstado,idCalendario))

}

function grabaActualizaDato(id,idEmpleado,idJornada,idEstado,idCalendario){
    document.querySelector("#id").value=id
    document.querySelector("#sEmpleados").value=idEmpleado
    document.querySelector("#sEstados").value=idEstado
    document.querySelector("#sCalendario").value=idCalendario
    document.querySelector("#sJornadas").value=idJornada
    
    

}

function cargarTabla() {
    obtenerDatos(urlUsuariosEstados).then((datos) => {
        datos.forEach((usuarioEstados)=>{
            var tr = document.createElement("tr")
            var td1 = document.createElement("td")
            td1.appendChild(document.createTextNode(`${usuarioEstados.empleado.nombre} ${usuarioEstados.empleado.apellidos}`))
            var td2 = document.createElement("td")
            td2.appendChild(document.createTextNode(usuarioEstados.jornada.des))
            var td3 = document.createElement("td")
            td3.appendChild(document.createTextNode(usuarioEstados.estado.descripcion))
            var td4 = document.createElement("td")
            td4.appendChild(document.createTextNode(usuarioEstados.calendario.fecha))
            var td5 = document.createElement("td")
            td5.appendChild(crearBotonModificar(usuarioEstados.id,usuarioEstados.empleado.id,usuarioEstados.jornada.id,usuarioEstados.especial.id,usuarioEstados.calendario.id))
            tr.appendChild(td1)
            tr.appendChild(td2)
            tr.appendChild(td3)
            tr.appendChild(td4)
            tr.appendChild(td5)

        })
    })
}

function cargarSelect(url,idSelect,texto,...campos)
{
    obtenerDatos(url).then((datos)=>{


        var sEmpleados=document.querySelector(idSelect)
        var option= document.createElement("option")
        option.value=0
        option.text=`selecciona ${texto}....`
        sEmpleados.appendChild(option)
        datos.forEach(dato=>{
            let option= document.createElement("option")
            option.value=dato.id
            var textoCampos=""
            campos.forEach((campo)=>{
                textoCampos=textoCampos+dato[campo]+" "
            })
            option.text=textoCampos
            sEmpleados.appendChild(option)
        })
    })
}

function crearTabla() {

    var tabla = document.createElement("table")
    tabla.id = "tabla"
    tabla.classList.add("table")
    var tr = document.createElement("tr")
    var td1 = document.createElement("td")
    td1.appendChild(document.createTextNode("EMPLEADO"))
    var td2 = document.createElement("td")
    td2.appendChild(document.createTextNode("JORNADA"))
    var td3 = document.createElement("td")
    td3.appendChild(document.createTextNode("ESTADO"))
    var td4 = document.createElement("td")
    td4.appendChild(document.createTextNode("CALENDARIO"))
    var td5 = document.createElement("td")
    td5.appendChild(document.createTextNode("ACCIONES"))
    tr.appendChild(td1)
    tr.appendChild(td2)
    tr.appendChild(td3)
    tr.appendChild(td4)
    tr.appendChild(td5)
    tabla.appendChild(tr)
    if (document.querySelector("#tabla") != null)
        document.querySelector("#tabla").remove
    document.querySelector("#capaTabla").appendChild(tabla)
}

function crearSelect() {

    var sEmpleados = document.createElement("select");
    sEmpleados.id = "sEmpleados"
    var sJornadas = document.createElement("select");
    sJornadas.id = "sJornadas"
    var sEstados = document.createElement("select");
    sEstados.id = "sEstados"
    var sCalendario = document.createElement("select");
    sCalendario.id = "sCalendario"
    if (document.querySelector("#sEmpleados") != null)
        document.querySelector("#sEmpleados").remove
    if (document.querySelector("#sJornadas") != null)
        document.querySelector("#sJornadas").remove
    if (document.querySelector("#sEstados") != null)
        document.querySelector("#sEstados").remove
    if (document.querySelector("#sCalendario") != null)
        document.querySelector("#sCalendario").remove

    document.querySelector("#capaSelect").appendChild(sEmpleados)

    document.querySelector("#capaSelect").appendChild(sJornadas)

    document.querySelector("#capaSelect").appendChild(sEstados)

    document.querySelector("#capaSelect").appendChild(sCalendario)

}








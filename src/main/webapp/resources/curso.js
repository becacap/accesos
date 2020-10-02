
const urlUsuariosEstados = "api/usuariosEstados"
const urlEmpleados = "api/empleados"
const urlEstados = "estados"
const urlJornadas = "api/jornadas"
const urlCalendario = "api/calendario/2020"
const urlGrabarUsuarioEstado = "api/calendario-empleado"
const urlDelete="/api/deleteUsuarioEstado"

function grabarDatos(url, dato) {

    return new Promise(function (resolve, reject) {
        var headers = new Headers();
        headers.append("Content-Type", "application/json");
        fetch(url,
        {"headers":headers,
        "method":"POST",
        "body":JSON.stringify(dato)
        }).then(response => response.json())
  .then(data => {return resolve(data)});
    })
}
function borrarDatos(url){
    return new Promise(function (resolve, reject) {
        var headers = new Headers();
        headers.append("Content-Type", "application/json");
        fetch(url, { "headers": headers,"method":"DELETE" })
            .then(() => { 
                
                alert("registro borrado correctamente");
                cargarTabla()
             });
    }) 
}

function obtenerDatos(url) {

    return new Promise(function (resolve, reject) {
        var headers = new Headers();
        headers.append("Content-Type", "application/json");

        fetch(url, { "headers": headers,"method":"GET" }).then(response => response.json())
            .then(data => { return resolve(data) });

    })
}

function botonModificar(idUsuarioEstado,idEmpleado,idJornada,idEstado,idCalenario){
    console.log("Hempos pulsado modificar")
    varModificar=true;
    
    document.getElementById("empleados").value=idEmpleado;
    document.getElementById("jornadas").value=idJornada;
    document.getElementById("estados").value=idEstado;
    document.getElementById("calendarios").value=idCalenario;

}

function registrar(){
    console.log("Hemos pulsado el boton grabar")
    grabarDatos("/api/empleados",idEmpleado).then(function(empleado){
        
        
    })
}
function botonEliminar(){
    console.log("Hempos pulsado eliminar")
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

    crearSelect()
    crearBotonGrabar()


    cargarTabla();
    document.querySelector("#id").value = 0;
    cargarSelect(urlEmpleados, "#sEmpleados", "empleado", "nombre", "apellidos")
    cargarSelect(urlJornadas, "#sJornadas", "jornadas", "descripcion")
    cargarSelect(urlEstados, "#sEstados", "estados", "descripcion")
    cargarSelect(urlCalendario, "#sCalendario", "calendario", "fecha")
}

function crearBotonGrabar() {
    var botonGrabar = document.createElement("button")
    if (document.querySelector("#botonGrabar") != null)
        document.querySelector("#botonGrabar").remove
    botonGrabar.classList.add("button")
    botonGrabar.classList.add("bg-success")
    botonGrabar.id = "botonGrabar"
    botonGrabar.textContent = "GRABAR"
    botonGrabar.onclick = grabaDato
    document.querySelector("#capaBoton").appendChild(botonGrabar)
}

function crearBotonBorrar(id) {
    var botonBorrar = document.createElement("button")
    if (document.querySelector("#botonBorrar") != null)
        document.querySelector("#botonBorrar").remove
        botonBorrar.classList.add("button")
        botonBorrar.classList.add("bg-danger")
        botonBorrar.id = "botonBorrar"
        botonBorrar.textContent = "BORRAR"
        botonBorrar.onclick = function(){borraDato(id)}
        return botonBorrar
}

function borraDato(id){

    borrarDatos(`${urlDelete}/${id}`).then(()=>{

        
    }).catch(function(error){
        alert(error)

    })

}

function grabaDato() {
    var empleado = document.querySelector("#sEmpleados").value;
    var jornada = document.querySelector("#sJornadas").value;
    var estado = document.querySelector("#sEstados").value;
    var calendario = document.querySelector("#sCalendario").value;
    var usuarioEstado = new UsuariosEstados(
        document.querySelector("#id").value,
        new Empleado(empleado),
        new Estado(estado),
        new Jornada(jornada),
        new Calendario(calendario)
    )
    console.log(usuarioEstado)

    var usuarioEstadoRespuesta = grabarDatos(urlGrabarUsuarioEstado, usuarioEstado).then((dato) => {
        if (dato.id > 0) {
            document.querySelector("#id").value = 0;
            document.querySelector("#sEmpleados").value = 0
            document.querySelector("#sEstados").value = 0
            document.querySelector("#sCalendario").value = 0
            document.querySelector("#sJornadas").value = 0
        }
        cargarTabla()
    })


}

function crearBotonModificar(id, idEmpleado, idJornada, idEstado, idCalendario) {
    var botonModificar = document.createElement("button")
    botonModificar.classList.add("button")
    botonModificar.classList.add("bg-success")
    botonModificar.textContent = "MODIFICAR"
    botonModificar.onclick = function () {
        grabaActualizaDato(id, idEmpleado, idJornada, idEstado, idCalendario)
    }

    return botonModificar;
}

function grabaActualizaDato(id, idEmpleado, idJornada, idEstado, idCalendario) {
    document.querySelector("#id").value = id
    console.log("id:" + id)
    document.querySelector("#sEmpleados").value = idEmpleado
    document.querySelector("#sEstados").value = idEstado
    document.querySelector("#sCalendario").value = idCalendario
    document.querySelector("#sJornadas").value = idJornada



}

function cargarTabla() {
    console.log(document.querySelector("#tabla"))
    if (document.querySelector("#tabla") != null)
        document.querySelector("#tabla").remove();
    crearTabla()
    obtenerDatos(urlUsuariosEstados).then((datos) => {
        console.log(datos)
        datos.forEach((usuarioEstados) => {
            var tr = document.createElement("tr")
            var td1 = document.createElement("td")
            td1.appendChild(document.createTextNode(`${usuarioEstados.empleado.nombre} ${usuarioEstados.empleado.apellidos}`))
            var td2 = document.createElement("td")
            td2.appendChild(document.createTextNode(usuarioEstados.jornada.descripcion))
            var td3 = document.createElement("td")
            td3.appendChild(document.createTextNode(usuarioEstados.estado.descripcion))
            var td4 = document.createElement("td")
            td4.appendChild(document.createTextNode(usuarioEstados.calendario.fecha))
            var td5 = document.createElement("td")
            td5.appendChild(crearBotonModificar(usuarioEstados.id, usuarioEstados.empleado.id, usuarioEstados.jornada.id, usuarioEstados.estado.id, usuarioEstados.calendario.id))
            td5.appendChild(crearBotonBorrar(usuarioEstados.id))
            tr.appendChild(td1)
            tr.appendChild(td2)
            tr.appendChild(td3)
            tr.appendChild(td4)
            tr.appendChild(td5)
            document.querySelector("#tabla").appendChild(tr)
        })
    })
}

function cargarSelect(url, idSelect, texto, ...campos) {
    obtenerDatos(url).then((datos) => {


        var sEmpleados = document.querySelector(idSelect)
        var option = document.createElement("option")
        option.value = 0
        option.text = `selecciona ${texto}....`
        sEmpleados.appendChild(option)
        datos.forEach(dato => {
            let option = document.createElement("option")
            option.value = dato.id
            var textoCampos = ""
            campos.forEach((campo) => {
                textoCampos = textoCampos + dato[campo] + " "
            })
            option.text = textoCampos
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








//###########################  CLASES   #####################

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
    constructor(id, estado, fecha,) {
        this.id = id;
        this.estado = estado;
        this.fecha = fecha;
    }

}

class Usuarios_estados {
    constructor(id, empleado, estado, jornada, calendario) {
        this.id = id
        this.empleado = empleado
        this.estado = estado
        this.jornada = jornada
        this.calendario = calendario
    }
}
var ue;
var table
// variables
var empleado = new Empleado();
var estado = new Estado();
var calendario = new Calendario();
var jornada = new Jornada();
var url
var url2
var url3
var url4
var estado_usuario = new Usuarios_estados(0,empleado,estado,jornada,calendario);

function cargarTabla() {
    var div = document.querySelector("#capa");
    var divT = document.querySelector(".tabl");
    div.removeChild(divT);

    var div2 = document.createElement("div");
    div2.classList.add("tabl");
    
    div.appendChild(div2);

    table = document.createElement("table");
    table.classList.add("table");
    table.classList.add("table-striped");

    var tr = document.createElement("tr");

    var td1 = document.createElement("td");

    td1.appendChild(document.createTextNode("Empleado"));

    tr.appendChild(td1);
    var td2 = document.createElement("td");
    td2.appendChild(document.createTextNode("Jornada"));
    tr.appendChild(td2);

    var td3 = document.createElement("td");
    td3.appendChild(document.createTextNode("Estado"));
    tr.appendChild(td3);

    var td4 = document.createElement("td");
    td4.appendChild(document.createTextNode("Calendario"));
    tr.appendChild(td4);

    var td5 = document.createElement("td");
    td5.appendChild(document.createTextNode("Acción"));
    tr.appendChild(td5);

    table.appendChild(tr);

    // cargar tabla
    obtenerDatos("api/tabla").then(function (usuarios_estados) {
        usuarios_estados.forEach(function (datos) {

            let tr = document.createElement("tr");

            let td1 = document.createElement("td");
            td1.appendChild(document.createTextNode(datos.empleado.nombre));
            tr.appendChild(td1);
            console.log(datos.empleados_id);

            let td2 = document.createElement("td");
            td2.appendChild(document.createTextNode(datos.jornada.descripcion));
            tr.appendChild(td2);

            let td3 = document.createElement("td");
            td3.appendChild(document.createTextNode(datos.estado.descripcion));
            tr.appendChild(td3);

            let td4 = document.createElement("td");
            td4.appendChild(document.createTextNode(datos.calendario.fecha));
            tr.appendChild(td4);

            let bt = document.createElement("button");
            let url = "api/calendario-empleados/" + datos.id;
            bt.onclick = function () { obtenerDatos(url).then(function (dat) { /*alert(JSON.stringify(dat));*/ ue = dat; cargarSelect(1); }) }
            bt.value = datos.id;
            bt.appendChild(document.createTextNode("Modificar"));
            tr.appendChild(bt);

            table.appendChild(tr);
        })
    })

    div2.appendChild(table);
}
function cargarSelect(val = 0) {

    if (val == 0) {
        // --------  EMPLEADO  ----------------
        obtenerDatos("api/empleados").then(function (empleados) {
            var componente = document.querySelector("#empleados");
            for (let i = componente.options.length; i >= 0; i--) {
                componente.remove(i);
            }

            var optionCabecera = document.createElement("option");
            optionCabecera.text = "selecciona estado..."
            componente.add(optionCabecera);

            empleados.forEach(function (empleado) {
                var option = document.createElement("option");
                option.value = empleado.id;
                option.text = empleado.nombre;
                componente.add(option)

            })
        })
        // --------  ESTADOS  ----------------
        obtenerDatos("estados").then(function (estados) {

            var componente = document.querySelector("#estados");
            for (let i = componente.options.length; i >= 0; i--) {
                componente.remove(i);
            }
            var optionCabecera = document.createElement("option");
            optionCabecera.text = "selecciona estado..."

            componente.add(optionCabecera);

            estados.forEach(function (estado) {
                var option = document.createElement("option");
                option.value = estado.id;
                option.text = estado.descripcion;
                componente.add(option)

            })
        })
        // --------  CALENDARIOS  ----------------
        obtenerDatos("api/calendario/").then(function (calendarios) {

            var componente = document.querySelector("#calendarios");
            for (let i = componente.options.length; i >= 0; i--) {
                componente.remove(i);
            }
            var optionCabecera = document.createElement("option");
            optionCabecera.text = "selecciona estado..."

            componente.add(optionCabecera);

            calendarios.forEach(function (calendario) {
                var option = document.createElement("option");
                option.value = calendario.id;
                option.text = calendario.fecha;
                componente.add(option)

            })
        })
        // --------  JORNADA  ----------------
        obtenerDatos("api/jornada").then(function (jornadas) {
            var componente = document.querySelector("#jornadas");
            for (let i = componente.options.length; i >= 0; i--) {
                componente.remove(i);
            }
            var optionCabecera = document.createElement("option");
            optionCabecera.text = "selecciona estado..."

            componente.add(optionCabecera);

            jornadas.forEach(function (jornada) {
                var option = document.createElement("option");
                option.value = jornada.id;
                option.text = jornada.descripcion;
                componente.add(option)

            })
        })
    } else {
        var componente = document.querySelector("#ue_id");
        componente.value = ue.id;
        // --------  EMPLEADO  ----------------
        obtenerDatos("api/empleados").then(function (empleados) {
            var componente = document.querySelector("#empleados");
            for (let i = componente.options.length; i >= 0; i--) {
                componente.remove(i);
            }
            var optionCabecera = document.createElement("option");
            // console.log(ue.empleado.id === undefined)
            if (ue === undefined)
                optionCabecera.text = "selecciona estado..."
            else
                optionCabecera.text = ue.empleado.nombre;
            optionCabecera.value = ue.empleado.id;
            componente.add(optionCabecera);

            empleados.forEach(function (empleado) {
                var option = document.createElement("option");
                if (ue.empleado.id != empleado.id) {
                    option.value = empleado.id;
                    option.text = empleado.nombre;
                    componente.add(option)
                }
            })
        })
        // --------  ESTADOS  ----------------
        obtenerDatos("estados").then(function (estados) {

            var componente = document.querySelector("#estados");
            for (let i = componente.options.length; i >= 0; i--) {
                componente.remove(i);
            }
            var optionCabecera = document.createElement("option");
            if (ue === undefined)
                optionCabecera.text = "selecciona estado..."
            else
                optionCabecera.text = ue.estado.descripcion;

                optionCabecera.value = ue.estado.id;
            componente.add(optionCabecera);

            estados.forEach(function (estado) {
                var option = document.createElement("option");
                if (ue.estado.id != estado.id) {
                    option.value = estado.id;
                    option.text = estado.descripcion;
                    componente.add(option)
                }
            })
        })
        // --------  CALENDARIOS  ----------------
        obtenerDatos("api/calendario/").then(function (calendarios) {

            var componente = document.querySelector("#calendarios");
            for (let i = componente.options.length; i >= 0; i--) {
                componente.remove(i);
            }
            var optionCabecera = document.createElement("option");
            if (ue === undefined)
                optionCabecera.text = "selecciona estado..."
            else
                optionCabecera.text = ue.calendario.fecha;
                optionCabecera.value = ue.calendario.id;

            componente.add(optionCabecera);

            calendarios.forEach(function (calendario) {
                var option = document.createElement("option");
                if (ue.calendario.id != calendario.id) {
                    option.value = calendario.id;
                    option.text = calendario.fecha;
                    componente.add(option)
                }
            })
        })
        // --------  JORNADA  ----------------
        obtenerDatos("api/jornada").then(function (jornadas) {
            var componente = document.querySelector("#jornadas");
            for (let i = componente.options.length; i >= 0; i--) {
                componente.remove(i);
            }
            var optionCabecera = document.createElement("option");
            if (ue === undefined)
                optionCabecera.text = "selecciona estado..."
            else
                optionCabecera.text = ue.jornada.descripcion;
                optionCabecera.value = ue.jornada.id;
            componente.add(optionCabecera);

            jornadas.forEach(function (jornada) {
                var option = document.createElement("option");
                if (ue.jornada.id != jornada.id) {
                    option.value = jornada.id;
                    option.text = jornada.descripcion;
                    componente.add(option)
                }
            })
        })
        estado_usuario = ue;
    }

}
cargarTabla();
cargarSelect(0);


function guardar() {
    ueValue = document.guarda.ue_id.value;
    // url = "/api/empleados/" + document.guarda.empleados.value;
    // url2 = "api/estado?descripcion=" + document.guarda.estados.value;
    // url3 = "api/calendario/" + document.guarda.calendarios.value;
    // url4 = "api/jornadaId/" + document.guarda.jornadas.value;

    estado_usuario.empleado.id=document.guarda.empleados.value;
    estado_usuario.estado.id=document.guarda.estados.value;
    estado_usuario.calendario.id=document.guarda.calendarios.value;
    estado_usuario.jornada.id=document.guarda.jornadas.value;

    escribirDB(ueValue);
    // console.log(url, url2, url3, url4)

}



///---------------------------------  GUARDAR DATO   -----------------
var escribirDB = (ueValue) => {
    ueValue==0?estado_usuario.id=0:estado_usuario.id=ueValue;
    console.log(JSON.stringify(estado_usuario))
    grabarDatos("/api/calendario-empleado", estado_usuario).then(function (estado_usuario) {
        console.log(estado_usuario)
        cargarTabla();
        cargarSelect();
        if (estado_usuario.id == 0)
            alert("el dato no se ha grabado")
    });
    
}


///-------------------------------------- GRABAR DATOS && OBTENER DATOS  -----------------------------------------------
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
        fetch(url, { "headers": headers }).then(response => response.json()).then(data => { return resolve(data) });
    })
}
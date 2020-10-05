
// var paises = ["españa", "francia", "alemania"];

// class Animal {
//     constructor(nombre, sonido) {
//         this.nombre = nombre;
//         this.sonido = sonido;
//     }

//     emitirSonido() {
//         console.log("el " + this.nombre + " emite el sonido " + this.sonido);
//     }
// }

// class Estado {
//     constructor(id, descripcion, tipo) {
//         this.id = id;
//         this.descripcion = descripcion
//         this.tipo = tipo;
//     }
// }


// class Perro extends Animal {

//     constructor(nombre, sonido, raza) {
//         super(nombre, sonido);
//         this.raza = raza;
//     }

//     getNombre() {
//         return this.nombre;
//     }

//     verPerro() {
//         console.log("El perro es de raza    " + this.raza);
//     }
// }

// function ver(valor = "pepe") {
//     console.log(valor);


// }

var prueba = () => {
    obtenerDatos("/api/tabla").then(function (calendario_empleado) {
        var table = document.createElement("table");
        table.classList.add("table")

        table.classList.add("table-stripped")
        var tr = document.createElement("tr");
        var empleado_col = document.createElement("td");
        var jornada_col = document.createElement("td");
        var estado_col = document.createElement("td");
        var calendario_col = document.createElement("td");
        var accion_col = document.createElement("td");
        empleado_col.appendChild(document.createTextNode("Empleado"));
        jornada_col.appendChild(document.createTextNode("Jornada"));
        estado_col.appendChild(document.createTextNode("Estado"));
        calendario_col.appendChild(document.createTextNode("Calendario"));
        accion_col.appendChild(document.createTextNode("Accion"));
        tr.appendChild(empleado_col)
        tr.appendChild(jornada_col)
        tr.appendChild(estado_col)
        tr.appendChild(calendario_col)
        tr.appendChild(accion_col)

        table.appendChild(tr);
        var btn_modificar = document.createElement("BUTTON");
        btn_modificar.innerHTML = "Modificar";
        var btn_borrar = document.createElement("BUTTON");
        btn_borrar.innerHTML = "Borrar";
        
        
        
        btn_borrar.onclick = function () { borrar() };

        calendario_empleado.forEach(function (calendario_empleado) {

            let tr = document.createElement("tr");

            let empleado_col = document.createElement("td");
            let jornada_col = document.createElement("td");
            let estado_col = document.createElement("td");
            let calendario_col = document.createElement("td");
            let accion_col = document.createElement("td");

            btn_modificar.onclick = function () { modificar(calendario_empleado.id, calendario_empleado.empleado.id, calendario_empleado.jornada.id, calendario_empleado.estado.id, calendario_empleado.calendario.id) };

            empleado_col.appendChild(document.createTextNode(calendario_empleado.empleado.nombre));
            jornada_col.appendChild(document.createTextNode(calendario_empleado.jornada.descripcion));
            estado_col.appendChild(document.createTextNode(calendario_empleado.estado.descripcion));
            calendario_col.appendChild(document.createTextNode(calendario_empleado.calendario.fecha));
            accion_col.appendChild(btn_modificar);
            accion_col.appendChild(btn_borrar);

            tr.appendChild(empleado_col)
            tr.appendChild(jornada_col)
            tr.appendChild(estado_col)
            tr.appendChild(calendario_col)
            tr.appendChild(accion_col)

            table.appendChild(tr);
            console.log(calendario_empleado.id)
        })

        document.querySelector("#tabla").appendChild(table);
    })

    obtenerDatos("api/empleados").then(function (empleados) {
        var componente = document.querySelector("#empleados");

        var optionCabecera = document.createElement("option");
        optionCabecera.text = "selecciona empleado..."

        componente.add(optionCabecera);

        empleados.forEach(function (empleado) {
            var option = document.createElement("option");
            option.text = empleado.nombre;
            option.value = empleado.id;
            componente.add(option)

        })

    })

    obtenerDatos("api/jornada").then(function (jornadas) {
        var componente = document.querySelector("#jornadas");

        var optionCabecera = document.createElement("option");
        optionCabecera.text = "selecciona jornada..."

        componente.add(optionCabecera);

        jornadas.forEach(function (jornada) {
            var option = document.createElement("option");
            option.text = jornada.descripcion;
            option.value = jornada.id;
            componente.add(option)

        })

    })

    obtenerDatos("estados").then(function (estados) {
        var componente = document.querySelector("#estados");

        var optionCabecera = document.createElement("option");
        optionCabecera.text = "selecciona estado..."

        componente.add(optionCabecera);

        estados.forEach(function (estado) {
            var option = document.createElement("option");
            option.text = estado.descripcion;
            option.value = estado.id;
            componente.add(option)

        })

    })

    obtenerDatos("api/calendario/").then(function (calendarios) {
        var componente = document.querySelector("#calendarios");

        var optionCabecera = document.createElement("option");
        optionCabecera.text = "selecciona fecha..."

        componente.add(optionCabecera);

        calendarios.forEach(function (calendario) {
            var option = document.createElement("option");
            option.text = calendario.fecha;
            option.value = calendario.id;
            componente.add(option)

        })

    })
}

function modificar(id, idEmpleado, idJornada, idEstado, idCalendario,btn_registrar) {
    console.log("Botón modificar")
    console.log(id)
    document.getElementById("empleados").value = idEmpleado
    document.getElementById("jornadas").value = idJornada
    document.getElementById("estados").value = idEstado
    document.getElementById("calendarios").value = idCalendario   

    
    btn_registrar.onclick = function () { registrar(calendario_empleado.id, calendario_empleado.empleado.id, calendario_empleado.jornada.id, calendario_empleado.estado.id, calendario_empleado.calendario.id) };
}

function borrar() {
    console.log("Botón borrar")
}

function registrar(id, idEmpleado, idJornada, idEstado, idCalendario){
    console.log("Botón registrar")
    
}

// var saludar = () => {
//     var estado = new Estado(0, "nuevo estado desde javascript", 1);
//     console.log(JSON.stringify(estado))
//     grabarDatos("api/estados", estado).then(function (estado) {

//         if (estado.id == 0)
//             alert("el dato no se ha grabado")

//     })


//     obtenerDatos("estados").then(function (estados) {





//         var componente = document.querySelector("#estados");

//         var optionCabecera = document.createElement("option");
//         optionCabecera.text = "selecciona estado..."

//         componente.add(optionCabecera);

//         estados.forEach(function (estado) {
//             var option = document.createElement("option");
//             option.text = estado.descripcion;
//             componente.add(option)

//         })

//         var table = document.createElement("table");
//         table.classList.add("table")

//         table.classList.add("table-stripped")
//         //table.border=1;
//         var tr = document.createElement("tr");
//         var td1 = document.createElement("td");
//         var td2 = document.createElement("td");
//         td1.appendChild(document.createTextNode("identificador"));
//         td2.appendChild(document.createTextNode("descripcion"));
//         tr.appendChild(td1)
//         tr.appendChild(td2)
//         table.appendChild(tr);
//         estados.forEach(function (estado, contador) {

//             let tr = document.createElement("tr");

//             if (contador % 2 == 0)
//                 tr.classList.add("text-success");
//             else
//                 tr.classList.add("text-danger");


//             let td1 = document.createElement("td");
//             let td2 = document.createElement("td");
//             td1.appendChild(document.createTextNode(estado.id));
//             td2.appendChild(document.createTextNode(estado.descripcion));
//             tr.appendChild(td1)
//             tr.appendChild(td2)
//             table.appendChild(tr);
//         })

//         document.querySelector("#capa").appendChild(table);
//     })
// }


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







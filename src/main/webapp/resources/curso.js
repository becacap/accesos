
var paises = ["españa", "francia", "alemania"];

class Animal {
    constructor(nombre, sonido) {
        this.nombre = nombre;
        this.sonido = sonido;
    }

    emitirSonido() {
        console.log("el " + this.nombre + " emite el sonido " + this.sonido);
    }
}




class Perro extends Animal {

    constructor(nombre, sonido, raza) {
        super(nombre, sonido);
        this.raza = raza;
    }

    getNombre() {
        return this.nombre;
    }

    verPerro() {
        console.log("El perro es de raza    " + this.raza);
    }
}

function ver(valor = "pepe") {
    console.log(valor);


}

var saludar = () => {




    var estado = new Estado(0, "nuevo estado desde javascript", 1);
    console.log(JSON.stringify(estado))
    grabarDatos("api/estados", estado).then(function (estado) {

        if (estado.id == 0)
            alert("el dato no se ha grabado")

    })


    obtenerDatos("estados").then(function (estados) {





        var componente = document.querySelector("#estados");

        var optionCabecera = document.createElement("option");
        optionCabecera.text = "selecciona estado..."

        componente.add(optionCabecera);

        estados.forEach(function (estado) {
            var option = document.createElement("option");
            option.text = estado.descripcion;
            componente.add(option)

        })

        var table = document.createElement("table");
        table.classList.add("table")

        table.classList.add("table-stripped")
        //table.border=1;
        var tr = document.createElement("tr");
        var td1 = document.createElement("td");
        var td2 = document.createElement("td");
        td1.appendChild(document.createTextNode("identificador"));
        td2.appendChild(document.createTextNode("descripcion"));
        tr.appendChild(td1)
        tr.appendChild(td2)
        table.appendChild(tr);
        estados.forEach(function (estado, contador) {

            let tr = document.createElement("tr");

            if (contador % 2 == 0)
                tr.classList.add("text-success");
            else
                tr.classList.add("text-danger");


            let td1 = document.createElement("td");
            let td2 = document.createElement("td");
            td1.appendChild(document.createTextNode(estado.id));
            td2.appendChild(document.createTextNode(estado.descripcion));
            tr.appendChild(td1)
            tr.appendChild(td2)
            table.appendChild(tr);
        })

        document.querySelector("#capa").appendChild(table);
    })
}


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
    constructor(id, estado, fecha,) {
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

function cargaDatos() {
    obtenerDatos("api/calendario/usuariosEstados").then(function (usuariosEstados) {
        console.log(usuariosEstados)
        var tabla = document.querySelector("#tablaUE");
        usuariosEstados.forEach(function(usuarioEstado){
            var tr= document.createElement("tr");
            var td1=document.createElement("td")
            var td2=document.createElement("td")
            var td3=document.createElement("td")
            var td4=document.createElement("td")
            var td5=document.createElement("td")
            td1.appendChild(document.createTextNode(`${usuarioEstado.empleado.nombre} ${usuarioEstado.empleado.apellidos}`))
            td2.appendChild(document.createTextNode(`${usuarioEstado.jornada.descripcion}`))
            td3.appendChild(document.createTextNode(`${usuarioEstado.estado.descripcion}`))
            td4.appendChild(document.createTextNode(`${usuarioEstado.calendario.fecha}`))
            var botonModificar=document.createElement("button")
            botonModificar.classList.add("bg-success");
            var botonBorrar= document.createElement("button")
            botonBorrar.classList.add("bg-danger")
            td5.appendChild(botonModificar)
            td5.appendChild(botonBorrar)
            tr.appendChild(td1)
            tr.appendChild(td2)
            tr.appendChild(td3)
            tr.appendChild(td4)
            tr.appendChild(td5)
            tabla.appendChild(tr)
        })

    })


}







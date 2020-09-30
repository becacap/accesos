generarTabla();

var saludar = () => {

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

function generarTabla() {
    obtenerDatos("/api/usuario-estado").then(function (usuariosEmpleados) {

        var table = document.createElement("table");
        table.classList ="table table-hover"

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

            var modificar = document.createElement("button");
            modificar.innerText="Modificar";
            var eliminar = document.createElement("button");
            eliminar.innerText="Eliminar";

            td1.appendChild(document.createTextNode(usuarioEmpleado.empleado.nombre));
            td2.appendChild(document.createTextNode(usuarioEmpleado.estado.descripcion));
            td3.appendChild(document.createTextNode(usuarioEmpleado.calendario.fecha));
            td4.appendChild(document.createTextNode(usuarioEmpleado.jornada.lunes));
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
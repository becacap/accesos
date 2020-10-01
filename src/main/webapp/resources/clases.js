class Jornada {
    constructor(id, lunes, martes, miercoles, jueves, viernes, descripcion, especial) {
        this.id = id;
        this.lunes = lunes;
        this.martes = martes;
        this.miercoles = miercoles;
        this.jueves = jueves;
        this.viernes = viernes;
        this.descripcion = descripcion;
        this.estado = especial;
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

class Estado {
    constructor(id, descripcion, tipo) {
        this.id = id;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }
}

class Calendario {
    constructor(id, fecha, estado) {
        this.id = id;
        this.fecha = fecha;
        this.estado = estado;
    }
}

class Usuario_Estado {
    constructor(id, empleado, estado, calendario, jornada) {
        this.id = id;
        this.empleado = empleado;
        this.estado = estado;
        this.calendario = calendario;
        this.jornada = jornada;
    }
}
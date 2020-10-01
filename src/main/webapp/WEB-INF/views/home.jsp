<!DOCTYPE html>



<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejemplo html</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="./resources/curso.js"></script>
    <script src="./resources/clases.js"></script>


</head>

<body>
    <div class="container">
        <div id="capa"></div>

        <form action="">
            <input type="hidden" id="idRegistro" value="0">
            <div class="form-group">
                <label>Empleado:</label>
                <select id="empleados" class="form-control"></select>
            </div>
            <div class="form-group">
                <label>Estado:</label>
                <select id="estados" class="form-control"></select>
            </div>
            <div class="form-group">
                <label>Calendario:</label>
                <select id="calendarios" class="form-control"></select>
            </div>
            <div class="form-group">
                <label>Jornadas:</label>
                <select id="jornadas" class="form-control"></select>
            </div>
            <input type="button" value="Aceptar" onclick="recogerFormulario()">

            <!--<br><input type="date" id="fecha">
            <br><input type="time" id="hora">-->
        </form>

    </div>
</body>

</html>

</html>
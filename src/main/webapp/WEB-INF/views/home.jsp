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
    <!-- <script src="./resources/curso.js"></script> -->
   


</head>

<body>
    <div class="container">
        <h1 class="">EJEMPLO USUARIOS-ESTADOS</h1>


        <!-- <button onclick="generarTabla()">Saludar</button> -->

        
        <div id="capa">
            <div id="tabl" class="tabl"></div>
        </div>
        <br>
        <br>
        <br>
    

        <!-- <input type="date" id="fecha"> -->
        <form name="guarda" action="">
            <input  type="hidden" id="ue_id"  value="0">
            Empleado:
            <select id="empleados"></select>
            <br>
            <div id="prueba"></div>
            <br>
            Estados:
            <select id="estados"></select>
            <br>
            <br>
            Calendarios:
            <select id="calendarios"></select>
            <br>
            <br>
            Jornada:
            <select id="jornadas"></select>
            <br>
            <br>
            <button  type="button" onclick="guardar()">Guardar</button>
        </form>
       
    </div>
    <script src="./resources/tabla.js"></script>
</body>

</html>

</html>
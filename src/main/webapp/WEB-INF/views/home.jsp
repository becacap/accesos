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

    
</head>

<body>
    <div class="container">
        <!-- <h1 class="pepe">EJEMPLO DE SELECTORES</h1>
        <h1>EJEMPLO DE SELECTORES</h1>
        <h1 id="pepe" class="pepe">EJEMPLO DE SELECTORES</h1>
        <h1>EJEMPLO DE SELECTORES</h1>
        <h1 class="pepe">EJEMPLO DE SELECTORES</h1>
        <div>
            <h1>EJEMPLO DE SELECTORES</h1>
        </div> -->


        <button onclick="prueba()">Generar tabla</button>

        
        
        <!-- <div id="tablausuariosestados"></div> -->
        <div id="tabla">

        </div>
        <form action="">
            Empleados:<select id="empleados"></select>
            <br>
            Jornadas:<select id="jornadas"></select>
            <br>
            Estados: <select id="estados"></select>
            <br>
            Calendarios: <select id="calendarios"></select>


        </form>     
        <button onclick="registrar()">Registrar</button>
    </div>
</body>

</html>

</html>
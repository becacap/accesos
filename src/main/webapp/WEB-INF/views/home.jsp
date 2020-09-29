<!DOCTYPE html>



<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejemplo html</title>

    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    
    <script src="./resources/curso.js"></script>
    
</head>

<body>
    <div class="container">

        <header class="bg-primary p-3 d-flex justify-content-center">
            <h1>Usuarios Estados</h1>
        </header>

        <main class="p-3">

            <table class="table table-hover">
                <tr>
                    <td>Empleado</td>
                    <td>Jornada</td>
                    <td>Estado</td>
                    <td>Calendario</td>
                    <td>Actions</td>
                </tr>
                <tr>
                    <td>ejemplo1</td>
                    <td>ejemplo1</td>
                    <td>ejemplo1</td>
                    <td>ejemplo1</td>
                    <td>
                        <button><i class="material-icons">edit</i></button>
                        <button><i class="material-icons">delete</i></button>
                    </td>
                </tr>
            </table>

            <form action="">
                <div class="form-group">
                    <label></label>
                    <input type="text" class="form-control">
                  </div>
            </form>

            <!-- <button onclick="saludar()" class="">Saludar</button> -->

            <!-- <form action="">
                estados:
                <select id="estados"></select>
                <br>
                <input type="date" id="fecha">
            </form> -->
        </main>

        <footer class="p-3 d-flex justify-content-center">

        </footer>
    </div>
</body>

</html>

</html>
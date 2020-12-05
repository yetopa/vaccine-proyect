<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>

    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <title>Vet | Login</title>

    <link href="../css/bootstrap.min.css" th:href="@{css/bootstrap.min.css}" rel="stylesheet" media="screen"/>
    <link href="../font-awesome/css/font-awesome.css" th:href="@{font-awesome/css/font-awesome.css}" rel="stylesheet" media="screen"/>

    <link href="../css/animate.css" th:href="@{css/animate.css}" rel="stylesheet" media="screen"/>
    <link href="css/style.css" th:href="@{css/style.css}" rel="stylesheet" media="screen"/>

</head>

<body class="gray-bg">

    <div class="middle-box text-center loginscreen animated fadeInDown">
        <div>
            <div>

                <h1 class="logo-name">CVMF</h1>

            </div>
            <h3>Bienvenido a CVMF</h3>
            <p>Tus fieles amigos son nuestra prioridad
            </p>
            <p>Ingreso.</p>
			<p th:if="${loginError}" class="error">Wrong user or password</p>            
            <form th:action="@{/login}" method="post">
                <div class="form-group">
                    <input type="text"  id="username" name="username" autofocus="autofocus" class="form-control" placeholder="Usuario" required="" />
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" placeholder="Contrase&ntilde;a" required="" id="password" name="password" />
                </div>
                <button type="submit" name="submit" class="btn btn-primary block full-width m-b">Ingresar</button>
            </form>
            <p class="m-t"> <small>Clinica veterinaria mascotas felices &copy; 2017</small> </p>
        </div>
    </div>

    <!-- Mainly scripts -->
    <script src="../js/jquery-2.1.1.js" th:src="@{js/jquery-2.1.1.js}" ></script>
    <script src="../js/bootstrap.min.js" th:src="@{js/bootstrap.min.js}"></script>

</body>

</html>

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<head>
   <meta charset="utf-8"/>
   <link href="../css/template.css" th:href="@{css/template.css}" rel="stylesheet" media="screen"/>
</head>

<body>

<div >

    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav metismenu" id="side-menu">
                <li class="nav-header">
                    <div class="dropdown profile-element">
                    		<span><img alt="image" class="img-circle" src="img/profile_small.jpg" /></span>
                            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <span class="clear"> <span class="block m-t-xs"> <strong class="font-bold">David Williams</strong>
                             </span> <span class="text-muted text-xs block">Art Director <b class="caret"></b></span> </span> </a>
                            <ul class="dropdown-menu animated fadeInRight m-t-xs">
                                <li><a href="#">Logout</a></li>
                            </ul>
                    </div>
                    <div class="logo-element">
                       <!-- IN +--><img src="img/logo_vete.png" class="img-circle"/>
                    </div>
                </li>
                <li class="active">
                	<a href="#" id="loadDashboard"><i class="fa fa-hospital-o"></i> <span class="nav-label">Dashboard</span></a>
                </li>
                <li >
                    <a href="#" id="loadIndex"><i class="fa fa-hospital-o"></i> <span class="nav-label">Inicio</span></a>
                </li>

            </ul>

        </div>
    </nav>
</div>

<!-- Mainly scripts -->
<script src="../js/jquery-2.1.1.js" th:src="@{js/jquery-2.1.1.js}" ></script>
<script src="../js/jquery-ui-1.10.4.min.js" th:src="@{js/jquery-ui-1.10.4.min.js}" ></script>
<script src="../js/bootstrap.min.js" th:src="@{js/bootstrap.min.js}"></script>
<script src="../js/plugins/metisMenu/jquery.metisMenu.js" th:src="@{js/plugins/metisMenu/jquery.metisMenu.js}"></script>
<script src="../js/plugins/slimscroll/jquery.slimscroll.min.js" th:src="@{js/plugins/slimscroll/jquery.slimscroll.min.js}"></script>

<!-- Custom and plugin javascript -->
<script src="../js/plugins/pace/pace.min.js" th:src="@{js/plugins/pace/pace.min.js}"></script>
<script src="../js/plugins/toastr/toastr.min.js" th:src="@{js/plugins/toastr/toastr.min.js}"></script>
<script src="../js/service/client.js" th:src="@{js/service/client.js}"></script>

 <!-- jQuery UI -->
<script src="js/plugins/jquery-ui/jquery-ui.min.js"></script>



<script>
  $( function() {
	 $("#loadDashboard").on("click", function () {
		 $.ajax({
				url: "/dashboard",
				success: function(response) {
		            $("#body").html( response );
		        }
			});
	 });
	 $("#loadIndex").on("click", function() {
		 $("#body").load("index.html");		 
	 }); 


  } );
 </script>
</body>

</html>


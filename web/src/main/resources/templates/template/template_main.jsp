<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<head>
   <meta charset="utf-8"/>
   <link href="../css/template.css" th:href="@{css/template.css}" rel="stylesheet" media="screen"/>
</head>

<body>

<div id="wrapper">
	
	<div id="menu">
	</div>
	
	 <div id="page-wrapper" class="gray-bg dashbard-1">
        <div id="header" >
           <!-- cabecera -->
        </div>
        <div id="body" >
        </div>
        <div  id="footer">
           <!-- pie -->
        </div>

    </div>
</div>

<!-- Mainly scripts -->
<script src="../js/jquery-2.1.1.js" th:src="@{js/jquery-2.1.1.js}" ></script>
<script src="../js/jquery-ui-1.10.4.min.js" th:src="@{js/jquery-ui-1.10.4.min.js}" ></script>
<script src="../js/bootstrap.min.js" th:src="@{js/bootstrap.min.js}"></script>
<script src="../js/plugins/metisMenu/jquery.metisMenu.js" th:src="@{js/plugins/metisMenu/jquery.metisMenu.js}"></script>
<script src="../js/plugins/slimscroll/jquery.slimscroll.min.js" th:src="@{js/plugins/slimscroll/jquery.slimscroll.min.js}"></script>

<!-- Custom and plugin javascript -->
<script src="../js/plugins/pace/pace.min.js" th:src="@{js/plugins/pace/pace.min.js}"></script>
<script src="../js/plugins/pace/pace.min.js" th:src="@{js/plugins/pace/pace.min.js}"></script>
<script src="../js/plugins/toastr/toastr.min.js" th:src="@{js/plugins/toastr/toastr.min.js}"></script>
<script src="../js/service/client.js" th:src="@{js/service/client.js}"></script>

<script>
  $( function() {
	  $("#menu").load("menu");
	  $("#header").load("header");
	  $("#footer").load("footer");
	  $.ajax({
					url: "/dashboard",
					success: function(response) {
			            $("#body").html( response );
			        }
	  });
	  
	  $("#body").load("dashboard")
  } );
 </script>
</body>

</html>

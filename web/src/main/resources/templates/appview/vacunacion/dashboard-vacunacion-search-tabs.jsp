<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
  
</head>

<body>
<!-- html -->
	    <ul class="nav nav-tabs">
           <li class="active"><a data-toggle="tab" href="#div-result-search-vacunacion" onclick="searchCustomer();"><i class="fa fa-user"></i>Pacientes</a></li>
           <li ><a data-toggle="tab" href="#div-dashboard-vacunacion-new" onclick="showNewCustomer();"><i class="fa fa-user"></i>Triaje</a></li>
        </ul>
<!-- JavaScript -->
<script>
  "use strict";	
  $( function() {
	  searchCustomer();
  } );
  
  function showNewCustomer() {
	  
	  $.ajax({
			url: "/dashboard/vacunacion/show/new",
			success: function(response) {
	            $("#div-dashboard-vacunacion-new").html( response );
	        }
		});
  }
</script>
</body>

</html>
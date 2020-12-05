<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
  
</head>

<body>
<!-- html -->
	    <ul class="nav nav-tabs">
           <li class="active"><a data-toggle="tab" href="#div-result-search-vacunacion" onclick="searchCustomer();"><i class="fa fa-user"></i>Pacientes</a></li>
                   </ul>
<!-- JavaScript -->
<script>
  "use strict";	
  $( function() {
	  // searchCustomer();
  } );
  
  function showCitas() {
	  
	  $.ajax({
			url: "/dashboard/vacunacion/show/new",
			success: function(response) {
                toastr.options = {
                    closeButton: true,
                    debug: false,
                    progressBar: true,
                    showMethod: 'slideDown',
                    timeOut: 4000
                };
                if (data.code === 200){
                    $("#div-dashboard-vacunacion-new").html( response );
                } else {
                    toastr.error(data.message, 'Message');
                }
	        }
		});
  }
</script>
</body>

</html>
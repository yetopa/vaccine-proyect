<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
  
</head>

<body>
<!-- html -->
	<!-- section for searh customer -->
	<div class="col-sm-8">
		<div class="ibox">
			<div class="ibox-content">
				<span class="text-muted small pull-right">
					Actualizado: <i class="fa fa-clock-o" /> <span th:text = '${updatedate}'/> 
				</span>
				
	                  <p>
	                      En esta pesta&ntilde;a pordra buscar a sus pacientes.
	                  </p>
	                  <div class="input-group">
	                        <input id="paramSearchVacunacion" type="text" placeholder="Busqueda de clientes " class="input form-control"/>
	                        <span class="input-group-btn">
	                                <button type="button" class="btn btn btn-primary" onclick="searchPaciente();"> <i class="fa fa-search"></i> Buscar</button>
	                        </span>
	                   </div>
			</div>
		</div>
	</div>
	<div class="col-sm-8">
		<div class="ibox">
			<div class="ibox-content">
	                   <div id ="div-search-vacunacion-tag" class="clients-list">
	                   		<!-- div for show the customer list search -->
	                   </div>
			</div>
		</div>
	</div>
	
<!-- JavaScript -->
<script src="js/service/appview/vacunacion/vacunacion.js"></script>
<script>
  "use strict";	
  $( function() {
	  $.ajax({
			url: "/dashboard/vacunacion/show/vacunacionSearchTag",
			success: function(response) {
	            $("#div-search-vacunacion-tag").html( response );
	        }
		});
	  $('#paramSearchVacunacion').focus();
  } );
</script>
</body>

</html>
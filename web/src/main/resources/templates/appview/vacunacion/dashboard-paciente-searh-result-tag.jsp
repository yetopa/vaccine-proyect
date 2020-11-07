<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
  
</head>

<body>
<!-- html -->

<div class="full-height-scroll">
	<div  th:unless="${#lists.isEmpty(dashboardPaciente)}" class="table-responsive">
		<table class="footable table table-striped table-hover">
			<tbody>
				<tr th:if="${dashboardPaciente != null}" th:each="paciente,iterStart : ${dashboardPaciente}">
                       <td><a data-toggle="tab" href="#contact-1" class="client-link"
                                th:text="${paciente.nombre + ' ' + paciente.apellidoPaterno +' ' + paciente.apellidoMaterno}"></a></td>
                       <td th:text="${paciente.dni}"></td>
                       <td class="contact-type"><i class="fa fa-envelope"> </i></td>
                       <td th:text="${paciente.fechaNacimiento}"></td>
                 	</tr>
			</tbody>
			<tfoot>
      <tr>
          <td colspan="5">
              <ul class="pagination pull-right"></ul>
          </td>
      </tr>
      </tfoot>
		</table>
	</div>
</div>
<script src="js/plugins/footable/footable.all.min.js"></script>
<!-- JavaScript -->
<script>
  "use strict";	
  $( function() {
	  $('.footable').footable();
  } );
</script>
</body>

</html>
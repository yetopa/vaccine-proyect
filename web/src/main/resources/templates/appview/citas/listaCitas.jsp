<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
  
</head>

<body>
<!-- html -->

<div class="full-height-scroll">
	<div  th:unless="${#lists.isEmpty(listaCitas)}" class="table-responsive">
		<table class="footable table table-striped table-hover">
		        <thead>
        <tr>
            <th scope="col">Nombre</th>
            <th/>
            <th scope="col">DNI</th>
            <th/>
            <th scope="col">F. Nacimiento</th>
            <th scope="col">Edad Meses</th>
            <th scope="col">Sexo</th>
            <th scope="col">F. Cita</th>
        </tr>
    </thead>
			<tbody>
				<tr th:if="${listaCitas != null}" th:each="cita,iterStart : ${listaCitas}">
                       <td><a data-toggle="tab" href="#contact-1" class="client-link"
                                th:text="${cita.nombre + ' ' + cita.apellidoPaterno +' ' + cita.apellidoMaterno}"></a></td>
                        <td class="contact-type"><i class="fa fa-credit-card"> </i></td>
                        <td th:text="${cita.dni}"></td>
                       <td class="contact-type"><i class="fa fa-calendar"> </i></td>
                        <td th:text="${cita.fechaNacimiento}"></td>
                        <td th:text="${#strings.toString(cita.edadMeses) + ' Meses'}"></td>
                       <td th:text="${cita.sexo}"></td>
                       <td th:text="${cita.fecha}"></td>
                       <td><button type="button" class="btn btn-primary" th:attr="onclick='atenderCita(\'' + ${cita.dni}+'\')'" >Aceptar</button></td>
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
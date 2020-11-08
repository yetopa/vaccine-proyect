<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
   <meta charset="utf-8"/>
   <link href="../css/template.css" th:href="@{css/template.css}" rel="stylesheet" media="screen"/>
   <link href="../css/animate.css" th:href="@{css/animate.css}" rel="stylesheet" media="screen"/>
   <link href="css/plugins/datapicker/datepicker3.css" rel="stylesheet"/>
</head>

<body>

<div class="wrapper wrapper-content  animated fadeInRight">
	<div class="row">
		<div id="div-dashboard-vacunacion">
			<!-- show page list customer -->
		</div>
		<div class="col-sm-4">
			<div class="ibox">
				<div class="ibox-content">
					<div class="tab-content">
						<div id="contact-1" class="tab-pane active">
							<div class="row m-b-lg">
                                        <div class="col-lg-4 text-center">
                                            <div class="m-b-sm">
                                                <img alt="image" class="img-circle" src="img/vacuna-campania.png"
                                                     style="width: 350px"/>
                                            </div>
                                        </div>

                                    </div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<div id="show-paciente" class="modal inmodal" role="dialog" aria-hidden="true" >
	<input type="hidden" id="show-paciente-pacienteId" />
	<div class="modal-dialog">
		<div class="modal-content animated fadeInDownBig">
			<div class="modal-header">
				<a class="list-group-item active" href="#">
					<h1 class="font-bold">Triaje</h1>
				</a>
			</div>
			<div class="modal-body" align="center">
				<div class="form-horizontal">
					<div class="form-group">

						<div class="col-xs-3">
							<label for="numero_documento" >Número D.:</label>
							<input type="text" class="form-control" id="numero_documento" placeholder="Dni" readonly/>
						</div>

						<div class="col-xs-7">
							<label for="nombre_completo" class="control-label col-xs-4">Nombre:</label>
							<input type="text" class="form-control" id="nombre_completo" placeholder="F.C. (/minuto)" readonly/>
						</div>

						<div class="col-xs-3">
							<label for="fecha_nacimiento" >Fecha Nacimiento:</label>
							<input type="text" class="form-control" id="fecha_nacimiento" placeholder="F.R. (/minuto)" readonly/>
						</div>

						<div class="col-xs-2">
							<label for="edad_meses" >Edad Meses:</label>
							<input type="text" class="form-control" id="edad_meses" placeholder="Edad(meses)" readonly/>
						</div>
						<div class="col-xs-2">
							<label for="grupo_sanguineo" >Grupo Sanguineo:</label>
							<input type="text" class="form-control" id="grupo_sanguineo" placeholder="O+" readonly/>
						</div>
					</div>
					<br>
					<div class="form-group" id="fec_paciente_div">
						<label for="fec_cliente" class="col-lg-3 control-label">F. de Atención:</label>
						<div class="col-xs-5">
							<div class="input-group date">
								<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
								<input type="text" class="form-control span2" id="fec_cliente" />
							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-xs-3">Centro Salud:</label>
						<div class="col-xs-7">
							<input  class="form-control" readonly value="HOSPITAL DE APOYO SANTA ROSA">  </input>
						</div>
					</div>

					<div class="form-group">
						<label for="diagnostico_consulta" class="control-label col-xs-2">Peso:</label>
						<div class="col-xs-5">
							<input rows="3" class="form-control" placeholder="Peso(kg)"></input>
						</div>
					</div>

					<div class="form-group">
						<label for="diagnostico_consulta" class="control-label col-xs-2">Talla:</label>
						<div class="col-xs-5">
							<input rows="3" class="form-control" placeholder="Talla(cm)"></input>
						</div>
					</div>
					<div class="form-group">
						<label for="diagnostico_consulta" class="control-label col-xs-2">Pc:</label>
						<div class="col-xs-5">
							<input rows="3" class="form-control" placeholder="cm"></input>
						</div>
					</div>

				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" data-dismiss="modal">
					<i class="fa fa-times">Guardar</i>
				</button>
				<button type="button" class="btn btn-danger" data-dismiss="modal">
					<i class="fa fa-times">Cerrar</i>
				</button>
			</div>
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
<script src="../js/plugins/toastr/toastr.min.js" th:src="@{js/plugins/toastr/toastr.min.js}"></script>
<script src="../js/jquery.blockUI.js" th:src="@{js/jquery.blockUI.js}"></script>

<script src="js/plugins/validate/jquery.validate.min.js"></script>
<script src="js/plugins/staps/jquery.steps.min.js"></script>
<!-- FooTable -->
<script src="js/service/appview/dashboard.js"></script>
<script src="js/service/utilFunction.js"></script>

<script src="../js/bootstrap-datepicker.js" th:src="@{js/bootstrap-datepicker.js}"></script>
<script src="../js/locales/bootstrap-datepicker.es.js" th:src="@{js/locales/bootstrap-datepicker.es.js}"></script>
<script src="js/plugins/datapicker/bootstrap-datepicker.js"></script>
<script>
  "use strict";	
  $(document).ajaxStart($.blockUI).ajaxStop($.unblockUI);
  $( function() {
	  /* set title for current page */
	  setTitlePage("Dashboard");

	  loadSearchVacunacion();
  } );

  function showTriaje(pacienteId) {
	  $(document).ajaxStart($.blockUI).ajaxStop($.unblockUI);
	 "use strict";

	  var url = "/paciente/".concat(pacienteId).concat("/byDni");

	  $('#show-paciente-pacienteId').val(pacienteId);

	  $.get(url, function (paciente){
		  $('#show-paciente').modal('toggle');
		  $("#numero_documento").val(paciente.data.dni);
		  $("#nombre_completo").val(paciente.data.nombre + " " + paciente.data.apellidoPaterno + " " + paciente.data.apellidoMaterno);
		  $("#fecha_nacimiento").val(paciente.data.fechaNacimiento);
		  $("#edad_meses").val(paciente.data.edadMeses);

		  console.log(paciente.data);
	  }, "json");
  }
</script>

</body>

</html>

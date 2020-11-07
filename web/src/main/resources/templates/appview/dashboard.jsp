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
<script>
  "use strict";	
  $(document).ajaxStart($.blockUI).ajaxStop($.unblockUI);
  $( function() {
	  /* set title for current page */
	  setTitlePage("Dashboard");

	  loadSearchVacunacion();
  } );
</script>

</body>

</html>

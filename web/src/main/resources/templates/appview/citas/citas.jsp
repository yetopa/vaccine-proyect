<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
   <meta charset="utf-8"/>
   <link href="../css/template.css" th:href="@{css/template.css}" rel="stylesheet" media="screen"/>
   <link href="../css/animate.css" th:href="@{css/animate.css}" rel="stylesheet" media="screen"/>
   <link href="css/plugins/datapicker/datepicker3.css" rel="stylesheet"/>
    <link href="css/style.css" th:href="@{css/style.css}" rel="stylesheet" media="screen"/>
    <link href="css/plugins/chosen/chosen.css" rel="stylesheet"/>
    <link href="css/plugins/datapicker/datepicker3.css" rel="stylesheet"/>
</head>

<body>
<div class="wrapper wrapper-content  animated fadeInRight">
	<div class="row">
		<div id="div-lista-citas">
			<!-- show page list customer -->
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
<script src="js/service/appview/citas/citas.js"></script>
<script src="js/service/utilFunction.js"></script>

<script src="../js/bootstrap-datepicker.js" th:src="@{js/bootstrap-datepicker.js}"></script>
<script src="../js/locales/bootstrap-datepicker.es.js" th:src="@{js/locales/bootstrap-datepicker.es.js}"></script>
<script src="../js/plugins/datapicker/bootstrap-datepicker.js"></script>
<script>
$(document).ajaxStart($.blockUI).ajaxStop($.unblockUI);
$( function() {       
	setTitlePage("Dashboard");

	loadLisaCitas();
	
});
</script>	



</body>

</html>

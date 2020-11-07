<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<head>
   <meta charset="utf-8"/>
   <link href="../css/template.css" th:href="@{css/template.css}" rel="stylesheet" media="screen"/>
</head>

<body>
  <div class="row border-bottom">
         <nav class="navbar navbar-static-top white-bg" role="navigation" style="margin-bottom: 0">
             <div class="col-lg-8">
                 <div id="pageTitle">
                 	<h2>Bienvenido</h2>
                 	 <ol class="breadcrumb">
                        <li>
                            <a href="#"></a>
                        </li>
                        <li>

                        </li>
                        <li class="active">
                            <strong></strong>
                        </li>
                    </ol>
                 </div>
             </div>
             <div class="col-lg-4 ">
             	<div class="title-action">
             		<div id="buttonHeaders"  class="text-right">
             		</div>
             	</div>
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
<script src="../js/plugins/pace/pace.min.js" th:src="@{js/plugins/pace/pace.min.js}"></script>
<script src="../js/plugins/toastr/toastr.min.js" th:src="@{js/plugins/toastr/toastr.min.js}"></script>
<script src="../js/service/client.js" th:src="@{js/service/client.js}"></script>
<script >
	"use strict";
	function setTitlePage(title){
		$("div#pageTitle h2").html(title);
	}
	
	function setButtons(buttons){
		var htmlButtons = '';
		console.log(buttons);
		buttons.forEach(function(btnButton){
			htmlButtons+=btnButton;
		});
		$("div#buttonHeaders").html(htmlButtons);
	}
</script>
</body>

</html>

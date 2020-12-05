<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
  
</head>

<body>
<!-- html -->
<div class="clients-list">
		<div id="div-dashboard-search-vacunacion-tabs">
       		<!-- div with tabs -->
       </div>
       
       <div class="tab-content">
	       	<div id="div-result-search-vacunacion" class="tab-pane active">
	       	</div>
	     </div>
       
</div>
<!-- JavaScript -->
<script>
  "use strict";	
  $( function() {
	  $.ajax({
			url: "/dashboard/vacunacion/show/searchTabs",
			success: function(response) {
	            $("#div-dashboard-search-vacunacion-tabs").html( response );
	        }
		});
  } );
</script>
</body>

</html>
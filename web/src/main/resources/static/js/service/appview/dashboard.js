
/*
 * show page with the html code for  customers search
 * */
function loadSearchVacunacion() {
	 $.ajax({
			url: "/dashboard/vacunacion/show",
			success: function(response) {
	            $("#div-dashboard-vacunacion").html( response );
	        }
	  });
}
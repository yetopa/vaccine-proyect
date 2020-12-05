
/*
 * show page with the html code for  customers search
 * */
function loadLisaCitas() {
	 $.ajax({
			url: "/citas/lista/show",
			success: function(response) {
	            $("#div-lista-citas").html( response );
	        }
	  });
	
}
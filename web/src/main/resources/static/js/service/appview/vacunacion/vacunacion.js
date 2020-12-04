var  cleanFormNewCustomer = function () {
		"use strict";
		$('#paramSearchCustomer').val($('#dni_cliente').val());
		$('#apenom_cliente').val('');
		$('#dni_cliente').val('');
		$('#email_cliente').val('');
		$('#tel_cliente').val('');
		$('#dir_cliente').val('');
		$('#fec_cliente').val('');
		$('#apenom_cliente').focus();
		$('#div-dashboard-search-customer-tabs').trigger('click');
		// searchCustomer();
};


$('#paramSearchVacunacion').keyup(function (e) {
	if (e.keyCode == 13) {
		searchPaciente();
	}
});
function searchPaciente() {
	var url = '/dashboard/vacunacion/service/search';
	var param = $('#paramSearchVacunacion').val();
	if ( param !='' ) {
		url = url + '?param=' + param; 
	}
	$.ajax({
		url: url,
		success: function(response) {

            $("#div-result-search-vacunacion").html( response );
            $('#paramSearchVacunacion').focus();
            $('#paramSearchVacunacion').select();
        }, error: function (response) {
			toastr.options = {
				closeButton: true,
				debug: false,
				progressBar: false,
				showMethod: 'slideDown',
				timeOut: 4000
			};
			console.log(response)
			toastr.error(response.responseJSON.message, 'Message');
		}
	});
}


/*
*  save customer
*/
function saveCustomer () {
	"use strict";

	var jsonCustomer = {
		customerId : $('#idClienteUpdate').val(),
		customerName : $('#apenom_cliente').val(),
		customerDni : $('#dni_cliente').val(),
		customerEmail : $('#email_cliente').val(),
		customerPhone : $('#tel_cliente').val(),
		customerAddress : $('#fec_cliente').val(),
		strCustomerBirthDate : $('#fec_cliente').val()
	};

	var request = $.ajax ({
		url: "/client",
		method: "POST",
		data: JSON.stringify(jsonCustomer),
		dataType: "json",
		contentType: 'application/json'
	});

	processResponseByAjax(request, cleanFormNewCustomer );
}
/*
* function to process response service by ajax
*/
function processResponseByAjax ($response, action) {
	console.log($response);
	$response.done (function (data){
		toastr.options = {
                closeButton: true,
                debug: false,
                progressBar: true,
                showMethod: 'slideDown',
                timeOut: 4000
        };
        if (data.code === 200) {
        	toastr.success(data.message, 'Message');
           	action();
        } else {
        	toastr.error(data.message, 'Message');
        }
	});

	$response.fail ( function (jqXHR, textStatus) {
		toastr.options = {
	                closeButton: true,
	                debug: false,
	                progressBar: true,
	                showMethod: 'slideDown',
	                timeOut: 4000
	            };
        toastr.error(textStatus, 'Message');	
	} );
}
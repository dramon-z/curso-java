/**var Curso;

//validaciones
Curso = function(){
	var eventSubmitForm;

	eventSumitForm = function(){
	$( "form" ).submit(function( event ) {
		return false;
	  	event.preventDefault();
	});
	}

	return {};
};**/


/**
$(".selector").validate({
  rules: {
    name: {
      required: true,
      minlength: 2
    }
  },
  messages: {
    name: {
      required: "We need your email address to contact you",
      minlength: jQuery.format("At least {0} characters required!")
    }
  },
  invalidHandler: function(form, validator) {
				var errors = validator.numberOfInvalids();
				if (errors) {
					var message = errors == 1
					? 'Por favor ingrese la contraseña que le fue enviada por correo electronico.'
					: 'You missed ' + errors + ' fields. They have been highlighted';
					$("#dgtic-validate-error").html(message).show();
				} else {
					$("#dgtic-validate-error").hide();
				}
			}
});
**/

// $('#example').DataTable();
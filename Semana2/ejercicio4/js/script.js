var Curso;

//VER SELECTORES
//#,.,Attr ,etc...
//ver Attr
//ver parents,css,data,each
Curso = function(){
	var init;
	init = function(){
		var div= $('div#id-div');
		console.log(div);
		console.log(document.getElementById('id-div'));
		var form = $('form');
		console.log(form);
		var inputs = $('.lista-input').find('input[type="text"]');
		console.log(inputs);
		
		var boton = $('input#btn-1');
		boton.click(function(){
			var input = $('input[name="nombre"]');			
			var div2 = $("#muestra");
			div2.text(input.val());
			boton.attr({
				value:'Exitoso'
			});
			$('ul.lista-input')
				.append($('<li>').text('Success'))
				.append('<li>Ok</li>')
				.append(input.clone().attr({
					name: 'apellido'
				}))
				.attr({
					style: 'color:blue;'
				});


		});
		$('input#btn-1').click(function(event) {
			window.location="test.html";
		});
		$('ul.lista-input').children('li');
		boton.parents('form');
		


	};
	init();
	return {};
};
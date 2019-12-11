/**
 * 
 */    
$(document).ready(function(){
	$('.table .eBtn').on('click', function(event){
		event.preventDefault();
		var href=$(this).attr('href');
		$.get(href,function(a,status){
			$('.myForm #id').val(country.id);
			$('.myForm #nome').val(country.nome);
			$('.myForm #acompanhante').val(country.acompanhante);
			$('.myForm #nomeAcompanhante').val(country.nomeAcompanhante);
		});
		$('.myForm #exampleModal').modal();
	});
	
});	

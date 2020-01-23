

function checkPasswordMatch() {
    var password = $("#password").val();
    var confirm_password = $("#confirm_password").val();

    if (password != confirm_password){
    	$("#divCheckPasswordMatch").html("Passwords do not match!");
    	$("#confirm_password").addClass('error step_required');	
    }else{
    	$("#divCheckPasswordMatch").html("Passwords match.");
    	$("#confirm_password").removeClass('error step_required');	
    }
        
}


var current_step, next_step, previous_step; 
var left, opacity, scale; 
var animating; 

$(document).ready(function(){
		$("#confirm_password").keyup(checkPasswordMatch);	
		$(".step_required").focusout(function() {

			if($('.next').data('clicked')) {
				$(".step_required").each(function( index ) {
			        if (!$(this).val())
						$(this).addClass('error').parent().find('mark').removeClass('validate').addClass('error');
					else
						$(this).removeClass('error').parent().find('mark').removeClass('error').addClass('valid');
				});

			}else{
				if (!$(this).val())
						$(this).addClass('error').parent().find('mark').removeClass('validate').addClass('error');
					else
						$(this).removeClass('error').parent().find('mark').removeClass('error').addClass('valid');

			}
			
		});

		$(".next").click(function(e){

			$(this).data('clicked', true);	

				$(".step_required").triggerHandler("focusout");
				if ($('#multi-step-form input.error').length>0 || $('#multi-step-form textarea.error').length>0) {
					return false;
				} 	

			if(animating) return false;
			animating = true;
			
			current_step = $(this).parent();
			next_step = $(this).parent().next();
			
			$("#progressbar li").eq($("fieldset").index(next_step)).addClass("active");
			
			next_step.show(); 
			current_step.animate({opacity: 0}, {
				step: function(now, mx) {
					scale = 1 - (1 - now) * 0.2;
					left = (now * 50)+"%";
					opacity = 1 - now;
					current_step.css({
		        		'transform': 'scale('+scale+')',
		        		'position': 'absolute'
		     		});

					next_step.css({'left': left, 'opacity': opacity});
				}, 
				duration: 800, 
				complete: function(){
					current_step.hide();
					animating = false;
				}, 
				easing: 'easeInOutBack'
			});

	});

	$(".previous").click(function(){
		if(animating) return false;
		animating = true;
		
		current_step = $(this).parent();
		previous_step = $(this).parent().prev();
		
		$("#progressbar li").eq($("fieldset").index(current_step)).removeClass("active");
		previous_step.show(); 
		current_step.animate({opacity: 0}, {
			step: function(now, mx) {
				scale = 0.8 + (1 - now) * 0.2;
				left = ((1-now) * 50)+"%";
				opacity = 1 - now;
				current_step.css({'left': left});
				previous_step.css({'transform': 'scale('+scale+')', 'opacity': opacity});
			}, 
			duration: 800, 
			complete: function(){
				current_step.hide();
				animating = false;
			}, 
			easing: 'easeInOutBack'
		});
	});

	$('#multi-step-form').submit(function(){
		
		$('#message').html('');

		if ($('#multi-step-form input.error').length>0 || $('#multi-step-form textarea.error').length>0) {
				return false;
		}else{
			$('#multi-step-form .loader').show();
		}

		var action = $(this).attr('action');

 		$('#submit').attr('disabled','disabled');

		$.post(action, $('#multi-step-form').serialize(),
			function(data){
				$('#message').html( data );
				$('#multi-step-form .loader').hide();
				$('#multi-step-form #submit').removeAttr('disabled');
				if(data.match('success') != null) $('#multi-step-form').slideUp('slow');

			}
		);
		return false;
	});

});

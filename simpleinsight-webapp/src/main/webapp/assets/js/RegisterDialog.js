(function ($) {

    var RegisterDialog = function (element, options)
   {
       var elem = $(element);
       var obj = this;
       var settings = $.extend({
           param: 'defaultValue'
       }, options || {});

       this.registerDialog = $('<div />', { 'class': 'modal register-modal fade', id: 'loginModal', style: 'width: 600px;', tabindex:'-1', role:'dialog', 'aria-labelledby':'registerModal', 'aria-hidden':'true' })
        .append($('<div />', { 'class': 'modal-header' })
            .append($('<h2/>', { id:'registerHeader', text: 'Sign up for SimpleInsight' })))
        .append($('<div />', { 'class': 'modal-body'} )
			.append($('<form />', {'class': 'form-register', id:'registrationForm', action:'#'})
				.append($('<div/>', {'class':'control-group', id:'registrationControls'})
                                	.append($('<input/>', {id:'firstName', 'class': 'input-block-level', 
                                                                placeholder:'First name', type:'text', name:'firstName',
                                                            'data-content':"Tell us your name, we promise not to share it with anyone else.", 'data-original-title':"First name"}))

                                        .append($('<input/>', {id:'lastName', 'class': 'input-block-level', placeholder:'Last name', type:'text', name:'lastName'}))

					.append($('<input/>', {id:'emailbox', 'class': 'input-block-level', placeholder:'Email address',
                                                                type:'text', name:'email', 'data-content':"What’s your email address? You will use this when you sign in.", 'data-original-title':"Email"}))

                                        .append($('<input/>', {'class': 'input-block-level', placeholder:'Password', type:'password', name:'password'}))
                                        .append($('<input/>', {'class': 'input-block-level', placeholder:'Retype password', type:'password', name:'password2'})))
                                        
				.append($('<label/>', {'class': 'checkbox', text:'I agree to the terms of service'})
					.append($('<input/>', {type:'checkbox', name:'termsAgreement', value:'i-agree'}))))
				.append($('<button/>', {'class':'hide btn-link', text:'I agree to the terms of service', id:'lostpass'}))
					)
		.append($('<div/>', {'class': 'modal-footer'})
			.append($('<button/>', {'class':'btn btn-success', type:'submit', text:'Create my account', id:'registerButton'}))
			.append($('<button/>', {'class':'btn-link', text:'Cancel', 'data-dismiss':'modal', 'aria-hidden':'true'})));


       // focus first form field
       this.registerDialog.on('shown', function () {
           setTimeout(function () {
               $('.form-register input').popover({trigger:'focus'});
               $('#firstName').focus();
           });
       });

       // bind ajax submit
       this.registerDialog.one('shown', function (e) {

	   $('#registerButton').on('click', function (e) {
               $.post("/api/register", $("#registrationForm").serialize(),
                   function (data) {
                       var response = $.parseJSON(data);
                       if (!response.success) {
						   
                       }
                       else {
                       
                       }
                   }
               );
           });
           
       });

       this.show = function () {
           this.registerDialog.modal({
               backdrop:true
           });
       };

   };

   $.fn.registerDialog = function(options)
   {
       return this.each(function()
       {
           var element = $(this);

           // Return early if this element already has a plugin instance
           if (element.data('registerDialog')) return;

           // pass options to plugin constructor
           var registerDialog = new RegisterDialog(this, options);

           // Store plugin object in this element's data
           element.data('registerDialog', registerDialog);
       });
   };
})(jQuery);

(function ($) {

    var CoursesModule = function (element, options)
   {
       var elem = $(element);
       var obj = this;
       var me = elem;

       var settings = $.extend({
           param: 'defaultValue'
       }, options || {});

       this.coursesModule = {}; 


	   this.activate = function(){
			try{
				$('.module.active').first().data('module').deactivate();
			} 
			catch (e){
				console.info("ACTIVATE: No active module to deactivate");
			}
			
			console.info("ACTIVATE: Activating module");
			me.addClass('active');
			
						$('#viewport').replaceWith('<div id="viewport"><p>Courses</p></div>');

	   }
	   
	   this.deactivate = function(){
		   	console.info("DEACTIVATE: Deactivating module");
			me.removeClass('active');
	   }

   };

   $.fn.coursesModule = function(options)
   {
       return this.each(function()
       {
           var element = $(this);

           // Return early if this element already has a plugin instance
           if (element.data('module')) return;

           // pass options to plugin constructor
           var coursesModule = new CoursesModule(this, options);

           // Store plugin object in this element's data
           element.data('module', coursesModule);
           
           element.on('click', function(){
				element.data('module').activate();
		   });
           
       });
   };
})(jQuery);

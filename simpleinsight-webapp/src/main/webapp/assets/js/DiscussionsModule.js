(function ($) {

    var DiscussionsModule = function (element, options)
   {
       var elem = $(element);
       var obj = this;
       var me = elem;
       var settings = $.extend({
           param: 'defaultValue'
       }, options || {});

	   this.activate = function(){
			try{
				$('.module.active').first().data('module').deactivate();
			} 
			catch (e){
				console.info("ACTIVATE: No active module to deactivate");
			}
			
			console.info("ACTIVATE: Activating module");
			me.addClass('active');
	   }
	   
	   this.deactivate = function(){
		   	console.info("DEACTIVATE: Deactivating module");
			me.removeClass('active');
	   }

   };

   $.fn.discussionsModule = function(options)
   {
       return this.each(function()
       {
           var element = $(this);

           // Return early if this element already has a plugin instance
           if (element.data('module')) return;

           // pass options to plugin constructor
           var discussionsModule = new DiscussionsModule(this, options);

           // Store plugin object in this element's data
           element.data('module', discussionsModule);
           
           
           element.on('click', function(){
				element.data('module').activate();
		   });
           
       });
   };
})(jQuery);

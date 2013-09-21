(function ($) {

    var CourseCatalogList = function (element, options)
   {
       var elem = $(element);
       var obj = this;
       var settings = $.extend({
           param: 'defaultValue'
       }, options || {});

       this.courseList = {}; 

   };

   $.fn.courseCatalogList = function(options)
   {
       return this.each(function()
       {
           var element = $(this);

           // Return early if this element already has a plugin instance
           if (element.data('courseCatalogList')) return;

           // pass options to plugin constructor
           var courseCatalogList = new CourseCatalogList(this, options);

           // Store plugin object in this element's data
           element.data('courseCatalogList', courseCatalogList);
       });
   };
})(jQuery);

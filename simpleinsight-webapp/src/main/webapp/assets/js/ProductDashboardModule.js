(function($) {

    var ProductDashboardModule = function(element, options)
    {
        var elem = $(element);
        var obj = this;
        var me = elem;
        var settings = $.extend({
            param: 'defaultValue'
        }, options || {});

        this.activate = function() {
            try {
                $('.module.active').first().data('module').deactivate();
            }
            catch (e) {
                console.info("ACTIVATE: No active module to deactivate");
            }

            console.info("ACTIVATE: Activating module");
            me.addClass('active');
        
            var skel='<div class="row">'+
	'		<div class="col-md-12">'+
	'			<span class="h2">Product lines</span>'+
	'			<div class="pull-right">'+
	'				<button type="button" class="btn btn-defaults"> <span class="glyphicon glyphicon-plus"></span>  Create a new product line </button>'+
	'			</div>'+
	'		</div>'+
	'</div>'+
	'<br/>'+
	'<div class="row" id="productLineList">'+
	'</div>'+
	'<div class="row">'+
	'	<ul class="pager">'+
	'	  <li class="previous disabled"><a href="#">&larr; Previous</a></li>'+
	'	  <li class="next"><a href="#">Next &rarr;</a></li>'+
	'	</ul>'+
	'</div>';


        $('#viewport').replaceWith(skel);

        $.getJSON( "../data/productLine/list", function( data ) {
		
	var items = [];

	  $.each( data, function( key, productLine ) {
	  
	    var prodLineT = "<li class='list-group-item'><h3> <strong>" + productLine.name + "</strong></h3>";
		prodLineT = prodLineT + "<ul class='list-group'>";
		
		$.each(productLine.products, function(prodKey, prodVal){
		
			var scaleType = "danger";
			var lt25 = prodVal.complete < 25;
			var lt50m25 = prodVal.complete >=25 && prodVal.complete <50;
			var lt75m50 = prodVal.complete >=50 && prodVal.complete <75;
			var lt100m75 = prodVal.complete >=75 && prodVal.complete <=100;
			
			
			if(lt25) scaleType = "danger";
			if(lt50m25 ) scaleType = "warning";
			if(lt75m50 ) scaleType = "info";
			if(lt100m75) scaleType = "success";
			
			alert(scaleType);
			
			prodLineT = prodLineT  + "<li class='list-group-item'>";
			prodLineT = prodLineT  + "<div class='row' style='padding-bottom:5px'>";
			prodLineT = prodLineT  + "		<div class='col-md-12'>";
			prodLineT = prodLineT  + "			<span class='h4'><strong>" + prodVal.name + "</strong></span>";		
			prodLineT = prodLineT  + "			<div class='btn-group pull-right'>";
			prodLineT = prodLineT  + "			  <button type='button' class='btn btn-sm btn-default'>Open</button>";
			prodLineT = prodLineT  + "			  <button type='button' class='btn btn-sm btn-default dropdown-toggle' data-toggle='dropdown'>";
			prodLineT = prodLineT  + "			    <span class='caret'></span>";
			prodLineT = prodLineT  + "			    <span class='sr-only'>Toggle Dropdown</span>";
			prodLineT = prodLineT  + "			  </button>";
			prodLineT = prodLineT  + "			  <ul class='dropdown-menu' role='menu'>";
			prodLineT = prodLineT  + "			    <li><a href='#'>Edit</a></li>";
			prodLineT = prodLineT  + "			    <li><a href='#'>Share</a></li>";
			prodLineT = prodLineT  + "			    <li class='divider'></li>";
			prodLineT = prodLineT  + "			    <li><a href='#'>Delete</a></li>";
			prodLineT = prodLineT  + "			  </ul>";		
			prodLineT = prodLineT  + "			</div>";
			prodLineT = prodLineT  + "		</div>";
			prodLineT = prodLineT  + "	</div>";
			
			prodLineT = prodLineT  + "	<div class='row'>";
			prodLineT = prodLineT  + "		<div class='col-md-12'>";
			prodLineT = prodLineT  + "			<div class='progress'>";
			prodLineT = prodLineT  + "				<div class='progress-bar progress-bar-"+scaleType+"' role='progressbar' aria-valuenow='"+prodVal.complete+"' aria-valuemin='0' "; 
			prodLineT = prodLineT  + "					aria-valuemax='100' style='width: "+prodVal.complete+"%;'>";
			prodLineT = prodLineT  + "		    			<span class='sr-only'>"+prodVal.complete+"% Complete</span>";
			prodLineT = prodLineT  + "					</div>";
			prodLineT = prodLineT  + "				</div>";
			prodLineT = prodLineT  + "			</div>";
			prodLineT = prodLineT  + "		</div>";
			
			
			prodLineT = prodLineT  + "</li>";
		});
		
	  	prodLineT = prodLineT + "</ul>";
	  
	  
	    items.push( prodLineT);
	  });
	  

	  $( "<ul/>", {
	    "class": "list-group",
	    html: items.join( "" )
	  }).appendTo( "#productLineList" );
    
});

        };

        this.deactivate = function() {
            console.info("DEACTIVATE: Deactivating module");
            me.removeClass('active');
        };

    };

    $.fn.productDashboardModule = function(options)
    {
        return this.each(function()
        {
            var element = $(this);

            // Return early if this element already has a plugin instance
            if (element.data('module'))
                return;

            // pass options to plugin constructor
            var productDashboardModule = new ProductDashboardModule(this, options);

            // Store plugin object in this element's data
            element.data('module', productDashboardModule);


            element.on('click', function() {
                element.data('module').activate();
            });

        });
    };
})(jQuery);

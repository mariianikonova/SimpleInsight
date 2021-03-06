(function($) {
    var MainMenu = function(element, options) {

        var elem = $(element);
        var settings = $.extend({
            user: window.ClientConfig.user
        }, options || {});

        this.productDashboard = UiHelpers.createMenuItem("Products", 'icon-dashboard', '2','#');
        $(this.productDashboard).productDashboardModule();
        
        this.addQuickTask = UiHelpers.createMenuItem("Add task", 'icon-plus-sign-alt', '3','#');

        
        $(elem).append(this.productDashboard);
        $(elem).append(this.addQuickTask);
        
        $(elem).append(UiHelpers.createMenuDivider());

        if (SecurityContext.hasPermission("PERMISSION_MANAGE_ORGANISATION")) {
            this.orgSettings = UiHelpers.createMenuItem("My organisation", 'icon-cogs', '4','#');
            $(elem).append(this.orgSettings);
        }

    };

    $.fn.createMainMenu = function(options)
    {
        return this.each(function()
        {
            var element = $(this);

            // Return early if this element already has a plugin instance
            if (element.data('mainMenu'))
                return;

            // pass options to plugin constructor
            var mainMenu = new MainMenu(this, options);

            // store plugin object in this element's data
            element.data('mainMenu', mainMenu);
        });
    };
})(jQuery);  
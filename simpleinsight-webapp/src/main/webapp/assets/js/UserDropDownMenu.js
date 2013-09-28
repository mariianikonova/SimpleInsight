(function($) {
    var UserDropDownMenu = function(element, options) {

        var elem = $(element);
        var settings = $.extend({
            user: window.ClientConfig.user
        }, options || {});

        this.userDropDownMenuButton = $('<button />', {'class': 'btn dropdown-toggle', 'data-toggle': 'dropdown'})
                .append($('<img />', {'alt': 'gravatar', 'src': 'http://www.gravatar.com/avatar/' + settings.user.emailHash + '?s=24'})
                        .after(" " + settings.user.displayName));


        this.userDropDownMenu = $('<ul />', {'class': 'dropdown-menu', 'role': 'menu', 'aria-labelledby': 'dLabel'})

                .append($('<li />').append($('<a />', {'tabindex': '-1', 'href': '#'}).append($('<i />', {'class': 'icon-user'})).append("Edit profile")))

                .append($('<li />', {class: 'divider'}))

                .append($('<li />').append($('<a />', {'tabindex': '-1', 'href': '#'}).append($('<i />', {'class': 'icon-cog'})).append("Account settings")))
                .append($('<li />').append($('<a />', {'tabindex': '-1', 'href': '#'}).append($('<i />', {'class': 'icon-flag'})).append("Change language")))

                .append($('<li />', {class: 'divider'}))
                
                .append($('<li />').append($('<a />', {'tabindex': '-1', 'href': '../logout'}).append($('<i />', {'class': 'icon-key'})).append("Sign out")));

        $(elem).append(this.userDropDownMenuButton);
        $(elem).append(this.userDropDownMenu);

    };

    $.fn.userDropDownMenu = function(options)
    {
        return this.each(function()
        {
            var element = $(this);

            // Return early if this element already has a plugin instance
            if (element.data('userDropDownMenu'))
                return;

            // pass options to plugin constructor
            var userDropDownMenu = new UserDropDownMenu(this, options);

            // store plugin object in this element's data
            element.data('userDropDownMenu', userDropDownMenu);
        });
    };
})(jQuery);  
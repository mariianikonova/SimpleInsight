(function($) {
    var UserDropDownMenu = function(element, options) {

        var elem = $(element);
        var obj = this;
        var settings = $.extend({
            user: window.ClientConfig.user
        }, options || {});

        this.userDropDownMenuButton = $('<button />', {'class': 'btn dropdown-toggle', 'data-toggle': 'dropdown'})
                .append($('<img src="http://www.gravatar.com/avatar/' + settings.user.emailHash + '?s=24" />').after(" " + settings.user.displayName));
        
        this.userDropDownMenu = $('<ul class="dropdown-menu" role="menu" aria-labelledby="dLabel" />')
                .append($('<li><a tabindex="-1" href="#"><i class="icon-user"> </i> Edit profile</a></a></li>'))

                .append($('<li class="divider"></li>'))

                .append($('<li><a tabindex="-1" href="#"><i class="icon-cog"> </i> Account settings</a></li>'))
                .append($('<li><a tabindex="-1" href="#"><i class="icon-flag"> </i> Change language</a></li>'))
                .append($('<li class="divider"></li>'))
                .append($('<li><a tabindex="-1" href="../logout"><i class="icon-key"> </i> Sign out</a></li>'));
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

            // Store plugin object in this element's data
            element.data('userDropDownMenu', userDropDownMenu);
        });
    };
})(jQuery);  
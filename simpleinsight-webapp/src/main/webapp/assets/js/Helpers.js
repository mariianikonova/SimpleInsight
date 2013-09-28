(function($)
{

    window.UiHelpers = {
        createMenuItem: function(caption, cssIconClass, tabIndex, href) {
            if (tabIndex === undefined)
                tabIndex = '-1';
            if (href === undefined)
                href = "#";
            return $('<li />').append($('<a />', {'tabindex': tabIndex, 'href': href}).append($('<i />', {'class': cssIconClass})).append(caption));
        },
        createMenuDivider: function() {
            return $('<li />', {class: 'divider'});
        }
    };

    window.SecurityContext = {
        hasPermission: function(permission) {
            var auth = ClientConfig.user.grantedAuthorities;
            return $.inArray(permission, auth) > -1;
        }
    };

})(jQuery);
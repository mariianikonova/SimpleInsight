(function($) {

    var LoginDialog = function(element, options)
    {
        var elem = $(element);
        var obj = this;
        var settings = $.extend({
            param: 'defaultValue'
        }, options || {});

        this.loginDialogModal = $('<div />', {'class': 'modal login-modal fade', id: 'loginModal', style: 'width: 500px;', tabindex: '-1', role: 'dialog', 'aria-labelledby': 'loginModal', 'aria-hidden': 'true'})
                .append($('<div />', {'class': 'modal-header'})
                .append($('<h2/>', {id: 'loginHeader', text: 'Welcome back'})))
                .append($('<div />', {'class': 'modal-body'})
                .append($('<form />', {'class': 'form-signin', id: 'loginForm', action: '#'})
                .append($('<div/>', {'class': 'control-group', id: 'loginControls'})
                .append($('<input/>', {id: 'userName', 'class': 'input-block-level', placeholder: 'Email address', type: 'text', name: 'username'}))
                .append($('<input/>', {'class': 'input-block-level', placeholder: 'Password', type: 'password', name: 'password'})))
                .append($('<label/>', {'class': 'checkbox', text: 'Remember me'})
                .append($('<input/>', {type: 'checkbox', name: 'remember', value: 'remember-me'}))))
                .append($('<button/>', {'class': 'hide btn-link', text: 'I lost my password', id: 'lostpass'}))
                )
                .append($('<div/>', {'class': 'modal-footer'})
                .append($('<button/>', {'class': 'btn btn-primary', type: 'submit', text: 'Sign in', id: 'loginButton'}))
                .append($('<button/>', {'class': 'btn-link', text: 'Cancel', 'data-dismiss': 'modal', 'aria-hidden': 'true'})));


        // bind ajax submit
        this.loginDialogModal.one('shown', function(e) {

            // track the enter key
            $("input").bind("keydown", function(event) {
                var keycode = (event.keyCode ? event.keyCode : (event.which ? event.which : event.charCode));
                if (keycode === 13) { // keycode for enter key
                    $('#loginButton').click();
                    return false;
                } else {
                    return true;
                }
            });

            $('#loginButton').on('click', function(e) {
                $.ajax({
                    url: "login",
                    type: "POST",
                    data: $("#loginForm").serialize(),
                    dataType: "json",
                    beforeSend: function(xhr) {
                        xhr.setRequestHeader("X-Ajax-call", "true");
                    },
                    statusCode: {
                        401: function(xhr, textStatus, errorThrown) {
                            if (xhr.status === 401 && textStatus === 'error') {
                                $('#loginForm').find("input[type=password]").val("");
                                $('#loginControls').addClass('error');
                                $('#loginHeader').text("Please try again!");
                                $('#lostpass').show();
                            }
                        }
                    },
                    success: function(response) {
                        if (response.status === 'ok') {
                            $('#loginControls').addClass('success');
                            window.location.replace("." + response.to);
                        }
                    },
                    error: function(xhr, textStatus, errorThrown) {
                        console.log(xhr);

                    }

                });

            });

        });

        // focus first form field
        this.loginDialogModal.on('shown', function() {
            setTimeout(function() {
                $('#userName').focus();
            });
        });


        this.show = function() {
            this.loginDialogModal.modal({
                backdrop: true
            });
        };

    };

    $.fn.logindialog = function(options)
    {
        return this.each(function()
        {
            var element = $(this);

            // Return early if this element already has a plugin instance
            if (element.data('logindialog'))
                return;

            // pass options to plugin constructor
            var logindialog = new LoginDialog(this, options);

            // Store plugin object in this element's data
            element.data('logindialog', logindialog);
        });
    };
})(jQuery);

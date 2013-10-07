var ClientConfig = {};

var Bootstrapper = function() {
};

Bootstrapper.prototype.initLogger = function() {
    if (console) {
        this.logger = console;
    } else {
        this.logger = {info: function() {
            }, error: function() {
            }};
    }
};

Bootstrapper.prototype.setupClientConfig = function(data) {
    ClientConfig = data;
    
    var perms = new Array();
    
    $.each(ClientConfig.user.grantedAuthorities, function(index, value) {
        perms.push(value.authority);
    });
    
    ClientConfig.user.grantedAuthorities = perms;
};

Bootstrapper.prototype.buildUi = function() {
    $('#userDropdown').createUserDropDownMenu();
    $('#mainMenu').createMainMenu();
};



Bootstrapper.prototype.run = function() {
    var me = this;

    me.initLogger();

    $(document).ready(
            function() {
                $(document).ajaxStart(function() {
                    $("#loadingMask").show();
                });

                $(document).ajaxStop(function() {
                    $("#loadingMask").hide();
                });

                $.ajaxSetup({
                    accepts: {"json": "application/json"},
                    dataType: "json"
                });

                $.ajax({
                    url: "../api/config",
                    success: function(data, textStatus, jqXHR) {
                        me.logger.info("[WireUp] Client config loaded");
                        me.setupClientConfig(data);
                        me.buildUi();

                    },
                    error: function(jqXHR, textStatus, errorThrown) {
                        me.logger.error("[WireUp] " + textStatus + " " + errorThrown);
                    }
                });
            });
};
package com.simbirsoft.derevyankoA.ui.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/authorization.properties"})
public interface AuthorizationConfig extends Config {

    @Key("login")
    String login();

    @Key("password")
    String password();
}

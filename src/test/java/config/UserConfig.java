package config;

import org.aeonbits.owner.Config;

public interface UserConfig extends Config {
    @Key("user")
    @DefaultValue("bsuser_NYdKOU")
    String getUser();

    @Key("key")
    @DefaultValue("1its8A75AgYyizDugKAE")
    String getKey();
}

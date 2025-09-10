package config;

import org.aeonbits.owner.Config;

public interface DeviceConfig extends Config {
    @Key("device")
    @DefaultValue("Samsung Galaxy S22 Ultra")
    String getDevice();

    @Key("app")
    @DefaultValue("bs://sample.app")
    String getApp();

    @Key("version")
    @DefaultValue("12.0")
    String getVersion();
}

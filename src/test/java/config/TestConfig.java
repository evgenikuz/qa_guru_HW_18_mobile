package config;

import org.aeonbits.owner.Config;

public interface TestConfig extends Config {
    @Key("url")
    @DefaultValue("https://hub.browserstack.com/wd/hub")
    String getUrl();

    @Key("project")
    @DefaultValue("First Java Project")
    String getProject();

    @Key("build")
    @DefaultValue("browserstack-build-1")
    String getBuild();

    @Key("name")
    @DefaultValue("first_test")
    String getName();
}

package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.DeviceConfig;
import config.UserConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        UserConfig userConfig = ConfigFactory.create(UserConfig.class, System.getProperties());
        DeviceConfig deviceConfig = ConfigFactory.create(DeviceConfig.class, System.getProperties());

        MutableCapabilities caps = new MutableCapabilities();

        caps.setCapability("browserstack.user", userConfig.getUser());
        caps.setCapability("browserstack.key", userConfig.getKey());

        caps.setCapability("app", deviceConfig.getApp());
        caps.setCapability("device", deviceConfig.getDevice());
        caps.setCapability("os_version", deviceConfig.getVersion());

        caps.setCapability("project", "First Java Project");
        caps.setCapability("build", "browserstack-build-1");
        caps.setCapability("name", "first_test");

        try {
            return new RemoteWebDriver(
                    new URL("https://hub.browserstack.com/wd/hub"), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}

package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.DeviceConfig;
import config.TestConfig;
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
        TestConfig testConfig = ConfigFactory.create(TestConfig.class, System.getProperties());

        MutableCapabilities caps = new MutableCapabilities();

        caps.setCapability("browserstack.user", userConfig.getUser());
        caps.setCapability("browserstack.key", userConfig.getKey());

        caps.setCapability("app", deviceConfig.getApp());
        caps.setCapability("device", deviceConfig.getDevice());
        caps.setCapability("os_version", deviceConfig.getVersion());

        caps.setCapability("project", testConfig.getProject());
        caps.setCapability("build", testConfig.getBuild());
        caps.setCapability("name", testConfig.getName());

        try {
            return new RemoteWebDriver(
                    new URL(testConfig.getUrl()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}

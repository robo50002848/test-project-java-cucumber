package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverInit {

    private static final int TIMEOUT = 15;
    private static final String SELENIUM_GRID_URL_PROPERTY = "seleniumGridUrl";

    private static final WebDriverInit instance = new WebDriverInit();

    private static WebDriver webDriver;
    private static WebDriverWait webDriverWait;

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public WebDriverWait getWebDriverWait() {
        return webDriverWait;
    }

    private WebDriverInit() {
        initWebDriver();
        initWebDriverWait();
    }

    public static WebDriverInit getInstance() {
        return instance;
    }

    private static WebDriver initWebDriver() {
        String environment = System.getProperty("environment");
        if (isEqual(environment, Environment.LOCAL)) {
            return setUpWebDriver();
        } else if (isEqual(environment, Environment.SELENIUM_GRID)) {
            return setUpRemoteWebDriver();
        }
        throw new IllegalArgumentException("No environment specified.");
    }

    private static boolean isEqual(String environmentName, Environment environment) {
        return environment.getName().equals(environmentName);
    }

    private static WebDriver setUpRemoteWebDriver() {
        try {
            DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
            desiredCapabilities.setBrowserName("chrome");
            desiredCapabilities.setPlatform(Platform.MAC);
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.merge(desiredCapabilities);
            return new RemoteWebDriver(new URL(System.getProperty(SELENIUM_GRID_URL_PROPERTY)), desiredCapabilities);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Wrong URL specified.", e);
        }
    }

    private static WebDriver setUpWebDriver() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        return webDriver;
    }

    private static void initWebDriverWait() {
        webDriverWait = new WebDriverWait(webDriver, TIMEOUT);
    }

    private enum Environment {
        LOCAL("local"),
        SELENIUM_GRID("seleniumGrid");

        private String name;

        Environment(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}

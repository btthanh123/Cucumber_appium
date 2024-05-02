package Basic;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BrowserTestBase {
    public static AppiumDriver driver;
//    public static AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(new File(System.getenv("APPIUM") + "\\main.js"))
//            .withIPAddress("127.0.0.1").usingPort(4723).withArgument(() -> "--base-path", "/wd/hub").build();

    //    @Before
//    public static void setup(String deviceName, String udid, String platformVersion, String platformName, String browserName, String automationName) {

    public static void setup() {
        try {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

            desiredCapabilities.setCapability("deviceName", "-avd Pixel_4_API_31");
//            desiredCapabilities.setCapability("udid", udid);
            desiredCapabilities.setCapability("platformVersion", "12");
            desiredCapabilities.setCapability("platformName", "Android");
            desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
            desiredCapabilities.setCapability("chromeOptions", ImmutableMap.of("w3c", false));
            desiredCapabilities.setCapability("automationName", "UiAutomator2");
//            System.out.println(System.getProperty("user.dir") + File.separator + "src/test/resources/drivers/chromedriver.exe");
            desiredCapabilities.setCapability("chromedriverExecutable", System.getProperty("user.dir") + File.separator + "src/test/resources/drivers/chromedriver124.exe");

//            desiredCapabilities.setCapability("systemPort", params.getSystemPort());
//            desiredCapabilities.setCapability("chromeDriverPort", params.getChromeDriverPort());


//            driver.set(new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities));
//            System.out.println(serverManager.getServer());
            driver = new AppiumDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void tearDown() {
        // Quit the Appium driver
        if (driver != null) {
            driver.quit();
//            service.stop();
        }
    }

}

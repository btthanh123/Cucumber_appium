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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AppiumTestBase {
    public static AppiumDriver driver;
//    public static AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(new File(System.getenv("APPIUM") + "\\main.js"))
//            .withIPAddress("127.0.0.1").usingPort(4723).withArgument(() -> "--base-path", "/wd/hub").build();


    //    public static void setup() throws MalformedURLException {
//        AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(new File("C://Users//btthanh//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
//                .withIPAddress("127.0.0.1").usingPort(4723).withArgument(() -> "--base-path", "/wd/hub").build();
//        service.start();
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("automationName", "uiautomator2");
//        capabilities.setCapability("platformName", "Android");
////        Path currentWorkingDir = Paths.get("").toAbsolutePath();
////        capabilities.setCapability("enableMultiWindows", true);
//        capabilities.setCapability("appPackage", "com.androidsample.generalstore");
//        capabilities.setCapability("appActivity", "com.androidsample.generalstore.SplashActivity");
////        UiAutomator2Options options = new UiAutomator2Options();
////        options.setApp("D://AppiumCucumber//AppiumProject//src//test//resources//App//General-Store.apk");
//        driver = new AppiumDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//    }

    @BeforeTest
    public void initializeWebDriver(String deviceName, String udid, String platformVersion, String platformName, String browserName, String automationName) {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        ServerManager serverManager = new ServerManager();

        desiredCapabilities.setCapability("deviceName", deviceName);
        desiredCapabilities.setCapability("udid", udid);
        desiredCapabilities.setCapability("platformVersion", platformVersion);
        desiredCapabilities.setCapability("platformName", platformName);
        desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, browserName);
        desiredCapabilities.setCapability("chromeOptions", ImmutableMap.of("w3c", false));
        desiredCapabilities.setCapability("automationName", automationName);
//            System.out.println(System.getProperty("user.dir") + File.separator + "src/test/resources/drivers/chromedriver.exe");
        desiredCapabilities.setCapability("chromedriverExecutable", System.getProperty("user.dir") + File.separator + "src/test/resources/drivers/chromedriver124.exe");

//            desiredCapabilities.setCapability("systemPort", params.getSystemPort());
//            desiredCapabilities.setCapability("chromeDriverPort", params.getChromeDriverPort());

//            String androidAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
//                    + File.separator + "resources" + File.separator + "apps" + File.separator + "Android.SauceLabs.Mobile.Sample.app.2.2.1.apk";
//            desiredCapabilities.setCapability("app", androidAppUrl);

//            driver.set(new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities));
//            System.out.println(serverManager.getServer());
        driver = new AndroidDriver(serverManager.getServer(), desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterClass
    public void stopServer() {
        // Quit the Appium driver
        if (driver != null) {
            driver.quit();
        }
    }


}

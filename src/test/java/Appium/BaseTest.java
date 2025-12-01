package Appium;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Map;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class BaseTest {
    public  AndroidDriver driver;
    public AppiumDriverLocalService service;
    public SoftAssert softAssert;
    WebDriverWait wait;

    @BeforeTest
    public  void start() throws URISyntaxException, MalformedURLException {
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\2B_49\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("samsung SM-S9160");
        options.setPlatformName("Android");
        options.setApp("C:\\Users\\2B_49\\IdeaProjects\\AppiumCourse\\src\\test\\resources\\ApiDemos-debug.apk");
        driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(),options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        softAssert = new SoftAssert();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

//    @AfterTest
//    public void stop(){
//        driver.quit();
//        service.stop();
//    }

    public void longGestures(){
        WebElement longPress =  driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='People Names']"));

        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId", ((RemoteWebElement)longPress).getId(),  "duration", 2000));

    }

    public void swipeGestures(WebElement element){
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement)element).getId(),
                        "direction", "left",
                        "percent", 0.75,
                        "duration", 2000,
                        "left",100
        ));
    }

    public void scrollGestures(){
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
    }

    public void dragAndDropGestures(WebElement element){
        ((JavascriptExecutor)driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId",((RemoteWebElement) element).getId(),
                "endX",619,
                "endY",560
        ));
    }
}

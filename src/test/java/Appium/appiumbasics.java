package Appium;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class appiumbasics extends BaseTest{
    
    @Test
    public void appiumTest() throws MalformedURLException, URISyntaxException {
        Activity activity = new Activity("io.appium.android.apis","io.appium.android.apis.preference.PreferenceDependencies");
        ((JavascriptExecutor)driver).executeScript("mobile: startActivity", ImmutableMap.of("intent","io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"));

//        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
//        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
        driver.findElement(AppiumBy.id("android:id/checkbox")).click();
        DeviceRotation landscape = new DeviceRotation(0,0,90);
        driver.rotate(landscape);
        driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]")).click();
        String titleText = driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
        softAssert.assertEquals(titleText, "WiFi Settings");
        driver.findElement(AppiumBy.id("android:id/edit")).sendKeys("Toka Mohamed");
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
    }
}

package Appium;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class longGestures extends BaseTest{
    @Test
    public void gestures(){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
        longGestures();
        String sampleText = driver.findElement(AppiumBy.id("android:id/title")).getText();
        softAssert.assertEquals(sampleText, "Sample menu");
        softAssert.assertTrue(driver.findElement(AppiumBy.id("android:id/title")).isDisplayed());
    }
}

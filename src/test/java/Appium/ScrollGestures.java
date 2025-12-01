package Appium;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class ScrollGestures extends BaseTest{
    @Test
    public void gestures(){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        scrollGestures();
    }
}

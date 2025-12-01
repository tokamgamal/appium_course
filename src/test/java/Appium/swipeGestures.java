package Appium;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class swipeGestures extends BaseTest{
    @Test
    public void gestures(){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
        WebElement element=driver.findElement(AppiumBy.xpath("//android.widget.ImageView[1]"));
        Assert.assertEquals(element.getAttribute("focusable"), "true");
        swipeGestures(element);
    }
}

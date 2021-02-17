package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static utils.ImageUtil.displayImage;

public class LandingPage {

    private final WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        driver.get("https://web.whatsapp.com/");
    }

    public void showQR() {
        final WebElement qr = driver.findElement(By.xpath("//*[@aria-label='Scan me!']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        String image = (String) jse.executeScript("return arguments[0].toDataURL('image/png').substring(22);", qr);
        displayImage(image);
    }



}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    public HomePage(WebDriver driver) {
        driver.findElement(By.xpath("//*[@aria-label='Menu']"));
    }
}

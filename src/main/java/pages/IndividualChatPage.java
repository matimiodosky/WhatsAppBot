package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

public class IndividualChatPage extends ChatPage {

    public IndividualChatPage(WebDriver driver, String phone) {

        super(driver, phone);
        Logger logger = Logger.getLogger(IndividualChatPage.class.getName());
        logger.info("Opening chat page for phone: " + phone);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.get(String.format("https://api.whatsapp.com/send?phone=%s", phone));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver
                .findElement(By.xpath("//*[contains(text(), 'Continue to Chat')]"))
                .click();

        driver
                .findElement(By.xpath("//*[contains(text(), 'use WhatsApp Web')]"))
                .click();

    }


}

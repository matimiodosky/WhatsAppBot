package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

public class GroupChatPage extends ChatPage {

    public GroupChatPage(WebDriver driver, String groupId) {

        super(driver, groupId);
        Logger logger = Logger.getLogger(GroupChatPage.class.getName());
        logger.info("Opening chat page for group: " + groupId);


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.get(String.format("https://chat.whatsapp.com/%s", groupId));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver
                .findElement(By.xpath("//*[contains(text(), 'Join Chat')]"))
                .click();

        driver
                .findElement(By.xpath("//*[contains(text(), 'use WhatsApp Web')]"))
                .click();

        logger.info("Opened chat page for group: " + groupId);
    }


}

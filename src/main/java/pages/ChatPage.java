package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

public class ChatPage {
    private final WebDriver driver;
    private final String identifier;
    private final Logger logger = Logger.getLogger(ChatPage.class.getName());

    protected ChatPage(WebDriver driver, String identifier) {
        this.driver = driver;
        this.identifier = identifier;
    }

    public void sendMessage(String message) {

        logger.info(String.format("Writing message: %s to %s", message, identifier));

        this.driver
                .findElement(By.xpath("//*[@spellcheck='true']"))
                .sendKeys(message);

        logger.info(String.format("Sending message: %s to %s", message, identifier));

        this.driver
                .findElement(By.xpath("//*[@data-testid='send']"))
                .click();

        this.driver.findElement(By.xpath(String.format("//*[contains(text(), '%s')]", message)));

        logger.info(String.format("Message sent to %s", identifier));
    }


}

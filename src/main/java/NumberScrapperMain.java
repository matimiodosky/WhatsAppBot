import org.openqa.selenium.WebDriver;
import pages.ChatPage;
import pages.HomePage;
import pages.IndividualChatPage;
import pages.LandingPage;

import static utils.DiverBuilder.buildWebDriver;

public class NumberScrapperMain {

    public static void main(String[] args) {
        WebDriver driver = buildWebDriver(true, 5);
        LandingPage landingPage = new LandingPage(driver);
        landingPage.showQR();
        new HomePage(driver); //just check its open
        String baseNumber = "00549299";
        for (long i = 4094753; i < 4100000; i++) {
            try {
                ChatPage chatPage = new IndividualChatPage(driver, baseNumber + i);
                chatPage.sendMessage("Hola! ");
                chatPage.sendMessage("Perdon!! Me equivoque de numero");
                System.out.println("Valid number: " + baseNumber + i);

            } catch (Exception e) {
                System.out.println("Invalid number: " + baseNumber + i);
            }
        }
        driver.quit();
    }
}

import org.openqa.selenium.WebDriver;
import pages.ChatPage;
import pages.GroupChatPage;
import pages.HomePage;
import pages.LandingPage;

import static utils.DiverBuilder.buildWebDriver;

public class GroupSender {

    public static void main(String[] args) {
        WebDriver driver = buildWebDriver(true, 5);
        LandingPage landingPage = new LandingPage(driver);
        landingPage.showQR();
        new HomePage(driver); //just check its open
        String groupId = "LncEFsPCLjpBt4C2biV4ms";
        ChatPage chatPage = new GroupChatPage(driver, groupId);
        for (long i = 0; i < 100; i++) {
            chatPage.sendMessage("Hola!");
        }
        driver.quit();
    }
}

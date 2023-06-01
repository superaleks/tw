import java.io.File;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class SeleniumTest {

    public static void main(String[] args) throws InterruptedException {

        ChromeOptions opt = new ChromeOptions();
        opt.addExtensions(new File("Trust-Wallet.crx"));
        ChromeDriver driver = new ChromeDriver(opt);
        //getData(driver);
        System.out.println("Session id is: " + driver.getSessionId());
        driver.get("chrome-extension://egjidjbpglichdcondbcbdnbeeppgdph/home.html#/onboarding/create/password"); //"//input[@name='username']"]


        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        System.out.println("Number of tabs is: " + tabs.size());
        driver.switchTo().window(tabs.get(0)); // change tabs

        // first create password
        WebElement createPassword = driver.findElement(By.xpath("//div[@data-testid='password']"));
        createPassword.sendKeys("Test!");

        //then test
        WebElement createWalletButton = driver.findElement(By.xpath(("//div[@data-testid='create-new-wallet']")));
        createWalletButton.click();

    }
}

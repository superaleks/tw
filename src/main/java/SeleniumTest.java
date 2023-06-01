import java.io.File;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class SeleniumTest {

    public static void main(String[] args) throws InterruptedException {

        String password = "Test1235%!";

        ChromeOptions opt = new ChromeOptions();
        opt.addExtensions(new File("Trust-Wallet.crx"));
        ChromeDriver driver = new ChromeDriver(opt);

        driver.get("chrome-extension://egjidjbpglichdcondbcbdnbeeppgdph/home.html#/onboarding");

        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        System.out.println("Number of tabs is: " + tabs.size());


        driver.switchTo().window(tabs.get(0)); // change tabs

        Thread.sleep(4000);

        WebElement createNewWallet = driver.findElement(By.xpath("//input[@data-testid='create-new-wallet']"));
        createNewWallet.click();


        // Create password test
        WebElement createPassword = driver.findElement(By.xpath("//input[@data-testid='password']"));
        createPassword.sendKeys(password);

        WebElement confirmPassword = driver.findElement(By.xpath("//input[@data-testid='confirm=password"));
        confirmPassword.sendKeys(password);

        WebElement termsCheckbox = driver.findElement(By.xpath("//input[@data-testid='confirm=password"));
        termsCheckbox.click();

    }
}

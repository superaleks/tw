import java.io.File;

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
        getData(driver);
        driver.get("chrome-extension://egjidjbpglichdcondbcbdnbeeppgdph/popup.html");
        WebElement createWalletButton = driver.findElement(By.linkText("Create a new wallet"));
        createWalletButton.click();
//        WebElement lanSel = driver.findElement(By.id())
//        new Select(lanSel).selectByVisibleText("Hindi");
//        driver.findElement(By.id("save-btn")).click();
//        getData(driver);

    }

    private static void getData(ChromeDriver driver) throws InterruptedException {
//        // popup page
//        driver.get("chrome-extension://mgijmajocgfcbeboacabfgobmjgjcoja/browser_action.html");
//        driver.findElementById("query-field").sendKeys("define");
//        driver.findElementById("define-btn").click();
//        Thread.sleep(5000);
//        String text = driver.findElementByClassName("headword").getText();
//        System.out.println(text);
    }
}

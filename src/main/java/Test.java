import graphql.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) throws InterruptedException {

        int WAIT_TIME = 60;
        String password = "Test12355!";
        String extensionLandingPage = "chrome-extension://egjidjbpglichdcondbcbdnbeeppgdph/home.html#/onboarding";
        String confirmationMessage = "I'm ready to use Trust Wallet!";
        ChromeOptions opt = new ChromeOptions();
        opt.addExtensions(new File("Trust-Wallet.crx"));
        ChromeDriver driver = new ChromeDriver(opt);
        driver.get(extensionLandingPage);
        WebElement createNewWallet = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME)).until(ExpectedConditions.visibilityOfElementLocated(PageObject.newWalletButton()));
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        createNewWallet.click();
        WebElement createPassword = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME)).until(ExpectedConditions.visibilityOfElementLocated(PageObject.newPasswordInput()));
        createPassword.sendKeys(password);
        WebElement confirmPassword = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME)).until(ExpectedConditions.visibilityOfElementLocated(PageObject.confirmPasswordInput()));
        confirmPassword.sendKeys(password);
        WebElement termsCheckbox = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME)).until(ExpectedConditions.visibilityOfElementLocated(PageObject.termsCheckbox()));
        termsCheckbox.click();
        WebElement nextButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME)).until(ExpectedConditions.visibilityOfElementLocated(PageObject.nextButton()));
        nextButton.click();
        WebElement safetyMessage = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME)).until(ExpectedConditions.visibilityOfElementLocated(PageObject.safetyMessageButton()));
        Assert.assertTrue(safetyMessage.isDisplayed());
        nextButton.click();
        nextButton.click();
        WebElement getSecretPhrase = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME)).until(ExpectedConditions.visibilityOfElementLocated(By.id("canvas")));
        String secretPhrase = getSecretPhrase.getText();
        nextButton.click();
        List<String> passphrase = Helper.extractPassPhrase(secretPhrase);
        for (int i = 0; i <= 20; i++) {
            driver.findElement(By.xpath("//input[data-testid='" + passphrase.get(i) + "-selectable'")).click();
        }
        nextButton.click();
        nextButton.click();
        WebElement openWallet = driver.findElement((PageObject.openWalletButton()));
        openWallet.click();
        nextButton.click();
        Assert.assertTrue(driver.findElement(By.xpath(PageObject.NEXT_BUTTON)).getText().contains(confirmationMessage));
        nextButton.click();
    }
}

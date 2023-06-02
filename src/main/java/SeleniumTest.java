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
import java.util.concurrent.TimeUnit;

public class SeleniumTest {

    public static void main(String[] args) throws InterruptedException {

        String password = "Test1235%!";
        String extensionLandingPage = "chrome-extension://egjidjbpglichdcondbcbdnbeeppgdph/home.html#/onboarding";

        int WAIT_TIME = 10;

        String CREATE_NEW_WALLET_BUTTON = "//input[@data-testid='create-new-wallet']";
        String CREATE_NEW_PASSWORD_INPUT = "//input[@data-testid='password']";
        String CONFIRM_PASSWORD_INPUT = "//input[@data-testid='confirm-password";
        String TERMS_CHECKBOX = "//input[@data-testid='terms-checkbox";
        String NEXT_BUTTON = "//button[@data-testid='next-button'";
        String CONFIRMATION_MESSAGE = "I'm ready to use Trust Wallet!";
        String OPEN_WALLET_BUTTON = "//button[@data-testid='open-wallet-button'";


        ChromeOptions opt = new ChromeOptions();
        opt.addExtensions(new File("Trust-Wallet.crx"));
        ChromeDriver driver = new ChromeDriver(opt);

        driver.get(extensionLandingPage);

        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        System.out.println("Number of tabs is: " + tabs.size());

        driver.switchTo().window(tabs.get(0)); // change tabs

        WebElement createNewWallet = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME)).until(ExpectedConditions.elementToBeClickable(By.xpath(CREATE_NEW_WALLET_BUTTON)));

        createNewWallet.click();
        WebElement createPassword = driver.findElement(By.xpath(CREATE_NEW_PASSWORD_INPUT));
        createPassword.sendKeys(password);
        WebElement confirmPassword = driver.findElement(By.xpath(CONFIRM_PASSWORD_INPUT));
        confirmPassword.sendKeys(password);

        WebElement termsCheckbox = driver.findElement(By.xpath(TERMS_CHECKBOX));
        termsCheckbox.click();

        WebElement nextButton = driver.findElement(By.xpath(NEXT_BUTTON));
        nextButton.click();
        Assert.assertTrue(driver.findElement(By.xpath(NEXT_BUTTON)).isDisplayed());

        nextButton.click();
        nextButton.click();

        WebElement getSecretPhrase = driver.findElement(By.id("canvas"));
        String secretPhrase = getSecretPhrase.getText();

        nextButton.click();

        List<String> passphrase = Helper.extractPassPhrase(secretPhrase);

        for (int i = 0; i <= 20; i++) {
            driver.findElement(By.xpath("//input[data-testid='" + passphrase.get(i) + "-selectable'")).click();
        }
        nextButton.click();
        nextButton.click();

        WebElement openWallet = driver.findElement(By.xpath(OPEN_WALLET_BUTTON));
        openWallet.click();

        nextButton.click();
        Assert.assertTrue(driver.findElement(By.xpath(NEXT_BUTTON)).getText().contains(CONFIRMATION_MESSAGE));
        nextButton.click();
    }
}

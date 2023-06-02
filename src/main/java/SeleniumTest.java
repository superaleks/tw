import graphql.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

        String password = "JuanEsteban14!";
        String extensionLandingPage = "chrome-extension://egjidjbpglichdcondbcbdnbeeppgdph/home.html#/onboarding";

        int WAIT_TIME = 60;

        String CREATE_NEW_WALLET_BUTTON = "//div[@data-testid='create-new-wallet']";
        String CREATE_NEW_PASSWORD_INPUT = "//input[@data-testid='password']";
        String CONFIRM_PASSWORD_INPUT = "//input[@data-testid='confirm-password']";
        String TERMS_CHECKBOX = "//label[@data-testid='terms-checkbox']";
        String NEXT_BUTTON = "//button[@data-testid='next-button']";
        String CONFIRMATION_MESSAGE = "I'm ready to use Trust Wallet!";
        String OPEN_WALLET_BUTTON = "//button[@data-testid='open-wallet-button']";
        String SAFETY_MESSAGE = "//button[@data-testid='keep-safe-link']";

        ChromeOptions opt = new ChromeOptions();
        opt.addExtensions(new File("Trust-Wallet.crx"));
        ChromeDriver driver = new ChromeDriver(opt);
        driver.get(extensionLandingPage);
        WebElement createNewWallet = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CREATE_NEW_WALLET_BUTTON)));
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        System.out.println("Number of tabs is: " + tabs.size());

        driver.switchTo().window(tabs.get(0));


        createNewWallet.click();
        WebElement createPassword = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CREATE_NEW_PASSWORD_INPUT)));

        createPassword.sendKeys(password);
        WebElement confirmPassword = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CONFIRM_PASSWORD_INPUT)));
        confirmPassword.sendKeys(password);

        WebElement termsCheckbox = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TERMS_CHECKBOX)));
        termsCheckbox.click();
        WebElement nextButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(NEXT_BUTTON)));
        nextButton.click();
        //Thread.sleep(10000L);

        WebElement safetyMessage = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SAFETY_MESSAGE)));
        System.out.println("Test is here: " + safetyMessage.getText());
//        Assert.assertTrue(driver.findElement(By.xpath(NEXT_BUTTON)).isDisplayed());

        //nextButton.click();
        //nextButton.click();

        WebElement getSecretPhrase = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME)).until(ExpectedConditions.visibilityOfElementLocated(By.id("canvas")));
      //  WebElement getSecretPhrase = driver.findElement(By.id("canvas"));
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

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject extends PageFactory {

    WebDriver driver;
    public static String CREATE_NEW_WALLET_BUTTON = "//div[@data-testid='create-new-wallet']";
    public static String CREATE_NEW_PASSWORD_INPUT = "//input[@data-testid='password']";
    public static String CONFIRM_PASSWORD_INPUT = "//input[@data-testid='confirm-password']";
    public static String TERMS_CHECKBOX = "//label[@data-testid='terms-checkbox']";
    public static String NEXT_BUTTON = "//button[@data-testid='next-button']";
    public static String OPEN_WALLET_BUTTON = "//button[@data-testid='open-wallet-button']";
    public static String SAFETY_MESSAGE_BUTTON = "//button[@data-testid='keep-safe-link']";

    public PageObject(WebDriver driver) {
        this.driver = driver;
    }

    public static By newWalletButton() {
        return By.xpath(CREATE_NEW_WALLET_BUTTON);
    }

    public static By newPasswordInput() {
        return By.xpath(CREATE_NEW_PASSWORD_INPUT);
    }

    public static By confirmPasswordInput() {
        return By.xpath(CONFIRM_PASSWORD_INPUT);
    }

    public static By termsCheckbox() {
        return By.xpath(TERMS_CHECKBOX);
    }

    public static By nextButton() {
        return By.xpath(NEXT_BUTTON);
    }

    public static By openWalletButton() {
        return By.xpath(OPEN_WALLET_BUTTON);
    }

    public static By safetyMessageButton() {
        return By.xpath(SAFETY_MESSAGE_BUTTON);
    }


}

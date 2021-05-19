package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LillyPage extends BaseHelper {

    @FindBy(className = "authorization-link")
    WebElement loginBtn;
    @FindBy(id = "email")
    WebElement emailField;
    @FindBy(id = "pass")
    WebElement passwordField;
    @FindBy(id = "send2")
    WebElement submitBtn;

    WebDriver driver;

    public LillyPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void navigateToPage() {
        driver.get("https://shop.lilly.rs/");
    }

    private void clickOnPrijaviteseButton() {
        loginBtn.click();
    }

    private void enterEmail(String email) {
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
        emailField.sendKeys(email);
    }

    private void enterPassword(String password) {
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("pass")));
        passwordField.sendKeys(password);
    }

    private void confirmButton() {
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("send2")));
        submitBtn.click();

    }

    public void loginForm(String email, String password) {
        navigateToPage();
        clickOnPrijaviteseButton();
        enterEmail(email);
        enterPassword(password);
        confirmButton();
    }

}
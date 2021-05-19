package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.LillyPage;

public class LillyTest extends BaseTest {

    @Test
    public void positiveLillyTest() throws InterruptedException {

        String email = "123aitorfernandez123@gmail.com";
        String password = "123456789";

        LillyPage LillyLoginPage = new LillyPage(driver);
        LillyLoginPage.loginForm(email, password);

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("welcome")));

        WebElement usernameText = driver.findElement(By.className("welcome"));

        Assert.assertTrue("Alert message does not appear",
                usernameText.getText().contains("Dobrodošli, Aitor Fernandez!"));

//        Assert.assertTrue(usernameText.isDisplayed());

        //due to visual confirmation
        Thread.sleep(4000);
    }

    @Test
    public void negativeLillyTest() throws InterruptedException {

        String email = "123aitorfernandez123@gmail.com";
        String password = "123";

        LillyPage LillyLoginPage = new LillyPage(driver);
        LillyLoginPage.loginForm(email, password);

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("message-error")));
        WebElement alertMsg = driver.findElement(By.className("message-error"));

        Assert.assertTrue("Alert message does not appear",
                alertMsg.getText().contains("Uneti podaci nisu ispravni. Molimo da proverite email i lozinku i pokušate ponovo."));

//        Assert.assertTrue(alertMsg.isDisplayed());

        //due to visual confirmation
        Thread.sleep(4000);
    }
}

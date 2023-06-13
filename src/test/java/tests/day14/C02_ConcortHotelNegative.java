package tests.day14;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import utilities.TestBase;

public class C02_ConcortHotelNegative extends TestBase {
    @Test
    public void negativeLoginTest(){
        // https://www.concorthotel.com/ adresine gidin
        // login butonuna basin.
        // test data username: manager
        // test data password: manager1!
        // Degerleri ile sayfaya basarili sekilde girilemedigini test edin.

        driver.get("https://www.concorthotel.com/");
        ConcortHotelPage concortHotelPage = new ConcortHotelPage(driver);
        concortHotelPage.login.click();
        concortHotelPage.userNameSearchBox.sendKeys("manager");
        concortHotelPage.passwordBox.sendKeys("manager1");
        concortHotelPage.loginButton.click();
        Assert.assertTrue(concortHotelPage.loginFailed.isDisplayed());

    }
}

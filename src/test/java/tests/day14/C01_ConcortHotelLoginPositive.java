package tests.day14;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import pages.ConcortHotelPage;
import utilities.TestBase;

public class C01_ConcortHotelLoginPositive extends TestBase {

    @Test
    public void positiveLoginTest(){
        // https://www.concorthotel.com/ adresine gidin
        // login butonuna basin.
        // test data username: manager
        // test data password: Manager1!
        // Degerleri ile sayfaya basarili sekilde girildigini test edin.
        driver.get("https://www.concorthotel.com/");
        ConcortHotelPage concortHotelPage = new ConcortHotelPage(driver);
        concortHotelPage.login.click();
        concortHotelPage.userNameSearchBox.sendKeys("manager");
        concortHotelPage.passwordBox.sendKeys("Manager1!");
        concortHotelPage.loginButton.click();
        Assert.assertTrue(concortHotelPage.ergebnis.isDisplayed());

    }
}

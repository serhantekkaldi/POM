package tests.day14;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import utilities.ConfigReader;
import utilities.TestBase;

public class C05_NegativeTestConfigReader extends TestBase {
    @Test
    public  void test(){
        // https://www.concorthotel.com/ adresine gidin
        // login butonuna basin.
        // test data username: manager
        // test data password: manager1!
        // Degerleri ile sayfaya basarili sekilde girilemedigini test edin.

        driver.get(ConfigReader.getProperty("CHUrl"));
        ConcortHotelPage concortHotelPage  =new ConcortHotelPage(driver);
        concortHotelPage.login.click();
        concortHotelPage.userNameSearchBox.sendKeys(ConfigReader.getProperty("CHInvalidUserName"));
        concortHotelPage.passwordBox.sendKeys(ConfigReader.getProperty("CHInvalidPassword"));
        concortHotelPage.loginButton.click();
        Assert.assertTrue(concortHotelPage.loginFailed.isDisplayed()); 

    }
}

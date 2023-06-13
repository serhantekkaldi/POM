package tests.day14;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import utilities.ConfigReader;
import utilities.TestBase;

public class C03_PositiveTestConfigReader extends TestBase {

    @Test
    public  void positiveTestConfig(){
        // https://www.concorthotel.com/ adresine gidin
        // login butonuna basin.
        // test data username: manager
        // test data password: Manager1!
        // Degerleri ile sayfaya basarili sekilde girildigini test edin.

        driver.get(ConfigReader.getProperty("CHUrl"));
        ConcortHotelPage concortHotelPage = new ConcortHotelPage(driver);
        concortHotelPage.login.click();
        concortHotelPage.userNameSearchBox.sendKeys(ConfigReader.getProperty("CHValidUsername"));
        concortHotelPage.passwordBox.sendKeys(ConfigReader.getProperty("CHValidPassword"));
        concortHotelPage.loginButton.click();
        Assert.assertTrue(concortHotelPage.ergebnis.isDisplayed());

    }
}

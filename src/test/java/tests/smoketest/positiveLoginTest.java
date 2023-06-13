package tests.smoketest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class positiveLoginTest {
    @Test
    public void pozitiveLogintest(){
        // https://qa-environment.concorthotel.com/ adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        // Login butonuna basin
        QAConcortPage qaConcortPage = new QAConcortPage();
        qaConcortPage.login.click();
        //test data username: manager
        qaConcortPage.userNameSearchBox.sendKeys(ConfigReader.getProperty("CHQValidUsername"));
        //test  data password: Manager1!
        qaConcortPage.passwordBox.sendKeys(ConfigReader.getProperty("CHQValidPassword"));
        qaConcortPage.loginButton.click();
        // Degerleri girildiginde sayfaya basarili sekilde girildigini test edin
        Assert.assertTrue(qaConcortPage.ergebnis.isDisplayed());
        Driver.closeDriver();


    }
}

package tests.smoketest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class negativeLoginTest {


    // Farkli Test Methodunda 3 senaryoyu test et:
    //        - yanlisSifre:
    //        - yanlisKullanici
    //        - yanlisSifreKullanici
    // test data:  yanlis username: manager1
    //             yanlis password: manager1!
    // https:////qa-environment.concorthotel.com/ adresine gidin
    // Login butonuna basin
    // Verilen senaryolar ile giris yapilmadigini test edin

    QAConcortPage qaConcortPage;
    @Test(priority = -1)
    public void test(){
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        qaConcortPage=new QAConcortPage();
        qaConcortPage.login.click();
    }
    @Test(dependsOnMethods = "test" )
    public void yanlisSifre(){
        qaConcortPage=new QAConcortPage();
        qaConcortPage.userNameSearchBox.sendKeys(ConfigReader.getProperty("CHQValidUsername"));
        qaConcortPage.passwordBox.sendKeys(ConfigReader.getProperty("CHQInvalidPassword"));
        qaConcortPage.loginButton.click();
        Assert.assertTrue(qaConcortPage.loginFailed.isDisplayed());
    }
    @Test(dependsOnMethods = "test")
    public void yanlisKullanici(){
        qaConcortPage=new QAConcortPage();
        qaConcortPage.userNameSearchBox.clear();
        qaConcortPage.userNameSearchBox.sendKeys(ConfigReader.getProperty("CHQInvalidUserName"));
        qaConcortPage.passwordBox.clear();
        qaConcortPage.passwordBox.sendKeys(ConfigReader.getProperty("CHQValidPassword"));
        qaConcortPage.loginButton.click();
        Assert.assertTrue(qaConcortPage.loginFailed.isDisplayed());

    }
    @Test(dependsOnMethods = "test")
    public void yanlisSifreKullanici(){
        qaConcortPage=new QAConcortPage();
        qaConcortPage.userNameSearchBox.clear();
        qaConcortPage.userNameSearchBox.sendKeys(ConfigReader.getProperty("CHQInvalidUserName"));
        qaConcortPage.passwordBox.clear();
        qaConcortPage.passwordBox.sendKeys(ConfigReader.getProperty("CHQInvalidPassword"));
        qaConcortPage.loginButton.click();
        Assert.assertTrue(qaConcortPage.loginFailed.isDisplayed());
        Driver.closeDriver();
    }
}

package tests.day13;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.TestBase;

public class C02_PagesFacebook extends TestBase {
    // facebook login sayfasina gidin
    // kullanici adi : techproed
    // sifre :12345
    // yazdigimizda giris yapamadigimizi test edin
    // page sayfasinda cookiesGec() methodu olusturun

    @Test
    public void testFacebook(){
        driver.get("https://www.facebook.com/");
        FacebookPage facebookPage = new FacebookPage();

        facebookPage.cookies();
        facebookPage.userNameBox.sendKeys("techproed");
        facebookPage.passwordBox.sendKeys("12345");
        facebookPage.loginButton.click();

        Assert.assertTrue(facebookPage.ergebnis.isDisplayed());



    }



}

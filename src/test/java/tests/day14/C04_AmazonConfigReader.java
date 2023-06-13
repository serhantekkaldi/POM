package tests.day14;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.TestBase;

public class C04_AmazonConfigReader extends TestBase {

    @Test
    public void test(){
        // amazon sayfasina gidin
        // nutella icin arama yapin
        // sonuc sayisini yazdirin ve sonuc yazisinin nutella icerdigini test edin

        driver.get(ConfigReader.getProperty("amazonUrl"));
        AmazonPage amazonPage = new AmazonPage(driver);
        amazonPage.searchbox.sendKeys(ConfigReader.getProperty("amazonArananKelime")+ Keys.ENTER);
        System.out.println(amazonPage.sonuc.getText());
        Assert.assertTrue(amazonPage.sonuc.getText().contains(ConfigReader.getProperty("amazonArananKelime")));

    }
}

package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.TestBase;

public class C01_Pages extends TestBase {
    // amazon sayfasina gidin
    // nutella icin arama yapin
    // sonuc sayisini yazdirin ve sonu yazisinin Nutella icerdigini test edin.

    @Test
    public void test(){

        driver.get("https://www.amazon.com");
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella"+ Keys.ENTER);
        WebElement sonuc = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonuc.getText());
        Assert.assertTrue(sonuc.getText().contains("Nutella"));

    }

    @Test
    public void testPom(){
        driver.get("https://www.amazon.com");
        AmazonPage amazonPage = new AmazonPage(driver);
        amazonPage.searchbox.sendKeys("Nutella"+Keys.ENTER);
        System.out.println(amazonPage.sonuc.getText());
        Assert.assertTrue(amazonPage.sonuc.getText().contains("Nutella"));
    }

}

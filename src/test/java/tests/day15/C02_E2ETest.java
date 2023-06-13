package tests.day15;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_E2ETest {
    @Test
    public void createHotel() throws InterruptedException {
        // 1. bir method olusturun : createHotel
        // 2. https://qa-environment.concorthotel.com/ adresine git
        // 3. Username textbox ve password metin kutularini locate edin ve asagidaki verileri girin.
        //       a. username : manager
        //       b. Password : Manager1!
        // 4. Login butonuna tiklayin
        QAConcortPage qaConcortPage=new QAConcortPage();
        qaConcortPage.ConcortHotelLogin();
        // 5. Hotel Managament/Hotel List nemusunun ADD TOTEL butonuna tiklayin
        qaConcortPage.hotelManagement.click();
        qaConcortPage.hotelList.click();
        qaConcortPage.addHotel.click();
        // 6. Acilan sayfadaki tüm metin kutularina istediginiz verileri girin
        Actions actions = new Actions(Driver.getDriver());
        Faker faker = new Faker();
        actions.click(qaConcortPage.addHotelCodeBox).sendKeys(faker.address().zipCode())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().name())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().fullAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().phoneNumber())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress()).perform();


        Select select= new Select(qaConcortPage.selectGroup);
        select.selectByVisibleText(ConfigReader.getProperty("CHQAddHotelDropdownOption"));
        // 7. Save butonuna tiklayin.
        actions.sendKeys(Keys.PAGE_DOWN);
        Thread.sleep(1000);
        qaConcortPage.saveButton.click();
        // 8. "Hotel was inserted successfully" textinin göründügünü test edin
        Thread.sleep(1000);
        System.out.println(qaConcortPage.addHotelSuccesfullText.getText());
        Assert.assertTrue(qaConcortPage.addHotelSuccesfullText.isDisplayed());

        // 9. OK butonuna tiklayin
        qaConcortPage.okButton.click();
        Driver.closeDriver();

    }
}

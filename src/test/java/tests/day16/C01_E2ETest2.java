package tests.day16;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_E2ETest2 {
    @Test
    public void RoomCreateTest() throws InterruptedException {
        // 3. https://qa-environment.concorthotel.com/ adresine git

        // 4. Username textbox ve password metin kutularini locate edin ve asagidaki verileri girin.
        //       a. username : manager
        //       b. Password : Manager1!
        // 5. Login butonuna tiklayin
        QAConcortPage qaConcortPage = new QAConcortPage();
        qaConcortPage.ConcortHotelLogin();
        // 6. Hotel Managament/Hotel List nemusunun ADD TOTEL butonuna tiklayin
        qaConcortPage.hotelManagement.click();
        qaConcortPage.hotelRoomLink.click();
        qaConcortPage.addRoomButton.click();
        // 7. Acilan sayfadaki tüm metin kutularina istediginiz verileri girin
        Select select = new Select(qaConcortPage.addRoomIdDropDown);
        select.selectByVisibleText(ConfigReader.getProperty("CHQAddRoomIdHotel"));
        // 8. Save butonuna tiklayin.
        Faker faker=new Faker();
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB)
                .sendKeys(faker.address().zipCode())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().name())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().cityName())
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("CHQAddRoomDescription"))
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("CHQAddRoomPreis"))
                .sendKeys(Keys.TAB).perform();
        Select select1=new Select(qaConcortPage.addRoomTypeDropDown);
        select1.selectByVisibleText(ConfigReader.getProperty("CHQAddRoomType"));
        actions.sendKeys(Keys.TAB)
                .sendKeys(String.valueOf(faker.number().numberBetween(1,2)))
                .sendKeys(Keys.TAB)
                .sendKeys(String.valueOf(faker.number().numberBetween(0,4)))
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.SPACE).perform();

        qaConcortPage.addRoomSaveButton.click();

        // 9. "Hotel was inserted successfully" textinin göründügünü test edin
        Thread.sleep(2000);
        Assert.assertTrue(qaConcortPage.addRoomSuccesfulText.isDisplayed());
        // 10. OK butonuna tiklayin
        qaConcortPage.addRoomOKButton.click();
        // 11. Hotel rooms linkine tiklayin
        actions.sendKeys(Keys.HOME).perform();
        Thread.sleep(2000);
        qaConcortPage.addRoomHotelRoomsLink.click();
        // 12. "LIST OF HOTELROOMS2 textinin göründügünü dogrulayin.
        Assert.assertTrue(qaConcortPage.addRoomHotelsRoomListText.isDisplayed());
        Driver.closeDriver();


    }
}

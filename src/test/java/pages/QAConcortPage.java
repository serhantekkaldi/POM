package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class QAConcortPage {
    public WebDriver driver;
    public QAConcortPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(linkText = "Log in")
    public WebElement login;

    @FindBy(id = "UserName")
    public WebElement userNameSearchBox;

    @FindBy(id = "Password")
    public WebElement passwordBox;

    @FindBy(id="btnSubmit")
    public WebElement loginButton;

    @FindBy(xpath = "//span[text()='ListOfUsers']")
    public WebElement ergebnis;

    @FindBy(xpath = "//*[.='Try again please']")
    public WebElement loginFailed;

    @FindBy(xpath = "//span[text()='Hotel Management']")
    public WebElement hotelManagement;

    @FindBy(partialLinkText ="Hotel List")
    public WebElement hotelList;

    @FindBy(xpath = "//span[text()='Add Hotel ']")
    public WebElement addHotel;

    @FindBy(id = "Code")
    public  WebElement addHotelCodeBox;

    @FindBy(id = "IDGroup")
    public WebElement selectGroup;

    @FindBy(id = "btnSubmit")
    public WebElement saveButton;

    @FindBy(xpath = "//div[text()='Hotel was inserted successfully']")
    public WebElement addHotelSuccesfullText;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement okButton;

    @FindBy(partialLinkText = "Hotel Rooms")
    public WebElement hotelRoomLink;

    @FindBy(xpath = "//span[text()='Add Hotelroom ']")
    public WebElement addRoomButton;

    @FindBy(id = "IDHotel")
    public WebElement addRoomIdDropDown;

    @FindBy(id = "IDGroupRoomType")
    public WebElement addRoomTypeDropDown;

    @FindBy(id = "btnSubmit")
    public WebElement addRoomSaveButton;

    @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement addRoomSuccesfulText;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement addRoomOKButton;

    @FindBy(linkText = "Hotelrooms")
    public WebElement addRoomHotelRoomsLink;

    @FindBy(xpath = "//span[text()='List Of Hotelrooms']")
    public WebElement addRoomHotelsRoomListText;

    @FindBy(xpath = "//thead/tr[1]/th")
    public List<WebElement> basliklarListesi;

    @FindBy(xpath = "//tbody")
    public WebElement tBodyTumu;

    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> satirlarListesi;

    @FindBy(xpath = "//tbody//tr[1]")
    public WebElement birinciSatir;



    public void ConcortHotelLogin(){
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        QAConcortPage qaConcortPage = new QAConcortPage();
        qaConcortPage.login.click();
        qaConcortPage.userNameSearchBox.sendKeys(ConfigReader.getProperty("CHQValidUsername"));
        qaConcortPage.passwordBox.sendKeys(ConfigReader.getProperty("CHQValidPassword"));
        qaConcortPage.loginButton.click();
    }
}

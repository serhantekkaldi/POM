package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class AmazonPage {

    WebDriver driver;
    // Bir page sayfasi olsuturuldugunda mutlaka yapmamiz gereken ;
    // bir consturctor olusturup driver a ilk degeri atamaktir.(instantiate)

    public AmazonPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="twotabsearchtextbox")
    public WebElement searchbox;

    @FindBy(xpath="//div[@class='a-section a-spacing-small a-spacing-top-small']")
    public WebElement sonuc;

    @FindBy(id = "searchDropdownBox")
    public  WebElement dropDown;

    @FindBy(linkText = "ListOfUsers")
    public WebElement ilkUrun;

}

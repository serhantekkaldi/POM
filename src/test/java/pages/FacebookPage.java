package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookPage {

    WebDriver driver;

    public void FacebookPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(id="email")
    public WebElement userNameBox;

    @FindBy(id="pass")
    public  WebElement passwordBox;

    @FindBy(name = "login")
    public WebElement loginButton;

    @FindBy(className ="9ay7")
    public  WebElement ergtebnis;

    public void cookies(){
        WebElement cook =  driver.findElement(By.xpath("//button[@class='_42ft _4jy0 _9xo7 _4jy3 _4jy1 selected _51sy']"));
        Actions actions = new Actions(driver);
        actions.click(cook).perform();



    }

}

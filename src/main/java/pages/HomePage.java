package pages;

import baseclass.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage {
    BaseTest bt = new BaseTest();
    WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    @FindBy(xpath = "//*[@aria-label='View profile and more']")
    private WebElement userIcon;
    @FindBy(xpath = "(//*[@role='menuitem'])[6]/strong[1]")
    private WebElement userName;

    public void verifySignedUser(){
        userIcon.click();
        String userNameText = userName.getText();
        Assert.assertEquals(userNameText,bt.getValue("username"));
    }
}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginInPage {
    WebDriver driver;
    public LoginInPage(WebDriver driver){
        this.driver = driver;
    }
    @FindBy(id="login_field")
    private WebElement txtUserName;
    @FindBy(id="password")
    private WebElement txtPassword;
    @FindBy(xpath = "//input[@value='Sign in']")
    private WebElement btnSignIn;
    @FindBy(xpath = "//div[@aria-label='Repositories']/div[1]/h2[1]")
    private WebElement txtHeading;

    public void logIn(String userName,String passWord){
        txtUserName.sendKeys(userName);
        txtPassword.sendKeys(passWord);
        btnSignIn.click();
        String value = txtHeading.getText();
        Assert.assertEquals("Repositories\n" +
                "New",value);
    }
}

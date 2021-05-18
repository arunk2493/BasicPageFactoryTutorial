package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage {
    WebDriver driver;
    public SignInPage(WebDriver driver){
        this.driver = driver;
    }
    @FindBy(linkText="Sign in")
    private WebElement linkSignIn;

    public void clickSignIn(){
        linkSignIn.click();
    }
}

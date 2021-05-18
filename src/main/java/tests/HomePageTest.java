package tests;

import baseclass.BaseTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginInPage;
import pages.SignInPage;

public class HomePageTest extends SignInTest {
    HomePage home = PageFactory.initElements(driver,HomePage.class);
    String user = getValue("username");
    String password = getValue("password");
    @Test
    public void launchHomePage(){
        try {
            signIn();
            home.verifySignedUser();
            testLog.log(Status.PASS,"Launched Git hub home page successfully");
        }catch (Exception e){
            testLog.log(Status.FAIL,"Not in Home Pages");
        }
    }
}

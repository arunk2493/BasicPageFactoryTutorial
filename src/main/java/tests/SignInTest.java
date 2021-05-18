package tests;

import baseclass.BaseTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.LoginInPage;
import pages.SignInPage;

public class SignInTest extends BaseTest {
    @Test
    public void signIn(){
        SignInPage signin = PageFactory.initElements(driver,SignInPage.class);
        LoginInPage login = PageFactory.initElements(driver,LoginInPage.class);
        String user = getValue("username");
        String password = getValue("password");
        try{
            signin.clickSignIn();
            testLog.log(Status.PASS,"Launched Git hub successfully");
        }catch (Exception e){
            testLog.log(Status.FAIL,"Unable to launch git hub");
        }
        try{
            login.logIn(user,password);
            testLog.log(Status.PASS,"Login successfully");
        }catch (Exception e){
            testLog.log(Status.FAIL,"nOt logged in");
        }

    }
}

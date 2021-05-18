package baseclass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver = null;
    public ExtentTest testLog = null;
    public ExtentReports report = null;
    public ExtentHtmlReporter htmlReporter = null;
    public String path = System.getProperty("user.dir");
    Properties prop = new Properties();
    public String propvalue = null;

    @BeforeSuite
    public void initialize() throws IOException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        //To maximize browser
        driver.manage().window().maximize();
        //Implicit wait
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //To open facebook
        driver.get("https://github.com/");

    }
    @BeforeTest
    public void initiateTest(ITestContext suite){
        htmlReporter = new ExtentHtmlReporter("/Users/apple/Documents/projects/Study/Backup Study/Frameworks/BasicPageFactory/Reports/"+"Report.html");
        String testName = suite.getCurrentXmlTest().getName().toString();
        report = new ExtentReports();
        report.attachReporter(htmlReporter);
        testLog=report.createTest(testName);
        htmlReporter.config().setDocumentTitle("Extent Report Demo");
        htmlReporter.config().setReportName(testName);
        htmlReporter.config().setTheme(Theme.STANDARD);
    }
    @AfterTest
    public void tearTest(){
        report.close();
        report.flush();
    }

    @AfterSuite
    //Test cleanup
    public void TeardownTest()
    {
        driver.quit();
    }

    public String getValue(String keyValue)  {
        String propFile =path+"//src//main//resources//data.properties";
        try{
            FileInputStream fis =  new FileInputStream(propFile);
            prop.load(fis);
            propvalue = prop.getProperty(keyValue);
            System.out.println(propvalue);
        }catch (Exception e){
            e.printStackTrace();
        }
        return propvalue;
    }
}

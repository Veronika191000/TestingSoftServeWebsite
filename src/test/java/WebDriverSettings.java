import browser.BrowserChange;
import enums.Browsers;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class WebDriverSettings {
    protected WebDriver driver;
       protected BrowserChange browsers;
    static String url = "https://career.softserveinc.com/uk-ua/learning-and-certification";


    @BeforeTest
    @Parameters({"browser"})
    public void setUp(Browsers browser) {
        browsers = new BrowserChange();
        driver = browsers.browserChange(browser);
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--disable-notifications");
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @BeforeClass
    public void navigate() {
        driver.get(url);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}

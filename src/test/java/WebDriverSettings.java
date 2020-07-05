import browser.BrowserChange;
import enums.Browsers;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import variables.InitializeVariable;

public class WebDriverSettings {
    protected WebDriver driver;
    protected BrowserChange browsers;
    protected InitializeVariable var;
    protected String url;


    @BeforeTest
    @Parameters({"browser"})
    public void setUp(Browsers browser) {
        browsers = new BrowserChange();
        driver = browsers.browserChange(browser);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

    }

    @Parameters({"language"})
    @BeforeClass
    public void navigate(String language) {
        var = new InitializeVariable();
        if (language.equalsIgnoreCase("UA")) url = var.urlUA;
        else url = var.urlEN;
        driver.get(url);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}

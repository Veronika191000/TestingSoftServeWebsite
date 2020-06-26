package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.MatcherAssert.assertThat;

public class TrainingAndSertification {
    protected WebDriver driver;
    private final Wait<WebDriver> waits;

    public TrainingAndSertification(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        waits = new WebDriverWait(driver, 5).ignoring(StaleElementReferenceException.class, ElementNotVisibleException.class);
    }

    @FindBy(how = How.XPATH, using = "//h1[@class='title-heading']")
    private WebElement heading;

    @FindBy(how = How.XPATH, using = "//*[@class='filters-title']")
    private List<WebElement> filtresTitle;

    @FindBy(how = How.XPATH, using = "//ul[@class='card-options']//li[2]")
    private List<WebElement> formatCertificate;

    @FindBy(how = How.XPATH, using = "//ul[@class='card-options']//li[1]")
    private List<WebElement> listCost;

//    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'not-expanded')]//div[contains(text(), 'Формат')]")
//    private List<WebElement> filtresChecked;

    public void checkTitleLearning(String title) {
        Assert.assertEquals(heading.getText(), title);
        System.out.println(heading.getText());
    }

    public void checkFilterTitle(List<String> titlesFilter) {
        List<String> currentResult = new ArrayList<String>();
        List<WebElement> actualResult = filtresTitle;
        for (WebElement listOfTitles : actualResult) {
            currentResult.add(listOfTitles.getText());
        }
        Assert.assertEquals(titlesFilter, currentResult);
    }

    //checking checkbox Format
    public void verifyFormatResult(String formatName) {
        waits.until(ExpectedConditions.visibilityOfAllElements(formatCertificate));
        checkingList(formatName, formatCertificate);
    }

    //cheking checkbox Payment
    public void verifyPaymentResult(String payment) {
        waits.until(ExpectedConditions.visibilityOfAllElements(listCost));
        checkingList(payment, listCost);
    }

    public void checkingList(String formatName, List<WebElement> elements) {
        List<String> currentResult = new ArrayList<String>();
        List<WebElement> actualResult = elements;
        for (WebElement listOfFormat : actualResult) {
            currentResult.add(listOfFormat.getText());
        }
        System.out.println(currentResult);
        assertThat(currentResult, everyItem(containsString(formatName.toUpperCase())));
    }

    public void selectCheckbox(String titleName, String option) {
        String optionXpath = String.format("//a[text()='%s']/../preceding-sibling::div", option);
        String listXpath = String.format("//div[contains(@class, 'not-expanded')]//div[contains(text(), '%s')]", titleName);
        System.out.println(optionXpath);
        System.out.println(listXpath);
        boolean searchElem = driver.findElements(By.xpath(listXpath)).size() > 0;
        if (searchElem) {
            driver.findElement(By.xpath(listXpath)).click();
        }
        driver.findElement(By.xpath(optionXpath)).click();
    }
}

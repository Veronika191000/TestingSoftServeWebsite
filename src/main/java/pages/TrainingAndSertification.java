package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Locatable;
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

    @FindBy(how = How.XPATH, using = "//ul[@class='card-options']//li[3]")
    private List<WebElement> listStatus;

    @FindBy(how = How.XPATH, using = "//div[@class='card-content-body']/h3")
    private List<WebElement> directionList;

    @FindBy(how = How.XPATH, using = "//h4[@class='card-location']")
    private List<WebElement> listPlaces;

    @FindBy(how = How.XPATH, using = "//div[@class='search']/input")
    private WebElement search;

    public void verifySearchResult(String query){
        search.sendKeys(query);
        search.sendKeys(Keys.ENTER);
        waits.until(ExpectedConditions.visibilityOfAllElements(directionList));
        checkingList(query, directionList);
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

    public void verifyStatusResult(String status) {
        waits.until(ExpectedConditions.visibilityOfAllElements(listStatus));
        checkingList(status, listStatus);
    }

    public void verifyLocationResult(String location) {
        waits.until(ExpectedConditions.visibilityOfAllElements(listPlaces));
        System.out.println(location);
        checkingList(location, listPlaces);
    }
    public void verifyDirectionResult(String direction) {
        waits.until(ExpectedConditions.visibilityOfAllElements(directionList));
        System.out.println(direction);
        checkingList(direction, directionList);
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

    //checkboxes with one option
    public void selectCheckbox(String titleName, String option) {
        String optionXpath = String.format("//a[text()='%s']/../preceding-sibling::div", option);
        clickOptionsTitle(titleName);
        System.out.println(optionXpath);
        waits.until(ExpectedConditions.elementToBeClickable(By.xpath(optionXpath)));
        driver.findElement(By.xpath(optionXpath)).click();
    }

    public void clickOptionsTitle(String titleName){
        String listXpath = String.format("//div[contains(@class, 'not-expanded')]//div[contains(text(), '%s')]", titleName);
        boolean searchElem = driver.findElements(By.xpath(listXpath)).size() > 0;
        System.out.println(listXpath);
        if (searchElem) {
            WebElement listX = driver.findElement(By.xpath(listXpath));
            listX.click();
        }
    }
    public void selectCheckboxTwoOptions(String titleName, String option, String secondOption) {
        clickOptionsTitle(titleName);
        String firstOptionXpath = String.format("//li[@data-uid=\"%s\" and @aria-expanded=\"false\"]//div[contains(@class,\"e-icons\")]", option);
        String secondOptionXpath = String.format("//li[@class=\"e-list-item e-level-2\" and @data-uid=\"%s\"]", secondOption);
        boolean searchElem = driver.findElements(By.xpath(firstOptionXpath)).size() > 0;
        System.out.println(firstOptionXpath);
        System.out.println(secondOptionXpath);
        if (searchElem) {
            WebElement listX = driver.findElement(By.xpath(firstOptionXpath));
            listX.click();
        }
        waits.until(ExpectedConditions.elementToBeClickable(By.xpath(secondOptionXpath)));
        driver.findElement(By.xpath(secondOptionXpath)).click();
    }
//////////////////////////////////////////////////
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
}

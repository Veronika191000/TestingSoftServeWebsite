import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.TrainingAndSertification;
import variables.InitializeVariable;

public class MainTestPage extends WebDriverSettings {
    private TrainingAndSertification training;
    private InitializeVariable variable;
    //  private WebDriver driver;

    //    private Variables var;
    //rivate String titleLearning = "НАВЧАННЯ І СЕРТИФІКАЦІЯ";
    // private static final String[] titles = {"ФОРМАТ", "НАПРЯМКИ", "ОПЛАТА", "ЛОКАЦІЯ", "СТАТУС", "ДАТА ПРОВЕДЕННЯ"};//?????????????
    // List<String> titlesFilter = Arrays.asList(titles);

    @BeforeTest
    @Parameters({"language"})
    public void initialize(String language) {
        training = new TrainingAndSertification(driver);
        variable = new InitializeVariable();
        variable = variable.initDependOnLanguage(language);
    }


//    @Test
//    public void checkingTitleLearning() {
//        training.checkTitleLearning(titleLearning);
//    }

    @Test
    public void checkingTitleFilterFormatSertif() {
        //  training.checkFilterTitle(titlesFilter);// не знаю оставлять или нет ????????????????????????
        training.selectCheckbox(variable.form, variable.sertification);
        training.verifyFormatResult(variable.sertification);
    }

    @Test
    public void checkingTitleFilterDirections() throws InterruptedException {
        training.selectCheckboxTwoOptions(variable.directions, variable.direction, variable.occupation);
//        training.selectCheckboxTwoOptions(variable.location, variable.country, variable.city);
//        training.verifyLocationResult(variable.cityList);
    }

    @Test
    public void checkingTitleFilterPayment() {
        training.selectCheckbox(variable.payment, variable.free);
        training.verifyPaymentResult(variable.free);
    }

    @Test
    public void checkingTitleFilterLocation() {
        training.selectCheckboxTwoOptions(variable.location, variable.country, variable.city);
        training.verifyLocationResult(variable.cityList);
    }

    @Test
    public void checkingTitleFilterStatus() {
        training.selectCheckbox(variable.status, variable.statusOpen);
        training.verifyStatusResult(variable.statOpenlist);
    }


    //Напрямки
    //div[contains(@class, 'not-expanded')]//div[contains(text(), 'Напрямки')]
    //li[@data-uid="34-Technologies & Development" and @aria-expanded="false"]//div[contains(@class,"e-icons")]
    //34-Technologies & Development
    ////////

    ///////

///////////////////////////
//    @Test
//    public void chekingTitleFilterFormatIntership(){
//        training.selectCheckbox("Формат", "Інтернатура");
//        training.verifyFormatResult("ІНТЕРНАТУРА");
//    }
//    @Test
//    public void chekingTitleFilterFormatCourse(){
//        training.selectCheckbox("Формат", "Курс");
//        training.verifyFormatResult("КУРС");
//    }
}

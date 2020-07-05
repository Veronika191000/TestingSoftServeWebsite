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

    @BeforeTest
    @Parameters({"language"})
    public void initialize(String language) {
        training = new TrainingAndSertification(driver);
        variable = new InitializeVariable();
        variable = variable.initDependOnLanguage(language);
    }

    @Test
    public void checkingQuery() {
        training.verifySearchResult(variable.diretctionList);
    }

    @Test
    public void checkingTitleFilterFormatSertif() {
        training.selectCheckbox(variable.form, variable.sertification);
        training.verifyFormatResult(variable.sertification);
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
    public void checkingTitleFilterDirections() {
        training.selectCheckboxTwoOptions(variable.directions, variable.direction, variable.occupation);
        training.verifyDirectionResult(variable.diretctionList);
    }

    @Test
    public void checkingTitleFilterStatus() {
        training.selectCheckbox(variable.status, variable.statusOpen);
        training.verifyStatusResult(variable.statOpenlist);
    }
}

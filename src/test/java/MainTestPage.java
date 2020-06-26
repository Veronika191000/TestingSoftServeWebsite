import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.TrainingAndSertification;

public class MainTestPage extends WebDriverSettings {
    private TrainingAndSertification training;
  //  private WebDriver driver;

    //    private Variables var;
    //rivate String titleLearning = "НАВЧАННЯ І СЕРТИФІКАЦІЯ";
    // private static final String[] titles = {"ФОРМАТ", "НАПРЯМКИ", "ОПЛАТА", "ЛОКАЦІЯ", "СТАТУС", "ДАТА ПРОВЕДЕННЯ"};//?????????????
    // List<String> titlesFilter = Arrays.asList(titles);

    @BeforeTest
    public void initialize() {
        training = new TrainingAndSertification(driver);
    }

    //  @BeforeTest
//    //@Parameters({"language"})
//    public void initializePage(String language) {
//        training = new TrainingAndCertification(driver);
//       // var = new Variables("Формат", "Оплата", "Сертифікація", "Безкоштовний");
//        //  System.out.println();
//        //   if(language == "UA"){
//        //      var = new Variables(var.form, var.payment, var.sertification, var.free);
//        //       var = var.methodXZ(language);
//        //  }
//
//        //   System.out.println(var.toString());
//
//    }


//    @Test
//    public void checkingTitleLearning() {
//        training.checkTitleLearning(titleLearning);
//    }

//    @Test
//    public void checkingTitleFilterFormatSertif() {
//        //  training.checkFilterTitle(titlesFilter);// не знаю оставлять или нет ????????????????????????
//        training.selectCheckbox(var.form, var.sertification);
//        training.verifyFormatResult(var.sertification);
//    }
//
//    @Test
//    public void checkingTitleFilterPayment() {
//        training.selectCheckbox(var.payment, var.free);
//        training.verifyPaymentResult(var.free);
//    }


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

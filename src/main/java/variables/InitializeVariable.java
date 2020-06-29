package variables;

public class InitializeVariable {
    public final String urlUA = "https://career.softserveinc.com/uk-ua/learning-and-certification";
    public final String urlEN = "https://career.softserveinc.com/en-us/learning-and-certification";
    public String form;
    public String payment;
    public String sertification;
    public String free;
    public String status;
    public String statusOpen;
    public String statOpenlist;
    public String location;
    public String country;
    public String city;
    public String cityList;
    public String directions;
    public String direction;
    public String occupation;
    public String diretctionList;
    public InitializeVariable variables;


    // private Variables variables;
    // public Variables(){}
    public InitializeVariable() {
        super();
    }

    public InitializeVariable(String form, String payment, String sertification, String free, String status,
                              String statusOpen, String statOpenlist, String location, String country, String city,
                              String cityList, String directions, String direction, String occupation, String diretctionList) {
        this.form = form;
        this.payment = payment;
        this.sertification = sertification;
        this.free = free;
        this.status = status;
        this.statusOpen = statusOpen;
        this.statOpenlist = statOpenlist;
        this.location = location;
        this.country = country;
        this.city = city;
        this.cityList = cityList;
        this.directions = directions;
        this.direction = direction;
        this.occupation = occupation;
        this.diretctionList = diretctionList;
    }

    public InitializeVariable initDependOnLanguage(String language) {
        if (language.equalsIgnoreCase("UA")) {
            variables = new InitializeVariable("Формат", "Оплата", "Сертифікація",
                    "Безкоштовний", "Статус", "Відкритий для реєстрації", "Відкритий",
                    "Локація", "1-Ukraine", "13-Kharkiv", "Харків","Напрямки",
                    "34-Technologies & Development","8-Java Development", "Java");
        } else {
            variables = new InitializeVariable("Format", "Payment", "Sertification",
                    "free", "Status", "Open for Registration", "Open",
                    "Location", "1-Ukraine", "13-Kharkiv", "Kharkiv", "Directions", "34-Technologies & Development",
                    "8-Java Development", "Java");
        }
        return variables;
    }
}

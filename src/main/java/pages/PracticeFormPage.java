package pages;

import dto.Student;
import enums.Gender;
import enums.Hobbies;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

public class PracticeFormPage extends BasePage {
    public PracticeFormPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory
                (driver, 10), this);
    }

    //  @FindBy(xpath = "//input[@id='firstName']")
    @FindBy(id = "firstName")
    WebElement fieldName;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
//(@id="lastName")
    WebElement fieldLastName;

    @FindBy(id = "userEmail")
    WebElement fieldEmail;

    @FindBy(xpath = "//input[@placeholder='Mobile Number'] ")
    // (id= "userNumber")
    WebElement filedMobile;

    @FindBy(id = "dateOfBirthInput")
    WebElement filedDateOfBirth;

    @FindBy(id = "currentAddress")
    WebElement fieldAddress;

    @FindBy(xpath = "//input[@id='subjectsInput']")
    WebElement fieldSubject;

    @FindBy(id="react-select-3-input")
    WebElement inputState;

    @FindBy(id="react-select-4-input")
    WebElement inputCity;

    @FindBy(css = "button[id='submit']")
    WebElement btnSubmit;

    @FindBy (id="example-modal-sizes-title-lg")
    WebElement modalMessage;


    //=====================================
    public void typePracticeForm(Student student) {
        hideBanner();
        hideFooter();

        fieldName.sendKeys(student.getName());
        fieldLastName.sendKeys(student.getLastName());
        fieldEmail.sendKeys(student.getEmail());
        typeGender(student.getGender());
        filedMobile.sendKeys(student.getMobile());
        //  filedDateOfBirth.sendKeys(student.getDateOfBirth());
        typeDateOfBirth(student.getDateOfBirth());
        typeSubjects(student.getSubject());
        typeHobbies(student.getHobbies());
        fieldAddress.sendKeys(student.getAddress());
        typeStateCity(student.getState(),student.getCity());
        btnSubmit.click();
    }

public boolean validateModalMessage(){
        return validateTextInElement(modalMessage,
                "Thanks for submitting the form");
}

    public boolean validateModalMessageNegative(){
        return validateTextInElement(modalMessage,
                "Negative");
    }


private void typeStateCity(String state, String city){
   inputState.sendKeys(state);
   inputState.sendKeys(Keys.ENTER);

   inputCity.sendKeys(city);
   inputCity.sendKeys(Keys.ENTER);
}


    private void typeDateOfBirth(String dateOfBirth) {
        filedDateOfBirth.click();
        String operationSystem = System.getProperty("os.name");
        System.out.println(operationSystem);
        if (operationSystem.startsWith("Win"))
            filedDateOfBirth.sendKeys(Keys.chord(Keys.CONTROL, "a")); //начать CTRl A -- все выделить
        else if (operationSystem.startsWith("Mac"))
            filedDateOfBirth.sendKeys(Keys.chord(Keys.COMMAND, "a"));

        filedDateOfBirth.sendKeys(dateOfBirth);
        filedDateOfBirth.sendKeys(Keys.ENTER);
    }

    private void typeGender(Gender gender) {
        WebElement btnGender = driver.findElement(By.xpath(gender.getLocator()));
        btnGender.click();
    }

    private void typeSubjects(String subjects) {
        fieldSubject.click();
        String[] arr = subjects.split(",");
        for (String s : arr) {
            fieldSubject.sendKeys(s);
            fieldSubject.sendKeys(Keys.ENTER);
        }
    }

    private void typeHobbies(List<Hobbies> hobbies){
        for(Hobbies h: hobbies){
            switch (h){
                case MUSIC:
                    driver.findElement(By.xpath(h.getLocator())).click();
                    break;
                case SPORTS:
                    driver.findElement(By.xpath(h.getLocator())).click();
                    break;
                case READING:
                    driver.findElement(By.xpath(h.getLocator())).click();
                    break;

            }
        }

    }

}

package pages;

import dto.Student;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

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

   @FindBy (id ="currentAddress")
    WebElement fieldAddress;

    //=====================================
    public void typePracticeForm(Student student) {
        hideBanner();
        hideFooter();

        fieldName.sendKeys(student.getName());
        fieldLastName.sendKeys(student.getLastName());
        fieldEmail.sendKeys(student.getEmail());
        filedMobile.sendKeys(student.getMobile());
      //  filedDateOfBirth.sendKeys(student.getDateOfBirth());
        typeDateOfBirth(student.getDateOfBirth());
        fieldAddress.sendKeys(student.getAddress());
    }

 private void typeDateOfBirth(String dateOfBirth){
    filedDateOfBirth.click();
    String operationSystem = System.getProperty("os.name");
     System.out.println(operationSystem);
     if(operationSystem.startsWith("Win"))
         filedDateOfBirth.sendKeys(Keys.chord(Keys.CONTROL,"a")); //начать CTRl A -- все выделить
else if(operationSystem.startsWith("Mac"))
    filedDateOfBirth.sendKeys(Keys.chord(Keys.COMMAND,"a"));

    filedDateOfBirth.sendKeys(dateOfBirth);
    filedDateOfBirth.sendKeys(Keys.ENTER);
 }
}

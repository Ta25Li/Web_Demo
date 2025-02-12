package tests;

import dto.Student;
import manager.AppManager;
import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;

public class PracticeFormTests extends AppManager {



    @Test
    public void studentRegFormPositiveTest(){
        Student student = new Student(
                 "Leon","Rocks","email@em.com",
                "male","0584564433","10 Jul 2001",
                "Maths,Physics,Chemistry","Sport","",
                "Green street 7","NCR","Delhi");


    new HomePage(getDriver()).clickBtnForms();
    new FormsPage(getDriver()).clickBtnPracticeForm();
    new PracticeFormPage(getDriver()).typePracticeForm(student);
    }


}

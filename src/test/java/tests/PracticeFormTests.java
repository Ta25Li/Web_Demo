package tests;

import dto.Student;
import enums.Gender;
import enums.Hobbies;
import manager.AppManager;
import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;

import java.util.ArrayList;
import java.util.List;

public class PracticeFormTests extends AppManager {



    @Test
    public void studentRegFormPositiveTest(){

        List<Hobbies> hobbies = new ArrayList<>();
        hobbies.add(Hobbies.MUSIC);
        hobbies.add(Hobbies.READING);
        hobbies.add(Hobbies.SPORTS);

        Student student = new Student(
                 "Leon","Rocks","email@em.com",
                Gender.MALE,"0584564433","10 Jul 2001",
                "Maths,Physics,Chemistry",hobbies,"",
                "Green street 7","NCR","Delhi");


    new HomePage(getDriver()).clickBtnForms();
    new FormsPage(getDriver()).clickBtnPracticeForm();
    new PracticeFormPage(getDriver()).typePracticeForm(student);
    }


}

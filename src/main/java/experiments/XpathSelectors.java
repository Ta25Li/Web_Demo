package experiments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class XpathSelectors {
    WebDriver driver = new ChromeDriver();

    @Test
    public void selectorsTextBox() {
        driver.get("https://demoqa.com/text-box");
        driver.manage().window().maximize(); //раскрыть окно на весь экран
        hideBanner();
        hideFooter();
        //===================================
        WebElement inputFullName = driver.findElement
                (By.xpath("//input[@id='userName']"));
        inputFullName.sendKeys("Cucumber"); //напечатать текст в найденном окне


        WebElement inputEmail = driver.findElement
                (By.xpath("//input[@placeholder='name@example.com']"));
        inputEmail.sendKeys("email@email.com");

        WebElement curAdr = driver.findElement
                (By.xpath("//textarea[@placeholder='Current Address']"));
        curAdr.sendKeys("NYC");

        WebElement curAdr1 = driver.findElement
                (By.xpath("//*[text()='Current Address']")); // поиск по тексту - но не возможно напечатать ничего
        System.out.println(curAdr1.getText());

        WebElement permAdr = driver.findElement
                (By.xpath("//textarea[@id='permanentAddress']")); //по атрибуту через @
        permAdr.sendKeys("SFO");

        WebElement btnSubmit = driver.findElement
                (By.xpath("//button[text()='Submit']")); //по тексту без @ но с ()
        btnSubmit.click();

        WebElement output = driver.findElement
                (By.xpath("//div[@id='output']")); //show
        System.out.println(output.getText());

//====================================
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //   driver.quit();  // closes all th windows
    }

    private void hideBanner() {  // убрать баннер, чт не закрывал элементы
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('#fixedban').style.display='none'");
    }

    private void hideFooter() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('footer').style.display='none'");
    }
}

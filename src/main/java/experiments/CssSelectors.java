package experiments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CssSelectors {
    WebDriver driver = new ChromeDriver();

    @Test
    public void selectorsHomePage(){
        driver.get ("https://demoqa.com/");
        driver.manage().window().maximize(); // so that site opens to full screen
        hideBanner();
        hideFooter();

        WebElement imgTools = driver.findElement
                (By.cssSelector("img[src='/images/Toolsqa.jpg']"));
        System.out.println(imgTools.getTagName());

        WebElement divElements = driver.findElement
                (By.cssSelector("div[class='avatar mx-auto white']")); // find element
        divElements.click(); //click


       // driver.quit();//close browser
    }
    private void hideBanner(){  // убрать баннер, чт не закрывал элементы
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('#fixedban').style.display='none'");
    }
    private void hideFooter(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('footer').style.display='none'");
    }


}

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
    public void selectorsHomePage() {
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize(); // so that site opens to full screen
        hideBanner();
        hideFooter();

        WebElement imgTools = driver.findElement
                (By.cssSelector("img[src='/images/Toolsqa.jpg']"));
        System.out.println(imgTools.getTagName());

        WebElement divElements = driver.findElement
                (By.cssSelector("div[class='avatar mx-auto white']")); // find element
        divElements.click(); //click

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();//close browser
    }

    @Test
    public void selectorsElementsPage() {
        driver.get("https://demoqa.com/elements");
        driver.manage().window().maximize();
        hideBanner();

        WebElement textBox = driver.findElement(By.id("item-0"));
        System.out.println(textBox.getAttribute("class"));

        WebElement checkBox = driver.findElement(By.cssSelector("li[id='item-1']"));
        checkBox.click();


        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }
        @Test
        public void selectorsRadioButtonPage(){
            driver.get("https://demoqa.com/radio-button");
            driver.manage().window().maximize();
            hideBanner();
            hideFooter();

          //  WebElement radioButtonYes = driver.findElement(By.cssSelector("label[for ='yesRadio']"));
           WebElement radioButtonYes = driver.findElement(By.xpath("//label[@for ='yesRadio']"));
            radioButtonYes.click();


            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            driver.quit();
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

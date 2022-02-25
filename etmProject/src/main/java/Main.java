import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {
  public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

   //  WebElement element=(new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.id(""))))
    driver.get("https://idev.etm.ru/ipro3");

    driver.findElement(By.xpath("//div[@id='__next']/div[2]/footer/div[2]/div/button/span")).click();
    driver.findElement(By.xpath("//div[@id='__next']/div[2]/div/div/div/div[2]/button/span")).click();
    driver.findElement(By.xpath("//div[@id='__next']/div[2]/div/div/header/div/nav/div[3]/div/div/div/p")).click();
    driver.findElement(By.name("login")).clear();
    driver.findElement(By.name("login")).sendKeys("9216572712");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("qakras123");
    driver.findElement(By.xpath("//div[@id='__next']/div[2]/div/div/div/div[2]/div/div/div/form/button/span")).click();

    driver.findElement(By.cssSelector("div.jss28")).click();

    driver.findElement(By.xpath("//div[@id='__next']/div[2]/div[2]/div/div[2]/div/div/p")).click();
    driver.findElement(By.xpath("//div[@id='__next']/div[2]/div[2]/div/div[2]/div[2]/div/div[3]/table/tbody/tr/td/input")).click();
    driver.findElement(By.xpath("//div[@id='__next']/div[2]/div[2]/div/div[2]/div[2]/div/div[3]/table/tbody/tr/td[2]/input")).click();
    driver.findElement(By.xpath("//div[@id='__next']/div[2]/div[2]/div/div[2]/div[2]/div/div[3]/table/tbody/tr/td[3]/input")).click();
    driver.findElement(By.xpath("//div[@id='__next']/div[2]/div[2]/div/div[2]/div[2]/div/div/span")).click();
    driver.findElement(By.cssSelector(".jss55")).click();
    driver.findElement(By.xpath("//img[@alt='Выход']")).click();
    driver.close();
  }
  //WebDriverWait wait = new WebDriverWait(driver, 10);
  //WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id(>someid>)));
 // private WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds) {
  //  System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
  //  WebDriver driver = new ChromeDriver();
  //  WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
   // wait.withMessage(error_message + "\n");

   // return wait.until(
        //    ExpectedConditions.presenceOfElementLocated(by)
   // );
  
}

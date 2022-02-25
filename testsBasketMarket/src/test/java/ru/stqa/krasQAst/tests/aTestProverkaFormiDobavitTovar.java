package ru.stqa.krasQAst.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class aTestProverkaFormiDobavitTovar {
  //FirefoxDriver wd;
  ChromeDriver wd;
  @BeforeMethod
  public void setUp() throws Exception  {
    //System.setProperty("webdriver.gecko.driver","C:/SeleniumGecko/geckodriver.exe");
    //wd = new FirefoxDriver();
    System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe");
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @Test
  public void testProverkaFormiDobavitTovar()  {
    wd.get("https://idev.etm.ru/ipro3");
    wd.findElement(By.xpath("//div[@id='__next']/div[2]/div/div/header/div/nav/div[3]/div/div/div/p")).click();
    wd.findElement(By.name("login")).clear();
    wd.findElement(By.name("login")).sendKeys("9216572712");
    wd.findElement(By.name("password")).clear();
    wd.findElement(By.name("password")).sendKeys("qakras123");
    wd.findElement(By.xpath("//div[@id='__next']/div[2]/div/div/div/div[2]/div/div/div/form/button/span")).click();
    wd.findElement(By.cssSelector(".jss30 > path")).click();
    wd.findElement(By.xpath("//div[@id='__next']/div[2]/div[2]/div/div[2]/div/div/p")).click();
    wd.findElement(By.xpath("//div[@id='__next']/div[2]/div[2]/div/div[2]/div[2]/div/div[3]/table/tbody/tr/td/input")).click();
    wd.findElement(By.xpath("//div[@id='__next']/div[2]/div[2]/div/div[2]/div[2]/div/div[3]/table/tbody/tr/td[2]/input")).click();
    wd.findElement(By.xpath("//div[@id='__next']/div[2]/div[2]/div/div[2]/div[2]/div/div[3]/table/tbody/tr/td[3]/input")).click();
    wd.findElement(By.xpath("//div[@id='__next']/div[2]/div[2]/div/div[2]/div[2]/div/div/span")).click();
    wd.findElement(By.cssSelector(".jss55")).click();
    wd.findElement(By.xpath("//img[@alt='Выход']")).click();
    wd.close();
  }

  @AfterMethod
  public void tearDown()  {
    wd.quit();}


  public static boolean isAlertPresent(FirefoxDriver wd) {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
}

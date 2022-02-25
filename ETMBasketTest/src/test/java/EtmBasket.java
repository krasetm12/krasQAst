import io.github.bonigarcia.wdm.WebDriverManager;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.junit.Assert;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
//import static org.junit.Assert.assertThat;




@TestMethodOrder(MethodOrderer.OrderAnnotation.class)



public class EtmBasket {
  String SITE_URL="https://idev.etm.ru/ipro3";
  WebDriver driver;
  String close_form_add="//span[contains(.,'close')]";


  @BeforeEach
  public  void start(){
    WebDriverManager.chromedriver().setup();
    ChromeOptions options= new ChromeOptions();
    options.setHeadless(false);
    driver= new ChromeDriver(options);
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }
  @AfterEach
  public void finish(){
    driver.quit();
  }
  @Epic("Testing FOR https://idev.etm.ru/ipro3/ tasks ")
  @Feature(value= "Tests for task-basket functionality for market-user")
  @Severity(SeverityLevel.MINOR)
  @Description("проверка формы добавить товар-" +
          "1-вводим логин пароль-" +
          "2-переходим в корзину-" +
          "3-кликаем на форму Добавить товар-" +
          "4-проверяем все поля формы на кликабельность"+
          "5-закрытие формы")
  @Test
  @Order(1)

  public void test1AproverkaKlikaFieldsOfFormi() {
    driver.get(SITE_URL);
    driver.findElement(By.xpath("//span[contains(.,'Все понятно')]")).click();
    driver.findElement(By.xpath("//span[contains(.,'Все верно')]")).click();
    driver.findElement(By.xpath("//span[contains(.,'Вход / Регистрация')]")).click();
    driver.findElement(By.name("login")).clear();
    driver.findElement(By.name("login")).sendKeys("9216572712");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("qakras123");
    driver.findElement(By.xpath("//span[contains(.,'Войти в систему')]")).click();

    try {
      WebElement button = driver.findElement(By.xpath("//p[@data-testid='go-to-basket']"));
      button.click();
    } catch (org.openqa.selenium.StaleElementReferenceException ex) {
      WebElement button = driver.findElement(By.xpath("//p[@data-testid='go-to-basket']"));
      button.click();
    }

    driver.findElement(By.xpath("//*[@data-testid ='action-item-1']")).click();
    driver.findElement(By.xpath("(//input[@value=''])[2]")).click();
    driver.findElement(By.xpath("(//input[@value=''])[3]")).click();
    driver.findElement(By.xpath("(//input[@value=''])[4]")).click();
    driver.findElement(By.xpath("//input[@value='1']")).click();
    driver.findElement(By.xpath(close_form_add)).click();
    driver.findElement(By.xpath("//button[@title='Выход']")).click();

  }
  /*@Epic("Testing FOR https://idev.etm.ru/ipro3/ tasks ")
  @Feature(value= "Tests for task-basket functionality for market-user")
  @Severity(SeverityLevel.MINOR)
  @Description("проверка формы добавить товар-" +
          "1-вводим логин пароль-" +
          "2-переходим в корзину-" +
          "3-кликаем на форму Добавить товар-" +
          "4-проверяем поиск в форме по производителю и меняем кол-во товара "+
          "5-выбираем товар -проверяем что он добавился в корзину")
    @Test
    @Order(2)

    public void test2ProverkaProizAndKolvo(){
    driver.get(SITE_URL);
    driver.findElement(By.xpath("//span[contains(.,'Все понятно')]")).click();
    driver.findElement(By.xpath("//span[contains(.,'Все верно')]")).click();
    driver.findElement(By.xpath("//span[contains(.,'Вход / Регистрация')]")).click();
    driver.findElement(By.name("login")).clear();
    driver.findElement(By.name("login")).sendKeys("9216572712");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("qakras123");
    driver.findElement(By.xpath("//span[contains(.,'Войти в систему')]")).click();

    try {
      WebElement button = driver.findElement(By.xpath("//p[@data-testid='go-to-basket']"));
      button.click();
    } catch (org.openqa.selenium.StaleElementReferenceException ex) {
      WebElement button = driver.findElement(By.xpath("//p[@data-testid='go-to-basket']"));
      button.click();
    }
      driver.findElement(By.xpath("//*[@data-testid ='action-item-1']")).click();
      driver.findElement(By.xpath("(//input[@value=''])[2]")).click();
      driver.findElement(By.xpath("(//input[@value=''])[2]")).sendKeys("I");
      waitForElementAndClick(By.xpath("//*[@data-testid ='brands-list-item-5']"),
              "error_message",
              5);

      driver.findElement(By.xpath("//input[@value='1']")).click();
      driver.findElement(By.xpath("//input[@value='1']")).sendKeys("2");

      waitForElementAndClickable(By.xpath("//*[@data-testid ='get-analogues-btn']"),
             "not click element test-id",
              5);
      waitForElementAndClick(By.xpath("//*[@data-testid ='get-analogues-btn']"),
              "error_message",
              5);

      driver.findElement(By.xpath("//div[2]/table/tbody/tr[2]")).click();

      driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root jss4']")).click();

      driver.findElement(By.xpath("//button[@title='Выход']")).click();

    }
  @Epic("Testing FOR https://idev.etm.ru/ipro3/ tasks ")
  @Feature(value= "Tests for task-basket functionality for market-user")
  @Severity(SeverityLevel.MINOR)
  @Description("проверка формы добавить товар-" +
          "1-вводим логин пароль-" +
          "2-переходим в корзину-" +
          "3-кликаем на форму Добавить товар-" +
          "4-проверяем поиск в форме по артикулу или коду и меняем кол-во товара "+
          "5-выбираем товар -проверяем что он добавился в корзину")
    @Test
    @Order(3)

    public void test3ProverkaArticulAndKolvo(){
    driver.get(SITE_URL);
    driver.findElement(By.xpath("//span[contains(.,'Все понятно')]")).click();
    driver.findElement(By.xpath("//span[contains(.,'Все верно')]")).click();
    driver.findElement(By.xpath("//span[contains(.,'Вход / Регистрация')]")).click();
    driver.findElement(By.name("login")).clear();
    driver.findElement(By.name("login")).sendKeys("9216572712");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("qakras123");
    driver.findElement(By.xpath("//span[contains(.,'Войти в систему')]")).click();

    try {
      WebElement button = driver.findElement(By.xpath("//p[@data-testid='go-to-basket']"));
      button.click();
    } catch (org.openqa.selenium.StaleElementReferenceException ex) {
      WebElement button = driver.findElement(By.xpath("//p[@data-testid='go-to-basket']"));
      button.click();
    }

      driver.findElement(By.xpath("//*[@data-testid ='action-item-1']")).click();
      driver.findElement(By.xpath("(//input[@value=''])[3]")).click();
      driver.findElement(By.xpath("//*[@data-testid='input-art']")).sendKeys("00005585");
      driver.findElement(By.xpath("//input[@value='1']")).click();
      driver.findElement(By.xpath("//input[@value='1']")).sendKeys("0");

      waitForElementAndClickable(By.xpath("//*[@data-testid ='get-analogues-btn']"),
              "not click element test-id",
              5);
      waitForElementAndClick(By.xpath("//*[@data-testid ='get-analogues-btn']"),
              "error_message",
              5);

      driver.findElement(By.xpath("//div[2]/table/tbody/tr")).click();
      driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root jss4']")).click();

      driver.findElement(By.xpath("//button[@title='Выход']")).click();

    }
  @Epic("Testing FOR https://idev.etm.ru/ipro3/ tasks ")
  @Feature(value= "Tests for task-basket functionality for market-user")
  @Severity(SeverityLevel.MINOR)
  @Description("проверка формы добавить товар-" +
          "1-вводим логин пароль-" +
          "2-переходим в корзину-" +
          "3-кликаем на форму Добавить товар-" +
          "4-проверяем поиск в форме по наименованию и меняем кол-во товара "+
          "5-выбираем товар -проверяем что он добавился в корзину")
    @Test
    @Order(4)

    public void test4ProverkaNaimenovanieAndKolvo(){
    driver.get(SITE_URL);
    driver.findElement(By.xpath("//span[contains(.,'Все понятно')]")).click();
    driver.findElement(By.xpath("//span[contains(.,'Все верно')]")).click();
    driver.findElement(By.xpath("//span[contains(.,'Вход / Регистрация')]")).click();
    driver.findElement(By.name("login")).clear();
    driver.findElement(By.name("login")).sendKeys("9216572712");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("qakras123");
    driver.findElement(By.xpath("//span[contains(.,'Войти в систему')]")).click();

    try {
      WebElement button = driver.findElement(By.xpath("//p[@data-testid='go-to-basket']"));
      button.click();
    } catch (org.openqa.selenium.StaleElementReferenceException ex) {
      WebElement button = driver.findElement(By.xpath("//p[@data-testid='go-to-basket']"));
      button.click();
    }
      driver.findElement(By.xpath("//*[@data-testid ='action-item-1']")).click();


      driver.findElement(By.xpath("(//input[@value=''])[4]")).click();

      driver.findElement(By.xpath("//input[@data-testid='input-name']")).sendKeys("адаптер");

      driver.findElement(By.xpath("//input[@value='1']")).click();

      driver.findElement(By.xpath("//input[@value='1']")).sendKeys("0");

      waitForElementAndClickable(By.xpath("//*[@data-testid ='get-analogues-btn']"),
              "not click element test-id",
              5);
      waitForElementAndClick(By.xpath("//*[@data-testid ='get-analogues-btn']"),
              "error_message",
              5);

      driver.findElement(By.xpath("//div[2]/table/tbody/tr")).click();
      driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root jss4']")).click();
      driver.findElement(By.xpath("//button[@title='Выход']")).click();

    }
  @Epic("Testing FOR https://idev.etm.ru/ipro3/ tasks ")
  @Feature(value= "Tests for task-basket functionality for market-user")
  @Severity(SeverityLevel.MINOR)
  @Description("проверка формы добавить товар-" +
          "1-вводим логин пароль-" +
          "2-переходим в корзину-" +
          "3-кликаем на форму Добавить товар-" +
          "4-проверяем поиск в форме по наименованию введя невалидное название "+
          "5-проверяем появление сообщения выберите товар или нажмите отменить "+
          "6-закрываю форму кнопкой отменить")
  @Test
  @Order(5)

       public void test5InvalidProductName(){
    driver.get(SITE_URL);
    driver.findElement(By.xpath("//span[contains(.,'Все понятно')]")).click();
    driver.findElement(By.xpath("//span[contains(.,'Все верно')]")).click();
    driver.findElement(By.xpath("//span[contains(.,'Вход / Регистрация')]")).click();
    driver.findElement(By.name("login")).clear();
    driver.findElement(By.name("login")).sendKeys("9216572712");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("qakras123");
    driver.findElement(By.xpath("//span[contains(.,'Войти в систему')]")).click();

    try {
      WebElement button = driver.findElement(By.xpath("//p[@data-testid='go-to-basket']"));
      button.click();
    } catch (org.openqa.selenium.StaleElementReferenceException ex) {
      WebElement button = driver.findElement(By.xpath("//p[@data-testid='go-to-basket']"));
      button.click();
    }

      driver.findElement(By.xpath("//*[@data-testid ='action-item-1']")).click();


      driver.findElement(By.xpath("(//input[@value=''])[4]")).click();

      driver.findElement(By.xpath("//input[@data-testid='input-name']")).sendKeys("втрпоррп");

      driver.findElement(By.xpath("//input[@value='1']")).click();

      driver.findElement(By.xpath("//input[@value='1']")).sendKeys("0");

      waitForElementAndClickable(By.xpath("//*[@data-testid ='get-analogues-btn']"),
              "not click element test-id",
              5);
      waitForElementAndClick(By.xpath("//*[@data-testid ='get-analogues-btn']"),
              "error_message",
              5);


      Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Может, нужный вам товар есть в этом списке?')]")).getText(),
              "Может, нужный вам товар есть в этом списке?\nВыберите его или нажмите на кнопку \"Отменить\".");

      driver.findElement(By.xpath("//span[contains(.,'Отменить')]")).click();

      driver.findElement(By.xpath("//button[@title='Выход']")).click();
    }
  @Epic("Testing FOR https://idev.etm.ru/ipro3/ tasks ")
  @Feature(value= "Tests for task-basket functionality for market-user")
  @Severity(SeverityLevel.MINOR)
  @Description("проверка формы добавить товар-" +
          "1-вводим логин пароль-" +
          "2-переходим в корзину-" +
          "3-в поле примечание вводим текст" +
          "4-меняем кол-во товара и подтверждаем изменение "+
          "5-проверяем что кол-во товара изменилось ")
  @Test
  @Order(6)

  public void test6PrimechanieProverkaIzmenenKolvaTovaraAndZnachInBasket(){
    driver.get(SITE_URL);
    driver.findElement(By.xpath("//span[contains(.,'Все понятно')]")).click();
    driver.findElement(By.xpath("//span[contains(.,'Все верно')]")).click();
    driver.findElement(By.xpath("//span[contains(.,'Вход / Регистрация')]")).click();
    driver.findElement(By.name("login")).clear();
    driver.findElement(By.name("login")).sendKeys("9216572712");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("qakras123");
    driver.findElement(By.xpath("//span[contains(.,'Войти в систему')]")).click();

    try {
      WebElement button = driver.findElement(By.xpath("//p[@data-testid='go-to-basket']"));
      button.click();
    } catch (org.openqa.selenium.StaleElementReferenceException ex) {
      WebElement button = driver.findElement(By.xpath("//p[@data-testid='go-to-basket']"));
      button.click();
    }

    driver.findElement(By.name("tovzak")).click();
    driver.findElement(By.name("tovzak")).sendKeys("тест");
    //waitForElementAndClickable(By.xpath("//input[@data-testid='note-input']"), "текст -Тест в примечаниях не появился", 5);

    //assertThat(driver.findElement(By.xpath("//input[@value='тест']")).getText(), is("тест"));
    assertThat(driver.findElement(By.xpath("//p[@data-testid='go-to-basket']//span[contains(text(),'1')]")).getText(), is("1"));
    driver.findElement(By.xpath("//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedEnd MuiOutlinedInput-inputAdornedEnd MuiInputBase-inputMarginDense MuiOutlinedInput-inputMarginDense']")).click();
    driver.findElement(By.xpath("//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedEnd MuiOutlinedInput-inputAdornedEnd MuiInputBase-inputMarginDense MuiOutlinedInput-inputMarginDense']")).sendKeys("1");
    waitForElementPresent(By.xpath("//*[@data-testid ='shopping-cart-count-button-1']"),
            "error_message -dont click on button",5);
    driver.findElement(By.xpath("//*[@data-testid ='shopping-cart-count-button-1']")).click();

      String value = driver.findElement(By.xpath("//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedEnd MuiOutlinedInput-inputAdornedEnd MuiInputBase-inputMarginDense MuiOutlinedInput-inputMarginDense']")).getAttribute("value");
      assertThat(value, is("11"));



    driver.findElement(By.xpath("//button[@title='Выход']")).click();
  }
  @Epic("Testing FOR https://idev.etm.ru/ipro3/ tasks ")
  @Feature(value= "Tests for task-basket functionality for market-user")
  @Severity(SeverityLevel.MINOR)
  @Description("проверка формы добавить товар-" +
          "1-вводим логин пароль-" +
          "2-переходим в каталог и добавляем товар 10 шт-" +
          "3-добавляем купон" +
          "4-проверяем что купон добавился"+
          "5-удаляем один товар-проверяем чо товар удалился кнопкой удалить выбранное "+
          "6-проверяем что скидка по купону составляет 1000")
  @Test
  @Order(7)

  public void test7AddCouponAndProductAndDelete(){
    driver.get(SITE_URL);
    driver.findElement(By.xpath("//span[contains(.,'Все понятно')]")).click();
    driver.findElement(By.xpath("//span[contains(.,'Все верно')]")).click();
    driver.findElement(By.xpath("//span[contains(.,'Вход / Регистрация')]")).click();
    driver.findElement(By.name("login")).clear();
    driver.findElement(By.name("login")).sendKeys("9216572712");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("qakras123");
    driver.findElement(By.xpath("//span[contains(.,'Войти в систему')]")).click();

    try {
      WebElement button = driver.findElement(By.xpath("//a[@href='/catalog']"));
      button.click();
    }
    catch(org.openqa.selenium.StaleElementReferenceException ex)
    {
      WebElement button = driver.findElement(By.xpath("//a[@href='/catalog']"));
      button.click();
    }

    driver.findElement(By.xpath("(//div[@data-testid='catalog-item-product-1']//input[@value=''])[1]")).click();
    driver.findElement(By.xpath("(//div[@data-testid='catalog-item-product-1']//input[@value=''])[1]")).sendKeys("10");
    driver.findElement(By.xpath("//div[@data-testid='catalog-item-product-1']//span[@class='MuiButton-label']")).click();
    driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root jss4']")).click();
    driver.findElement(By.xpath("//p[@data-testid='go-to-basket']")).click();

    driver.findElement(By.name("promocode")).click();

    driver.findElement(By.name("promocode")).sendKeys("TEST");

    driver.findElement(By.xpath("//div[@data-testid='save-promo']")).click();

    driver.findElement(By.linkText("Купон")).click();
    assertThat(driver.findElement(By.linkText("Купон")).getText(), is("Купон"));

    driver.findElement(By.xpath("//*[@data-testid='checkbox-shopping-cart-item-3']")).click();
    driver.findElement(By.xpath("//*[@data-testid='action-item-3']")).click();
    waitForElementPresent(By.xpath("//div[@role='dialog']"),
            "error_message -dont present of modal window",5);
    driver.findElement(By.xpath("//div[@role='dialog']//span[contains(.,'Нет')]")).click();
    driver.findElement(By.xpath("//*[@data-testid='action-item-3']")).click();
    driver.findElement(By.xpath("//div[@role='dialog']//span[contains(.,'Да')]")).click();

    waitForElementNotPresent(By.xpath("//*[@data-testid='checkbox-shopping-cart-item-4']"),"error don click element",5);

    waitForElementAndClick(By.xpath("//*[@data-testid='conditions-points-and-discounts']"),
            "не кликается ссылка Условия оформления скидки и баллов",
    5);
    driver.findElement(By.xpath("//*[@data-testid='modal-button-close']")).click();
    assertThat(driver.findElement(By.xpath("//*[@data-testid='shopping-cart-item-3']")).getText(), is("TEST\nКупон\n-1000"));


    driver.findElement(By.xpath("//button[@title='Выход']")).click();
  }
  @Epic("Testing FOR https://idev.etm.ru/ipro3/ tasks ")
  @Feature(value= "Tests for task-basket functionality for market-user")
  @Severity(SeverityLevel.CRITICAL)
  @Description("проверка формы добавить товар-" +
          "1-вводим логин пароль-" +
          "2-переходим в каталог и добавляем товар 10 шт-" +
          "3-переходим в корзину" +
          "4-удаляем один товар иконкой корзины"+
          "5-удаляем все товары"+
          "6-Проверяем что корзина пуста ")
  @Test
  @Order(8)

  public void test8DeleteAllAtBasket(){
    driver.get(SITE_URL);
    driver.findElement(By.xpath("//span[contains(.,'Все понятно')]")).click();
    driver.findElement(By.xpath("//span[contains(.,'Все верно')]")).click();
    driver.findElement(By.xpath("//span[contains(.,'Вход / Регистрация')]")).click();
    driver.findElement(By.name("login")).clear();
    driver.findElement(By.name("login")).sendKeys("9216572712");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("qakras123");
    driver.findElement(By.xpath("//span[contains(.,'Войти в систему')]")).click();

    try {
      WebElement button = driver.findElement(By.xpath("//a[@href='/catalog']"));
      button.click();
    }
    catch(org.openqa.selenium.StaleElementReferenceException ex)
    {
      WebElement button = driver.findElement(By.xpath("//a[@href='/catalog']"));
      button.click();
    }

    driver.findElement(By.xpath("(//div[@data-testid='catalog-item-product-1']//input[@value=''])[1]")).click();
    driver.findElement(By.xpath("(//div[@data-testid='catalog-item-product-1']//input[@value=''])[1]")).sendKeys("10");
    driver.findElement(By.xpath("//div[@data-testid='catalog-item-product-1']//span[@class='MuiButton-label']")).click();
    driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root jss4']")).click();
    driver.findElement(By.xpath("//p[@data-testid='go-to-basket']")).click();





    //driver.findElement(By.xpath("//*[@data-testid='shopping-cart-row-delete-button-3']")).click();
    //waitForElementPresent(By.xpath("//div[@role='dialog']"),
           // "error_message -dont present of modal window",5);
    //clickVisible(By.xpath("//div[@role='dialog']//span[contains(.,'Нет')]") ,"element no clickable", 5);
    //waitForElementPresent(By.xpath("//div[@role='dialog']//span[contains(.,'Нет')]"),
         //   "error_message -dont present element click NO of modal window",5);
    //driver.findElement(By.xpath("//div[@role='dialog']//span[@class='MuiTouchRipple-root']")).click();
   // driver.findElement(By.xpath("//*[@data-testid='action-item-3']")).click();
    //driver.findElement(By.xpath("//div[@role='dialog']//span[contains(.,'Да')]")).click();
    //waitForElementNotPresent(By.xpath("//*[@data-testid='checkbox-shopping-cart-item-3']"),"error don click element",5);

    driver.findElement(By.xpath("//*[@data-testid='checkbox-0']")).click();
    driver.findElement(By.xpath("//*[@data-testid='action-item-4']")).click();
    waitForElementPresent(By.xpath("//div[@role='dialog']"),
            "error_message -dont present of modal window",5);
    driver.findElement(By.xpath("//div[@role='dialog']//span[contains(.,'Нет')]")).click();
    driver.findElement(By.xpath("//*[@data-testid='action-item-3']")).click();
    driver.findElement(By.xpath("//div[@role='dialog']//span[contains(.,'Да')]")).click();
    assertThat(driver.findElement(By.xpath("//p[contains(.,'В корзине нет товаров')]")).getText(), is("В корзине нет товаров"));


    driver.findElement(By.xpath("//button[@title='Выход']")).click();
  }
  @Epic("Testing FOR https://idev.etm.ru/ipro3/ tasks ")
  @Feature(value= "Tests for task-basket functionality for market-user")
  @Severity(SeverityLevel.MINOR)
  @Description("проверка формы добавить товар-" +
          "1-вводим логин пароль-" +
          "2-переходим в корзину" +
          "3-кликаем по ссылке на корзину" +
          "4-проверяем что форма открылась"+
          "5-Проверяем кликабельность кнопки копирования "+
          "6-проверяем что появляется окно -ссылка скопирована")
  @Test
  @Order(9)

  public void test9CopyLinkForBasketAndConditionsOfSale(){
    driver.get(SITE_URL);
    driver.findElement(By.xpath("//span[contains(.,'Все понятно')]")).click();
    driver.findElement(By.xpath("//span[contains(.,'Все верно')]")).click();
    driver.findElement(By.xpath("//span[contains(.,'Вход / Регистрация')]")).click();
    driver.findElement(By.name("login")).clear();
    driver.findElement(By.name("login")).sendKeys("9216572712");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("qakras123");
    driver.findElement(By.xpath("//span[contains(.,'Войти в систему')]")).click();

    try {
      WebElement button = driver.findElement(By.xpath("//a[@href='/catalog']"));
      button.click();
    }
    catch(org.openqa.selenium.StaleElementReferenceException ex)
    {
      WebElement button = driver.findElement(By.xpath("//a[@href='/catalog']"));
      button.click();
    }




    driver.findElement(By.xpath("(//div[@data-testid='catalog-item-product-1']//input[@value=''])[1]")).click();
    driver.findElement(By.xpath("(//div[@data-testid='catalog-item-product-1']//input[@value=''])[1]")).sendKeys("10");
    driver.findElement(By.xpath("//div[@data-testid='catalog-item-product-1']//span[@class='MuiButton-label']")).click();
    driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root jss4']")).click();
    driver.findElement(By.xpath("//p[@data-testid='go-to-basket']")).click();


    driver.findElement(By.xpath("//*[@data-testid='action-item-9']")).click();
    assertThat(driver.findElement(By.xpath("//*[@data-testid='link-to-cart']")).getText(), is("Ссылка на корзину:"));
    driver.findElement(By.xpath("//*[@data-testid='copy-link-btn']")).click();



    clickVisible(By.xpath("//button[@title='Выход']") ,"element exit not clickable", 5);

  }
  @Epic("Testing FOR https://idev.etm.ru/ipro3/ tasks ")
  @Feature(value= "Tests for task-basket functionality for market-user")
  @Severity(SeverityLevel.BLOCKER)
  @Description("проверка формы добавить товар-" +
          "1-вводим логин пароль-" +
          "2-переходим в каталог ,добавляем товар -10 шт" +
          "3-переходим в корзину" +
          "4-жмем ссылку условия предоставления скидок...закрываем поп-ап"+
          "5-кликаем оформиить заказ "+
          "6-проверяем появление способа получения")

  @Test
  @Order(10)

  public void test10MakingAnOrder(){
    driver.get(SITE_URL);
    driver.findElement(By.xpath("//span[contains(.,'Все понятно')]")).click();
    driver.findElement(By.xpath("//span[contains(.,'Все верно')]")).click();
    driver.findElement(By.xpath("//span[contains(.,'Вход / Регистрация')]")).click();
    driver.findElement(By.name("login")).clear();
    driver.findElement(By.name("login")).sendKeys("9216572712");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("qakras123");
    driver.findElement(By.xpath("//span[contains(.,'Войти в систему')]")).click();

    try {
      WebElement button = driver.findElement(By.xpath("//a[@href='/catalog']"));
      button.click();
    }
    catch(org.openqa.selenium.StaleElementReferenceException ex)
    {
      WebElement button = driver.findElement(By.xpath("//a[@href='/catalog']"));
      button.click();
    }




    driver.findElement(By.xpath("(//div[@data-testid='catalog-item-product-1']//input[@value=''])[1]")).click();
    driver.findElement(By.xpath("(//div[@data-testid='catalog-item-product-1']//input[@value=''])[1]")).sendKeys("10");
    driver.findElement(By.xpath("//div[@data-testid='catalog-item-product-1']//span[@class='MuiButton-label']")).click();
    driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root jss4']")).click();
    driver.findElement(By.xpath("//p[@data-testid='go-to-basket']")).click();

    driver.findElement(By.xpath("//*[@data-testid='conditions-points-and-discounts']")).click();
    driver.findElement(By.xpath("//*[@data-testid='modal-button-close']")).click();
    driver.findElement(By.xpath("//*[@data-testid='go-checkout-btn']")).click();

    assertThat(driver.findElement(By.xpath("//h2[contains(.,'Способ получения')]")).getText(), is("Способ получения"));

    driver.findElement(By.xpath("//button[@title='Выход']")).click();
  }
  @Epic("Testing FOR https://idev.etm.ru/ipro3/ tasks ")
  @Feature(value= "Tests for task-basket functionality for market-user")
  @Severity(SeverityLevel.BLOCKER)
  @Description("проверка формы добавить товар-" +
          "1-вводим логин пароль-" +
          "2-переходим в каталог ,добавляем товар -10 шт" +
          "3-переходим в корзину" +
          "4-жмем Сохранить как смету "+
          "5-закрываем инф.окно что смета создана"+
          "6-проверяем что корзина пуста")
  @Test
  @Order(11)

  public void test11SaveEstimate(){
    driver.get(SITE_URL);
    driver.findElement(By.xpath("//span[contains(.,'Все понятно')]")).click();
    driver.findElement(By.xpath("//span[contains(.,'Все верно')]")).click();
    driver.findElement(By.xpath("//span[contains(.,'Вход / Регистрация')]")).click();
    driver.findElement(By.name("login")).clear();
    driver.findElement(By.name("login")).sendKeys("9216572712");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("qakras123");
    driver.findElement(By.xpath("//span[contains(.,'Войти в систему')]")).click();

    try {
      WebElement button = driver.findElement(By.xpath("//a[@href='/catalog']"));
      button.click();
    }
    catch(org.openqa.selenium.StaleElementReferenceException ex)
    {
      WebElement button = driver.findElement(By.xpath("//a[@href='/catalog']"));
      button.click();
    }




    driver.findElement(By.xpath("(//div[@data-testid='catalog-item-product-1']//input[@value=''])[1]")).click();
    driver.findElement(By.xpath("(//div[@data-testid='catalog-item-product-1']//input[@value=''])[1]")).sendKeys("10");
    driver.findElement(By.xpath("//div[@data-testid='catalog-item-product-1']//span[@class='MuiButton-label']")).click();
    driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root jss4']")).click();
    driver.findElement(By.xpath("//p[@data-testid='go-to-basket']")).click();

    driver.findElement(By.xpath("//*[@data-testid='save-as-estimate']")).click();
    //driver.findElement(By.cssSelector(".jss4 path")).click();
    assertThat(driver.findElement(By.xpath("//p[contains(.,'В корзине нет товаров')]")).getText(), is("В корзине нет товаров"));

    clickVisible(By.xpath("//button[@title='Выход']") ,"element exit not clickable", 5);
  }
  @Epic("Testing FOR https://idev.etm.ru/ipro3/ tasks ")
  @Feature(value= "Tests for task-basket functionality for market-user")
  @Severity(SeverityLevel.BLOCKER)
  @Description("проверка формы добавить товар-" +
          "1-вводим логин пароль-" +
          "2-переходим в каталог ,добавляем товар -10 шт" +
          "3-переходим в корзину" +
          "4-жмем ссылку условия предоставления скидок...закрываем поп-ап"+
          "5-кликаем оформить заказ "+
          "6-проверяем появление способа получения"+
  "7-выбираем СДЭк"+
  "8-выбираем точку получения"+
  "9-заполняем телеофн и ФИО-подтверждаем"+
  "10-Выбираем оплату при получении и жмем оформить заказ"+
  "11-переходим в заказы")
  @Test
  @Order(12)

  public void test12MakingAnOrderBySdekPayUponReceipt(){
    driver.get(SITE_URL);
    driver.findElement(By.xpath("//span[contains(.,'Все понятно')]")).click();
    driver.findElement(By.xpath("//span[contains(.,'Все верно')]")).click();
    driver.findElement(By.xpath("//span[contains(.,'Вход / Регистрация')]")).click();
    driver.findElement(By.name("login")).clear();
    driver.findElement(By.name("login")).sendKeys("9216572712");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("qakras123");
    driver.findElement(By.xpath("//span[contains(.,'Войти в систему')]")).click();

    try {
      WebElement button = driver.findElement(By.xpath("//a[@href='/catalog']"));
      button.click();
    }
    catch(org.openqa.selenium.StaleElementReferenceException ex)
    {
      WebElement button = driver.findElement(By.xpath("//a[@href='/catalog']"));
      button.click();
    }
    //By.xpath("//a[contains(.,'Каталог')]")



    driver.findElement(By.xpath("(//div[@data-testid='catalog-item-product-1']//input[@value=''])[1]")).click();
    driver.findElement(By.xpath("(//div[@data-testid='catalog-item-product-1']//input[@value=''])[1]")).sendKeys("10");
    driver.findElement(By.xpath("//div[@data-testid='catalog-item-product-1']//span[@class='MuiButton-label']")).click();
    driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root jss4']")).click();
    driver.findElement(By.xpath("//p[@data-testid='go-to-basket']")).click();

    driver.findElement(By.xpath("//*[@data-testid='go-checkout-btn']")).click();
    driver.findElement(By.xpath("//img[@src='/assets/img/logo_cdek.png']")).click();
    driver.findElement(By.xpath("//div[contains(.,'Самовывоз СДЭК')]")).click();
    clickVisible(By.xpath("//div[contains(.,'Сенная площадь, Адмиралтейская')]") ,"not click delivery point", 5 );
    driver.findElement(By.xpath("//div[contains(text(),'Сенная площадь, Адмиралтейская')]")).click();


    driver.findElement(By.xpath("//input[@name='phone']")).click();
    driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("9216572712");
    driver.findElement(By.xpath("//input[@name='name']")).click();
    driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Алексей");
    driver.findElement(By.xpath("//span[contains(.,'Подтвердить заявку')]")).click();
    driver.findElement(By.xpath("//div[contains(text(),'При получении')]")).click();
    driver.findElement(By.xpath("//span[contains(.,'Оформить заказ')]")).click();
    waitForElementPresent(By.xpath("//p[contains(.,'Благодарим вас за использование системы iPRO!')]"),"the order is not issued",5);
    driver.findElement(By.xpath("//span[contains(.,'Перейти в Заказы')]")).click();

    driver.findElement(By.xpath("//button[@title='Выход']")).click();
  }
  @Epic("Testing FOR https://idev.etm.ru/ipro3/ tasks ")
  @Feature(value= "Tests for task-basket functionality for market-user")
  @Severity(SeverityLevel.BLOCKER)
  @Description("проверка формы добавить товар-" +
          "1-вводим логин пароль-" +
          "2-переходим в каталог ,добавляем товар -10 шт" +
          "3-переходим в корзину" +
          "4-жмем ссылку условия предоставления скидок...закрываем поп-ап"+
          "5-кликаем оформить заказ "+
          "6-проверяем появление способа получения"+
          "7-выбираем СДЭк"+
          "8-выбираем точку получения"+
          "9-заполняем телеофн и ФИО-подтверждаем"+
          "10-Выбираем оплату картой и жмем оформить заказ"+
          "11-переходим в заказы")
  @Test
  @Order(13)

  public void test13MakingAnOrderBySdekPayByCard(){
    driver.get(SITE_URL);
    driver.findElement(By.xpath("//span[contains(.,'Все понятно')]")).click();
    driver.findElement(By.xpath("//span[contains(.,'Все верно')]")).click();
    driver.findElement(By.xpath("//span[contains(.,'Вход / Регистрация')]")).click();
    driver.findElement(By.name("login")).clear();
    driver.findElement(By.name("login")).sendKeys("9216572712");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("qakras123");
    driver.findElement(By.xpath("//span[contains(.,'Войти в систему')]")).click();

    try {
      WebElement button = driver.findElement(By.xpath("//a[contains(text(),'Каталог')]"));
      button.click();
    }
    catch(org.openqa.selenium.StaleElementReferenceException ex)
    {
      WebElement button = driver.findElement(By.xpath("//a[contains(text(),'Каталог')]"));
      button.click();
    }
    //By.xpath("//a[@href='/catalog']")



    driver.findElement(By.xpath("(//div[@data-testid='catalog-item-product-1']//input[@value=''])[1]")).click();
    driver.findElement(By.xpath("(//div[@data-testid='catalog-item-product-1']//input[@value=''])[1]")).sendKeys("10");
    driver.findElement(By.xpath("//div[@data-testid='catalog-item-product-1']//span[@class='MuiButton-label']")).click();
    driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root jss4']")).click();
    driver.findElement(By.xpath("//p[@data-testid='go-to-basket']")).click();

    driver.findElement(By.xpath("//*[@data-testid='go-checkout-btn']")).click();
    //driver.findElement(By.xpath("//img[@src='/assets/img/logo_cdek.png']")).click();
    //driver.findElement(By.xpath("//div[contains(text(),'Самовывоз СДЭК')]")).click();
    waitForElementPresent(By.xpath("//div[contains(text(),'Самовывоз СДЭК')]"),"the CDEK is not issued",5);
    driver.findElement(By.xpath("//div[contains(text(),'Самовывоз СДЭК')]")).click();
    clickVisible(By.xpath("//div[contains(.,'Сенная площадь, Адмиралтейская')]") ,"not click delivery point", 5 );
    waitForElementPresent(By.xpath("//div[contains(text(),'Сенная площадь, Адмиралтейская')]"),"the delivery point is not issued",5);
    driver.findElement(By.xpath("//div[contains(text(),'Сенная площадь, Адмиралтейская')]")).click();
    driver.findElement(By.xpath("//div[contains(text(),'Сенная площадь, Адмиралтейская')]")).click();


    driver.findElement(By.xpath("//input[@name='phone']")).click();
    driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("9216572712");
    driver.findElement(By.xpath("//input[@name='name']")).click();
    driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Алексей");
    driver.findElement(By.xpath("//span[contains(.,'Подтвердить заявку')]")).click();
    //driver.findElement(By.xpath("//div[contains(text(),'Оплата')]")).click();
    driver.findElement(By.xpath("//img[@src='/assets/img/visa_payment.png']")).click();
    driver.findElement(By.xpath("//span[contains(text(),'Оформить заказ')]")).click();
    waitForElementPresent(By.xpath("//img[@src='img/main-logo-ru.png']"),"the order is not issued",20);
    driver.findElement(By.xpath("//input[@id='iPAN_sub']")).click();
    driver.findElement(By.xpath("//input[@id='iPAN_sub']")).sendKeys("4111111111111111");
    driver.findElement(By.xpath("//input[@id='input-month']")).click();
    driver.findElement(By.xpath("//input[@id='input-month']")).sendKeys("12");
    driver.findElement(By.xpath("//input[@id='input-year']")).click();
    driver.findElement(By.xpath("//input[@id='input-year']")).sendKeys("24");
    driver.findElement(By.xpath("//input[@id='iTEXT']")).click();
    driver.findElement(By.xpath("//input[@id='iTEXT']")).sendKeys("IVAN IVANOV");
    driver.findElement(By.xpath("//input[@id='iCVC']")).click();
    driver.findElement(By.xpath("//input[@id='iCVC']")).sendKeys("123");

    //id="email"
    driver.findElement(By.xpath("//button[@name='SendPayment']")).click();
    waitForElementPresent(By.xpath("//h1[contains(text(),'Подтверждение оплаты')]"),"the page of pay dont present",20);
    driver.findElement(By.xpath("//input[@id='password']")).click();
    driver.findElement(By.xpath("//input[@id='password']")).sendKeys("12345678");
    waitForElementPresent(By.xpath("//p[contains(.,'Статус оплаты: платёж принят')]"),"the page of catalog dont present",10);

    driver.findElement(By.xpath("//button[@title='Выход']")).click();
  }

  @Epic("Testing FOR https://idev.etm.ru/ipro3/ tasks ")
  @Feature(value= "Tests for task-basket functionality for market-user")
  @Severity(SeverityLevel.BLOCKER)
  @Description("проверка формы добавить товар-" +
          "1-вводим логин пароль-" +
          "2-переходим в каталог ,добавляем товар -10 шт" +
          "3-переходим в корзину" +
          "4-жмем ссылку условия предоставления скидок...закрываем поп-ап"+
          "5-кликаем оформить заказ "+
          "6-проверяем появление способа получения"+
          "7-выбираем СДЭк"+
          "8-выбираем точку получения"+
          "9-Выбираем Выписать счет"+
          "10-Вводим инн"+
          "11-Из списка выбираем Газнадзор"+
          "12-Сохраняем данные"+
          "13-Жмем оформить заказ"+
          "8-В форме в заголовок вводим текст"+
          "9-заполняем поле текст письма"+
          "10-вводим email"+
          "11-жмем отправить")
  @Test
  @Order(14)

  public void test14MakingAnOrderByPickUpByIssueAnInvoice(){
    driver.get(SITE_URL);
    driver.findElement(By.xpath("//span[contains(.,'Все понятно')]")).click();
    driver.findElement(By.xpath("//span[contains(.,'Все верно')]")).click();
    driver.findElement(By.xpath("//span[contains(.,'Вход / Регистрация')]")).click();
    driver.findElement(By.name("login")).clear();
    driver.findElement(By.name("login")).sendKeys("9216572712");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("qakras123");
    driver.findElement(By.xpath("//span[contains(.,'Войти в систему')]")).click();

    try {
      WebElement button = driver.findElement(By.xpath("//a[contains(text(),'Каталог')]"));
      button.click();
    }
    catch(org.openqa.selenium.StaleElementReferenceException ex)
    {
      WebElement button = driver.findElement(By.xpath("//a[contains(text(),'Каталог')]"));
      button.click();
    }
    //By.xpath("//a[@href='/catalog']")



    driver.findElement(By.xpath("(//div[@data-testid='catalog-item-product-1']//input[@value=''])[1]")).click();
    driver.findElement(By.xpath("(//div[@data-testid='catalog-item-product-1']//input[@value=''])[1]")).sendKeys("10");
    driver.findElement(By.xpath("//div[@data-testid='catalog-item-product-1']//span[@class='MuiButton-label']")).click();
    driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root jss4']")).click();
    driver.findElement(By.xpath("//p[@data-testid='go-to-basket']")).click();

    driver.findElement(By.xpath("//*[@data-testid='go-checkout-btn']")).click();
    //driver.findElement(By.xpath("//img[@src='/assets/img/logo_cdek.png']")).click();
    //driver.findElement(By.xpath("//div[contains(text(),'Самовывоз СДЭК')]")).click();
    waitForElementPresent(By.xpath("//div[contains(text(),'Самовывоз ЭТМ')]"),"the PickUp is not issued",5);
    //driver.findElement(By.xpath("//div[contains(text(),'Самовывоз ЭТМ')]")).click();
    driver.findElement(By.xpath("//img[@src='/assets/img/logo_etm_blue.png']")).click();
    driver.findElement(By.xpath("//img[@src='/assets/img/logo_etm_blue.png']")).click();
    clickVisible(By.xpath("//div[contains(.,'пос. Шушары, Ленсоветовская дорога, д.12, корп.2, лит.Б')]") ,"not click delivery point", 5 );
    waitForElementPresent(By.xpath("//div[contains(text(),'пос. Шушары, Ленсоветовская дорога, д.12, корп.2, лит.Б')]"),"the delivery point is not issued",5);
    driver.findElement(By.xpath("//div[contains(text(),'пос. Шушары, Ленсоветовская дорога, д.12, корп.2, лит.Б')]")).click();
    driver.findElement(By.xpath("//div[contains(text(),'пос. Шушары, Ленсоветовская дорога, д.12, корп.2, лит.Б')]")).click();

    driver.findElement(By.xpath("//div[contains(text(),'Выписать счет')]")).click();


    driver.findElement(By.xpath("//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputMarginDense MuiOutlinedInput-inputMarginDense']")).click();
    driver.findElement(By.xpath("//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputMarginDense MuiOutlinedInput-inputMarginDense']")).sendKeys("7740000051");
    //driver.findElement(By.xpath("//fieldset[@aria-hidden='true']")).click();
    //driver.findElement(By.xpath("//fieldset[@aria-hidden='true']")).sendKeys("760443001");
    driver.findElement(By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputMarginDense MuiOutlinedInput-inputMarginDense'])[2]")).click();
    driver.findElement(By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputMarginDense MuiOutlinedInput-inputMarginDense'])[2]")).sendKeys("760443001");
    driver.findElement(By.xpath("//input[@name='org_code_fake']")).click();
    driver.findElement(By.xpath("//input[@name='org_code_fake']")).sendKeys("AutoTest");

    //driver.findElement(By.xpath("//div[contains(text(),'Оплата')]")).click();
    driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text']")).click();
    waitForElementPresent(By.xpath("//div[contains(text(),'Данные успешно сохранены.')]"),"the DATA is not saved",5);

    driver.findElement(By.xpath("//span[contains(text(),'Оформить заказ')]")).click();

    waitForElementPresent(By.xpath("//div[contains(text(),'Выставление счета')]"),"the invoice is not issued",20);
    driver.findElement(By.xpath("//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputMarginDense MuiOutlinedInput-inputMarginDense']")).click();
    driver.findElement(By.xpath("//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputMarginDense MuiOutlinedInput-inputMarginDense']")).sendKeys("test");
    driver.findElement(By.xpath("//textarea[@rows='1']")).click();
    driver.findElement(By.xpath("//textarea[@rows='1']")).sendKeys("test");
    driver.findElement(By.xpath("//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiAutocomplete-input MuiAutocomplete-inputFocused MuiInputBase-inputAdornedEnd MuiOutlinedInput-inputAdornedEnd MuiInputBase-inputMarginDense MuiOutlinedInput-inputMarginDense']")).click();
    driver.findElement(By.xpath("//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiAutocomplete-input MuiAutocomplete-inputFocused MuiInputBase-inputAdornedEnd MuiOutlinedInput-inputAdornedEnd MuiInputBase-inputMarginDense MuiOutlinedInput-inputMarginDense']")).sendKeys("krasikov_al@etm.ru");
    driver.findElement(By.xpath("//span[contains(text(),'Отправить по E-mail')]")).click();

    waitForElementPresent(By.xpath("//p[contains(.,'Благодарим вас за использование системы iPRO!')]"),"the page of catalog dont present",10);

    waitForElementPresent(By.xpath("//button[@title='Выход']"),"the element EXIT is dont present",10);
    driver.findElement(By.xpath("//button[@title='Выход']")).click();
  }
  @Epic("Testing FOR https://idev.etm.ru/ipro3/ tasks ")
  @Feature(value= "Tests for task-basket functionality for market-user")
  @Severity(SeverityLevel.BLOCKER)
  @Description("проверка формы добавить товар-" +
          "1-вводим логин пароль-" +
          "2-переходим в каталог ,добавляем товар -10 шт" +
          "3-переходим в корзину" +
          "4-жмем ссылку условия предоставления скидок...закрываем поп-ап"+
          "5-кликаем оформить заказ "+
          "6-проверяем появление способа получения"+
          "7-выбираем СДЭк"+
          "8-выбираем точку получения"+
          "9-Выбираем Выписать счет"+
          "10-Вводим инн"+
          "11-Из списка выбираем Газнадзор"+
          "12-Сохраняем данные"+
          "13-Жмем оформить заказ"+
          "8-В форме в заголовок вводим текст"+
          "9-заполняем поле текст письма"+
          "10-вводим email"+
          "11-жмем отправить")
  @Test
  @Order(15)

  public void test15MakingAnOrderByDeliveryPayToCard(){
    driver.get(SITE_URL);
    driver.findElement(By.xpath("//span[contains(.,'Все понятно')]")).click();
    driver.findElement(By.xpath("//span[contains(.,'Все верно')]")).click();
    driver.findElement(By.xpath("//span[contains(.,'Вход / Регистрация')]")).click();
    driver.findElement(By.name("login")).clear();
    driver.findElement(By.name("login")).sendKeys("9216572712");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("qakras123");
    driver.findElement(By.xpath("//span[contains(.,'Войти в систему')]")).click();

    try {
      WebElement button = driver.findElement(By.xpath("//a[contains(text(),'Каталог')]"));
      button.click();
    }
    catch(org.openqa.selenium.StaleElementReferenceException ex)
    {
      WebElement button = driver.findElement(By.xpath("//a[contains(text(),'Каталог')]"));
      button.click();
    }
    //By.xpath("//a[@href='/catalog']")



    driver.findElement(By.xpath("(//div[@data-testid='catalog-item-product-1']//input[@value=''])[1]")).click();
    driver.findElement(By.xpath("(//div[@data-testid='catalog-item-product-1']//input[@value=''])[1]")).sendKeys("10");
    driver.findElement(By.xpath("//div[@data-testid='catalog-item-product-1']//span[@class='MuiButton-label']")).click();
    driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root jss4']")).click();
    driver.findElement(By.xpath("//p[@data-testid='go-to-basket']")).click();

    driver.findElement(By.xpath("//*[@data-testid='go-checkout-btn']")).click();
    //driver.findElement(By.xpath("//img[@src='/assets/img/logo_cdek.png']")).click();
    //driver.findElement(By.xpath("//div[contains(text(),'Самовывоз СДЭК')]")).click();
    waitForElementPresent(By.xpath("//div[contains(text(),'Доставка ЭТМ')]"),"the PickUp is not issued",5);
    //driver.findElement(By.xpath("//div[contains(text(),'Самовывоз ЭТМ')]")).click();
    driver.findElement(By.xpath("(//img[@src='/assets/img/logo_etm_blue.png'])[2]")).click();
    driver.findElement(By.xpath("(//img[@src='/assets/img/logo_etm_blue.png'])[2]")).click();
    //clickVisible(By.xpath("//div[contains(.,'пос. Шушары, Ленсоветовская дорога, д.12, корп.2, лит.Б')]") ,"not click delivery point", 5 );
    //waitForElementPresent(By.xpath("//div[contains(text(),'пос. Шушары, Ленсоветовская дорога, д.12, корп.2, лит.Б')]"),"the delivery point is not issued",5);
    //driver.findElement(By.xpath("//div[contains(text(),'пос. Шушары, Ленсоветовская дорога, д.12, корп.2, лит.Б')]")).click();
    //driver.findElement(By.xpath("//div[contains(text(),'пос. Шушары, Ленсоветовская дорога, д.12, корп.2, лит.Б')]")).click();

    driver.findElement(By.xpath("//input[@name='contactPerson']")).click();
    driver.findElement(By.xpath("//input[@name='contactPerson']")).sendKeys("Aleksey");
    driver.findElement(By.xpath("//input[@name='phone']")).click();
    driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("9216572712");
    driver.findElement(By.xpath("//input[@name='additional']")).click();
    driver.findElement(By.xpath("//input[@name='additional']")).sendKeys("test");



    driver.findElement(By.xpath("//input[@name='position_fake']")).click();
    driver.findElement(By.xpath("//input[@name='position_fake']")).sendKeys("Санкт-Петербург");

    WebElement element = driver.findElement(By.xpath("//input[@name='position_fake']"));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

    WebElement ListCity = driver.findElement(By.xpath("//input[@name='position_fake']"));
    int Width = ListCity.getSize().getWidth();
    int Height = ListCity.getSize().getHeight();
    int MyX = 1;//spot to click is at 200% of the width
    int MyY = (Height * 150) / 100;                        //anywhere above Height/2 works
    Actions Actions = new Actions(driver);
    Actions.moveToElement(ListCity,MyX,MyY).click().build().perform();
    //waitForElementAndClick(By.xpath("//input[contains(@aria-controls,'popup')]"),"the SPB is not issued",5);


    //actions.moveToElement(driver.findElement(By.xpath("//input[@name='position_fake']"))).click().sendKeys("Санкт-Петербург").moveToElement(driver.findElement(By.xpath("//input[@name='contactPerson']"))).moveToElement(driver.findElement(By.xpath("//input[@aria-activedescendant='mui-41531-option-0']"))).click().build().perform();
    //waitForElementPresent(By.xpath("//input[@aria-activedescendant='mui-41531-option-0']"),"the SPB is not issued",5);
    driver.findElement(By.xpath("//input[@name='address']")).click();
    driver.findElement(By.xpath("//input[@name='address']")).sendKeys("Авиаторов");
    driver.findElement(By.xpath("//input[@name='date_fake']")).click();

    waitForElementPresent(By.xpath("//div[@class='MuiPaper-root MuiPopover-paper MuiPaper-elevation8 MuiPaper-rounded']"),"the Calendar is not present",5);

    WebElement ListDate = driver.findElement(By.xpath("//input[@name='date_fake']"));
    int Widths = ListDate.getSize().getWidth();
    int Heights = ListDate.getSize().getHeight();
    int MyXs = 1;//spot to click is at 200% of the width
    int MyYs = (Heights * 600) / 100;                        //anywhere above Height/2 works
    Actions Builder = new Actions(driver);
    Builder.moveToElement(ListDate,1,MyYs).click().build().perform();
//,MyXs,MyYs
    waitForElementPresent(By.xpath("//div[@id='mui-component-select-time_fake']"),"the time_fake is not issued",5);
    driver.findElement(By.xpath("//div[@id='mui-component-select-time_fake']")).click();
    driver.findElement(By.xpath("//li[@data-value='12:00']")).click();
    waitForElementPresent(By.xpath("//div[@id='mui-component-select-time_po_fake']"),"the time_fake is not issued",5);
    driver.findElement(By.xpath("//div[@id='mui-component-select-time_po_fake']")).click();
    waitForElementPresent(By.xpath("//li[@data-value='20:00']"),"the time_20:00 is not issued",5);
    driver.findElement(By.xpath("//li[@data-value='20:00']")).click();

    driver.findElement(By.xpath("//span[contains(text(),'Подтвердить заявку')]")).click();
    driver.findElement(By.xpath("//div[contains(text(),'Выписать счет')]")).click();


    driver.findElement(By.xpath("//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputMarginDense MuiOutlinedInput-inputMarginDense']")).click();
    driver.findElement(By.xpath("//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputMarginDense MuiOutlinedInput-inputMarginDense']")).sendKeys("7740000051");
    //driver.findElement(By.xpath("//fieldset[@aria-hidden='true']")).click();
    //driver.findElement(By.xpath("//fieldset[@aria-hidden='true']")).sendKeys("760443001");
    driver.findElement(By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputMarginDense MuiOutlinedInput-inputMarginDense'])[2]")).click();
    driver.findElement(By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputMarginDense MuiOutlinedInput-inputMarginDense'])[2]")).sendKeys("760443001");
    driver.findElement(By.xpath("//input[@name='org_code_fake']")).click();
    driver.findElement(By.xpath("//input[@name='org_code_fake']")).sendKeys("AutoTest");

    //driver.findElement(By.xpath("//div[contains(text(),'Оплата')]")).click();
    driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text']")).click();
    waitForElementPresent(By.xpath("//div[contains(text(),'Данные успешно сохранены.')]"),"the DATA is not saved",5);

    driver.findElement(By.xpath("//span[contains(text(),'Оформить заказ')]")).click();

    waitForElementPresent(By.xpath("//div[contains(text(),'Выставление счета')]"),"the invoice is not issued",20);
    driver.findElement(By.xpath("//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputMarginDense MuiOutlinedInput-inputMarginDense']")).click();
    driver.findElement(By.xpath("//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputMarginDense MuiOutlinedInput-inputMarginDense']")).sendKeys("test");
    driver.findElement(By.xpath("//textarea[@rows='1']")).click();
    driver.findElement(By.xpath("//textarea[@rows='1']")).sendKeys("test");
    driver.findElement(By.xpath("//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiAutocomplete-input MuiAutocomplete-inputFocused MuiInputBase-inputAdornedEnd MuiOutlinedInput-inputAdornedEnd MuiInputBase-inputMarginDense MuiOutlinedInput-inputMarginDense']")).click();
    driver.findElement(By.xpath("//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiAutocomplete-input MuiAutocomplete-inputFocused MuiInputBase-inputAdornedEnd MuiOutlinedInput-inputAdornedEnd MuiInputBase-inputMarginDense MuiOutlinedInput-inputMarginDense']")).sendKeys("krasikov_al@etm.ru");
    driver.findElement(By.xpath("//span[contains(text(),'Отправить по E-mail')]")).click();

    waitForElementPresent(By.xpath("//p[contains(.,'Благодарим вас за использование системы iPRO!')]"),"the page of catalog dont present",10);

    waitForElementPresent(By.xpath("//button[@title='Выход']"),"the element EXIT is dont present",10);
    driver.findElement(By.xpath("//button[@title='Выход']")).click();
  }*/







  private WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds) {
    WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
    wait.withMessage(error_message + "\n");

    return wait.until(
            ExpectedConditions.presenceOfElementLocated(by)
    );
  }
  private WebElement waitForElementAndClick(By by, String error_message, long timeoutInSeconds) {
    WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
    element.click();

    return element;

  }
  private WebElement waitForElementAndClickable(By by, String error_message, long timeoutInSeconds){
    WebDriverWait wait=new WebDriverWait(driver, 10);
    wait.withMessage(error_message + "\n");
    return wait.until
            (ExpectedConditions.elementToBeClickable(by));

  }


  private WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeoutInSeconds) {
    WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
    element.sendKeys(value);

    return element;

  }

  private boolean waitForElementNotPresent(By by, String error_message, long timeoutInSeconds) {
    WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
    wait.withMessage(error_message + "\n");

    return wait.until(
            ExpectedConditions.invisibilityOfElementLocated(by)
    );
  }

  private WebElement waitForElementAndClear(By by, String error_message, long timeoutInSeconds) {
    WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
    element.clear();
    return element;
  }
  private WebElement waitForElementLocated(By by, String error_message, long timeoutInSeconds) {
    WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
    wait.withMessage(error_message + "\n");

    return wait.until(
            ExpectedConditions.visibilityOfElementLocated(by)
    );
  }
  public void clickVisible(By by ,String error_message, long timeoutInSeconds ){
    WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
    wait.until(ExpectedConditions.elementToBeClickable(by));
    wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    final Actions actions = new Actions(driver);
    actions.moveToElement(driver.findElement(by)).click().perform();
  }
}



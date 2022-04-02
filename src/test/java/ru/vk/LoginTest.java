package ru.vk;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class LoginTest {
    public static AuthorizationPage authorizationPage;
    public static MainPage mainPage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperies.getProperty("chromedriver"));
        //WebDriver driver = new ChromeDriver();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperies.getProperty("loginPage"));
        authorizationPage = new AuthorizationPage(driver);
        mainPage = new MainPage(driver);
    }

    @Test
    public void loginTest() {
       // Кликаем войти
        authorizationPage.clickLoginBtn();
        //Вводим логин
        authorizationPage.inputLogin(ConfProperies.getProperty("login"));
        //Кликаем продолжить
        authorizationPage.clickProceedBtn();
        //Вводим пароль
        authorizationPage.inputPasswd(ConfProperies.getProperty("password"));
        //Кликаем далее
        authorizationPage.clickNextBtn();
        //Кликаем на иконку профиля
        mainPage.entryMenu();
        //Получаем значение в юзернейм
        String user = mainPage.getUserName();
        Assert.assertEquals("Татьяна Гринвеева",user);
        //System.out.println(user);
    }
        @AfterClass
        public static void tearDown() {
            mainPage.userLogout();
            driver.quit(); }
    }


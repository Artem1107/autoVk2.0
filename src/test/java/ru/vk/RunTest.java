package ru.vk;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class RunTest {
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
    public void login() {
       Login.login();
        mainPage.userLogout(); //тут должна быть шутка про костыль
    }

    @Test
    public void Negativlogin(){
        Login.loginNegativ();
    }


        @AfterClass
        public static void tearDown() {
        driver.quit(); }
    }


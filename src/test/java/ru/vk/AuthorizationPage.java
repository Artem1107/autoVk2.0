package ru.vk;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;


public class AuthorizationPage {
    // конструктор класса, занимающийся инициализацией полей класса
    public WebDriver driver;
    public AuthorizationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    //Кнопка вход
    @FindBy(xpath="//button[@class=\"FlatButton FlatButton--primary FlatButton--size-l FlatButton--wide VkIdForm__button VkIdForm__signInButton\"]")
    private WebElement entryBtn;

    //Поле номер или емаил
    @FindBy(xpath="//input[@name = 'login']")
    private WebElement loginField;

    //Кнопка продолжить
    @FindBy(xpath="//div[@class=\"vkc__EnterLogin__button\"]")
    private WebElement proceedBtn;

    //Кнопка далее
    @FindBy(xpath="//div[@class=\"vkc__EnterPasswordNoUserInfo__buttonWrap\"]")
    private WebElement nextBtn;

    //Поле пароль
    @FindBy(xpath="//input[@name = 'password'] ")
    private WebElement passwdField;

    //Метод ввода логина
    public void inputLogin (String login) {
        loginField.sendKeys(login);
    }

    // Метод нажатия кнопки продолжить
        public void clickProceedBtn() {
            proceedBtn.click();}

    // Метод нажатия кнопки далее, ебись конём, раньше ж норм интерфейс был
    public void clickNextBtn() {
        nextBtn.click();}

    // Метод нажатия кнопки вход
    public void clickLoginBtn() {
        entryBtn.click();}

    //Метод ввода пароля
    public void inputPasswd(String passwd) {
        passwdField.sendKeys(passwd); }
    }



package ru.vk;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    public WebDriver driver;
    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    //Выпадашка меню
    @FindBy(xpath="//div[@class = 'TopNavBtn__profileArrow']")
    private WebElement profileMenuBtn;

    //Имя профиля
    @FindBy(xpath="//div[@class = 'EcosystemAccountMenu_name__1wHzk']")
    private WebElement userMenu;

    //Кнопка выход
    @FindBy(id="top_logout_link")
    private WebElement logOutBtn;

    /**
     * метод для получения имени пользователя из меню пользователя
     */

    public String getUserName() {
        String userName = userMenu.getText();
        return userName; }

    /**
     * метод для нажатия кнопки меню пользователя
     */
    public void entryMenu() {
        profileMenuBtn.click(); }
    /**
     * метод для нажатия кнопки выхода из аккаунта
     */
    public void userLogout() {
        logOutBtn.click(); }
}

package ru.vk;

import org.junit.Assert;

import static ru.vk.RunTest.authorizationPage;
import static ru.vk.RunTest.mainPage;

public class Login {
    public static void login(){
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
        //Кликаем на выход


    }
    public static void loginNegativ(){
        // Кликаем войти
        authorizationPage.clickLoginBtn();
        //Вводим логин
        authorizationPage.inputLogin(ConfProperies.getProperty("login"));
        //Кликаем продолжить
        authorizationPage.clickProceedBtn();
        //Вводим пароль
        authorizationPage.inputPasswd(ConfProperies.getProperty("falsePassword"));
        //Кликаем далее
        authorizationPage.clickNextBtn();
        //Получаем текст подсказки и присваиваем в стрингу
        String hintText = authorizationPage.getTextHint();
        //Сравниваем с неповторимым оригиналом
        Assert.assertEquals("Неверный пароль",hintText);



    }

}

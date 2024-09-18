package ru.iteco.fmhandroid.tests.hospis;

import static ru.iteco.fmhandroid.testdata.User.UNREGISTERED_USER;
import static ru.iteco.fmhandroid.testdata.User.USER_WITHOUT_LOGIN;
import static ru.iteco.fmhandroid.testdata.User.USER_WITHOUT_PASSWORD;
import static ru.iteco.fmhandroid.testdata.User.VALID_USER;

import org.junit.Test;

import io.qameta.allure.kotlin.Feature;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.tests.BaseTest;

@Feature(value = "Авторизация")
public class LoginScreenTest extends BaseTest {

    @Story("Авторизация в приложении под валидными учетными данными")
    @Test
    public void loginWithValidUserTest() {
        loginScreenSteps.login(VALID_USER);
        mainScreenSteps.checkScreenIsLoaded();
    }

    @Story("Выход из учетной записи")
    @Test
    public void logoutTest() {
        loginScreenSteps.login(VALID_USER);
        mainScreenSteps.checkScreenIsLoaded();
        mainScreenSteps.logOut();
    }

    @Story("Авторизация в мобильном приложении при пустом поле \"Логин\"")
    @Test
    public void loginWithEmptyLoginTest() {
        loginScreenSteps.login(USER_WITHOUT_LOGIN);
        loginScreenSteps.checkEmptyUserDataToastIsDisplayed();
    }

    @Story("Авторизация в мобильном приложении при пустом поле \"Пароль\"")
    @Test
    public void loginWithEmptyPasswordTest() {
        loginScreenSteps.login(USER_WITHOUT_PASSWORD);
        loginScreenSteps.checkEmptyUserDataToastIsDisplayed();
    }

    @Story("Авторизация в мобильном приложении незарегистрированного пользователя")
    @Test
    public void loginWithUnregisteredUserTest() {
        loginScreenSteps.login(UNREGISTERED_USER);
        loginScreenSteps.checkWrongUserDataToastIsDisplayed();
    }
}

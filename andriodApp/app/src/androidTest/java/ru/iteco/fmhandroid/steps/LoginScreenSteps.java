package ru.iteco.fmhandroid.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.utils.CustomMatchers.waitForElement;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.screens.LoginScreen;
import ru.iteco.fmhandroid.testdata.User;

public class LoginScreenSteps extends BaseSteps {

    private final LoginScreen loginScreen = new LoginScreen();

    @Step("Проверка отображения экрана авторизации")
    public void checkScreenIsLoaded() {
        waitForElement(withText(R.string.authorization), DEFAULT_TIMEOUT);
        loginScreen.title.check(matches(isDisplayed()));
        loginScreen.loginField.check(matches(isDisplayed()));
        loginScreen.passwordField.check(matches(isDisplayed()));
        loginScreen.signInButton.check(matches(isDisplayed()));
    }

    @Step("Авторизоваться по логину и паролю")
    public void login(User user) {
        enterText(loginScreen.loginField, user.getLogin());
        enterText(loginScreen.passwordField, user.getPassword());
        loginScreen.signInButton.perform(click());
    }

    @Step("Проверка отображения уведомления \"Логин и Пароль не могут быть пустыми\"")
    public void checkEmptyUserDataToastIsDisplayed() {
        loginScreen.emptyUserDataToast.check(matches(isDisplayed()));
    }

    @Step("Проверка отображения уведомления \"Неверный логин или пароль\"")
    public void checkWrongUserDataToastIsDisplayed() {
        loginScreen.wrongUserDataToast.check(matches(isDisplayed()));
    }

    private void enterText(ViewInteraction field, String text) {
        field.perform(click());
        field.perform(replaceText(text));
    }
}

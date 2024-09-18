package ru.iteco.fmhandroid.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.screens.MainScreen;

public class MainScreenSteps extends NavigationBarSteps {

    private final MainScreen mainScreen = new MainScreen();

    @Step("Проверка отображения раздела \"Главная\"")
    public void checkScreenIsLoaded() {
        super.checkScreenIsLoaded();
        mainScreen.news.check(matches(isDisplayed()));
        mainScreen.newsList.check(matches(isDisplayed()));
        mainScreen.allNewsButton.check(matches(isDisplayed()));
    }

    @Step("Перейти в раздел \"Новости\" по кнопке \"Все новости\"")
    public void goToNews() {
        mainScreen.allNewsButton.perform(click());
    }
}

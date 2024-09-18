package ru.iteco.fmhandroid.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.utils.CustomMatchers.waitForElement;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.screens.NavigationBar;

public class NavigationBarSteps extends BaseSteps {

    private final NavigationBar navigationBar = new NavigationBar();

    @Step("Проверка отображения элементов панели навигации")
    public void checkScreenIsLoaded() {
        waitForElement(withId(R.id.trademark_image_view), DEFAULT_TIMEOUT);
        navigationBar.menuButton.check(matches(isDisplayed()));
        navigationBar.logo.check(matches(isDisplayed()));
        navigationBar.ourMissionButton.check(matches(isDisplayed()));
        navigationBar.logoutButton.check(matches(isDisplayed()));
    }

    @Step("Выйти из учетной записи")
    public void logOut() {
        navigationBar.logoutButton.perform(click());
        waitForElement(withText(R.string.log_out), DEFAULT_TIMEOUT);
        navigationBar.logoutMenuItem.check(matches(isDisplayed()));
        navigationBar.logoutMenuItem.perform(click());
    }

    @Step("Открыть \"Меню\"")
    public void clickMenuButton() {
        navigationBar.menuButton.check(matches(isClickable()));
        navigationBar.menuButton.perform(click());
        navigationBar.mainMenuItem.check(matches(isDisplayed()));
        navigationBar.newsMenuItem.check(matches(isDisplayed()));
        navigationBar.aboutMenuItem.check(matches(isDisplayed()));
    }

    @Step("Перейти в раздел \"Главная\" из \"Меню\"")
    public void goToMainFromMenu() {
        clickMenuButton();
        navigationBar.mainMenuItem.perform(click());
    }

    @Step("Перейти в раздел \"Новости\" из \"Меню\"")
    public void goToNewsFromMenu() {
        clickMenuButton();
        navigationBar.newsMenuItem.perform(click());
    }

    @Step("Перейти в раздел \"О приложении\" из \"Меню\"")
    public void goToAboutFromMenu() {
        clickMenuButton();
        navigationBar.aboutMenuItem.perform(click());
    }

    @Step("Перейти в раздел \"Наша миссия\"")
    public void goToOurMission() {
        navigationBar.ourMissionButton.perform(click());
    }
}

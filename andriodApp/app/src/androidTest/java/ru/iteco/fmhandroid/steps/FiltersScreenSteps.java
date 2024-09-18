package ru.iteco.fmhandroid.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.utils.CustomMatchers.waitForElement;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.screens.FiltersScreen;

public class FiltersScreenSteps extends BaseSteps {

    private final FiltersScreen filtersScreen = new FiltersScreen();

    @Step("Проверка отображения раздела \"Фильтровать новости\" на экране \"Новости\"")
    public void checkNewsFilterScreenIsLoaded() {
        checkScreenIsLoaded();
    }

    @Step("Очистить поля с датами")
    public void clearDateFields() {
        fillDateFields("", "");
    }

    @Step("Заполнить поля с датами")
    public void fillDateFields(String startDate, String endDate) {
        filtersScreen.startDateField.perform(replaceText(startDate));
        filtersScreen.endDateField.perform(replaceText(endDate));
    }

    @Step("Нажать \"Фильтровать\"")
    public void clickFilterButton() {
        filtersScreen.filterButton.perform(click());
    }

    @Step("Нажать на чекбокс \"Активный\"")
    public void clickActiveCheckbox() {
        filtersScreen.checkBoxActive.perform(click());
    }

    @Step("Нажать на чекбокс \"Неактивный\"")
    public void clickNotActiveCheckbox() {
        filtersScreen.checkBoxNotActive.perform(click());
    }

    private void checkScreenIsLoaded() {
        waitForElement(withText(R.string.filter_news), DEFAULT_TIMEOUT);
        filtersScreen.title.check(matches(isDisplayed()));
        filtersScreen.categoryField.check(matches(isDisplayed()));
        filtersScreen.startDateField.check(matches(isDisplayed()));
        filtersScreen.endDateField.check(matches(isDisplayed()));
        filtersScreen.filterButton.check(matches(isDisplayed()));
        filtersScreen.cancelButton.check(matches(isDisplayed()));
    }
}

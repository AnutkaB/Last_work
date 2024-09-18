package ru.iteco.fmhandroid.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.not;
import static ru.iteco.fmhandroid.utils.CustomMatchers.waitForElement;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.screens.OurMissionScreen;
import ru.iteco.fmhandroid.testdata.Quote;

public class OurMissionScreenSteps extends NavigationBarSteps {

    private final OurMissionScreen ourMissionScreen = new OurMissionScreen();

    @Step("Проверка отображения раздела \"О приложении\"")
    public void checkScreenIsLoaded() {
        super.checkScreenIsLoaded();
        waitForElement(withId(R.id.our_mission_title_text_view), DEFAULT_TIMEOUT);
        ourMissionScreen.title.check(matches(isDisplayed()));
        ourMissionScreen.listOfItems.check(matches(isDisplayed()));
    }

    @Step("Развернуть цитату")
    public void expandQuote(Quote quote) {
        expandQuote(quote.getTitle());
    }

    @Step("Развернуть цитату")
    public void expandQuote(String title) {
        ourMissionScreen.getCollapsedMissionItem(title).check(matches(isDisplayed()));
        ourMissionScreen.getCollapsedMissionItem(title).perform(click());
    }

    @Step("Проверить содержимое цитаты")
    public void checkExpandedQuote(Quote quote) {
        checkExpandedQuote(quote.getTitle(), quote.getDescription());
    }

    @Step("Проверить содержимое цитаты")
    public void checkExpandedQuote(String title, String description) {
        ourMissionScreen.getExpandedMissionItem(title, description).check(matches(isDisplayed()));
    }

    @Step("Свернуть цитату")
    public void collapseQuote(Quote quote) {
        collapseQuote(quote.getTitle(), quote.getDescription());
    }

    @Step("Свернуть цитату")
    public void collapseQuote(String title, String description) {
        ourMissionScreen.getExpandedMissionItem(title, description).perform(click());
    }

    @Step("Проверить, что цитата свернута")
    public void checkQuoteDescriptionIsNotDisplayed(Quote quote) {
        checkQuoteDescriptionIsNotDisplayed(quote.getDescription());
    }

    @Step("Проверить, что цитата свернута")
    public void checkQuoteDescriptionIsNotDisplayed(String description) {
        ourMissionScreen.getMissionItemDescription(description).check(matches(not(isDisplayed())));
    }
}

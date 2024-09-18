package ru.iteco.fmhandroid.tests.hospis;

import static ru.iteco.fmhandroid.testdata.Quote.QUOTE;
import static ru.iteco.fmhandroid.testdata.User.VALID_USER;

import org.junit.Test;

import io.qameta.allure.kotlin.Feature;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.tests.BaseTest;

@Feature(value = "Цитаты")
public class OurMissionTest extends BaseTest {

    @Story("Развернуть и свернуть цитату")
    @Test
    public void expandAndCollapseQuoteTest() {
        loginScreenSteps.login(VALID_USER);
        mainScreenSteps.checkScreenIsLoaded();
        mainScreenSteps.goToOurMission();
        ourMissionScreenSteps.checkScreenIsLoaded();
        ourMissionScreenSteps.expandQuote(QUOTE);
        ourMissionScreenSteps.checkExpandedQuote(QUOTE);
        ourMissionScreenSteps.collapseQuote(QUOTE);
        ourMissionScreenSteps.checkQuoteDescriptionIsNotDisplayed(QUOTE);
    }
}

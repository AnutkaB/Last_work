package ru.iteco.fmhandroid.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static ru.iteco.fmhandroid.utils.CustomMatchers.waitForElement;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.screens.AboutScreen;

public class AboutScreenSteps extends BaseSteps {

    private final AboutScreen aboutScreen = new AboutScreen();

    @Step("Проверка отображения раздела \"О приложении\"")
    public void checkScreenIsLoaded() {
        waitForElement(withId(R.id.about_version_title_text_view), DEFAULT_TIMEOUT);
        aboutScreen.version.check(matches(isDisplayed()));
        aboutScreen.privacyPolicyLink.check(matches(isDisplayed()));
        aboutScreen.privacyPolicyTitle.check(matches(isDisplayed()));
        aboutScreen.termsOfUseLink.check(matches(isDisplayed()));
        aboutScreen.termsOfUseTitle.check(matches(isDisplayed()));
        aboutScreen.companyInfo.check(matches(isDisplayed()));
        aboutScreen.backButton.check(matches(isDisplayed()));
    }

    @Step("Нажать на кнопку \"Назад\"")
    public void clickBackButton() {
        aboutScreen.backButton.perform(click());
    }
}

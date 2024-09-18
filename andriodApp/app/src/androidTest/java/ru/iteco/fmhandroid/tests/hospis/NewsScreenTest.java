package ru.iteco.fmhandroid.tests.hospis;

import static ru.iteco.fmhandroid.testdata.User.VALID_USER;

import org.junit.Before;
import org.junit.Test;

import io.qameta.allure.kotlin.Feature;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.tests.BaseTest;

@Feature(value = "Вкладка «Новости»")
public class NewsScreenTest extends BaseTest {

    @Before
    public void beforeEach() {
        loginScreenSteps.login(VALID_USER);
        mainScreenSteps.checkScreenIsLoaded();
        mainScreenSteps.goToNews();
        newsScreenSteps.checkScreenIsLoaded();
    }

    @Story("Переход на вкладку «Главная» через меню навигации")
    @Test
    public void goToNewsFromMenuTest() {
        newsScreenSteps.goToMainFromMenu();
        mainScreenSteps.checkScreenIsLoaded();
    }

    @Story("Переход на вкладку «О приложении» через меню навигации")
    @Test
    public void goToAboutFromMenuTest() {
        newsScreenSteps.goToAboutFromMenu();
        aboutScreenSteps.checkScreenIsLoaded();
    }

    @Story("Переход на вкладку «Цитаты»")
    @Test
    public void goToOurMissionTest() {
        newsScreenSteps.goToOurMission();
        ourMissionScreenSteps.checkScreenIsLoaded();
    }
}

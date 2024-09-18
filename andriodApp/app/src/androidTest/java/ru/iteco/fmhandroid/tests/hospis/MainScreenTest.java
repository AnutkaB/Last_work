package ru.iteco.fmhandroid.tests.hospis;

import static ru.iteco.fmhandroid.testdata.User.VALID_USER;

import org.junit.Before;
import org.junit.Test;

import io.qameta.allure.kotlin.Feature;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.tests.BaseTest;

@Feature(value = "Вкладка «Главная»")
public class MainScreenTest extends BaseTest {

    @Before
    public void beforeEach() {
        loginScreenSteps.login(VALID_USER);
        mainScreenSteps.checkScreenIsLoaded();
    }

    @Story("Переход на вкладку «Новости» с главной страницы")
    @Test
    public void goToNewsFromMainScreenTest() {
        mainScreenSteps.goToNews();
        newsScreenSteps.checkScreenIsLoaded();
    }

    @Story("Переход на вкладку «Новости» через меню навигации")
    @Test
    public void goToNewsFromMenuTest() {
        mainScreenSteps.goToNewsFromMenu();
        newsScreenSteps.checkScreenIsLoaded();
    }

    @Story("Переход на вкладку «О приложении» через меню навигации")
    @Test
    public void goToAboutFromMenuTest() {
        mainScreenSteps.goToAboutFromMenu();
        aboutScreenSteps.checkScreenIsLoaded();
    }

    @Story("Переход на вкладку «Цитаты»")
    @Test
    public void goToOurMissionTest() {
        mainScreenSteps.goToOurMission();
        ourMissionScreenSteps.checkScreenIsLoaded();
    }
}

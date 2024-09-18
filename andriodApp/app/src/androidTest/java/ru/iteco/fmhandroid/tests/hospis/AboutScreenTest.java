package ru.iteco.fmhandroid.tests.hospis;

import static ru.iteco.fmhandroid.testdata.User.VALID_USER;

import org.junit.Test;

import io.qameta.allure.kotlin.Feature;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.tests.BaseTest;

@Feature(value = "Вкладка «О приложении»")
public class AboutScreenTest extends BaseTest {

    @Story("Переход из раздела «О приложении» назад")
    @Test
    public void goBackFromAboutScreenTest() {
        loginScreenSteps.login(VALID_USER);
        mainScreenSteps.checkScreenIsLoaded();
        mainScreenSteps.goToAboutFromMenu();
        aboutScreenSteps.checkScreenIsLoaded();
        aboutScreenSteps.clickBackButton();
        mainScreenSteps.checkScreenIsLoaded();
    }
}

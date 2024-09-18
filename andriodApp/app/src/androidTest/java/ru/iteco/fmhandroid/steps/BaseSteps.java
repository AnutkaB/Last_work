package ru.iteco.fmhandroid.steps;

import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static ru.iteco.fmhandroid.utils.CustomMatchers.waitForElement;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;

public class BaseSteps {

    protected static final int DEFAULT_TIMEOUT = 5000;

    @Step("Ожидание загрузки приложения")
    public void waitForAppToLoad() {
        waitForElement(withId(R.id.splashscreen_image_view), DEFAULT_TIMEOUT);
    }
}

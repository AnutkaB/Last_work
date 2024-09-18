package ru.iteco.fmhandroid.tests;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import ru.iteco.fmhandroid.steps.AboutScreenSteps;
import ru.iteco.fmhandroid.steps.ControlPanelScreenSteps;
import ru.iteco.fmhandroid.steps.CreateEditNewsScreenSteps;
import ru.iteco.fmhandroid.steps.FiltersScreenSteps;
import ru.iteco.fmhandroid.steps.LoginScreenSteps;
import ru.iteco.fmhandroid.steps.MainScreenSteps;
import ru.iteco.fmhandroid.steps.NewsScreenSteps;
import ru.iteco.fmhandroid.steps.OurMissionScreenSteps;
import ru.iteco.fmhandroid.ui.AppActivity;

@RunWith(AllureAndroidJUnit4.class)
public class BaseTest {

    protected static AboutScreenSteps aboutScreenSteps = new AboutScreenSteps();
    protected static ControlPanelScreenSteps controlPanelScreenSteps = new ControlPanelScreenSteps();
    protected static CreateEditNewsScreenSteps createEditNewsScreenSteps = new CreateEditNewsScreenSteps();
    protected static FiltersScreenSteps filtersScreenSteps = new FiltersScreenSteps();
    protected static LoginScreenSteps loginScreenSteps = new LoginScreenSteps();
    protected static MainScreenSteps mainScreenSteps = new MainScreenSteps();
    protected static NewsScreenSteps newsScreenSteps = new NewsScreenSteps();
    protected static OurMissionScreenSteps ourMissionScreenSteps = new OurMissionScreenSteps();

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void setUp() {
        loginScreenSteps.waitForAppToLoad();
        try {
            loginScreenSteps.checkScreenIsLoaded();
        } catch (Exception e) {
            mainScreenSteps.logOut();
            loginScreenSteps.checkScreenIsLoaded();
        }
    }
}

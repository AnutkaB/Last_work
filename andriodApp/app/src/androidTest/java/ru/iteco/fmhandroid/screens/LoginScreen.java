package ru.iteco.fmhandroid.screens;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.utils.ToastMatcher;

public class LoginScreen {

    public ViewInteraction loginField = onView(withHint(R.string.login));
    public ViewInteraction passwordField = onView(withHint(R.string.password));
    public ViewInteraction signInButton = onView(withId(R.id.enter_button));
    public ViewInteraction title = onView(withText(R.string.authorization));
    public ViewInteraction emptyUserDataToast = onView(withText(R.string.empty_login_or_password))
            .inRoot(new ToastMatcher());
    public ViewInteraction wrongUserDataToast = onView(withText(R.string.wrong_login_or_password))
            .inRoot(new ToastMatcher());
}

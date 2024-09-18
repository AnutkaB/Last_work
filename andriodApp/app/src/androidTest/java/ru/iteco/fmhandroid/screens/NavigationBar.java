package ru.iteco.fmhandroid.screens;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class NavigationBar {

    public ViewInteraction menuButton = onView(withId(R.id.main_menu_image_button));
    public ViewInteraction mainMenuItem = onView(withText(R.string.main));
    public ViewInteraction newsMenuItem = onView(withText(R.string.news));
    public ViewInteraction aboutMenuItem = onView(withText(R.string.about));
    public ViewInteraction logo = onView(withId(R.id.trademark_image_view));
    public ViewInteraction ourMissionButton = onView(withId(R.id.our_mission_image_button));
    public ViewInteraction logoutButton = onView(withId(R.id.authorization_image_button));
    public ViewInteraction logoutMenuItem = onView(withText(R.string.log_out));
}

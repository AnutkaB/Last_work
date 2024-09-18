
package ru.iteco.fmhandroid.screens;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withChild;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class OurMissionScreen extends NavigationBar {

    public ViewInteraction title = onView((withId(R.id.our_mission_title_text_view)));
    public ViewInteraction listOfItems = onView(withId(R.id.our_mission_item_list_recycler_view));

    public ViewInteraction getCollapsedMissionItem(String title) {
        return onView(allOf(
                withId(R.id.our_mission_item_material_card_view),
                withChild(withChild(allOf(
                        withId(R.id.our_mission_item_title_text_view),
                        withText(title))))));
    }

    public ViewInteraction getExpandedMissionItem(String title, String description) {
        return onView(allOf(
                withId(R.id.our_mission_item_material_card_view),
                withChild(allOf(
                        withChild(allOf(
                                withId(R.id.our_mission_item_title_text_view),
                                withText(title))),
                        withChild(allOf(
                                withId(R.id.our_mission_item_description_text_view),
                                withText(description)))))));
    }

    public ViewInteraction getMissionItemDescription(String description) {
        return onView(allOf(
                withId(R.id.our_mission_item_description_text_view),
                withText(description)));
    }
}
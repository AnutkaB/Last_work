package ru.iteco.fmhandroid.screens;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class FiltersScreen {

    public ViewInteraction title = onView(withText(R.string.filter_news));
    public ViewInteraction categoryField = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
    public ViewInteraction startDateField = onView(withId(R.id.news_item_publish_date_start_text_input_edit_text));
    public ViewInteraction endDateField = onView(withId(R.id.news_item_publish_date_end_text_input_edit_text));
    public ViewInteraction checkBoxActive = onView(withId(R.id.filter_news_active_material_check_box));
    public ViewInteraction checkBoxNotActive = onView(withId(R.id.filter_news_inactive_material_check_box));
    public ViewInteraction filterButton = onView(withId(R.id.filter_button));
    public ViewInteraction cancelButton = onView(withId(R.id.cancel_button));
}

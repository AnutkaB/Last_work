package ru.iteco.fmhandroid.screens;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.utils.ToastMatcher;

public class CreateEditNewsScreen {

    public ViewInteraction title = onView(withText(R.string.news));
    public ViewInteraction creatingTitle = onView(withText(R.string.creating));
    public ViewInteraction editingTitle = onView(withText(R.string.editing));
    public ViewInteraction categoryField = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
    public ViewInteraction titleField = onView(withId(R.id.news_item_title_text_input_edit_text));
    public ViewInteraction publicationDateField = onView(withId(R.id.news_item_publish_date_text_input_edit_text));
    public ViewInteraction timeField = onView(withId(R.id.news_item_publish_time_text_input_edit_text));
    public ViewInteraction descriptionField = onView(withId(R.id.news_item_description_text_input_edit_text));
    public ViewInteraction switcher = onView(withId(R.id.switcher));
    public ViewInteraction saveButton = onView(withId(R.id.save_button));
    public ViewInteraction emptyFieldsToast = onView(withText(R.string.empty_fields))
            .inRoot(new ToastMatcher());
    public ViewInteraction cancelButton = onView(withId(R.id.cancel_button));
    public ViewInteraction okButton = onView(withText(R.string.fragment_positive_button));
}

package ru.iteco.fmhandroid.screens;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withChild;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class ControlPanelScreen extends NavigationBar {

    public ViewInteraction title = onView(withText(R.string.news_control_panel));
    public ViewInteraction sortButton = onView(withId(R.id.sort_news_material_button));
    public ViewInteraction filterButton = onView(withId(R.id.filter_news_material_button));
    public ViewInteraction addButton = onView(withId(R.id.add_news_image_view));
    public ViewInteraction listOfNews = onView(withId(R.id.news_list_recycler_view));

    public ViewInteraction cancelButton = onView(withText(R.string.cancel));
    public ViewInteraction okButton = onView(withText(R.string.fragment_positive_button));

    public ViewInteraction getCollapsedNewsItem(String title, String publicationDate, String author) {
        return onView(allOf(
                withId(R.id.news_item_material_card_view),
                withChild(allOf(
                        withChild(allOf(
                                withId(R.id.news_item_title_text_view),
                                withText(title))),
                        withChild(allOf(
                                withId(R.id.news_item_publication_date_text_view),
                                withText(publicationDate))),
                        withChild(allOf(
                                withId(R.id.news_item_author_name_text_view),
                                withText(author)))))));
    }

    public ViewInteraction getExpandedNewsItem(String title, String publicationDate, String author, String description) {
        return onView(allOf(
                withId(R.id.news_item_material_card_view),
                withChild(allOf(
                        withChild(allOf(
                                withId(R.id.news_item_title_text_view),
                                withText(title))),
                        withChild(allOf(
                                withId(R.id.news_item_publication_date_text_view),
                                withText(publicationDate))),
                        withChild(allOf(
                                withId(R.id.news_item_author_name_text_view),
                                withText(author))),
                        withChild(allOf(
                                withId(R.id.news_item_description_text_view),
                                withText(description)))))));
    }

    public ViewInteraction getNewsDeleteButton(String title) {
        return onView(allOf(
                withId(R.id.delete_news_item_image_view),
                withParent(withChild(withText(title)))));
    }

    public ViewInteraction getNewsEditButton(String title) {
        return onView(allOf(
                withId(R.id.edit_news_item_image_view),
                withParent(withChild(withText(title)))));
    }

    public ViewInteraction getNewsStatus(String title) {
        return onView(allOf(
                withId(R.id.news_item_published_text_view),
                withParent(withChild(withText(title)))));
    }
}

package ru.iteco.fmhandroid.screens;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withChild;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class NewsScreen extends NavigationBar {

    public ViewInteraction title = onView(withText(R.string.news));
    public ViewInteraction sortButton = onView(withId(R.id.sort_news_material_button));
    public ViewInteraction filterButton = onView(withId(R.id.filter_news_material_button));
    public ViewInteraction listOfNews = onView(withId(R.id.all_news_cards_block_constraint_layout));
    public ViewInteraction editButton = onView(withId(R.id.edit_news_material_button));

    public ViewInteraction getCollapsedNewsItem(String title, String date) {
        return onView(allOf(
                withId(R.id.news_item_material_card_view),
                withChild(allOf(
                        withChild(allOf(
                                withId(R.id.news_item_title_text_view),
                                withText(title))),
                        withChild(allOf(
                                withId(R.id.news_item_date_text_view),
                                withText(date)))))));
    }

    public ViewInteraction getExpandedNewsItem(String title, String date, String description) {
        return onView(allOf(
                withId(R.id.news_item_material_card_view),
                withChild(allOf(
                        withChild(allOf(
                                withId(R.id.news_item_title_text_view),
                                withText(title))),
                        withChild(allOf(
                                withId(R.id.news_item_date_text_view),
                                withText(date))),
                        withChild(allOf(
                                withId(R.id.news_item_description_text_view),
                                withText(description)))))));
    }
}

package ru.iteco.fmhandroid.screens;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class MainScreen extends NavigationBar {

    public ViewInteraction news = onView(withText(R.string.news));
    public ViewInteraction newsList = onView(withId(R.id.news_list_recycler_view));
    public ViewInteraction allNewsButton = onView(withId(R.id.all_news_text_view));
}

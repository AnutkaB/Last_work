package ru.iteco.fmhandroid.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.utils.CustomMatchers.waitForElement;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.screens.NewsScreen;
import ru.iteco.fmhandroid.testdata.News;

public class NewsScreenSteps extends NavigationBarSteps {

    private final NewsScreen newsScreen = new NewsScreen();

    @Step("Проверка отображения раздела \"Новости\"")
    public void checkScreenIsLoaded() {
        super.checkScreenIsLoaded();
        waitForElement(withText(R.string.news), DEFAULT_TIMEOUT);
        newsScreen.title.check(matches(isDisplayed()));
        newsScreen.filterButton.check(matches(isDisplayed()));
        newsScreen.sortButton.check(matches(isDisplayed()));
        newsScreen.editButton.check(matches(isDisplayed()));
        newsScreen.listOfNews.check(matches(isDisplayed()));
    }

    @Step("Проверить наличие свернутой новости")
    public void checkCollapsedNewsItemIsDisplayed(News news) {
        checkCollapsedNewsItemIsDisplayed(news.getTitle(), news.getPublicationDate());
    }

    @Step("Проверить наличие свернутой новости")
    public void checkCollapsedNewsItemIsDisplayed(String title, String date) {
        newsScreen.getCollapsedNewsItem(title, date).check(matches(isDisplayed()));
    }

    @Step("Проверить отсутствие свернутой новости")
    public void checkCollapsedNewsItemIsNotExists(News news) {
        checkCollapsedNewsItemIsNotExists(news.getTitle(), news.getPublicationDate());
    }

    @Step("Проверить отсутствие свернутой новости")
    public void checkCollapsedNewsItemIsNotExists(String title, String date) {
        newsScreen.getCollapsedNewsItem(title, date).check(doesNotExist());
    }

    @Step("Развернуть новость")
    public void expandNewsItem(News news) {
        expandNewsItem(news.getTitle(), news.getPublicationDate());
    }

    @Step("Развернуть новость")
    public void expandNewsItem(String title, String date) {
        checkCollapsedNewsItemIsDisplayed(title, date);
        newsScreen.getCollapsedNewsItem(title, date).perform(click());
    }

    @Step("Проверить наличие развернутой новости")
    public void checkExpandedNewsItemIsDisplayed(News news) {
        checkExpandedNewsItemIsDisplayed(news.getTitle(), news.getPublicationDate(), news.getDescription());
    }

    @Step("Проверить наличие развернутой новости")
    public void checkExpandedNewsItemIsDisplayed(String title, String date, String description) {
        newsScreen.getExpandedNewsItem(title, date, description).check(matches(isDisplayed()));
    }

    @Step("Проверить отсутствие развернутой новости")
    public void checkExpandedNewsItemIsNotExists(News news) {
        checkExpandedNewsItemIsNotExists(news.getTitle(), news.getPublicationDate(), news.getDescription());
    }

    @Step("Проверить отсутствие развернутой новости")
    public void checkExpandedNewsItemIsNotExists(String title, String publicationDate, String description) {
        newsScreen.getExpandedNewsItem(title, publicationDate, description).check(doesNotExist());
    }

    @Step("Перейти в \"Фильтры\"")
    public void goToFilters() {
        newsScreen.filterButton.perform(click());
    }

    @Step("Перейти в \"Панель управления\"")
    public void goToControlPanel() {
        newsScreen.editButton.perform(click());
    }
}

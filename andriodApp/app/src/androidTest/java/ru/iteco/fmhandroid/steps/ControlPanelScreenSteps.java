package ru.iteco.fmhandroid.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.utils.CustomMatchers.waitForElement;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.screens.ControlPanelScreen;
import ru.iteco.fmhandroid.testdata.News;

public class ControlPanelScreenSteps extends NavigationBarSteps {

    private final ControlPanelScreen controlPanelScreen = new ControlPanelScreen();

    @Step("Проверка отображения раздела \"Панель управления\"")
    public void checkScreenIsLoaded() {
        super.checkScreenIsLoaded();
        waitForElement(withText(R.string.news_control_panel), DEFAULT_TIMEOUT);
        controlPanelScreen.title.check(matches(isDisplayed()));
        controlPanelScreen.filterButton.check(matches(isDisplayed()));
        controlPanelScreen.sortButton.check(matches(isDisplayed()));
        controlPanelScreen.addButton.check(matches(isDisplayed()));
        controlPanelScreen.listOfNews.check(matches(isDisplayed()));
    }

    @Step("Проверить наличие свернутой новости")
    public void checkCollapsedNewsItemIsDisplayed(News news) {
        checkCollapsedNewsItemIsDisplayed(news.getTitle(), news.getPublicationDate(), news.getAuthor());
    }

    @Step("Проверить наличие свернутой новости")
    public void checkCollapsedNewsItemIsDisplayed(String title, String publicationDate, String author) {
        controlPanelScreen.getCollapsedNewsItem(title, publicationDate, author).check(matches(isDisplayed()));
    }

    @Step("Проверить отсутствие свернутой новости")
    public void checkCollapsedNewsItemIsNotExists(News news) {
        checkCollapsedNewsItemIsNotExists(news.getTitle(), news.getPublicationDate(), news.getAuthor());
    }

    @Step("Проверить отсутствие свернутой новости")
    public void checkCollapsedNewsItemIsNotExists(String title, String publicationDate, String author) {
        controlPanelScreen.getCollapsedNewsItem(title, publicationDate, author).check(doesNotExist());
    }

    @Step("Развернуть новость")
    public void expandNewsItem(News news) {
        expandNewsItem(news.getTitle(), news.getPublicationDate(), news.getAuthor());
    }

    @Step("Развернуть новость")
    public void expandNewsItem(String title, String publicationDate, String author) {
        checkCollapsedNewsItemIsDisplayed(title, publicationDate, author);
        controlPanelScreen.getCollapsedNewsItem(title, publicationDate, author).perform(click());
    }

    @Step("Проверить наличие развернутой новости")
    public void checkExpandedNewsItemIsDisplayed(News news) {
        checkExpandedNewsItemIsDisplayed(news.getTitle(), news.getPublicationDate(), news.getAuthor(), news.getDescription());
    }

    @Step("Проверить наличие развернутой новости")
    public void checkExpandedNewsItemIsDisplayed(String title, String publicationDate, String author, String description) {
        controlPanelScreen.getExpandedNewsItem(title, publicationDate, author, description).check(matches(isDisplayed()));
    }

    @Step("Проверить отсутствие развернутой новости")
    public void checkExpandedNewsItemIsNotExists(News news) {
        checkExpandedNewsItemIsNotExists(news.getTitle(), news.getPublicationDate(), news.getAuthor(), news.getDescription());
    }

    @Step("Проверить отсутствие развернутой новости")
    public void checkExpandedNewsItemIsNotExists(String title, String publicationDate, String author, String description) {
        controlPanelScreen.getExpandedNewsItem(title, publicationDate, author, description).check(doesNotExist());
    }

    @Step("Перейти в \"Фильтры\"")
    public void goToFilters() {
        controlPanelScreen.filterButton.perform(click());
    }

    @Step("Перейти в \"Создание новости\"")
    public void goToCreateNews() {
        controlPanelScreen.addButton.perform(click());
    }

    @Step("Удалить новость")
    public void clickDeleteNewsButton(News news) {
        clickDeleteNewsButton(news.getTitle());
    }

    @Step("Удалить новость")
    public void clickDeleteNewsButton(String title) {
        controlPanelScreen.getNewsDeleteButton(title).check(matches(isDisplayed()));
        controlPanelScreen.getNewsDeleteButton(title).perform(click());
        controlPanelScreen.okButton.perform(click());
    }

    @Step("Открыть \"Редактирование новости\"")
    public void clickEditNewsButton(News news) {
        clickEditNewsButton(news.getTitle());
    }

    @Step("Открыть \"Редактирование новости\"")
    public void clickEditNewsButton(String title) {
        controlPanelScreen.getNewsEditButton(title).check(matches(isDisplayed()));
        controlPanelScreen.getNewsEditButton(title).perform(click());
    }

    @Step("Проверить, что новость активна")
    public void checkNewsIsActive(News news) {
        checkNewsIsActive(news.getTitle());
    }

    @Step("Проверить, что новость активна")
    public void checkNewsIsActive(String title) {
        controlPanelScreen.getNewsStatus(title).check(matches(isDisplayed()));
        controlPanelScreen.getNewsStatus(title).check(matches(withText(R.string.news_control_panel_active)));
    }

    @Step("Проверить, что новость неактивна")
    public void checkNewsIsNotActive(News news) {
        checkNewsIsNotActive(news.getTitle());
    }

    @Step("Проверить, что новость неактивна")
    public void checkNewsIsNotActive(String title) {
        controlPanelScreen.getNewsStatus(title).check(matches(isDisplayed()));
        controlPanelScreen.getNewsStatus(title).check(matches(withText(R.string.news_control_panel_not_active)));
    }
}

package ru.iteco.fmhandroid.testdata;

import static ru.iteco.fmhandroid.testdata.CommonTestData.TODAY;
import static ru.iteco.fmhandroid.testdata.CommonTestData.TOMORROW;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public enum News {

    TODAY_NEWS(
            "Зарплата",
            "Title1",
            TODAY,
            "00:01",
            "Description1",
            "Лебедев Д.А."
    ),
    TOMORROW_NEWS(
            "День рождения",
            "Title2",
            TOMORROW,
            "02:00",
            "Description2",
            "Лебедев Д.А."
    ),
    EMPTY_NEWS(
            "",
            "",
            "",
            "",
            "",
            "Лебедев Д.А."
    );

    private final String category;
    private final String title;
    private final String publicationDate;
    private final String time;
    private final String description;
    private final String author;

    News(String category, String title, String publicationDate,
         String time, String description, String author) {
        this.category = category;
        this.title = title;
        this.publicationDate = publicationDate;
        this.time = time;
        this.description = description;
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public String getTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }
}

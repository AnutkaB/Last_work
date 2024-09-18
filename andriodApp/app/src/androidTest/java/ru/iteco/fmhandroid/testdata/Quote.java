package ru.iteco.fmhandroid.testdata;

public enum Quote {

    QUOTE(
            "“В хосписе не работают плохие люди” В.В. Миллионщикова\"",
            "Все сотрудники хосписа - это адвокаты пациента, " +
                    "его прав и потребностей. Поиск путей решения различных задач - " +
                    "это и есть хосписный индивидуальный подход к паллиативной помощи.");

    private final String title;
    private final String description;

    Quote(String login, String description) {
        this.title = login;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}

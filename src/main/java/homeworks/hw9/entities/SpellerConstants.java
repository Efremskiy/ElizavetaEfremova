package homeworks.hw9.entities;

public enum SpellerConstants {
    TEXT("text"),
    OPTIONS("options"),
    LANG("lang"),
    SPELLER_API_URL("https://speller.yandex.net/services/spellservice.json/checkTexts"),
    LANGUAGE_RU("ru"),
    LANGUAGE_EN("en"),
    LANGUAGE_UK("uk"),
    ERROR_UNKNOWN_WORD("1"),
    ERROR_REPEAT_WORD("2"),
    ERROR_CAPITALIZATION("3"),
    ERROR_TOO_MANY_ERRORS("4");

    private String text;

    SpellerConstants(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

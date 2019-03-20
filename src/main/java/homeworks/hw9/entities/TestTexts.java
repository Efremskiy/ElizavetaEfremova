package homeworks.hw9.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum TestTexts {
    SIMPLE_POSITIVE_TEST_TEXT(new ArrayList<>(Arrays.asList("Съешь ещё этих мягких французских булок, да выпей же чаю.",
            "The quick brown fox jumps over the lazy dog."))),
    WORD_NOT_FROM_DICTIONARY_TEST_TEXT(new ArrayList<>(Arrays.asList("метрр", "asdfgh"))),
    MISMATCHING_LANGUAGES_TEST_TEXT(new ArrayList<>(Arrays.asList("Алгоритм — конечная совокупность точно заданных " +
            "правил решения произвольного класса задач или набор инструкций, описывающих порядок действий исполнителя " +
            "для решения некоторой задачи", "Алгоритм — набір інструкцій, які описують порядок дій виконавця, щоб " +
            "досягти результату розв'язання задачі за скінченну кількість дій; система правил виконання дискретного " +
            "процесу, яка досягає поставленої мети за скінченний час"))),
    REPEAT_WORDS_TEST_TEXT(new ArrayList<>(Arrays.asList("Let's meet at at five.", "Where have have you been?"))),
    REPEAT_WORDS_TEST_ERRORS(new ArrayList<>(Arrays.asList("at", "have"))),
    CAPITALIZATION_TEST_TEXT(new ArrayList<>(Arrays.asList("buckingham Palace is the london residence and " +
            "administrative headquarters of the monarch of the United Kingdom.", "московский кремль — крепость " +
            "в центре москвы и древнейшая её часть, главный общественно-политический и историко-художественный " +
            "комплекс города, официальная резиденция президента Российской Федерации."))),
    UNIGNORE_CAPITALIZATION_TEST_ERRORS(new ArrayList<>(Arrays.asList("buckingham", "london", "москвы"))),
    DIGITS_TEST_TEXT(new ArrayList<>(Arrays.asList("One1 two three", "Один 2два три"))),
    UNIGNORE_DIGITS_TEST_ERRORS(new ArrayList<>(Arrays.asList("One1", "2два"))),
    IGNORE_URL_TEST_TEXT(new ArrayList<>(Arrays.asList("https://www.google.com/ and other useful sites.",
            "Создайте почтовый ящик вида name_surname@gmail.com"))),
    HINT_ON_SIMPLE_WORDS_TEST_TEXT(new ArrayList<>(Arrays.asList("Helo, wrld!", "Превет, миир!"))),
    HINT_ON_SIMPLE_WORDS_TEST_HINTS(new ArrayList<>(Arrays.asList("Hello", "world", "Привет", "мир")));

    private List<String> text;

    TestTexts(List<String> text) {
        this.text = text;
    }

    public List<String> getText() {
        return text;
    }
}

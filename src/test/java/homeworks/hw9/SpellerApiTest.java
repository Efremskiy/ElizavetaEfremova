package homeworks.hw9;

import homeworks.hw9.entities.Options;
import homeworks.hw9.entities.SpellerAnswer;
import homeworks.hw9.entities.SpellerConstants;
import homeworks.hw9.entities.TestTexts;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SpellerApiTest {

    //1
    @Test
    public void simplePositiveTest() {
        List<SpellerAnswer> answers =
                SpellerCheckTextsApi
                        .getSpellerAnswers(SpellerCheckTextsApi.with().setText(TestTexts
                                .SIMPLE_POSITIVE_TEST_TEXT.getText())
                                .callApi());
        assertThat("Expected different amount of answers.", answers, hasSize(0));
    }

    //2
    @Test
    public void wordNotFromDictionaryTest() {
        List<SpellerAnswer> answers =
                SpellerCheckTextsApi
                        .getSpellerAnswers(SpellerCheckTextsApi.with().setText(TestTexts
                                .WORD_NOT_FROM_DICTIONARY_TEST_TEXT.getText())
                                .callApi());
        assertThat("Expected different amount of answers.",answers, hasSize(2));
        assertThat(answers.get(0).word, equalTo(TestTexts.WORD_NOT_FROM_DICTIONARY_TEST_TEXT
                .getText().get(0)));
        assertThat(answers.get(1).word, equalTo(TestTexts.WORD_NOT_FROM_DICTIONARY_TEST_TEXT
                .getText().get(1)));
    }

    //3
    @Test
    public void mismatchingLanguagesTest() {
        List<SpellerAnswer> answers =
                SpellerCheckTextsApi
                        .getSpellerAnswers(SpellerCheckTextsApi.with().setText(TestTexts
                                .MISMATCHING_LANGUAGES_TEST_TEXT.getText())
                                .setLang(SpellerConstants.LANGUAGE_EN.getText())
                                .callApi());
        assertThat("Expected different amount of answers.", answers.size(), greaterThan(0));
    }

    //4
    @Test
    public void repeatWordsTest() {
        List<SpellerAnswer> answers =
                SpellerCheckTextsApi
                        .getSpellerAnswers(SpellerCheckTextsApi.with().setText(TestTexts
                                .REPEAT_WORDS_TEST_TEXT.getText())
                                .setOptions(Options.FIND_REPEAT_WORDS)
                                .callApi());
        assertThat("Expected different amount of answers.", answers, hasSize(2));
        assertThat(answers.get(0).word, equalTo(TestTexts.REPEAT_WORDS_TEST_ERRORS
                .getText().get(0)));
        assertThat(answers.get(1).word, equalTo(TestTexts.REPEAT_WORDS_TEST_ERRORS
                .getText().get(1)));
    }

    //5
    @Test
    public void ignoreCapitalizationTest() {
        List<SpellerAnswer> answers =
                SpellerCheckTextsApi
                        .getSpellerAnswers(SpellerCheckTextsApi.with().setText(TestTexts
                                .CAPITALIZATION_TEST_TEXT.getText())
                                .setOptions(Options.IGNORE_CAPITALIZATION)
                                .callApi());
        assertThat("Expected different amount of answers.", answers, hasSize(0));
    }

    //6
    @Test
    public void unignoreCapitalizationTest() {
        List<SpellerAnswer> answers =
                SpellerCheckTextsApi
                        .getSpellerAnswers(SpellerCheckTextsApi.with().setText(TestTexts
                                .CAPITALIZATION_TEST_TEXT.getText())
                                .callApi());
        assertThat("Expected different amount of answers.", answers, hasSize(3));
        assertThat(answers.get(0).word, equalTo(TestTexts.UNIGNORE_CAPITALIZATION_TEST_ERRORS
                .getText().get(0)));
        assertThat(answers.get(1).word, equalTo(TestTexts.UNIGNORE_CAPITALIZATION_TEST_ERRORS
                .getText().get(1)));
        assertThat(answers.get(2).word, equalTo(TestTexts.UNIGNORE_CAPITALIZATION_TEST_ERRORS
                .getText().get(2)));
    }

    //7
    @Test
    public void ignoreDigitsTest() {
        List<SpellerAnswer> answers =
                SpellerCheckTextsApi
                        .getSpellerAnswers(SpellerCheckTextsApi.with().setText(TestTexts
                                .DIGITS_TEST_TEXT.getText())
                                .setOptions(Options.IGNORE_DIGITS)
                                .callApi());
        assertThat("Expected different amount of answers.", answers, hasSize(0));
    }

    //8
    @Test
    public void unignoreDigitsTest() {
        List<SpellerAnswer> answers =
                SpellerCheckTextsApi
                        .getSpellerAnswers(SpellerCheckTextsApi.with().setText(TestTexts
                                .DIGITS_TEST_TEXT.getText())
                                .callApi());
        assertThat("Expected different amount of answers.", answers, hasSize(2));
        assertThat(answers.get(0).word, equalTo(TestTexts.UNIGNORE_DIGITS_TEST_ERRORS
                .getText().get(0)));
        assertThat(answers.get(1).word, equalTo(TestTexts.UNIGNORE_DIGITS_TEST_ERRORS
                .getText().get(1)));

    }

    //9
    @Test
    public void ignoreUrlTest() {
        List<SpellerAnswer> answers =
                SpellerCheckTextsApi
                        .getSpellerAnswers(SpellerCheckTextsApi.with().setText(TestTexts
                                .IGNORE_URL_TEST_TEXT.getText())
                                .callApi());
        assertThat("Expected different amount of answers.", answers, hasSize(0));
    }

    //10
    @Test
    public void hintOnSimpleWordsTest() {
        List<SpellerAnswer> answers =
                SpellerCheckTextsApi
                        .getSpellerAnswers(SpellerCheckTextsApi.with().setText(TestTexts
                                .HINT_ON_SIMPLE_WORDS_TEST_TEXT.getText())
                                .callApi());
        assertThat("Expected different amount of answers.", answers, hasSize(4));
        for(int i = 0; i < answers.size(); i++) {
            assertThat(answers.get(i).s, hasItem(TestTexts.HINT_ON_SIMPLE_WORDS_TEST_HINTS
                    .getText().get(i)));
        }
    }
}

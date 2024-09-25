package ru.yandex.practicum.seleniumtest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.practicum.pageobject.SamokatPageObject;
import static org.junit.Assert.assertEquals;
import static ru.yandex.practicum.сonstants.FAQAnswerText.*;
import static ru.yandex.practicum.сonstants.FAQQuestionText.*;

@RunWith(Parameterized.class)
public class FAQBlockAssertionTest extends AbstractTest  {


    private final String textQuestion;
    private final String ethalonAnswerText;
    private final String indexAnswer;
    private final boolean expectedResult;

    public FAQBlockAssertionTest(String textQuestion, String ethalonAnswerText, String indexAnswer, boolean expectedResult){
        this.textQuestion = textQuestion;
        this.ethalonAnswerText = ethalonAnswerText;
        this.indexAnswer = indexAnswer;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Object[][] parametersFAQ() {
        return new Object[][] {
                { FIRST_QUESTION, FIRST_ANSWER, "0", true},
                { SECOND_QUESTION, SECOND_ANSWER, "1", true},
                { THIRD_QUESTION, THIRD_ANSWER, "2", true},
                { FOURTH_QUESTION, FOURTH_ANSWER, "3", true},
                { FIFTH_QUESTION, FIFTH_ANSWER, "4", true},
                { SIXTH_QUESTION, SIXTH_ANSWER, "5", true},
                { SEVENTH_QUESTION, SEVENTH_ANSWER, "6", true},
                { EIGHTH_QUESTION, EIGHTH_ANSWER, "7", true},
        };
    }



    @Test
    public void blockFAQAssertionTest(){        //  позитивный сценарий для валидации ответов в блоке FAQ.

        SamokatPageObject mainPageObject = new SamokatPageObject(driver);

        mainPageObject.cookieAccept();
        mainPageObject.scrollUntilFAQ();
        mainPageObject.openTheAnswer(textQuestion, indexAnswer);
        String gottenAnswer = mainPageObject.gotAnswerText(indexAnswer);
        boolean answerCollationResult = ethalonAnswerText.equals(gottenAnswer);

        assertEquals("Ожидалось,что текст ответа с индексом " + indexAnswer + " совпадает с эталоном: " + ethalonAnswerText +"." ,expectedResult, answerCollationResult);

    }

}

package steps.asserts;

import com.codeborne.selenide.SelenideElement;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.StringContains.containsString;

public class Assert {

    public static void textPresence(SelenideElement element, String expectedText) {
        assertThat(element.getText(), containsString(expectedText));
    }

    public static void textMatch(String text1, String text2) {
        if (text1.startsWith("/")) {
            text1 = text1.substring(2);
        }

        assertThat(text1, equalTo(text2));
    }
}

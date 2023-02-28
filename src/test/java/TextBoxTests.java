import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {
    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTests() {
        //https://demoqa.com/text-box
        open("/text-box");
        $("#userName").setValue("Zhuravlev Mikhail Alexeyevich");
        $("#userEmail").setValue("miha99_66@mail.ru");
        $("#currentAddress").setValue("Krasnodar");
        $("#permanentAddress").setValue("Novoyralsk");
        $("#submit").click();

        $("#output").shouldHave(text("Zhuravlev Mikhail Alexeyevich"),
                                         text("miha99_66@mail.ru"),
                                         text("Krasnodar"),
                                         text("Novoyralsk"));
    }
}

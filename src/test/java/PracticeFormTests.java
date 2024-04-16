import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTests extends TestBase {
    @Test
    void successfulFillFormTest() {

        open("/automation-practice-form");

        $(".practice-form-wrapper").shouldHave(text("Practice Form"));

        $("#firstName").setValue("George");
        $("#lastName").setValue("Rockford");
        $("#userEmail").setValue("user@example.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("8800902020");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").$(byText("2000")).click();
        $(".react-datepicker__month-select").$(byText("May")).click();
        $(".react-datepicker__day--001").click();
        $("#subjectsInput").setValue("Maths").pressEnter().setValue("Economics").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/1.jpg"));
        $("#currentAddress").setValue("Petrovskaya Street 77");
        $("#state").click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Karnal")).click();
        $("#submit").click();

        $(".table").shouldHave(
                text("George"),
                text("Rockford"),
                text("user@example.com"),
                text("Male"),
                text("8800902020"),
                text("01 May,2000"),
                text("Maths"),
                text("Economics"),
                text("Sports"),
                text("1.jpg"),
                text("Petrovskaya Street 77"),
                text("Haryana"),
                text("Karnal"));

    }
}

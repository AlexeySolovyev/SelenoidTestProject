package selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class SeleniumTest {

    @Test
    public void automationTest() {
        open("https://explorecalifornia.org/contact.htm");

        $("#name").should(appear);
        $("#comments").should(appear);

        $("#name").setValue("TestUser");
        $("#email").setValue("testuser@mail.org");
        $("#phone").setValue("9297899889");
        $("#address").setValue("Main street, 12");
        $("#state").selectOptionContainingText("Texas");
        $("#zip").setValue("90210");
        $("#backpack").click();
        $(By.name("newsletter")).selectRadio("yes");

        $("#name").shouldHave(value("TestUser"));
        String state = $("#state").getSelectedText();
        assert(state).equals("Texas");

        $("#backpack").shouldBe(selected);
        $(By.name("newsletter")).shouldHave(value("yes"));

        $("#submit2").click();
    }
}

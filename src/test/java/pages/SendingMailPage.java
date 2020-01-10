package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class SendingMailPage {

    @Step("Создание письма")
    public static void LetterCreation() {
        $(byText("Ответить")).shouldBe(enabled).click();
    }

    @Step("Заполнение тела письма")
    public static void WriteLetter() {
        // Переключение на фрейм
        switchTo().frame($(byTitle("{#aria.rich_text_area}")));

        // Вставка в тело письма информации о количестве полученных писем
        $(byId("tinymce")).setValue("Количество входящих = " + ResultPage.countInbox);

    }

    @Step("Отправка письма")
    public static void SendingLetter() {
        // Переключение на родительский фрейм
        switchTo().parentFrame();

        // Ctrl + Enter для отправки письма
        $(byId("jsHtml")).sendKeys(Keys.chord(Keys.CONTROL, Keys.RETURN));
    }

    public static void logout() {
        $(byId("PH_logoutLink")).click();
    }
}

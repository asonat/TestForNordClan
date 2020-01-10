package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ResultPage {

    public static int countInbox;

    @Step("Подсчёт входящих писем")
    public static void incomingMailCount() {
        // Установка фильра по входящим
        $(byXpath("//span[text()='Входящие']")).click();

        // Проверка отсутсвия отправленных писем в списке
        $(byXpath("//span[text()='Re:']")).shouldNotHave(enabled);

        // Подсчёт входящих
        countInbox = $$(byXpath("//span[contains(@title,'ilya.filinin@nordclan.com')]")).size();

    }

    @Step("Вход в последнее полученное письмо")
    // Вход в последнее полученное письмо
    public static void entryLetter() {
        $(byXpath("//span[contains(@title,'ilya.filinin@nordclan.com')]")).click();
    }
}

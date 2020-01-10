package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class FirstOnMailPage {

    @Step("Установка фильтра по письмам")
    public static void MailSearch(String mailing) {
        // Активация поля для поиска
        $(byClassName("search-panel-button")).click();

        // Поиск писем
        $(byClassName("_1BEp2b6vqOez8I6Rw9SpK6")).setValue(mailing).pressEnter();
    }
}
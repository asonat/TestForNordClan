package pages;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class StartPage {
    @Step("Открытие стартовой страницы")
    public static void openStartPage(String host) {
        Configuration.browser = "chrome";
        open(host);
    }

    @Step("Авторизация")
    public static void autorization(String login, String password) {
        $(byId("mailbox:login")).setValue(login).pressEnter();
        $(byId("mailbox:password")).setValue(password).pressEnter();
    }
}

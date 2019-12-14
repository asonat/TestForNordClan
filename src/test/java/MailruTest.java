import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;


public class MailruTest {
    String email = "ilya.filinin@nordclan.com";
    SelenideElement inbox = $(byXpath("//*[@id='b-nav_search']/div/div[3]/div[2]/div[1]/a/span[2]"));
    SelenideElement loginInput = $(byId("mailbox:login"));
    SelenideElement passwordInput = $(byId("mailbox:password"));
    ElementsCollection listInbox = $$(byClassName("search_tick")).filterBy(text(email));
    SelenideElement iframe = $(byTitle("{#aria.rich_text_area}"));

    @BeforeEach
    public void setUp() {
        Configuration.browser = "chrome";
        open("https://mail.ru/");

        // Авторизация
        loginInput.setValue("Login").pressEnter();
        passwordInput.setValue("Password").pressEnter();
    }

    @Test
    public void openAndLogin() {
        // Активация поля для поиска
        $(byId("portal-menu__search__form")).click();

        // Поиск писем
        $(byClassName("b-operand__input")).setValue(email).pressEnter();

        // Установка фильра по входящим
        inbox.click();

        sleep(1000);

        // Подсчёт входящих
        int countInbox = listInbox.size();

        // Вход в последнее полученное письмо
        $(byClassName("search_tick")).click();

        // Создание письма
        $(byText("Ответить")).shouldBe(enabled).click();

        // Переключение на фрейм
        // SelenideElement iframe = $(byTitle("{#aria.rich_text_area}"));
        switchTo().frame(iframe);

        // Вставка в тело письма информации о количестве полученных писем
        $(byId("tinymce")).setValue("Количество входящих = " + countInbox);

        // Переключение на родительский фрейм
        switchTo().parentFrame();

        // Ctrl + Enter для отправки письма
        $(byId("jsHtml")).sendKeys(Keys.chord(Keys.CONTROL, Keys.RETURN));

        // логаут
        $(byId("PH_logoutLink")).click();
        sleep(1000);

    }

}
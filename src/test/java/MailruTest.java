import pages.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class MailruTest {

    @BeforeEach
    public void setUp() throws Exception {

        // Запуск инициализации конфигурационного файла
        TestConfig.initConfigFile();

        String host = TestConfig.mailHost;
        String login = TestConfig.mailLogin;
        String password = TestConfig.mailPassword;

        // Открытие стартовой страницы
        StartPage.openStartPage(host);

        // Авторизация
        StartPage.autorization(login, password);
    }

    @Test
    public void goTest() {

        // Поиск писем
        String mailing = TestConfig.mailForMailing;
        FirstOnMailPage.MailSearch(mailing);

        // Подсчёт входящих писем
        ResultPage.incomingMailCount();

        // Вход в последнее полученное письмо
        ResultPage.entryLetter();

        // Создание письма
        SendingMailPage.LetterCreation();

        // Заполнение тела письма
        SendingMailPage.WriteLetter();

        // отправка письма
        SendingMailPage.SendingLetter();;

        // логаут
        SendingMailPage.logout();
    }

}
import io.qameta.allure.Step;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestConfig {
    static String mailHost, mailLogin, mailPassword, mailForMailing;

    @Step("Иницииализация конфигурационного файла")
    public static void initConfigFile() throws IOException {
        FileInputStream fis;
        Properties property = new Properties();

        fis = new FileInputStream("src/main/resources/config.properties");
        property.load(fis);

        mailHost = property.getProperty("mail.host");
        mailLogin = property.getProperty("mail.login");
        mailPassword = property.getProperty("mail.password");
        mailForMailing = property.getProperty("mail.mailing");
    }
}

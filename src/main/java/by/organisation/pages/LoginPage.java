package by.organisation.pages;

import by.organisation.utils.PropertiesLoader;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.openqa.selenium.By.id;

public class LoginPage {


    public LoginPage open() {
        String baseUrl = PropertiesLoader.loadProperties("configuration.properties").getProperty("base.url");
        Selenide.open(baseUrl + "/login.cshtml");
        $x("//button[@type='submit']").shouldBe(visible);
        getWebDriver().manage().window().maximize();
        return new LoginPage();
    }

    public void loginWithValidData() {
        String login = PropertiesLoader.loadProperties("configuration.properties").getProperty("username");
        String password = PropertiesLoader.loadProperties("configuration.properties").getProperty("password");
        $(id("login_name")).shouldBe(visible).sendKeys(login);
        $(id("login_password")).shouldBe(visible).sendKeys(password);
        $x("//button[@type='submit']").shouldBe(visible).click();
        new CalendarPage();
    }

    public void loginWithInvalidData() {
        $(id("login_name")).shouldBe(visible).sendKeys("test@mail.ru");
        $(id("login_password")).shouldBe(visible).sendKeys("12345");
        $x("//button[@type='submit']").shouldBe(visible).click();
        new LoginPage();
    }
}
package pom;

import api.UserClient;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class LoginPage {
    private WebDriver driver;

    private By emailField = By.xpath(".//input[@name='name']");
    private By passwordField = By.xpath(".//input[@name='Пароль']");
    private By loginButton = By.xpath("//button[text()='Войти']");
    private By forgotPasswordLink = By.xpath("//a[text()='Восстановить пароль']");
    private By registrationLink = By.xpath("//a[text()='Зарегистрироваться']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Авторизация пользователя с email: {email} и паролем: {password}")
    public void loginUser(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    @Step("Нажать на ссылку 'Забыли пароль?' на главной странице")
    public void clickForgotPasswordLink() {
        driver.findElement(forgotPasswordLink).click();
    }

    @Step("Нажать на ссылку 'Забыли пароль?' на главной странице")
    public void clickRegistrationLink() {
        driver.findElement(registrationLink).click();
    }

    @Step("Проверка успешной авторизации")
    public boolean isLoginSuccessful() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
       WebElement burgerTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Соберите бургер']")));

       return burgerTitle.isDisplayed();

    }
}

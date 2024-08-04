package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private WebDriver driver;

    private By nameField = By.xpath("//fieldset[1]/div/div/input");
    private By emailField = By.xpath("//fieldset[2]/div/div/input");
    private By passwordField = By.xpath("//input[@name='Пароль']");
    private By registerButton = By.xpath("//button[text()='Зарегистрироваться']");
    private By signInLink = By.xpath("//a[text()='Войти']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Регистрация пользователя с именем: {name}, email: {email} и паролем: {password}")
    public void registerUser(String name, String email, String password) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(registerButton).click();
    }

    @Step("Нажать на ссылку 'Войти' на странице регистрации")
    public void clickSignInLink() {
        driver.findElement(signInLink).click();
    }

}

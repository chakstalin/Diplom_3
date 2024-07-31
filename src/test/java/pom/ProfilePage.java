package pom;

import api.UserClient;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {
    private WebDriver driver;

    private By constructorButton = By.linkText("Конструктор");
    private By logoButton = By.className("AppHeader_header__logo__2D0X2");
    private By logoutButton = By.xpath("//button[text()='Выход']");
    private By profileLink = By.xpath("//a[text()='Профиль']");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажать на кнопку 'Конструктор'")
    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }

    @Step("Нажать на логотип Stellar Burgers")
    public void clickLogoButton() {
        driver.findElement(logoButton).click();
    }

    @Step("Нажать на кнопку 'Выход'")
    public void clickLogoutButton() {
        driver.findElement(logoutButton).click();
    }

    @Step("Проверка успешного выхода из аккаунта")
    public boolean isLoggedOut(HomePage homePage) {

        homePage.clickAccountButton();

        return driver.getCurrentUrl().contains("login");
    }


    @Step("Проверка нахождения на странице 'Личный кабинет'")
    public boolean isAtAccountPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement burgerTitleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(profileLink));

        return burgerTitleElement.isDisplayed();
    }
}

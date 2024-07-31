package pom;

import api.UserClient;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {
    private WebDriver driver;

    private static final String HOME_URL = UserClient.BASE_URL;
    private String currentTabMarker = "tab_tab_type_current__2BEPc";
    private By signInButton = By.xpath("//button[text()='Войти в аккаунт']");
    private By accountButton = By.xpath(".//p[text()='Личный Кабинет']");
    private By bunsSection = By.xpath("//span[text()='Булки']/parent::*");
    private By saucesSection = By.xpath("//span[text()='Соусы']/parent::*");
    private By fillingsSection = By.xpath("//span[text()='Начинки']/parent::*");
    private By burgerTitle = By.xpath("//h1[text()='Соберите бургер']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открыть главную страницу")
    public void openHomePage() {
        driver.get(HOME_URL);
    }

    @Step("Нажать на кнопку 'Войти' на главной странице")
    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }

    @Step("Нажать на кнопку 'Зарегистрироваться' на главной странице")
    public void clickSignUpButton() {
        driver.findElement(signInButton).click();
    }

    @Step("Нажать на кнопку 'Личный кабинет' на главной странице")
    public void clickAccountButton() {
        driver.findElement(accountButton).click();
    }

    @Step("Нажать на раздел 'Булки'")
    public void clickBunsSection() {
        driver.findElement(bunsSection).click();
    }

    @Step("Нажать на раздел 'Соусы'")
    public void clickSaucesSection() {
        driver.findElement(saucesSection).click();
    }

    @Step("Нажать на раздел 'Начинки'")
    public void clickFillingsSection() {
        driver.findElement(fillingsSection).click();
    }

    @Step("Проверка нахождения в разделе 'Булки'")
    public boolean isAtBunsSection() {

        return driver.findElement(bunsSection).getAttribute("class").contains(currentTabMarker);
    }

    @Step("Проверка нахождения в разделе 'Соусы'")
    public boolean isAtSaucesSection() {

        return driver.findElement(saucesSection).getAttribute("class").contains(currentTabMarker);
    }

    @Step("Проверка нахождения в разделе 'Начинки'")
    public boolean isAtFillingsSection() {

        return driver.findElement(fillingsSection).getAttribute("class").contains(currentTabMarker);
    }

    @Step("Проверка нахождения на странице конструктора")
    public boolean isAtConstructorPage() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement burgerTitleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(burgerTitle));

        return burgerTitleElement.isDisplayed();
    }

}

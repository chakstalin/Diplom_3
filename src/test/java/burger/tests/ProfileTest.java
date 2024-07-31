package burger.tests;

import api.UserClient;
import io.qameta.allure.junit4.DisplayName;
import pom.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class ProfileTest extends BaseTest {

    private HomePage homePage;
    private LoginPage loginPage;
    private ProfilePage profilePage;

    @Before
    public void loginUser() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);

        UserClient.registerUser(user);
        homePage.clickSignInButton();
        loginPage.loginUser(user.getEmail(), user.getPassword());
    }

    @Test
    @DisplayName("Проверка перехода в личный кабинет по кнопке Личный кабинет")
    public void testGoToAccount() {

        homePage.clickAccountButton();

        assertTrue("Переход в личный кабинет должен быть успешным", profilePage.isAtAccountPage());
    }

    @Test
    @DisplayName("Проверка перехода из личного кабинета в конструктор по кнопке Конструктор")
    public void testGoToConstructorFromProfile() {

        homePage.clickAccountButton();
        profilePage.clickConstructorButton();

        assertTrue("Переход в конструктор должен быть успешным", homePage.isAtConstructorPage());
    }

    @Test
    @DisplayName("Проверка перехода из личного кабинета в конструктор по логотипу Stellar Burgers")
    public void testGoToConstructorFromLogo() {

        homePage.clickAccountButton();
        profilePage.clickLogoButton();

        assertTrue("Переход в конструктор должен быть успешным", homePage.isAtConstructorPage());
    }

    @Test
    @DisplayName("Проверка выхода из аккаунта")
    public void testLogout() {

        homePage.clickAccountButton();
        profilePage.clickLogoutButton();

        assertTrue("Выход из аккаунта должен быть успешным", profilePage.isLoggedOut(homePage));
    }
}

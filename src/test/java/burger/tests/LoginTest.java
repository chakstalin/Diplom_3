package burger.tests;

import api.UserClient;
import org.junit.Before;
import pom.*;
import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;
import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest {

    private HomePage homePage;
    private LoginPage loginPage;
    private RegisterPage registerPage;
    private ForgotPasswordPage forgotPasswordPage;

    @Before
    public void setUp(){
        UserClient.registerUser(user);
        token = UserClient.getUserToken(user);

        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
        forgotPasswordPage = new ForgotPasswordPage(driver);
    }

    @Test
    @DisplayName("Проверка авторизации через главную страницу")
    public void testLoginFromMainPage() {
        homePage.clickSignInButton();
        loginPage.loginUser(user.getEmail(), user.getPassword());

        assertTrue("Авторизация должна быть успешной", loginPage.isLoginSuccessful());
    }

    @Test
    @DisplayName("Проверка авторизации через кнопку Личный кабинет")
    public void testLoginFromAccountButton() {
        homePage.clickAccountButton();
        loginPage.loginUser(user.getEmail(), user.getPassword());

        assertTrue("Авторизация должна быть успешной", loginPage.isLoginSuccessful());
    }

    @Test
    @DisplayName("Проверка авторизации через форму регистрации")
    public void testLoginFromRegisterPage() {
        homePage.clickSignInButton();
        loginPage.clickRegistrationLink();
        registerPage.clickSignInLink();
        loginPage.loginUser(user.getEmail(), user.getPassword());

        assertTrue("Авторизация должна быть успешной", loginPage.isLoginSuccessful());
    }

    @Test
    @DisplayName("Проверка авторизации через форму восстановления пароля")
    public void testLoginFromForgotPasswordPage() {
        homePage.clickAccountButton();
        loginPage.clickForgotPasswordLink();
        forgotPasswordPage.clickSignInLink();
        loginPage.loginUser(user.getEmail(), user.getPassword());

        assertTrue("Авторизация должна быть успешной", loginPage.isLoginSuccessful());

    }
}

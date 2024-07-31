package burger.tests;

import pom.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import datagenerator.UserDataGenerator;
import pojo.UserPOJO;
import api.UserClient;
import io.qameta.allure.junit4.DisplayName;

public class RegistrationTest extends BaseTest {
    private String newUserToken = null;
    private HomePage homePage;
    private LoginPage loginPage;
    private RegisterPage registerPage;


    @Before
    public void setUp(){
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);

    }


    @Test
    @DisplayName("Проверка успешной регистрации пользователя")
    public void testSuccessfulRegistration() {
        homePage.clickSignUpButton();
        loginPage.clickRegistrationLink();
        registerPage.registerUser(user.getName(), user.getEmail(), user.getPassword());

        newUserToken = UserClient.getUserToken(new UserPOJO(user.getEmail(), user.getPassword()));

        assertTrue("Пользователь должен быть зарегистрирован", newUserToken != null);
    }

    @Test
    @DisplayName("Проверка ошибки при регистрации с некорректным паролем")
    public void testRegistrationWithShortPassword() {
        homePage.clickSignUpButton();
        loginPage.clickRegistrationLink();
        String shortPassword = UserDataGenerator.generateShortPassword();
        registerPage.registerUser(user.getName(), user.getEmail(), shortPassword);

        assertFalse("Регистрация должна быть отклонена из-за короткого пароля", registerPage.isRegisterSuccessful());
    }
}

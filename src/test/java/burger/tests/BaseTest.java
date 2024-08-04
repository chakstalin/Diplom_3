package burger.tests;

import api.UserClient;
import datagenerator.UserDataGenerator;
import driver.WebDriverCreator;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pojo.UserPOJO;

import java.time.Duration;


public abstract class BaseTest {
    protected WebDriver driver;
    protected UserPOJO user;
    protected String token;
    private String name;
    private String email;
    private String password;

    @Before
    public void setUpBase() {
        driver = WebDriverCreator.createWebDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        name = UserDataGenerator.generateRandomName();
        email = UserDataGenerator.generateRandomEmail();
        password = UserDataGenerator.generateRandomPassword();
        user = new UserPOJO(email, password, name);
        driver.manage().window().maximize();
        driver.get(UserClient.BASE_URL);
    }

    @After
    public void tearDownBase() {
        if (driver != null) {
            driver.quit();
        }
        if (token != null) {
            UserClient.deleteUser(token);
            token = null;
        }
    }
}

package burger.tests;

import pom.*;
import org.junit.Before;
import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;
import static org.junit.Assert.assertTrue;

public class ConstructorTest extends BaseTest {

    HomePage homePage;

    @Before
    public void SetUp(){
        homePage = new HomePage(driver);
    }

    @Test
    @DisplayName("Проверка перехода на вкладку Соусы")
    public void testChangeConstructorSectionToSauce() {

        homePage.clickSaucesSection();
        assertTrue("Переход в раздел Соусы должен быть успешным", homePage.isAtSaucesSection());

    }

    @Test
    @DisplayName("Проверка перехода на вкладку Начинки")
    public void testChangeConstructorSectionToFillings() {

        homePage.clickFillingsSection();
        assertTrue("Переход в раздел Начинки должен быть успешным", homePage.isAtFillingsSection());
    }

    @Test
    @DisplayName("Проверка перехода на вкладку Булки")
    public void testChangeConstructorSectionFromSauceToBuns() {
        homePage.clickSaucesSection();
        homePage.clickBunsSection();
        assertTrue("Переход в раздел Булки должен быть успешным", homePage.isAtBunsSection());


    }
}

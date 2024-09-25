package ru.yandex.practicum.seleniumtest;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import ru.yandex.practicum.webdriverfactory.WebDriverFactory;

import static ru.yandex.practicum.constants.Browsers.*;

public class AbstractTest {

    public WebDriver driver;

    @Before
    public void starter(){
        driver = WebDriverFactory.getWebDriver(FF);  // аргумент GC ==> запуск теста в гугл хром, FF ==> запуск теста в мозила файрфокс
        driver.get(URL);
    }

    @After
    public void shutDown(){
        driver.quit();
    }
}

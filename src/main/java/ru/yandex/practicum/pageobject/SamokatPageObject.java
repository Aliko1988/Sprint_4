package ru.yandex.practicum.pageobject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SamokatPageObject {

    private final WebDriver driver;

/*
  Конструктор объекта */

    public SamokatPageObject (WebDriver driver){
        this.driver = driver;
    }

/*
  Селекторы узлов для создания заказа */

    private final By headerOrderButtonSelector = By.xpath("//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g' and text()='Заказать']");
    //селектор верхней кнопки Заказать на главной странице Яндекс Самокат

    private final By footerOrderButtonSelector = By.xpath("//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");
    // селектор нижней кнопки Заказать на главной странице Яндекс самокат

    private final By nameFieldOrderSelector = By.xpath("//input[@placeholder='* Имя']");
    // селектор поля Имя страницы создания заказа

    private final By lastNameFieldOrderSelector = By.xpath("//input[@placeholder='* Фамилия']");
    // cелектор поля Фамилия страницы создания заказа

    private final By addressFieldOrderSelector = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    // cелектор поля Адрес страницы создания заказа

    private final By metroFieldOrderSelector =  By.xpath("//input[@placeholder='* Станция метро']");
    // cелектор поля Метро страницы создания заказа

    private final By phoneFieldOrderSelector = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    // cелектор поля Телефон страницы создания заказа

    private final By nextButtonOrderSelector = By.xpath("//div[@class='Order_NextButton__1_rCA']/button[text()='Далее']");
    // селектор кнопки Далее страницы создания заказа

    private final By dateFieldOrderSelector = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    //селектор поля выбора Даты страницы создания заказа

    private final By rentFieldOrderSelector =  By.xpath("//div[text()='* Срок аренды']");
    //селектор псевдополя Срок аренды страницы создания заказа

    private final By rentDaysAvalabilityListSelector = By.xpath("//div[@class='Dropdown-root is-open']/div[@class='Dropdown-menu']");
    //селектор выпадающего списка с доступной датой аренды самоката формы заполнения заказа

    private final String rentDayCountSelector = "//div[@class='Dropdown-menu']/div[text()='%s']";
    //заготовка селектора для метода выбора числа дней аренды. Используется метод string.format

    private final By totalOrderButtonSelector = By.xpath("//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    // селектор кнопки Заказать на конечном шаге заполения формы заказа

    private final By conformationOrderCreationSelector = By.xpath("//div[text()='Хотите оформить заказ?']");
    //селектор всплывающего окна с подтверждением создания заказа

    private final By yesButtonSelector = By.xpath("//button[text()='Да']");
    //селектор кнопки ДА, подтверждающий создание заказа

    private final By orderConfirmPopUp = By.xpath("//div[text()='Заказ оформлен']");
    //селектор всплывающего окна с подтверждением создания заказа

    /*
      Селекторы узлов блока FAQ главной страницы Яндекс Самокат */

    private final By cookieAcceptButtonSelector = By.id("rcc-confirm-button");
    //Селектор кнопки принятия куки

    private final String questionTemplate = "//div[text()='%s']";
    //Шаблон селектора для поиска узла с вопросом блока FAQ

    private final By lastQuestionFAQSelector = By.xpath("//div[text()='Я жизу за МКАДом, привезёте?']");

    private final String answerTemplate = "//div[@class='accordion']//div[@id='accordion__panel-%s']/p";
    //Шаблон селектора для поиска узла с ответом блока FAQ


/*
    Методы создания заказа */

    public void clickHeaderOrderButton() {      //Метод нажатия на кнопку Заказать в верхней части страницы СДЕЛАТЬ ЛОКАТОР
        WebElement headerOrderButton = driver.findElement(headerOrderButtonSelector);
        headerOrderButton.click();
    }

    public void clickFooterOrderButton() {      //Метод нажатия на кнопку Заказать в нижней части страницы
        WebElement headerOrderButton = driver.findElement(footerOrderButtonSelector);
        headerOrderButton.click();
    }

    public void scrollUntilFooterOrderButton(){     //Метод скролла до нижней кнопки Заказать
        WebElement footerButton = driver.findElement(footerOrderButtonSelector);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", footerButton);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(footerOrderButtonSelector));

    }

    public void fillNameField(String name) {     //метод заполнения поля Имя формы создания заказа
        WebElement nameInputOrderPage = driver.findElement(nameFieldOrderSelector);
        nameInputOrderPage.sendKeys(name);
    }

    public void fillLastNameField(String lastName) {     //метод заполнения поля Фамилия формы создания заказа
        WebElement lastNameInputOrderPage = driver.findElement(lastNameFieldOrderSelector);
        lastNameInputOrderPage.sendKeys(lastName);
    }

    public void fillAddressField(String address) {       //метод заполнения поля Адресс формы создания заказа
        WebElement addressInputOrderPage = driver.findElement(addressFieldOrderSelector);
        addressInputOrderPage.sendKeys(address);
    }

    public void fillMetroField(String stationName) {     //метод заполнения поля Станция Метро формы создания заказа
        WebElement metroInputOrderPage = driver.findElement(metroFieldOrderSelector);
        metroInputOrderPage.click();
        metroInputOrderPage.sendKeys(stationName, Keys.DOWN, Keys.ENTER);
    }

    public void fillPhoneField(String phone) {       //метод заполнения поля Телефон формы создания заказа
        WebElement phoneInputOrderPage = driver.findElement(phoneFieldOrderSelector);
        phoneInputOrderPage.sendKeys(phone);
    }

    public void nextButtonClick() {      //метод нажатия на кнопку Далее для перехода на второй блок полей создания заказа
        WebElement nextButton = driver.findElement(nextButtonOrderSelector);
        nextButton.click();
    }

    public void fillDateField(String date) {     //метод заполнения поля Дата доставки формы создания заказа

        WebElement dateOfDelivery = driver.findElement(dateFieldOrderSelector);

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(dateFieldOrderSelector));

        dateOfDelivery.sendKeys(date, Keys.ENTER);

    }

    public void fillRentTimeField(String daysOfRent) {       //метод заполнения псевдополя Количество дней аренды формы создания заказа

        WebElement rentTime = driver.findElement(rentFieldOrderSelector);
        rentTime.click();

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(rentDaysAvalabilityListSelector));

        WebElement countOfRentDays = driver.findElement(By.xpath(String.format(rentDayCountSelector, daysOfRent)));
        countOfRentDays.click();

    }

    public void totalOrderButtonClick() {        //метод нажатия на кнопку Заказать завершения создания заказа

        WebElement totalOrderButton = driver.findElement(totalOrderButtonSelector);
        totalOrderButton.click();

    }

    public void orderCreateCompleteStep() {       //метод нажатия на кнопку ДА для финального подтверждения заказа во всплывающем окне

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(conformationOrderCreationSelector));

        WebElement yesButton = driver.findElement(yesButtonSelector);
        yesButton.click();

    }

    public boolean isCreatedNewOrder(){     //метод проверки наличия всплывающего окна с подтверждением создания заказа
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(orderConfirmPopUp));

        return driver.findElement(orderConfirmPopUp).isDisplayed();
    }

/*
   Методы проверки блока FAQ */

    public void cookieAccept(){        // Метод закрытия блока информирования об использовании куки
        WebElement cookieButton = driver.findElement(cookieAcceptButtonSelector);
        cookieButton.click();
    }

    public void scrollUntilFAQ(){       // Метод скролла до блока FAQ
        WebElement lastFAQ = driver.findElement(lastQuestionFAQSelector);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", lastFAQ);
    }

    public void openTheAnswer(String text, String index){       //Метод раскрытия блока ответа к вопросу
        WebElement question = driver.findElement(By.xpath(String.format(questionTemplate, text)));
        question.click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(answerTemplate, index))));
    }

    public String gotAnswerText(String index){         //Метод получения текста блока ответа
        WebElement answer = driver.findElement(By.xpath(String.format(answerTemplate, index)));
        return answer.getText();
    }

 /*========================================================================================================================*/

}

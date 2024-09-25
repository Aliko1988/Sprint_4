package ru.yandex.practicum.seleniumtest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.practicum.pageobject.SamokatPageObject;

@RunWith(Parameterized.class)
public class OrderCreationFooterButtonTest extends AbstractTest {

    private final String name;
    private final String surname;
    private final String address;
    private final String metro;
    private final String phone;
    private final String date;
    private final String rent;



    public OrderCreationFooterButtonTest(String name, String surname, String address, String metro, String phone, String date, String rent){
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.date = date;
        this.rent = rent;

    }

    @Parameterized.Parameters
    public static Object[][] createOrderParams() {
        return new Object[][] {
                { "петрова", "иванова", "сидорова, "улица петрова, дом 123", "Лубянка", "8901234567890", "22.09.2024", "трое суток"},
                        { "иванова", "петрова", "сидорова, "улица петрова, дом 124", "Лубянка", "8901234567891", "23.09.2024", "трое суток"},
                                { "сидорова", "петрова", "сидорова, "улица петрова, дом 125", "Лубянка", "8901234567892", "23.09.2024", "трое суток"}
        };
    }



    @Test
    public void orderCreationHeaderButtonTest(){        // автоматизированный позитивный сценарий создания заказа с использованием верхней кнопки заказать


        SamokatPageObject mainPageObject = new SamokatPageObject(driver);

        mainPageObject.scrollUntilFooterOrderButton();

        mainPageObject.clickFooterOrderButton();

        mainPageObject.fillNameField(name);

        mainPageObject.fillLastNameField(surname);

        mainPageObject.fillAddressField(address);

        mainPageObject.fillMetroField(metro);

        mainPageObject.fillPhoneField(phone);

        mainPageObject.nextButtonClick();

        mainPageObject.fillDateField(date);

        mainPageObject.fillRentTimeField(rent);

        mainPageObject.totalOrderButtonClick();

        mainPageObject.orderCreateCompleteStep();

        boolean actualResult = mainPageObject.isCreatedNewOrder();

        Assert.assertTrue(actualResult);

    }


}

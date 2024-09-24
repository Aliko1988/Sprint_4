package ru.yandex.practicum.seleniumtest;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.practicum.pageobject.SamokatPageObject;

import static ru.yandex.practicum.сonstants.FAQAnswerText.*;
import static ru.yandex.practicum.сonstants.FAQAnswerText.EIGHTH_ANSWER;
import static ru.yandex.practicum.сonstants.FAQQuestionText.*;
import static ru.yandex.practicum.сonstants.FAQQuestionText.EIGHTH_QUESTION;


@RunWith(Parameterized.class)
public class OrderCreationHeaderButtonTest extends AbstractTest {

    private final String name;
    private final String surname;
    private final String address;
    private final String metro;
    private final String phone;
    private final String date;
    private final String rent;



    public OrderCreationHeaderButtonTest(String name, String surname, String address, String metro, String phone, String date, String rent){
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
                { "петрова", "иванова", "сидорова, улица петрова, дом 123", "Алматы", "8901234567890", "22.09.2024", "трое суток"},
                {"иванов", "петров", "Питер, Москва", "мхад", "83534000000", "21.09.2024", "двое суток"},
                {"петрова", "петрова1", "иванова, центральная", "Огонь", "89035353543", "01.09.2026", " пять суток"},
        };
    }


    @Test
    public void orderCreationHeaderButtonTest(){        //  позитивный сценарий для заказа с помощью верхней кнопки "заказать"


        SamokatPageObject mainPageObject = new SamokatPageObject(driver);


        mainPageObject.clickHeaderOrderButton();

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

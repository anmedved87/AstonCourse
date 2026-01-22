package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ServicesPaymentTest extends DriverTest {

    @Test
    void servicesPayment() {

        String phone = "297777777";
        String fullPhone = "375297777777";
        String amount = "50";

        OnlinePayBlockPage page = new OnlinePayBlockPage(driver)
                .open()
                .closeCookie()
                .scroll()
                .openServices();

        page.servicesPhone().sendKeys(phone);
        page.servicesSum().sendKeys(amount);
        page.servicesEmail().sendKeys("an.medvedeva87@gmail.com");

        assertTrue(page.servicesContinue().isEnabled());
        page.servicesContinue().click();


        PayCardBlockPage pay = new PayCardBlockPage(driver).payCard();

        String description = pay.descriptionOrder();
        assertTrue(
                description.contains("Оплата"),
                "Отсутствует надпись 'Оплата'"
        );

        assertTrue(
                description.contains("Услуги связи"),
                "Отсутствует тип услуги"
        );

        assertTrue(
                description.contains(fullPhone),
                "Отсутствует номер телефона"
        );


        assertTrue(
                pay.textOrder().contains(amount),
                "Сумма отображается некорректно"
        );

        assertTrue(
                pay.payButton().contains(amount),
                "Отсутствует сумма на кнопке оплаты"
        );
        assertEquals("Номер карты", pay.сardNumberPlaceholder());
        assertEquals("Срок действия", pay.periodPlaceholder());
        assertEquals("CVC", pay.cvcPlaceholder());
        assertEquals("Имя и фамилия на карте", pay.nameCardPlaceholder());

        assertTrue(pay.payIcons().stream().findAny().isPresent(), "Иконки платёжных систем отсутствуют");
    }
}
package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ServicesPaymentTest extends DriverTest {

    @Test
    void servicesPaymentFlow() {

        String phone = "297777777";
        String fullPhone = "375" + phone;
        String amount = "10";

        OnlineTopUpPage page = new OnlineTopUpPage(driver)
                .open()
                .closeCookies()
                .scrollToForm()
                .tabServices();

        // заполнение формы
        page.servicesPhone().sendKeys(phone);
        page.servicesSum().sendKeys(amount);
        page.servicesEmail().sendKeys("test@test.by");

        assertTrue(page.servicesContinue().isEnabled());
        page.servicesContinue().click();

        // страница подтверждения оплаты (iframe)
        PaymentConfirmationPage pay =
                new PaymentConfirmationPage(driver).waitLoaded();

        // ✅ проверка описания платежа
        String description = pay.getOrderDescriptionText();

        assertTrue(
                description.contains("Оплата"),
                "Отсутствует текст 'Оплата'"
        );

        assertTrue(
                description.contains("Услуги связи"),
                "Отсутствует тип услуги"
        );

        assertTrue(
                description.contains(fullPhone),
                "Номер телефона не отображается"
        );

        // ✅ проверка суммы
        assertTrue(
                pay.getAmountText().contains(amount),
                "Сумма отображается некорректно"
        );

        // ✅ проверка кнопки оплаты
        assertTrue(
                pay.getPayButtonText().contains(amount),
                "Сумма отсутствует на кнопке оплаты"
        );
        assertEquals("Номер карты", pay.getCardNumberLabel());
        assertEquals("Срок действия", pay.getExpirationLabel());
        assertEquals("CVC", pay.getCvcLabel());
        assertEquals("Имя и фамилия на карте", pay.getCardHolderLabel());
        // ================= проверка иконок платёжных систем =================
        assertTrue(
                pay.getPaymentSystemIcons().size() >= 3,
                "Иконки платёжных систем отсутствуют или их меньше трёх");
    }
}
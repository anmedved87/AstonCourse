package org.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ServicesPaymentTest extends DriverTest {

    @Test
    void servicesPaymentFlow() {
        String phone = "297777777";
        String fullPhone = "375" + phone;
        String amount = "10.00";

        OnlineTopUpPage page = new OnlineTopUpPage(driver)
                .open()
                .closeCookies()
                .scroll()
                .tabServices();

        // Заполняем форму
        page.servicesPhone().sendKeys(phone);
        page.servicesSum().sendKeys("10");
        page.servicesEmail().sendKeys("test@example.com");

        // Проверяем, что кнопка активна
        assertTrue(page.servicesContinue().isEnabled());
        page.servicesContinue().click();

        // Ждём загрузки страницы оплаты
        PaymentConfirmationPage pay = new PaymentConfirmationPage(driver).waitLoaded();

        // Проверка текста с номером телефона
        String description = pay.getOrderDescriptionText();
        assertTrue(description.contains("Оплата: Услуги связи"));
        assertTrue(description.contains(fullPhone));

        // Проверка суммы
        String amountText = pay.getAmountText();
        assertTrue(amountText.contains(amount));

        // Проверка кнопки оплаты
        String buttonText = pay.getPayButtonText();
        assertTrue(buttonText.contains("10"));

        // Проверка плейсхолдеров карты
        List<WebElement> fields = pay.getCardFields();
        assertTrue(fields.stream().anyMatch(e -> e.getAttribute("placeholder").toLowerCase().contains("карты")));
        assertTrue(fields.stream().anyMatch(e -> e.getAttribute("placeholder").toLowerCase().contains("cvv")));

        // Проверка логотипов платёжных систем
        List<WebElement> icons = pay.getPaymentIcons();
        assertTrue(icons.stream().anyMatch(e ->
                (e.getAttribute("alt") != null &&
                        (e.getAttribute("alt").toLowerCase().contains("visa") ||
                                e.getAttribute("alt").toLowerCase().contains("mastercard") ||
                                e.getAttribute("alt").toLowerCase().contains("белкарт") ||
                                e.getAttribute("alt").toLowerCase().contains("gpay")))
        ));
    }
}

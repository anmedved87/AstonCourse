package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlaceholdersTest extends DriverTest {

    @Test
    void checkPlaceholders() {

        OnlinePayBlockPage page = new OnlinePayBlockPage(driver)
                .open()
                .closeCookie()
                .scroll();

        page.openServices();
        assertEquals("Номер телефона", page.servicesPhonePlaceholder());
        assertEquals("Сумма", page.servicesSumPlaceholder());
        assertEquals("E-mail для отправки чека", page.servicesEmailPlaceholder());

        page.openInternet();
        assertEquals("Номер абонента", page.internetPhonePlaceholder());
        assertEquals("Сумма", page.internetSumPlaceholder());
        assertEquals("E-mail для отправки чека", page.internetEmailPlaceholder());

        page.openInstallment();
        assertEquals("Номер счета на 44", page.installmentScorePlaceholder());
        assertEquals("Сумма", page.installmentSumPlaceholder());
        assertEquals("E-mail для отправки чека", page.installmentEmailPlaceholder());

        page.openDuty();
        assertEquals("Номер счета на 2073", page.dutyScorePlaceholder());
        assertEquals("Сумма", page.duutySumPlaceholder());
        assertEquals("E-mail для отправки чека", page.dutyEmailPlaceholder());
    }
}
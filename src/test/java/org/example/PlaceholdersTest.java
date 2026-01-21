package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlaceholdersTest extends DriverTest {

    @Test
    void checkPlaceholders() {

        OnlineTopUpPage page = new OnlineTopUpPage(driver)
                .open()
                .closeCookies()
                .scrollToForm();

        page.tabServices();
        assertEquals("Номер телефона", page.servicesPhonePH());
        assertEquals("Сумма", page.servicesSumPH());
        assertEquals("E-mail для отправки чека", page.servicesEmailPH());

        page.tabInternet();
        assertEquals("Номер абонента", page.internetPhonePH());
        assertEquals("Сумма", page.internetSumPH());
        assertEquals("E-mail для отправки чека", page.internetEmailPH());

        page.tabInstallment();
        assertEquals("Номер счета на 44", page.installmentScorePH());
        assertEquals("Сумма", page.installmentSumPH());
        assertEquals("E-mail для отправки чека", page.installmentEmailPH());

        page.tabDebt();
        assertEquals("Номер счета на 2073", page.debtScorePH());
        assertEquals("Сумма", page.debtSumPH());
    }
}

package org.example;

import org.example.OnlineBlock;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InscriptionOnlineBlockTest extends DriverTest {
    @Test
    void checkPlaceholdersForAllTabs() {
        OnlineBlock page = new OnlineBlock(driver)
                .open()
                .closeCookiesIfPresent()
                .scrollToBlock();

        page.selectTabServices();
        assertEquals("Номер телефона", page.getConnectionPhonePlaceholder());
        assertEquals("Сумма", page.getConnectionSumPlaceholder());
        assertEquals("E-mail для отправки чека", page.getConnectionEmailPlaceholder());

        page.tabInternet();
        assertEquals("Номер абонента", page.internetPhonePlaceholder());
        assertEquals("Сумма", page.internetSumPlaceholder());
        assertEquals("E-mail для отправки чека", page.internetEmailPlaceholder());

        page.tabInstallment();
        assertEquals("Номер счета на 44", page.installmentScorePlaceholder());
        assertEquals("Сумма", page.installmentSumPlaceholder());
        assertEquals("E-mail для отправки чека", page.installmentEmailPlaceholder());

        page.tabDebt();
        assertEquals("Номер счета на 2073", page.debtScorePlaceholder());
        assertEquals("Сумма", page.debtSumPlaceholder());

    }
}


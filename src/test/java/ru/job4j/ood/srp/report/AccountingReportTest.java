package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.currency.Currency;
import ru.job4j.ood.srp.currency.InMemoryCurrencyConverter;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class AccountingReportTest {
    @Test
    public void whenGenerateReportInUSD() {
        MemoryStore store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100000);
        store.add(worker);
        InMemoryCurrencyConverter converter = new InMemoryCurrencyConverter();
        Report report = new AccountingReport(store, converter, Currency.USD);
        StringBuilder expected = new StringBuilder()
                .append("Name; Salary (USD);")
                .append(System.lineSeparator())
                .append("Ivan;1620.0;")
                .append(System.lineSeparator());
        assertThat(report.generate(employee -> true)).isEqualTo(expected.toString());
    }
}
package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.currency.Currency;
import ru.job4j.ood.srp.currency.CurrencyConverter;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.function.Predicate;

public class AccountingReport implements Report {
    private final Store store;
    private final CurrencyConverter converter;
    private final Currency targetCurrency;

    public AccountingReport(Store store, CurrencyConverter converter, Currency targetCurrency) {
        this.store = store;
        this.converter = converter;
        this.targetCurrency = targetCurrency;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary (").append(targetCurrency).append(");")
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            double convertedSalary = converter.convert(Currency.RUB, employee.getSalary(), targetCurrency);
            text.append(employee.getName()).append(";")
                    .append(convertedSalary).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}

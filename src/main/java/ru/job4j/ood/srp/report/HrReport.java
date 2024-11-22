package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class HrReport implements Report {
    private final Store store;
    private final Comparator<Employee> comparator;

    public HrReport(Store store, Comparator<Employee> comparator) {
        this.store = store;
        this.comparator = comparator;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        List<Employee> salarySortedEmployees = store.findBy(filter)
                .stream()
                .sorted(comparator)
                .toList();
        StringBuilder sb = new StringBuilder();
        sb.append("Name; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : salarySortedEmployees) {
            sb.append(employee.getName()).append(" ")
                    .append(employee.getSalary())
                    .append(System.lineSeparator());
        }
        return sb.toString();
    }
}

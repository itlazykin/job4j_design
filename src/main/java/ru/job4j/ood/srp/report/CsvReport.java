package ru.job4j.ood.srp.report;

import java.util.logging.Logger;
import java.util.logging.Level;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Calendar;
import java.util.function.Predicate;

public class CsvReport implements Report {
    private static final Logger LOGGER = Logger.getLogger(CsvReport.class.getName());
    private final Store store;
    private final DateTimeParser<Calendar> dateTimeParser;

    public CsvReport(Store store, DateTimeParser<Calendar> dateTimeParser) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append("; ")
                    .append(dateTimeParser.parse(employee.getHired())).append("; ")
                    .append(dateTimeParser.parse(employee.getFired())).append("; ")
                    .append(employee.getSalary())
                    .append(System.lineSeparator());
        }
        try (PrintStream output = new PrintStream("./data/EmployeeReport.csv")) {
            output.print(text);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to write CSV report", e);
        }
        return text.toString();
    }
}

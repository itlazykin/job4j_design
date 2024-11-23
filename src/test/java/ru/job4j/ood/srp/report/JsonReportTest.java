package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.assertj.core.api.Assertions.*;

class JsonReportTest {
    @Test
    void whenEmployeesToJsonGenerated() {
        Store store = new MemoryStore();
        store.add(new Employee("Nasty",
                new GregorianCalendar(2023, Calendar.JUNE, 8, 17, 41),
                new GregorianCalendar(2023, Calendar.JUNE, 8, 17, 41),
                30000D));
        store.add(new Employee("Den",
                new GregorianCalendar(2023, Calendar.JUNE, 8, 17, 41),
                new GregorianCalendar(2023, Calendar.JUNE, 8, 17, 41),
                45000D));
        JsonReport report = new JsonReport(store);
        String rsl = report.generate(employee -> true);
        String expected = """
                [
                  {
                    "name": "Nasty",
                    "hired": "08:06:2023 17:41",
                    "fired": "08:06:2023 17:41",
                    "salary": 30000.0
                  },
                  {
                    "name": "Den",
                    "hired": "08:06:2023 17:41",
                    "fired": "08:06:2023 17:41",
                    "salary": 45000.0
                  }
                ]""";
        assertThat(rsl).isEqualTo(expected);
    }
}
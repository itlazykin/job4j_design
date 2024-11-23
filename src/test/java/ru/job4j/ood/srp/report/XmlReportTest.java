package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.assertj.core.api.Assertions.*;

class XmlReportTest {
    @Test
    void whenGenerated() {
        Store store = new MemoryStore();
        XmlReport report = new XmlReport(store);
        store.add(new Employee("Nasty",
                new GregorianCalendar(2023, Calendar.JUNE, 8, 17, 41),
                new GregorianCalendar(2023, Calendar.JUNE, 8, 17, 41),
                30000D));
        store.add(new Employee("Den",
                new GregorianCalendar(2023, Calendar.JUNE, 8, 17, 41),
                new GregorianCalendar(2023, Calendar.JUNE, 8, 17, 41),
                45000D));
        String rsl = report.generate(employee -> true);
        String expected = """
                <?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>
                <employee name=\"Nasty\" salary=\"30000.0\">
                    <fired>08:06:2023 17:41</fired>
                    <hired>08:06:2023 17:41</hired>
                </employee>
                <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                <employee name="Den" salary="45000.0">
                    <fired>08:06:2023 17:41</fired>
                    <hired>08:06:2023 17:41</hired>
                </employee>
                """;
        assertThat(rsl).isEqualTo(expected);
    }
}
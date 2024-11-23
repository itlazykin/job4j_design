package ru.job4j.ood.srp.report;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.io.StringWriter;

import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XmlReport implements Report {
    private static final Logger LOGGER = Logger.getLogger(XmlReport.class.getName());
    private final Store store;
    private Marshaller marshaller;

    public XmlReport(Store store) {
        this.store = store;
        this.marshaller = getMarshaller();
    }

    private Marshaller getMarshaller() {
        Marshaller marshaller = null;
        try {
            JAXBContext context = JAXBContext.newInstance(Employee.class);
            marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        } catch (JAXBException e) {
            LOGGER.log(Level.SEVERE, "Failed to create XML report", e);
        }
        return marshaller;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        String rsl = "";
        try (StringWriter writer = new StringWriter()) {
            for (Employee employee : store.findBy(employee -> true)) {
                marshaller.marshal(employee, writer);
            }
            rsl = writer.getBuffer().toString();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error while generating report", e);
        }
        return rsl;
    }
}

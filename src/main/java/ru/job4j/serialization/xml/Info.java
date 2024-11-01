package ru.job4j.serialization.xml;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.StringReader;
import java.io.StringWriter;

public class Info {
    public static void main(String[] args)throws Exception {
        final Sportsman sportsman = new Sportsman(false, "Leo Messi", new Team("Inter Miami"),
                new String[]{"Golden Ball", "Golden Boy", "Champions League Winner", "World Cup winner"});
        JAXBContext context = JAXBContext.newInstance(Sportsman.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(sportsman, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            Sportsman result = (Sportsman) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
    }
}

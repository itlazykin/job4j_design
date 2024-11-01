package ru.job4j.serialization.xml;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.annotation.*;

import java.io.StringWriter;
import java.util.Arrays;
@XmlRootElement(name = "sportsman")
@XmlAccessorType(XmlAccessType.FIELD)
public class Sportsman {
    @XmlAttribute
    private boolean retired;
    @XmlAttribute
    private String name;
    @XmlElement
    private Team team;
    @XmlElementWrapper(name = "rewards")
    @XmlElement(name = "reward")
    private String[] rewards;

    public Sportsman() {
    }

    public Sportsman(boolean retired, String name, Team team, String[] rewards) {
        this.retired = retired;
        this.name = name;
        this.team = team;
        this.rewards = rewards;
    }

    @Override
    public String toString() {
        return "Sportsman{"
                + "retired=" + retired
                + ", name='" + name + '\''
                + ", team=" + team
                + ", rewards=" + Arrays.toString(rewards)
                + '}';
    }

    public static void main(String[] args) throws JAXBException {
        final Sportsman sportsman = new Sportsman(false, "Leo Messi", new Team("Inter Miami"),
                new String[]{"Golden Ball", "Golden Boy", "Champions League Winner", "World Cup winner"});
        JAXBContext context = JAXBContext.newInstance(Sportsman.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(sportsman, writer);
            String rsl = writer.getBuffer().toString();
            System.out.println(rsl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

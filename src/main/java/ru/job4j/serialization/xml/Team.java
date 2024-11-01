package ru.job4j.serialization.xml;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "team")
public class Team {
    @XmlAttribute
    private String name;

    public Team() {

    }

    public Team(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Team{"
                + "name='" + name + '\''
                + '}';
    }
}

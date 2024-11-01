package ru.job4j.serialization.xml;

public class Team {
    private final String name;

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

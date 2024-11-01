package ru.job4j.serialization.xml;

import java.util.Arrays;

public class Sportsman {
    private final boolean retired;
    private final String name;
    private final Team team;
    private final String[] rewards;

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
}

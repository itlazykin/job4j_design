package ru.job4j.serialization.json;

import java.util.Arrays;
import java.util.Objects;

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
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Sportsman sportsman = (Sportsman) object;
        return retired == sportsman.retired && Objects.equals(name, sportsman.name) && Objects.equals(team, sportsman.team) && Objects.deepEquals(rewards, sportsman.rewards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(retired, name, team, Arrays.hashCode(rewards));
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

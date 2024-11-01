package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Info {
    public static void main(String[] args) {
        final Sportsman sportsman = new Sportsman(false, "Leo Messi", new Team("Inter Miami"),
                new String[]{"Golden Ball", "Golden Boy", "Champions League Winner", "World Cup winner"});
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(sportsman));
        final String sportsmanJson =
                "{"
                        + "\"retired\":false,"
                        + "\"name\":\"Leo Messi\","
                        + "\"team\":"
                        + "{"
                        + "\"name\":\"Inter Miami\""
                        + "},"
                        + "\"rewards\":"
                        + "[\"Golden Ball\", \"Golden Boy\", \"Champions League Winner\", \"World Cup winner\"]"
                        + "}";
        final Sportsman sportsmanMod = gson.fromJson(sportsmanJson, Sportsman.class);
        System.out.println(sportsmanMod);
    }
}

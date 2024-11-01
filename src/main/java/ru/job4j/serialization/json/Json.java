package ru.job4j.serialization.json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Json {
    public static void main(String[] args) {
        JSONObject jsonTeam = new JSONObject("{\"name\":\"Inter Miami\"}");
        List<String> list = new ArrayList<>();
        list.add("Golden Ball");
        list.add("Golden Boy");
        list.add("Champions League Winner");
        list.add("World Cup winner");
        JSONArray jsonRewards = new JSONArray(list);
        final Sportsman sportsman = new Sportsman(false, "Leo Messi", new Team("Inter Miami"),
                new String[]{"Golden Ball", "Golden Boy", "Champions League Winner", "World Cup winner"});
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("retired", sportsman.isRetired());
        jsonObject.put("name", sportsman.getName());
        jsonObject.put("team", jsonTeam);
        jsonObject.put("rewards", jsonRewards);
        System.out.println(jsonObject);
        System.out.println(new JSONObject(sportsman));
    }
}

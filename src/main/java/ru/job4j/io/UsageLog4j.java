package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Denis Lazykin";
        byte age = 35;
        short height = 183;
        int weight = 70;
        long neurones = 86_000_000_000L;
        float hair = 100_000F;
        double bacteria = 420.24_000_000_000_000D;
        char gender = 'M';
        boolean learnJava = true;
        LOG.debug("User info name : {}, age : {}, height : {}, weight : {}, neurones : {},"
                        + " hair : {}, bacteria : {}, gender : {}, learnJava : {}",
                name, age, height, weight, neurones, hair, bacteria, gender, learnJava);
    }
}

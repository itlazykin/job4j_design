package ru.job4j.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("Job4j", Pattern.CASE_INSENSITIVE);
        String textOne = "JoB4j";
        /*
        Метод matches() проверяет, совпадает ли шаблон с указанной строкой.
         */
        Matcher matcherOne = pattern.matcher(textOne);
        boolean isPresentOne = matcherOne.matches();
        System.out.println(isPresentOne);
        String textTwo = "jOb4J";
        Matcher matcherTwo = pattern.matcher(textTwo);
        boolean isPresentTwo = matcherTwo.matches();
        System.out.println(isPresentTwo);
        /*
        Проверить шаблон на его присутствие в тексте. Проверка выполняется с помощью метода find().
         */
        Pattern pattern1 = Pattern.compile("Job4j");
        String text = "Я учусь на курсе Job4j";
        Matcher matcher = pattern1.matcher(text);
        boolean isPresent = matcher.find();
        System.out.println(isPresent);
        Pattern pattern2 = Pattern.compile("Job4j");
        String text1 = "Job4j и Job4j и Job4j";
        Matcher matcher1 = pattern2.matcher(text1);
        /*
        Чтобы найти многократные вхождения шаблона в коде, нужно использовать find() в цикле.
        Получить найденное совпадение в виде строки можно с помощью метода group().
        Этот метод выводит ту часть текста, которая совпадает с шаблоном регулярного выражения.
         */
        while (matcher1.find()) {
            System.out.println("Найдено совпадение " + matcher1.group());
        }
        Pattern pattern3 = Pattern.compile("Job4j");
        String text2 = "Job4j1 и Job4j2 и Job4j3";
        Matcher matcher2 = pattern3.matcher(text2);
        /*
        Метод start() - получает индекс, в котором находится первый символ искомой последовательности символов.
        Метод end() - получает индекс, следующий за последним символом искомой последовательности символов.
         */
        while (matcher2.find()) {
            System.out.println("Найдено совпадение. iStart: " + matcher2.start()
                    + " iEnd: " + matcher2.end());
        }
        /*
         Найденные совпадения можно заменить другой строкой с помощью метода replaceAll(),
         который применяется к сопоставителю matcher.
         */
        Pattern pattern4 = Pattern.compile("123");
        String text3 = "1231 и 1232 и 1233";
        Matcher matcher3 = pattern4.matcher(text3);
        String result = matcher3.replaceAll("Job4j");
        System.out.println(result);
    }
}

package ru.job4j.pool;

public class StringPoolExample2 {
    public static void main(String[] args) {
        String string1 = "Hello, world";
        String string2 = "Hello, ";
        String string3 = string2 + "world";
        System.out.println(string1 == string3);
        /*
        В данном примере сначала создаются исходная строка и первая часть этой строки в пуле строк.
        В следующей строке мы объединяем string2 со строковым литералом, который тоже хранится в пуле строк.
        В результате конкатенации которых получим значение, идентичное значению string1.
        Сравнение ссылок полученной в результате конкатенации целой строки string3 и идентичной ей по значению string1
        вернет false, потому что вычисление string3 будет происходить только во время выполнения программы,
        а результирующая строка string3 будет создана в куче.
         */
    }
}

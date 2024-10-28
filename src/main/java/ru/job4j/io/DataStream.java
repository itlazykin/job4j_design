package ru.job4j.io;

import java.io.*;

public class DataStream {
    public static void main(String[] args) throws Exception {
        String path = "data/dataOutput.txt";
        String[] names = {"unit1", "unit2", "unit3"};
        int[] amounts = {5, 7, 2};
        boolean[] checked = {true, false, true};
        /*
        создаются потоки чтения и записи примитивов в файл в двоичном формате
         */
        try (DataOutputStream output = new DataOutputStream(new FileOutputStream(path));
             DataInputStream input = new DataInputStream(new FileInputStream(path))) {
            /*
            записываем в файл значения из всех массивов
             */
            for (int i = 0; i < names.length; i++) {
                output.writeUTF(names[i]);
                output.writeInt(amounts[i]);
                output.writeBoolean(checked[i]);
            }
            /*
            в цикле читаем переменные, соответствующие типам данных,
            эти данные мы храним в файле (также соблюдается порядок, в котором данные были записаны в файл),
             и выводим считанные значения в консоль
             */
            while (true) {
                String name = input.readUTF();
                int amount = input.readInt();
                boolean check = input.readBoolean();
                System.out.println("Наименование: " + name
                        + ", количество: " + amount
                        + ", проверен: " + check);
            }
        } catch (EOFException e) {
            System.err.println("Достигнут конец файла");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

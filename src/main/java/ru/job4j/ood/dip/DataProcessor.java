package ru.job4j.ood.dip;

public class DataProcessor {
    private final FileStorage fileStorage;

    public DataProcessor(FileStorage fileStorage) {
        this.fileStorage = fileStorage;
    }

    public void process(String data) {
        System.out.println("Processing data: " + data);
        fileStorage.save(data);
    }
}

class FileStorage {
    public void save(String data) {
        System.out.println("Saving data to a file: " + data);
    }
}

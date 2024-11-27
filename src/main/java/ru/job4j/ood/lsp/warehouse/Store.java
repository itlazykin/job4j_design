package ru.job4j.ood.lsp.warehouse;

import java.util.List;

public interface Store {
    boolean addFood(Food product);

    List<Food> getStoreProducts();

    void deleteProducts();
}

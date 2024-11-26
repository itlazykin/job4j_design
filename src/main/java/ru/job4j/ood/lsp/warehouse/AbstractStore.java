package ru.job4j.ood.lsp.warehouse;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStore implements Store {
    protected List<Food> products = new ArrayList<>();

    @Override
    public boolean addFood(Food product) {
        boolean result = false;
        if (accept(product)) {
            result = products.add(product);
        }
        return result;
    }

    abstract public boolean accept(Food product);

    @Override
    public List<Food> getStoreProducts() {
        return products;
    }
}

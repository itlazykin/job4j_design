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

    /**
     * Метод добавления продукта, который проверяет, подходит ли продукт для конкретного хранилища.
     *
     * @param product принимает продукт, для которого нужно рассчитать срок годности
     * @return true, если продукт подходит для данного хранилища, если нет false.
     */
    abstract public boolean accept(Food product);

    @Override
    public List<Food> getStoreProducts() {
        return products;
    }
}

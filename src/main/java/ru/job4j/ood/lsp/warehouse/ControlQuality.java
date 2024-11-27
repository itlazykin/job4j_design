package ru.job4j.ood.lsp.warehouse;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс отвечает за распределение продуктов по хранилищам в зависимости от их срока годности.
 */
public class ControlQuality {
    /**
     * Список всех возможных хранилищ (List<Store>) при создании
     */
    private final List<Store> stores;

    public ControlQuality(List<Store> stores) {
        this.stores = stores;
    }

    /**
     * Перебирает все доступные хранилища и добавляет продукт в первое подходящее
     *
     * @param product принимает продукт, который будет сортировать.
     */
    public void sort(Food product) {
        for (Store store : stores) {
            if (store.addFood(product)) {
                break;
            }
        }
    }

    /**
     * Извлекает все продукты и перераспределяет их заново.
     */
    public void resortProducts() {
        List<Food> prods = new ArrayList<>();
        for (Store store : stores) {
            prods.addAll(store.getStoreProducts());
            store.deleteProducts();
        }
        prods.forEach(this::sort);
    }
}

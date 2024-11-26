package ru.job4j.ood.lsp.warehouse;

import java.util.List;

public class ControlQuality {
   private final List<Store> stores;

    public ControlQuality(List<Store> stores) {
        this.stores = stores;
    }

    public void sort(Food product) {
        for (Store store : stores) {
            if (store.addFood(product)) {
                break;
            }
        }
    }
}

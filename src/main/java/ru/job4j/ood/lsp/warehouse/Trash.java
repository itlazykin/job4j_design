package ru.job4j.ood.lsp.warehouse;

public class Trash extends AbstractStore {
    @Override
    public boolean accept(Food product) {
        return product.getPercentOfExpiry() >= 100;
    }
}

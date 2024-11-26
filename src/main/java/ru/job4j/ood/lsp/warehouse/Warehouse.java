package ru.job4j.ood.lsp.warehouse;

public class Warehouse extends AbstractStore {
    @Override
    public boolean accept(Food product) {
        return product.getPercentOfExpiry() < 25;
    }
}

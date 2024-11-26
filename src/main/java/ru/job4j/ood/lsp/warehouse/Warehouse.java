package ru.job4j.ood.lsp.warehouse;

/**
 * Используется для продуктов, срок годности которых почти не истек — менее 25% от всего времени хранения.
 */
public class Warehouse extends AbstractStore {
    @Override
    public boolean accept(Food product) {
        return product.getPercentOfExpiry() < 25;
    }
}

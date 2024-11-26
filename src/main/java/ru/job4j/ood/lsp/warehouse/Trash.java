package ru.job4j.ood.lsp.warehouse;

/**
 * Для продуктов, у которых срок годности полностью истек (100% и больше).
 */
public class Trash extends AbstractStore {
    @Override
    public boolean accept(Food product) {
        return product.getPercentOfExpiry() >= 100;
    }
}

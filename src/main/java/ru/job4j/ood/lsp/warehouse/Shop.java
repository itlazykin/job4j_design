package ru.job4j.ood.lsp.warehouse;

/**
 * Используется для продуктов, у которых срок годности истек на 25–75%.
 * Также в магазине можно продавать продукты со скидкой, если их срок истекает на 75–100%.
 */
public class Shop extends AbstractStore {
    @Override
    public boolean accept(Food product) {
        double percent = product.getPercentOfExpiry();
        boolean rsl = false;
        if (percent >= 25 && percent <= 75) {
            rsl = true;
        } else if (percent > 75 && percent < 100) {
            product.setPrice(product.getPrice() * (1 - product.getDiscount()));
            rsl = true;
        }
        return rsl;
    }
}

package tudelft.discount;

import java.math.BigDecimal;

class DiscountApplier {

    private ProductDao dao;

    DiscountApplier (ProductDao dao) {
        this.dao = dao;
    }

    void setNewPrices() {
        for (Product product : dao.all()) {
            if (product.getCategory().equals("BUSINESS")) {
                product.setPrice(calculateNewPrice(product.getPrice(), 1.1));
            }

            if (product.getCategory().equals("HOME")) {
                product.setPrice(calculateNewPrice(product.getPrice(), 0.9));
            }
        }
    }

    private double calculateNewPrice(double price, double multiplicand) {
        return BigDecimal.valueOf(price).multiply(BigDecimal.valueOf(multiplicand)).doubleValue();
    }
}

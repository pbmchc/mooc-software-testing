package tudelft.discount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

class DiscountApplierTest {

    @Test
    void shouldCalculateNewProductPrices() {
        Product homeProduct = new Product("home", 100.00, "HOME");
        Product businessProduct = new Product("business", 100.00, "BUSINESS");
        Product otherProduct = new Product("other", 100.00, "OTHER");
        List<Product> products = Arrays.asList(homeProduct, businessProduct, otherProduct);

        ProductDao productDao = Mockito.mock(ProductDao.class);
        Mockito.when(productDao.all()).thenReturn(products);

        DiscountApplier discountApplier = new DiscountApplier(productDao);
        discountApplier.setNewPrices();

        Assertions.assertEquals(homeProduct.getPrice(), 90.00);
        Assertions.assertEquals(businessProduct.getPrice(), 110.00);
        Assertions.assertEquals(otherProduct.getPrice(), 100.00);
    }

}

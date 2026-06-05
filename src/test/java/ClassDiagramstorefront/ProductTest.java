package ClassDiagramstorefront;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for Product class
 * Tests product inventory and pricing operations
 */
@DisplayName("Product Management Tests")
public class ProductTest {

    private Product product;

    @BeforeEach
    void setUp() {
        product = new Product();
    }

    @Test
    @DisplayName("Should initialize product with default values")
    void testProductInitialization() {
        assertNotNull(product, "Product object should be created");
    }

    @Test
    @DisplayName("Should throw UnsupportedOperationException when updating stock quantity")
    void testStockQty() {
        assertThrows(UnsupportedOperationException.class, () -> {
            product.stockQty(100);
        }, "stockQty should throw UnsupportedOperationException");
    }

    @Test
    @DisplayName("Should throw UnsupportedOperationException when changing price")
    void testChangePrice() {
        assertThrows(UnsupportedOperationException.class, () -> {
            product.changePrice(99);
        }, "changePrice should throw UnsupportedOperationException");
    }

    @Test
    @DisplayName("Should throw UnsupportedOperationException when getting details")
    void testGetDetails() {
        assertThrows(UnsupportedOperationException.class, () -> {
            product.getDetails();
        }, "getDetails should throw UnsupportedOperationException");
    }

    @Test
    @DisplayName("Should handle various stock quantities")
    void testVariousStockQuantities() {
        int[] quantities = {0, 1, 50, 100, 1000, 10000};
        
        for (int qty : quantities) {
            assertThrows(UnsupportedOperationException.class, () -> {
                product.stockQty(qty);
            });
        }
    }

    @Test
    @DisplayName("Should handle various price values")
    void testVariousPrices() {
        int[] prices = {0, 1, 50, 100, 999, 10000};
        
        for (int price : prices) {
            assertThrows(UnsupportedOperationException.class, () -> {
                product.changePrice(price);
            });
        }
    }

    @Test
    @DisplayName("Should handle negative stock and prices gracefully")
    void testNegativeValues() {
        assertThrows(UnsupportedOperationException.class, () -> {
            product.stockQty(-10);
        });
        
        assertThrows(UnsupportedOperationException.class, () -> {
            product.changePrice(-50);
        });
    }

    @Test
    @DisplayName("Should manage all product operations consistently")
    void testAllProductOperations() {
        assertThrows(UnsupportedOperationException.class, () -> product.stockQty(100));
        assertThrows(UnsupportedOperationException.class, () -> product.changePrice(99));
        assertThrows(UnsupportedOperationException.class, () -> product.getDetails());
    }

    @Test
    @DisplayName("Should create independent product instances")
    void testMultipleProductInstances() {
        Product product1 = new Product();
        Product product2 = new Product();
        
        assertNotNull(product1);
        assertNotNull(product2);
        assertNotEquals(product1, product2);
    }
}

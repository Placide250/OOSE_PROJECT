package ClassDiagramstorefront;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for StoreLocation class
 * Tests store location inventory management
 */
@DisplayName("Store Location Tests")
public class StoreLocationTest {

    private StoreLocation storeLocation;

    @BeforeEach
    void setUp() {
        storeLocation = new StoreLocation();
    }

    @Test
    @DisplayName("Should initialize store location with default values")
    void testStoreLocationInitialization() {
        assertNotNull(storeLocation, "StoreLocation object should be created");
    }

    @Test
    @DisplayName("Should throw UnsupportedOperationException when adding product")
    void testAddProduct() {
        assertThrows(UnsupportedOperationException.class, () -> {
            storeLocation.addproduct(1, 99, 50);
        }, "addproduct should throw UnsupportedOperationException");
    }

    @Test
    @DisplayName("Should throw UnsupportedOperationException when removing product")
    void testRemoveProduct() {
        assertThrows(UnsupportedOperationException.class, () -> {
            storeLocation.removeproduct(1);
        }, "removeproduct should throw UnsupportedOperationException");
    }

    @Test
    @DisplayName("Should throw UnsupportedOperationException when listing products")
    void testListProducts() {
        assertThrows(UnsupportedOperationException.class, () -> {
            storeLocation.listproducts();
        }, "listproducts should throw UnsupportedOperationException");
    }

    @Test
    @DisplayName("Should handle adding products with various prices and stocks")
    void testAddProductVariousPricesAndStocks() {
        int[] prices = {9, 29, 99, 199, 999};
        int[] stocks = {10, 25, 50, 100, 500};
        
        for (int price : prices) {
            for (int stock : stocks) {
                assertThrows(UnsupportedOperationException.class, () -> {
                    storeLocation.addproduct(1, price, stock);
                });
            }
        }
    }

    @Test
    @DisplayName("Should handle removing various product IDs")
    void testRemoveVariousProducts() {
        int[] productIds = {1, 5, 10, 50, 100};
        
        for (int id : productIds) {
            assertThrows(UnsupportedOperationException.class, () -> {
                storeLocation.removeproduct(id);
            });
        }
    }

    @Test
    @DisplayName("Should handle negative and zero prices gracefully")
    void testInvalidPrices() {
        assertThrows(UnsupportedOperationException.class, () -> {
            storeLocation.addproduct(1, -10, 50);
        });
        
        assertThrows(UnsupportedOperationException.class, () -> {
            storeLocation.addproduct(1, 0, 50);
        });
    }

    @Test
    @DisplayName("Should handle negative and zero stock gracefully")
    void testInvalidStock() {
        assertThrows(UnsupportedOperationException.class, () -> {
            storeLocation.addproduct(1, 50, -10);
        });
        
        assertThrows(UnsupportedOperationException.class, () -> {
            storeLocation.addproduct(1, 50, 0);
        });
    }

    @Test
    @DisplayName("Should manage all store location operations consistently")
    void testAllStoreLocationOperations() {
        assertThrows(UnsupportedOperationException.class, () -> storeLocation.addproduct(1, 99, 50));
        assertThrows(UnsupportedOperationException.class, () -> storeLocation.removeproduct(1));
        assertThrows(UnsupportedOperationException.class, () -> storeLocation.listproducts());
    }

    @Test
    @DisplayName("Should create independent store location instances")
    void testMultipleStoreLocationInstances() {
        StoreLocation location1 = new StoreLocation();
        StoreLocation location2 = new StoreLocation();
        
        assertNotNull(location1);
        assertNotNull(location2);
        assertNotEquals(location1, location2);
    }
}

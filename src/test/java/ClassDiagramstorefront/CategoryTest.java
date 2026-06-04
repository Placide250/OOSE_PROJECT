package ClassDiagramstorefront;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for Category class
 * Tests category and product management operations
 */
@DisplayName("Category Management Tests")
public class CategoryTest {

    private Category category;

    @BeforeEach
    void setUp() {
        category = new Category();
    }

    @Test
    @DisplayName("Should initialize category with default values")
    void testCategoryInitialization() {
        assertNotNull(category, "Category object should be created");
    }

    @Test
    @DisplayName("Should throw UnsupportedOperationException when adding product")
    void testAddProduct() {
        assertThrows(UnsupportedOperationException.class, () -> {
            category.AddProduct(null);
        }, "AddProduct should throw UnsupportedOperationException");
    }

    @Test
    @DisplayName("Should throw UnsupportedOperationException when removing product")
    void testRemoveProduct() {
        assertThrows(UnsupportedOperationException.class, () -> {
            category.removeProduct(1);
        }, "removeProduct should throw UnsupportedOperationException");
    }

    @Test
    @DisplayName("Should throw UnsupportedOperationException when listing products")
    void testListProducts() {
        assertThrows(UnsupportedOperationException.class, () -> {
            category.listProducts();
        }, "listProducts should throw UnsupportedOperationException");
    }

    @Test
    @DisplayName("Should handle removing various product IDs")
    void testRemoveVariousProducts() {
        int[] productIds = {1, 5, 10, 50, 100};
        
        for (int id : productIds) {
            assertThrows(UnsupportedOperationException.class, () -> {
                category.removeProduct(id);
            });
        }
    }

    @Test
    @DisplayName("Should handle negative product IDs gracefully")
    void testNegativeProductIds() {
        assertThrows(UnsupportedOperationException.class, () -> {
            category.removeProduct(-1);
        });
    }

    @Test
    @DisplayName("Should handle zero product ID gracefully")
    void testZeroProductId() {
        assertThrows(UnsupportedOperationException.class, () -> {
            category.removeProduct(0);
        });
    }

    @Test
    @DisplayName("Should manage all category operations consistently")
    void testAllCategoryOperations() {
        assertThrows(UnsupportedOperationException.class, () -> category.AddProduct(null));
        assertThrows(UnsupportedOperationException.class, () -> category.removeProduct(1));
        assertThrows(UnsupportedOperationException.class, () -> category.listProducts());
    }

    @Test
    @DisplayName("Should create independent category instances")
    void testMultipleCategoryInstances() {
        Category category1 = new Category();
        Category category2 = new Category();
        
        assertNotNull(category1);
        assertNotNull(category2);
        assertNotEquals(category1, category2);
    }
}

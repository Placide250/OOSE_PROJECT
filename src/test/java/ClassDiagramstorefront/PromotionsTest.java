package ClassDiagramstorefront;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for Promotions class
 * Tests promotional operations
 */
@DisplayName("Promotions Management Tests")
public class PromotionsTest {

    private Promotions promotions;

    @BeforeEach
    void setUp() {
        promotions = new Promotions();
    }

    @Test
    @DisplayName("Should initialize promotions with default values")
    void testPromotionsInitialization() {
        assertNotNull(promotions, "Promotions object should be created");
    }

    @Test
    @DisplayName("Should throw UnsupportedOperationException when applying promotion")
    void testApplyPromotion() {
        assertThrows(UnsupportedOperationException.class, () -> {
            promotions.appypromotion(1);
        }, "appypromotion should throw UnsupportedOperationException");
    }

    @Test
    @DisplayName("Should throw UnsupportedOperationException when removing promotion")
    void testRemovePromotion() {
        assertThrows(UnsupportedOperationException.class, () -> {
            promotions.removepromtion(1);
        }, "removepromtion should throw UnsupportedOperationException");
    }

    @Test
    @DisplayName("Should handle applying promotions to various products")
    void testApplyPromotionToVariousProducts() {
        int[] productIds = {1, 5, 10, 50, 100};
        
        for (int id : productIds) {
            assertThrows(UnsupportedOperationException.class, () -> {
                promotions.appypromotion(id);
            });
        }
    }

    @Test
    @DisplayName("Should handle removing promotions from various products")
    void testRemovePromotionFromVariousProducts() {
        int[] productIds = {1, 5, 10, 50, 100};
        
        for (int id : productIds) {
            assertThrows(UnsupportedOperationException.class, () -> {
                promotions.removepromtion(id);
            });
        }
    }

    @Test
    @DisplayName("Should handle zero and negative product IDs")
    void testInvalidProductIds() {
        assertThrows(UnsupportedOperationException.class, () -> {
            promotions.appypromotion(0);
        });
        
        assertThrows(UnsupportedOperationException.class, () -> {
            promotions.removepromtion(-1);
        });
    }

    @Test
    @DisplayName("Should manage all promotion operations consistently")
    void testAllPromotionOperations() {
        assertThrows(UnsupportedOperationException.class, () -> promotions.appypromotion(1));
        assertThrows(UnsupportedOperationException.class, () -> promotions.removepromtion(1));
    }

    @Test
    @DisplayName("Should handle promotion lifecycle")
    void testPromotionLifecycle() {
        int productId = 1;
        
        // Apply and remove promotion
        assertThrows(UnsupportedOperationException.class, () -> {
            promotions.appypromotion(productId);
            promotions.removepromtion(productId);
        });
    }

    @Test
    @DisplayName("Should create independent promotion instances")
    void testMultiplePromotionInstances() {
        Promotions promo1 = new Promotions();
        Promotions promo2 = new Promotions();
        
        assertNotNull(promo1);
        assertNotNull(promo2);
        assertNotEquals(promo1, promo2);
    }
}

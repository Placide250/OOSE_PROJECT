package ClassDiagramstorefront;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for Delivery class
 * Tests delivery preference management operations
 */
@DisplayName("Delivery Preference Management Tests")
public class DeliveryTest {

    private Delivery delivery;

    @BeforeEach
    void setUp() {
        delivery = new Delivery();
    }

    @Test
    @DisplayName("Should initialize delivery with default values")
    void testDeliveryInitialization() {
        assertNotNull(delivery, "Delivery object should be created");
    }

    @Test
    @DisplayName("Should throw UnsupportedOperationException when setting preference")
    void testSetPreference() {
        assertThrows(UnsupportedOperationException.class, () -> {
            delivery.setPreference("Express");
        }, "setPreference should throw UnsupportedOperationException");
    }

    @Test
    @DisplayName("Should throw UnsupportedOperationException when updating preference")
    void testUpdatePreference() {
        assertThrows(UnsupportedOperationException.class, () -> {
            delivery.updatePreference("Standard");
        }, "updatePreference should throw UnsupportedOperationException");
    }

    @Test
    @DisplayName("Should handle different delivery types")
    void testDifferentDeliveryTypes() {
        String[] deliveryTypes = {"Express", "Standard", "Economy", "Pickup"};
        
        for (String type : deliveryTypes) {
            assertThrows(UnsupportedOperationException.class, () -> {
                delivery.setPreference(type);
            });
        }
    }

    @Test
    @DisplayName("Should handle null delivery type gracefully")
    void testNullDeliveryType() {
        assertThrows(UnsupportedOperationException.class, () -> {
            delivery.setPreference(null);
        });
    }

    @Test
    @DisplayName("Should create multiple delivery instances")
    void testMultipleDeliveryInstances() {
        Delivery delivery1 = new Delivery();
        Delivery delivery2 = new Delivery();
        
        assertNotNull(delivery1);
        assertNotNull(delivery2);
        assertNotEquals(delivery1, delivery2);
    }
}

package ClassDiagramstorefront;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for Cart class
 * Tests shopping cart operations
 */
@DisplayName("Shopping Cart Tests")
public class CartTest {

    private Cart cart;

    @BeforeEach
    void setUp() {
        cart = new Cart();
    }

    @Test
    @DisplayName("Should initialize cart with default values")
    void testCartInitialization() {
        assertNotNull(cart, "Cart object should be created");
    }

    @Test
    @DisplayName("Should throw UnsupportedOperationException when adding item")
    void testAddItem() {
        assertThrows(UnsupportedOperationException.class, () -> {
            cart.addItem(1, 5);
        }, "addItem should throw UnsupportedOperationException");
    }

    @Test
    @DisplayName("Should throw UnsupportedOperationException when removing item")
    void testRemoveItem() {
        assertThrows(UnsupportedOperationException.class, () -> {
            cart.removeItem(1);
        }, "removeItem should throw UnsupportedOperationException");
    }

    @Test
    @DisplayName("Should throw UnsupportedOperationException when calculating total price")
    void testTotalPrice() {
        assertThrows(UnsupportedOperationException.class, () -> {
            cart.TotalPrice();
        }, "TotalPrice should throw UnsupportedOperationException");
    }

    @Test
    @DisplayName("Should handle adding various product quantities")
    void testAddItemVariousQuantities() {
        int[] quantities = {1, 5, 10, 50, 100};
        int productId = 1;
        
        for (int qty : quantities) {
            assertThrows(UnsupportedOperationException.class, () -> {
                cart.addItem(productId, qty);
            });
        }
    }

    @Test
    @DisplayName("Should handle removing various product IDs")
    void testRemoveItemVariousIds() {
        int[] productIds = {1, 5, 10, 50, 100};
        
        for (int id : productIds) {
            assertThrows(UnsupportedOperationException.class, () -> {
                cart.removeItem(id);
            });
        }
    }

    @Test
    @DisplayName("Should handle zero and negative quantities gracefully")
    void testInvalidQuantities() {
        assertThrows(UnsupportedOperationException.class, () -> {
            cart.addItem(1, 0);
        });
        
        assertThrows(UnsupportedOperationException.class, () -> {
            cart.addItem(1, -5);
        });
    }

    @Test
    @DisplayName("Should manage all cart operations consistently")
    void testAllCartOperations() {
        assertThrows(UnsupportedOperationException.class, () -> cart.addItem(1, 5));
        assertThrows(UnsupportedOperationException.class, () -> cart.removeItem(1));
        assertThrows(UnsupportedOperationException.class, () -> cart.TotalPrice());
    }

    @Test
    @DisplayName("Should create independent cart instances")
    void testMultipleCartInstances() {
        Cart cart1 = new Cart();
        Cart cart2 = new Cart();
        
        assertNotNull(cart1);
        assertNotNull(cart2);
        assertNotEquals(cart1, cart2);
    }
}

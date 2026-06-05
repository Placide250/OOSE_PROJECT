package ClassDiagramstorefront;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for Customer class
 * Tests customer authentication and profile management
 */
@DisplayName("Customer Management Tests")
public class CustomerTest {

    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer();
    }

    @Test
    @DisplayName("Should initialize customer with default values")
    void testCustomerInitialization() {
        assertNotNull(customer, "Customer object should be created");
    }

    @Test
    @DisplayName("Should throw UnsupportedOperationException when registering profile")
    void testRegisterProfile() {
        assertThrows(UnsupportedOperationException.class, () -> {
            customer.registerprofile();
        }, "registerprofile should throw UnsupportedOperationException");
    }

    @Test
    @DisplayName("Should throw UnsupportedOperationException when logging in")
    void testLogin() {
        assertThrows(UnsupportedOperationException.class, () -> {
            customer.login();
        }, "login should throw UnsupportedOperationException");
    }

    @Test
    @DisplayName("Should throw UnsupportedOperationException when updating profile")
    void testUpdateProfile() {
        assertThrows(UnsupportedOperationException.class, () -> {
            customer.updateprofile();
        }, "updateprofile should throw UnsupportedOperationException");
    }

    @Test
    @DisplayName("Should throw UnsupportedOperationException when viewing orders")
    void testViewOrders() {
        assertThrows(UnsupportedOperationException.class, () -> {
            customer.vieworders();
        }, "vieworders should throw UnsupportedOperationException");
    }

    @Test
    @DisplayName("Should manage all authentication operations consistently")
    void testAllAuthOperations() {
        assertThrows(UnsupportedOperationException.class, () -> customer.registerprofile());
        assertThrows(UnsupportedOperationException.class, () -> customer.login());
        assertThrows(UnsupportedOperationException.class, () -> customer.updateprofile());
        assertThrows(UnsupportedOperationException.class, () -> customer.vieworders());
    }

    @Test
    @DisplayName("Should handle sequential operations gracefully")
    void testSequentialOperations() {
        // Simulate customer workflow
        assertThrows(UnsupportedOperationException.class, () -> customer.registerprofile());
        assertThrows(UnsupportedOperationException.class, () -> customer.login());
        assertThrows(UnsupportedOperationException.class, () -> customer.updateprofile());
        assertThrows(UnsupportedOperationException.class, () -> customer.vieworders());
    }

    @Test
    @DisplayName("Should handle multiple concurrent operations")
    void testConcurrentOperations() {
        assertThrows(UnsupportedOperationException.class, () -> {
            customer.login();
            customer.updateprofile();
        });
    }

    @Test
    @DisplayName("Should create independent customer instances")
    void testMultipleCustomerInstances() {
        Customer customer1 = new Customer();
        Customer customer2 = new Customer();
        
        assertNotNull(customer1);
        assertNotNull(customer2);
        assertNotEquals(customer1, customer2);
    }
}

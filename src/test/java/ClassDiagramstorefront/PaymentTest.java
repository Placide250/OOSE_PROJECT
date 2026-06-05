package ClassDiagramstorefront;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for Payment class
 * Tests payment method management operations
 */
@DisplayName("Payment Management Tests")
public class PaymentTest {

    private Payment payment;

    @BeforeEach
    void setUp() {
        payment = new Payment();
    }

    @Test
    @DisplayName("Should initialize payment with default values")
    void testPaymentInitialization() {
        assertNotNull(payment, "Payment object should be created");
    }

    @Test
    @DisplayName("Should throw UnsupportedOperationException when setting payment method")
    void testSetMethod() {
        assertThrows(UnsupportedOperationException.class, () -> {
            payment.setmethod("Credit Card");
        }, "setmethod should throw UnsupportedOperationException");
    }

    @Test
    @DisplayName("Should throw UnsupportedOperationException when updating payment method")
    void testUpdateMethod() {
        assertThrows(UnsupportedOperationException.class, () -> {
            payment.updateMethod("Debit Card");
        }, "updateMethod should throw UnsupportedOperationException");
    }

    @Test
    @DisplayName("Should throw UnsupportedOperationException when listing payment details")
    void testListDetails() {
        assertThrows(UnsupportedOperationException.class, () -> {
            payment.listdetails();
        }, "listdetails should throw UnsupportedOperationException");
    }

    @Test
    @DisplayName("Should handle various payment method types")
    void testDifferentPaymentMethods() {
        String[] paymentMethods = {
            "Credit Card",
            "Debit Card",
            "PayPal",
            "Bank Transfer",
            "Mobile Payment"
        };
        
        for (String method : paymentMethods) {
            assertThrows(UnsupportedOperationException.class, () -> {
                payment.setmethod(method);
            });
        }
    }

    @Test
    @DisplayName("Should handle null payment method")
    void testNullPaymentMethod() {
        assertThrows(UnsupportedOperationException.class, () -> {
            payment.setmethod(null);
        });
    }

    @Test
    @DisplayName("Should manage all payment operations consistently")
    void testAllPaymentOperations() {
        assertThrows(UnsupportedOperationException.class, () -> payment.setmethod("Card"));
        assertThrows(UnsupportedOperationException.class, () -> payment.updateMethod("Card"));
        assertThrows(UnsupportedOperationException.class, () -> payment.listdetails());
    }

    @Test
    @DisplayName("Should create independent payment instances")
    void testMultiplePaymentInstances() {
        Payment payment1 = new Payment();
        Payment payment2 = new Payment();
        
        assertNotNull(payment1);
        assertNotNull(payment2);
        assertNotEquals(payment1, payment2);
    }
}

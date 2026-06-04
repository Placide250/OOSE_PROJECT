package ClassDiagramstorefront;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for NotificationService class
 * Tests email and SMS notification operations
 */
@DisplayName("Notification Service Tests")
public class NotificationServiceTest {

    private NotificationService notificationService;

    @BeforeEach
    void setUp() {
        notificationService = new NotificationService();
    }

    @Test
    @DisplayName("Should initialize notification service with default values")
    void testNotificationServiceInitialization() {
        assertNotNull(notificationService, "NotificationService object should be created");
    }

    @Test
    @DisplayName("Should throw UnsupportedOperationException when sending email")
    void testSendEmail() {
        assertThrows(UnsupportedOperationException.class, () -> {
            notificationService.sendEmail("test@example.com", "Test message");
        }, "sendEmail should throw UnsupportedOperationException");
    }

    @Test
    @DisplayName("Should throw UnsupportedOperationException when sending SMS")
    void testSendSMS() {
        assertThrows(UnsupportedOperationException.class, () -> {
            notificationService.sendSMS("Test SMS message");
        }, "sendSMS should throw UnsupportedOperationException");
    }

    @Test
    @DisplayName("Should handle email with valid format")
    void testSendEmailValidFormat() {
        String[] validEmails = {
            "user@example.com",
            "test.user@domain.co.uk",
            "info@storefront.com"
        };
        
        for (String email : validEmails) {
            assertThrows(UnsupportedOperationException.class, () -> {
                notificationService.sendEmail(email, "Body");
            });
        }
    }

    @Test
    @DisplayName("Should handle SMS with various message formats")
    void testSendSMSVariousMessages() {
        String[] messages = {
            "Order confirmed",
            "Delivery update: Your package is on the way",
            "Alert: Low inventory"
        };
        
        for (String message : messages) {
            assertThrows(UnsupportedOperationException.class, () -> {
                notificationService.sendSMS(message);
            });
        }
    }

    @Test
    @DisplayName("Should handle null parameters gracefully")
    void testNullParameters() {
        assertThrows(UnsupportedOperationException.class, () -> {
            notificationService.sendEmail(null, null);
        });
        
        assertThrows(UnsupportedOperationException.class, () -> {
            notificationService.sendSMS(null);
        });
    }

    @Test
    @DisplayName("Should create independent service instances")
    void testMultipleServiceInstances() {
        NotificationService service1 = new NotificationService();
        NotificationService service2 = new NotificationService();
        
        assertNotNull(service1);
        assertNotNull(service2);
        assertNotEquals(service1, service2);
    }
}

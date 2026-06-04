package ClassDiagramstorefront;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for Admin class
 * Tests admin operations including product and employee management
 */
@DisplayName("Admin Operations Tests")
public class AdminTest {

    private Admin admin;

    @BeforeEach
    void setUp() {
        admin = new Admin();
    }

    @Test
    @DisplayName("Should initialize admin with default values")
    void testAdminInitialization() {
        assertNotNull(admin, "Admin object should be created");
    }

    @Test
    @DisplayName("Should throw UnsupportedOperationException when adding product")
    void testAddProduct() {
        assertThrows(UnsupportedOperationException.class, () -> {
            admin.AddProduct();
        }, "AddProduct should throw UnsupportedOperationException");
    }

    @Test
    @DisplayName("Should throw UnsupportedOperationException when removing product")
    void testRemoveProduct() {
        assertThrows(UnsupportedOperationException.class, () -> {
            admin.RemoveProduct();
        }, "RemoveProduct should throw UnsupportedOperationException");
    }

    @Test
    @DisplayName("Should throw UnsupportedOperationException when adding employee")
    void testAddEmployee() {
        assertThrows(UnsupportedOperationException.class, () -> {
            admin.AddEmployee();
        }, "AddEmployee should throw UnsupportedOperationException");
    }

    @Test
    @DisplayName("Should throw UnsupportedOperationException when removing employee")
    void testRemoveEmployee() {
        assertThrows(UnsupportedOperationException.class, () -> {
            admin.RemoveEmployee();
        }, "RemoveEmployee should throw UnsupportedOperationException");
    }

    @Test
    @DisplayName("Should throw UnsupportedOperationException during operation")
    void testOperation() {
        assertThrows(UnsupportedOperationException.class, () -> {
            admin.operation();
        }, "operation should throw UnsupportedOperationException");
    }

    @Test
    @DisplayName("Should handle multiple admin instances independently")
    void testMultipleAdminInstances() {
        Admin admin1 = new Admin();
        Admin admin2 = new Admin();
        
        assertNotNull(admin1);
        assertNotNull(admin2);
        assertNotEquals(admin1, admin2, "Different admin instances should be distinct");
    }
}

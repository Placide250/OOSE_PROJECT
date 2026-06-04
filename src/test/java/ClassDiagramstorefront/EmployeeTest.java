package ClassDiagramstorefront;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for Employee class
 * Tests employee operations including shifts, products, and order management
 */
@DisplayName("Employee Operations Tests")
public class EmployeeTest {

    private Employee employee;

    @BeforeEach
    void setUp() {
        employee = new Employee();
    }

    @Test
    @DisplayName("Should initialize employee with default values")
    void testEmployeeInitialization() {
        assertNotNull(employee, "Employee object should be created");
    }

    @Test
    @DisplayName("Should throw UnsupportedOperationException when managing shifts")
    void testShifts() {
        assertThrows(UnsupportedOperationException.class, () -> {
            employee.shifts();
        }, "shifts should throw UnsupportedOperationException");
    }

    @Test
    @DisplayName("Should throw UnsupportedOperationException when adding product")
    void testAddProduct() {
        assertThrows(UnsupportedOperationException.class, () -> {
            employee.addproduct();
        }, "addproduct should throw UnsupportedOperationException");
    }

    @Test
    @DisplayName("Should throw UnsupportedOperationException when removing product")
    void testRemoveProduct() {
        assertThrows(UnsupportedOperationException.class, () -> {
            employee.removeproduct();
        }, "removeproduct should throw UnsupportedOperationException");
    }

    @Test
    @DisplayName("Should throw UnsupportedOperationException when managing orders")
    void testManageOrders() {
        assertThrows(UnsupportedOperationException.class, () -> {
            employee.ManageOrders();
        }, "ManageOrders should throw UnsupportedOperationException");
    }

    @Test
    @DisplayName("Should handle all employee operations consistently")
    void testAllOperationsThrowException() {
        assertThrows(UnsupportedOperationException.class, () -> employee.shifts());
        assertThrows(UnsupportedOperationException.class, () -> employee.addproduct());
        assertThrows(UnsupportedOperationException.class, () -> employee.removeproduct());
        assertThrows(UnsupportedOperationException.class, () -> employee.ManageOrders());
    }

    @Test
    @DisplayName("Should create independent employee instances")
    void testMultipleEmployeeInstances() {
        Employee emp1 = new Employee();
        Employee emp2 = new Employee();
        
        assertNotNull(emp1);
        assertNotNull(emp2);
        assertNotEquals(emp1, emp2);
    }
}

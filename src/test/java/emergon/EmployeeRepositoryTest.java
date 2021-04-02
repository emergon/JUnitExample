
package emergon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class EmployeeRepositoryTest {
    
    EmployeeRepository repo;
    
    @BeforeEach
    public void setUpTest(){
        repo = new EmployeeRepository();
    }
    
    @Test
    public void testAddEmployeeSuccess(){
        repo.addEmployee("Nick", "Nikolaou", 20, 1000);
        int numberOfEmployees = repo.getEmployees().size();
        Assertions.assertEquals(1, numberOfEmployees);
        Assertions.assertTrue(numberOfEmployees<10);
    }
    
    @Test
    public void testAddEmployeeInvalidFirstName(){
        Assertions.assertThrows(RuntimeException.class, () -> {
            repo.addEmployee(null, "Nikolaou", 20, 1000);
        });
    }
    
    @Test
    public void testAddEmployeeInvalidLastName(){
        Assertions.assertThrows(RuntimeException.class, () -> {
            repo.addEmployee("Nick", null, 20, 1000);
        });
    }
    
    
    @Test
    public void testAddEmployeeSmallAge(){
        Assertions.assertThrows(RuntimeException.class, () -> {
            repo.addEmployee("Nick", "Nickolaou", 10, 1000);
        });
    }
    
    @Disabled(value = "Do not test now")
    @ParameterizedTest
    @ValueSource(doubles = {-100.0, 300.0, 600.0, 1000.0, 1500.0, 2000.0, 10000})
    public void testAddEmployeeSalaries(double salary){
        repo.addEmployee("Nick", "Nickolaou", 25, salary);
        int numberOfEmployees = repo.getEmployees().size();
        Assertions.assertEquals(1, numberOfEmployees);
    }
    
}

package emergon;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class EmployeeRepository {
    private Map<String, Employee> employees = new ConcurrentHashMap();
    
    public void addEmployee(String fname, String lname, int age, double salary){
        Employee employee = new Employee(fname, lname, age, salary);
        validateEmployee(employee);
        String employeeId = getEmployeeId(employee);
        employees.put(employeeId, employee);
    }
    
    public Collection<Employee> getEmployees(){
        return employees.values();
    }
    
    private void validateEmployee(Employee employee){
        boolean isEmployeeValid;
        isEmployeeValid = employee.validateName();
        if(!isEmployeeValid){
            throw new RuntimeException("Name of employee is not valid:"+employee.getFname() + "-"+employee.getLname());
        }
        
        isEmployeeValid = employee.validateAge();
        if(!isEmployeeValid){
            throw new RuntimeException("Age of employee is not valid:"+employee.getAge());
        }
        
        isEmployeeValid = employee.validateSalary();
        if(!isEmployeeValid){
            throw new RuntimeException("Salary of employee is not valid:"+employee.getSalary());
        }
    }
    
    private String getEmployeeId(Employee employee){
        StringBuilder builder = new StringBuilder();
        char fnameInitial = employee.getFname().charAt(0);
        char lnameInitial = employee.getLname().charAt(0);
        builder.append(fnameInitial).append('.').append(lnameInitial);
        return builder.toString();
    }
}

package emergon;

import java.util.Objects;

public class Employee {
    
    private String fname;
    private String lname;
    private int age;
    private double salary;

    public Employee(String fname, String lname, int age, double salary) {
        this.fname = fname;
        this.lname = lname;
        this.age = age;
        this.salary = salary;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    public boolean validateFname(){
        boolean isFnameValid = (fname != null) && !fname.isEmpty();
        return isFnameValid;
    }
    
    public boolean validateLname(){
        boolean isLnameValid = (lname != null) && !lname.isEmpty();
        return isLnameValid;
    }
    
    public boolean validateName(){
        boolean isNameValid = validateFname() && validateLname();
        return isNameValid;
    }
    
    public boolean validateAge(){
        boolean isAgeValid = (age > 18) && (age < 60);
        return isAgeValid;
    }

    public boolean validateSalary(){
        boolean isSalaryValid = (salary > 500) && (salary < 1500);
        return isSalaryValid;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.fname);
        hash = 53 * hash + Objects.hashCode(this.lname);
        hash = 53 * hash + this.age;
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.salary) ^ (Double.doubleToLongBits(this.salary) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employee other = (Employee) obj;
        if (this.age != other.age) {
            return false;
        }
        if (Double.doubleToLongBits(this.salary) != Double.doubleToLongBits(other.salary)) {
            return false;
        }
        if (!Objects.equals(this.fname, other.fname)) {
            return false;
        }
        if (!Objects.equals(this.lname, other.lname)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Employee{" + "fname=" + fname + ", lname=" + lname + ", age=" + age + ", salary=" + salary + '}';
    }
    
    
}

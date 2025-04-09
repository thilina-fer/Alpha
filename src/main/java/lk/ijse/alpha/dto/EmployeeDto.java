package lk.ijse.alpha.dto;

public class EmployeeDto {
    private String empId;
    private String empName;
    private String empContact;
    private String empAddress;
    private int empAge;
    private double salary;

    public EmployeeDto() {
    }

    public EmployeeDto(String empId, String empName, String empContact, String empAddress, int empAge, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.empContact = empContact;
        this.empAddress = empAddress;
        this.empAge = empAge;
        this.salary = salary;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpContact() {
        return empContact;
    }

    public void setEmpContact(String empContact) {
        this.empContact = empContact;
    }

    public String getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    public int getEmpAge() {
        return empAge;
    }

    public void setEmpAge(int empAge) {
        this.empAge = empAge;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String toString() {
        return "EmployeeDto{" + "empId=" + empId + ", empName=" + empName + ", empContact=" + empContact + ", empAddress=" + empAddress + ", empAge=" + empAge + ", salary=" + salary + '}';
    }
}

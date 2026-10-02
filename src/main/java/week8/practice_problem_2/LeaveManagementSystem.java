package week8.practice_problem_2;

enum LeaveStatus {
    PENDING, APPROVED, REJECTED
}

abstract class Employee {
    private final String name;

    Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract boolean canTakeLeave(int numberOfDays);
}

class FullTimeEmployee extends Employee {
    FullTimeEmployee(String name) { super(name); }

    @Override
    public boolean canTakeLeave(int numberOfDays) {
        return numberOfDays > 0 && numberOfDays <= 15;
    }
}

class PartTimeEmployee extends Employee {
    PartTimeEmployee(String name) { super(name); }

    @Override
    public boolean canTakeLeave(int numberOfDays) {
        return numberOfDays > 0 && numberOfDays <= 7;
    }
}

class EmployeeLeaveRequest {
    private final Employee employee;
    private final String startDate;
    private final String endDate;
    private final int numberOfDays;
    private LeaveStatus status = LeaveStatus.PENDING;

    EmployeeLeaveRequest(Employee employee, String startDate, String endDate, int numberOfDays) {
        if (employee == null || numberOfDays <= 0) {
            throw new IllegalArgumentException("Invalid leave request.");
        }
        if (!employee.canTakeLeave(numberOfDays)) {
            throw new IllegalArgumentException("Employee leave policy does not allow this duration.");
        }
        this.employee = employee;
        this.startDate = startDate;
        this.endDate = endDate;
        this.numberOfDays = numberOfDays;
    }

    public Employee getEmployee() { return employee; }
    public String getStartDate() { return startDate; }
    public String getEndDate() { return endDate; }
    public int getNumberOfDays() { return numberOfDays; }
    public LeaveStatus getStatus() { return status; }

    void changeStatus(LeaveStatus newStatus) {
        if (status != LeaveStatus.PENDING) {
            throw new IllegalStateException("Leave request has already been reviewed.");
        }
        status = newStatus;
    }
}

class LeaveManager {
    public void approve(EmployeeLeaveRequest request) {
        request.changeStatus(LeaveStatus.APPROVED);
    }

    public void reject(EmployeeLeaveRequest request) {
        request.changeStatus(LeaveStatus.REJECTED);
    }
}

public class LeaveManagementSystem {
    public EmployeeLeaveRequest submit(Employee employee, String startDate, String endDate, int days) {
        return new EmployeeLeaveRequest(employee, startDate, endDate, days);
    }
}

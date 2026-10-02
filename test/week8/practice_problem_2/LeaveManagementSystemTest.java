package week8.practice_problem_2;

public class LeaveManagementSystemTest {
    public static void main(String[] args) {
        LeaveManagementSystem system = new LeaveManagementSystem();
        LeaveManager manager = new LeaveManager();

        Employee john = new FullTimeEmployee("John");
        Employee jane = new PartTimeEmployee("Jane");

        EmployeeLeaveRequest request1 =
                system.submit(john, "Jan 1", "Jan 5", 5);
        check(request1.getStatus() == LeaveStatus.PENDING, "Request should start pending");

        manager.approve(request1);
        check(request1.getStatus() == LeaveStatus.APPROVED, "Request should be approved");

        expectFailure(() -> manager.reject(request1));

        EmployeeLeaveRequest request2 =
                system.submit(jane, "Feb 10", "Feb 14", 5);
        manager.reject(request2);
        check(request2.getStatus() == LeaveStatus.REJECTED, "Request should be rejected");

        expectFailure(() -> system.submit(jane, "Mar 1", "Mar 10", 10));

        System.out.println("Leave management tests passed.");
    }

    private static void check(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }

    private static void expectFailure(Runnable action) {
        try {
            action.run();
            throw new AssertionError("Expected operation to fail.");
        } catch (IllegalArgumentException | IllegalStateException expected) {
        }
    }
}

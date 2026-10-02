package week8.assignment_problem_1;

public class HostelLaundryQueueTest {
    public static void main(String[] args) {
        HostelLaundryQueue system = new HostelLaundryQueue();

        Student asha = new Student("Asha");
        Student ravi = new Student("Ravi");
        WashingMachine m1 = new WashingMachine("M1");
        WashingMachine m2 = new WashingMachine("M2");

        WashCycle quick = system.startWash(asha, m1, new QuickWash());
        check(quick.getDurationMinutes() == 30, "Quick wash duration should be 30");
        check(quick.getCharge() == 20.0, "Quick wash charge should be 20");

        expectFailure(() -> system.startWash(ravi, m1, new HeavyWash()));

        WashCycle heavy = system.startWash(ravi, m2, new HeavyWash());
        check(heavy.getDurationMinutes() == 60, "Heavy wash duration should be 60");
        check(heavy.getCharge() == 45.0, "Heavy wash charge should be 45");

        system.completeWash(m1);
        check(m1.isFree(), "Machine M1 should be free after completion");

        WashCycle normal = system.startWash(ravi, m1, new NormalWash());
        check(normal.getDurationMinutes() == 45, "Normal wash duration should be 45");
        check(normal.getCharge() == 30.0, "Normal wash charge should be 30");

        System.out.println("Hostel laundry tests passed.");
    }

    private static void check(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }

    private static void expectFailure(Runnable action) {
        try {
            action.run();
            throw new AssertionError("Expected operation to fail.");
        } catch (IllegalStateException expected) {
        }
    }
}

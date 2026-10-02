package week8.assignment_problem_1;

interface WashType {
    String getName();
    int getDurationMinutes();
    double getCharge();
}

class QuickWash implements WashType {
    public String getName() { return "Quick"; }
    public int getDurationMinutes() { return 30; }
    public double getCharge() { return 20.0; }
}

class NormalWash implements WashType {
    public String getName() { return "Normal"; }
    public int getDurationMinutes() { return 45; }
    public double getCharge() { return 30.0; }
}

class HeavyWash implements WashType {
    public String getName() { return "Heavy"; }
    public int getDurationMinutes() { return 60; }
    public double getCharge() { return 45.0; }
}

class Student {
    private final String name;

    Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class WashCycle {
    private final Student student;
    private final WashType washType;
    private boolean completed;

    WashCycle(Student student, WashType washType) {
        this.student = student;
        this.washType = washType;
    }

    public Student getStudent() { return student; }
    public WashType getWashType() { return washType; }
    public int getDurationMinutes() { return washType.getDurationMinutes(); }
    public double getCharge() { return washType.getCharge(); }
    public boolean isCompleted() { return completed; }

    void complete() {
        completed = true;
    }
}

class WashingMachine {
    private final String id;
    private WashCycle currentCycle;

    WashingMachine(String id) {
        this.id = id;
    }

    public String getId() { return id; }
    public boolean isFree() { return currentCycle == null; }
    public WashCycle getCurrentCycle() { return currentCycle; }

    public WashCycle startWash(Student student, WashType washType) {
        if (student == null || washType == null) {
            throw new IllegalArgumentException("Student and wash type are required.");
        }
        if (!isFree()) {
            throw new IllegalStateException("Machine is currently busy.");
        }
        currentCycle = new WashCycle(student, washType);
        return currentCycle;
    }

    public void completeWash() {
        if (isFree()) {
            throw new IllegalStateException("Machine has no running wash.");
        }
        currentCycle.complete();
        currentCycle = null;
    }
}

public class HostelLaundryQueue {
    public WashCycle startWash(Student student, WashingMachine machine, WashType washType) {
        return machine.startWash(student, washType);
    }

    public void completeWash(WashingMachine machine) {
        machine.completeWash();
    }
}

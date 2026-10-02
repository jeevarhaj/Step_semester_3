package week8.assignment_problem_2;

enum SubmissionStatus {
    NOT_SUBMITTED, SUBMITTED, GRADED
}

abstract class Assignment {
    private final String title;
    private final double maximumMarks;

    Assignment(String title, double maximumMarks) {
        this.title = title;
        this.maximumMarks = maximumMarks;
    }

    public String getTitle() { return title; }
    public double getMaximumMarks() { return maximumMarks; }

    public abstract double calculateLatePenalty(int lateDays);

    public double finalMarks(double awardedMarks, int lateDays) {
        if (awardedMarks < 0 || awardedMarks > maximumMarks) {
            throw new IllegalArgumentException("Invalid marks.");
        }
        if (lateDays < 0) {
            throw new IllegalArgumentException("Late days cannot be negative.");
        }

        double penalty = calculateLatePenalty(lateDays);
        return Math.max(0, awardedMarks - penalty);
    }
}

class CodingAssignment extends Assignment {
    CodingAssignment(String title, double maximumMarks) {
        super(title, maximumMarks);
    }

    @Override
    public double calculateLatePenalty(int lateDays) {
        return lateDays * 10.0;
    }
}

class WrittenAssignment extends Assignment {
    WrittenAssignment(String title, double maximumMarks) {
        super(title, maximumMarks);
    }

    @Override
    public double calculateLatePenalty(int lateDays) {
        return lateDays * 20.0;
    }
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

class Submission {
    private final Student student;
    private final Assignment assignment;
    private final int lateDays;
    private SubmissionStatus status = SubmissionStatus.NOT_SUBMITTED;
    private double finalMarks;

    Submission(Student student, Assignment assignment, int lateDays) {
        if (student == null || assignment == null) {
            throw new IllegalArgumentException("Student and assignment are required.");
        }
        if (lateDays < 0) {
            throw new IllegalArgumentException("Late days cannot be negative.");
        }
        this.student = student;
        this.assignment = assignment;
        this.lateDays = lateDays;
    }

    public Student getStudent() { return student; }
    public Assignment getAssignment() { return assignment; }
    public int getLateDays() { return lateDays; }
    public SubmissionStatus getStatus() { return status; }
    public double getFinalMarks() { return finalMarks; }

    public void submit() {
        if (status != SubmissionStatus.NOT_SUBMITTED) {
            throw new IllegalStateException("Assignment cannot be submitted again.");
        }
        status = SubmissionStatus.SUBMITTED;
    }

    public void grade(double awardedMarks) {
        if (status != SubmissionStatus.SUBMITTED) {
            throw new IllegalStateException("Only submitted work can be graded.");
        }
        finalMarks = assignment.finalMarks(awardedMarks, lateDays);
        status = SubmissionStatus.GRADED;
    }
}

public class AssignmentSubmissionPortal {
    public Submission createSubmission(Student student, Assignment assignment, int lateDays) {
        return new Submission(student, assignment, lateDays);
    }
}

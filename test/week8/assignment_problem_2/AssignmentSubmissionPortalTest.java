package week8.assignment_problem_2;

public class AssignmentSubmissionPortalTest {
    public static void main(String[] args) {
        AssignmentSubmissionPortal portal = new AssignmentSubmissionPortal();

        Student asha = new Student("Asha");
        Assignment linkedList = new CodingAssignment("Linked List Lab", 50);
        Assignment designEssay = new WrittenAssignment("Design Essay", 50);

        Submission coding = portal.createSubmission(asha, linkedList, 0);
        check(coding.getStatus() == SubmissionStatus.NOT_SUBMITTED,
                "Submission should initially be not submitted");

        coding.submit();
        check(coding.getStatus() == SubmissionStatus.SUBMITTED,
                "Submission should be submitted");

        coding.grade(45);
        check(coding.getStatus() == SubmissionStatus.GRADED,
                "Submission should be graded");
        check(coding.getFinalMarks() == 45.0,
                "On-time coding assignment should keep full awarded marks");

        expectFailure(coding::submit);
        expectFailure(() -> coding.grade(40));

        Submission essay = portal.createSubmission(asha, designEssay, 2);
        essay.submit();
        essay.grade(50);
        check(essay.getFinalMarks() == 10.0,
                "Written assignment should lose 40 marks for two late days");

        System.out.println("Assignment submission portal tests passed.");
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

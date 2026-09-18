package week6.category_b.practice_problem_1;

public class StudentMember extends LibraryMember {
  private String course;
  public StudentMember(String memberId, int borrowLimit, String course) {
    super(memberId, borrowLimit);
    this.course = course;
  }
  public String getCourse() { return course; }
}

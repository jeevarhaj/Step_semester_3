package week6.category_b.practice_problem_2;
public class StudentMember extends LibraryMember {
  private String course;
  public StudentMember(String id, int limit, String course) {
    super(id, limit);
    this.course = course;
  }
  public String getCourse() { return course; }
  @Override
  public String displayInfo() {
    return "Student Member | Course: " + course +
        " | Books Borrowed: " + getBooksBorrowed();
  }
}

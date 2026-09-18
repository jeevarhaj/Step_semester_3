package week6.category_b.practice_problem_4;
public class StudentMember extends LibraryMember {
  private String course;
  public StudentMember(String id, int limit, String course) {
    super(id, limit);
    this.course = course;
  }
  public String getCourse() { return course; }
  @Override
  public String displayInfo() {
    return "Student | Course: " + course + " | Books: " + getBooksBorrowed();
  }
}

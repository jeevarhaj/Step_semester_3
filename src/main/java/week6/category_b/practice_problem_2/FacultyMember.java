package week6.category_b.practice_problem_2;
public class FacultyMember extends LibraryMember {
  private String department;
  public FacultyMember(String id, int limit, String department) {
    super(id, limit);
    this.department = department;
  }
  @Override
  public String displayInfo() {
    return "Faculty Member | Department: " + department +
        " | Books Borrowed: " + getBooksBorrowed();
  }
}

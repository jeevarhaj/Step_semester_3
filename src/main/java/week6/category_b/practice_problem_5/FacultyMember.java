package week6.category_b.practice_problem_5;
public class FacultyMember extends LibraryMember {
  private String department;
  public FacultyMember(int borrowLimit, String department) {
    super(borrowLimit);
    this.department = department;
  }
  public String getDepartment() { return department; }
}

package week6.category_b.practice_problem_3;
public class StudentMember extends LibraryMember {
  private String course;
  public StudentMember(String id, int limit, String course) {
    super(id, limit);
    this.course = course;
  }
  @Override
  protected void chargeFine(int amount) {
    super.chargeFine(amount / 2);
  }
  public void applyFine(int amount) { chargeFine(amount); }
}

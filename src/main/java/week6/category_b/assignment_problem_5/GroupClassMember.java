package week6.category_b.assignment_problem_5;
public class GroupClassMember extends GymMember {
  private String className;
  public GroupClassMember(int monthlyFee, String className) {
    super(monthlyFee);
    this.className = className;
  }
  public String getClassName() { return className; }
}

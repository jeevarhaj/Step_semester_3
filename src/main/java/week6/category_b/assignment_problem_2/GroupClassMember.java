package week6.category_b.assignment_problem_2;
public class GroupClassMember extends GymMember {
  private String className;
  public GroupClassMember(String id, int fee, String className) {
    super(id, fee);
    this.className = className;
  }
  @Override
  public String displayInfo() {
    return "Group Class Member | Class: " + className +
        " | Sessions: " + getSessionsAttended();
  }
}

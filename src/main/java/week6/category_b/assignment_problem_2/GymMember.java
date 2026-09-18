package week6.category_b.assignment_problem_2;
public class GymMember {
  private int sessionsAttended;
  public GymMember(String id, int fee) {
    if (id == null || id.trim().length() < 4 || fee <= 0)
      throw new IllegalArgumentException("Invalid member details");
  }
  public void attendSession() { sessionsAttended++; }
  public int getSessionsAttended() { return sessionsAttended; }
  public String displayInfo() {
    return "Standard Member | Sessions: " + sessionsAttended;
  }
  public static String classifyGeneration(GymMember member) {
    if (member instanceof EliteMember)
      return "Multilevel descendant (3 generations deep)";
    if (member instanceof GroupClassMember)
      return "Hierarchical sibling (independent branch)";
    return "Base member";
  }
  public static int getTotalSessionsAttended(GymMember[] members) {
    int total = 0;
    for (GymMember member : members)
      total += member.getSessionsAttended();
    return total;
  }
}

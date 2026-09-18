package week6.category_b.assignment_problem_4;
public class GymMember {
  private int sessionsAttended;
  public GymMember(String id, int fee) {
    if (id == null || id.trim().length() < 4 || fee <= 0)
      throw new IllegalArgumentException("Invalid member details");
  }
  public void attendSession() { sessionsAttended++; }
  public int getSessionsAttended() { return sessionsAttended; }
  public String displayInfo() {
    return "Standard | Sessions: " + sessionsAttended;
  }
  public static String batchPrint(GymMember[] members) {
    StringBuilder result = new StringBuilder();
    for (GymMember member : members) {
      result.append(member.displayInfo());
      if (member instanceof PremiumMember) {
        PremiumMember premium = (PremiumMember)member;
        result.append(" [Trainer via downcast: ")
            .append(premium.getTrainerName())
            .append("]");
      }
      result.append(" | ");
    }
    return result.toString();
  }
}

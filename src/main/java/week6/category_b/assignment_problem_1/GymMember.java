package week6.category_b.assignment_problem_1;
public class GymMember {
  private String memberId;
  private int monthlyFee;
  private int sessionsAttended;
  public GymMember(String memberId, int monthlyFee) {
    if (memberId == null || memberId.trim().length() < 4 || monthlyFee <= 0)
      throw new IllegalArgumentException("Invalid member details");
    this.memberId = memberId;
    this.monthlyFee = monthlyFee;
  }
  public void attendSession() { sessionsAttended++; }
  public int getSessionsAttended() { return sessionsAttended; }
  public static String signUpBatch(String[] memberIds, int monthlyFee) {
    int signedUp = 0, rejected = 0;
    for (String memberId : memberIds) {
      try {
        new GymMember(memberId, monthlyFee);
        signedUp++;
      } catch (IllegalArgumentException e) {
        rejected++;
      }
    }
    return "Signed Up: " + signedUp + " | Rejected: " + rejected;
  }
}

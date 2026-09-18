package week6.category_b.assignment_problem_5;
public class GymMember {
  private static int membersEnrolled;
  private final String membershipNumber;
  private int monthlyFee;
  private int feesPaid;
  public GymMember(int monthlyFee) {
    if (monthlyFee <= 0)
      throw new IllegalArgumentException("Invalid monthly fee");
    this.monthlyFee = monthlyFee;
    membersEnrolled++;
    membershipNumber = "GYM-" + (2000 + membersEnrolled);
  }
  public String getMembershipNumber() { return membershipNumber; }
  public void payFee(int amount) {
    if (amount < 0)
      throw new IllegalArgumentException("Invalid payment");
    feesPaid += amount;
  }
  public void payFee(int amount, String mode) { payFee(amount); }
  public int getFeesPaid() { return feesPaid; }
  public static boolean isValidReferralCode(String code) {
    return code != null && code.length() == 4 && code.charAt(0) == 'G' &&
        Character.isDigit(code.charAt(1)) &&
        Character.isDigit(code.charAt(2)) &&
        Character.isUpperCase(code.charAt(3));
  }
  public static int getMembersEnrolled() { return membersEnrolled; }
  public static String processWeeklyCheckIn(GymMember[] members) {
    int processed = 0, nullSkipped = 0, group = 0, individual = 0;
    for (GymMember member : members) {
      if (member == null) {
        nullSkipped++;
        continue;
      }
      processed++;
      if (member instanceof GroupClassMember)
        group++;
      else
        individual++;
    }
    return processed + " processed | " + nullSkipped + " null skipped | " +
        group + " group | " + individual + " individual";
  }
}

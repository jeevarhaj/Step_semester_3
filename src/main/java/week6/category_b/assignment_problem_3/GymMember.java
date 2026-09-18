package week6.category_b.assignment_problem_3;
import java.util.Arrays;
public class GymMember {
  private int[] lateFeeHistory = new int[10];
  private int feeCount;
  public GymMember(String id, int fee) {
    if (id == null || id.trim().length() < 4 || fee <= 0)
      throw new IllegalArgumentException("Invalid member details");
  }
  protected void chargeLateFee(int amount) {
    if (amount < 0)
      throw new IllegalArgumentException("Invalid late fee");
    if (feeCount < lateFeeHistory.length)
      lateFeeHistory[feeCount++] = amount;
  }
  public int[] getLateFeeHistory() {
    return Arrays.copyOf(lateFeeHistory, feeCount);
  }
  public int getTotalLateFees() {
    int total = 0;
    for (int fee : lateFeeHistory)
      total += fee;
    return total;
  }
}

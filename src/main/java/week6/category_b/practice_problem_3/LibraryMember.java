package week6.category_b.practice_problem_3;
import java.util.Arrays;
public class LibraryMember {
  private int[] fineHistory = new int[10];
  private int fineCount;
  public LibraryMember(String id, int limit) {
    if (id == null || id.trim().length() < 4 || limit <= 0)
      throw new IllegalArgumentException("Invalid member details");
  }
  protected void chargeFine(int amount) {
    if (amount < 0)
      throw new IllegalArgumentException("Invalid fine");
    if (fineCount < fineHistory.length)
      fineHistory[fineCount++] = amount;
  }
  public int[] getFineHistory() {
    return Arrays.copyOf(fineHistory, fineCount);
  }
  public int getTotalFine() {
    int total = 0;
    for (int fine : fineHistory)
      total += fine;
    return total;
  }
}

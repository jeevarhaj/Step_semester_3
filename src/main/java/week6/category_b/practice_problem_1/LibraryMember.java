package week6.category_b.practice_problem_1;

public class LibraryMember {
  private String memberId;
  private int borrowLimit;
  private int booksBorrowed;
  public LibraryMember(String memberId, int borrowLimit) {
    if (memberId == null || memberId.trim().length() < 4 || borrowLimit <= 0)
      throw new IllegalArgumentException("Invalid member details");
    this.memberId = memberId;
    this.borrowLimit = borrowLimit;
  }
  public void borrowBook() {
    if (booksBorrowed < borrowLimit)
      booksBorrowed++;
  }
  public int getBooksBorrowed() { return booksBorrowed; }
  public static String enrollBatch(String[] memberIds, int borrowLimit) {
    int enrolled = 0, rejected = 0;
    for (String memberId : memberIds) {
      try {
        new LibraryMember(memberId, borrowLimit);
        enrolled++;
      } catch (IllegalArgumentException e) {
        rejected++;
      }
    }
    return "Enrolled: " + enrolled + " | Rejected: " + rejected;
  }
}

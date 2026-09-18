package week6.category_b.practice_problem_5;
public class LibraryMember {
  private static int membersEnrolled;
  private final String memberNumber;
  private int booksBorrowed;
  private int borrowLimit;
  public LibraryMember(int borrowLimit) {
    if (borrowLimit <= 0)
      throw new IllegalArgumentException("Invalid borrow limit");
    this.borrowLimit = borrowLimit;
    membersEnrolled++;
    memberNumber = "LIB-" + (100 + membersEnrolled);
  }
  public String getMemberNumber() { return memberNumber; }
  public void borrowBook() {
    if (booksBorrowed < borrowLimit)
      booksBorrowed++;
  }
  public void borrowBook(String genre) { borrowBook(); }
  public int getBooksBorrowed() { return booksBorrowed; }
  public static boolean isValidRenewalCode(String code) {
    return code != null && code.length() == 4 && code.charAt(0) == 'R' &&
        Character.isDigit(code.charAt(1)) &&
        Character.isDigit(code.charAt(2)) &&
        Character.isUpperCase(code.charAt(3));
  }
  public static int getMembersEnrolled() { return membersEnrolled; }
  public static String processNightlyAudit(LibraryMember[] members) {
    int processed = 0, nullSkipped = 0, faculty = 0, regular = 0;
    for (LibraryMember member : members) {
      if (member == null) {
        nullSkipped++;
        continue;
      }
      processed++;
      if (member instanceof FacultyMember)
        faculty++;
      else
        regular++;
    }
    return processed + " processed | " + nullSkipped + " null skipped | " +
        faculty + " faculty | " + regular + " regular";
  }
}

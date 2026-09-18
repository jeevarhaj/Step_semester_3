package week6.category_b.practice_problem_2;

public class LibraryMember {
  private int booksBorrowed;
  public LibraryMember(String memberId, int borrowLimit) {
    if (memberId == null || memberId.trim().length() < 4 || borrowLimit <= 0)
      throw new IllegalArgumentException("Invalid member details");
  }
  public void borrowBook() { booksBorrowed++; }
  public int getBooksBorrowed() { return booksBorrowed; }
  public String displayInfo() {
    return "General Member | Books Borrowed: " + booksBorrowed;
  }
  public static String classifyGeneration(LibraryMember member) {
    if (member instanceof HonorsStudentMember)
      return "Multilevel descendant (3 generations deep)";
    if (member instanceof FacultyMember)
      return "Hierarchical sibling (independent branch)";
    return "Base member";
  }
  public static int getTotalBooksBorrowed(LibraryMember[] members) {
    int total = 0;
    for (LibraryMember member : members)
      total += member.getBooksBorrowed();
    return total;
  }
}

package week6.category_b.practice_problem_4;
public class LibraryMember {
  private int booksBorrowed;
  public LibraryMember(String id, int limit) {
    if (id == null || id.trim().length() < 3 || limit <= 0)
      throw new IllegalArgumentException("Invalid member details");
  }
  public void borrowBook() { booksBorrowed++; }
  public int getBooksBorrowed() { return booksBorrowed; }
  public String displayInfo() { return "General | Books: " + booksBorrowed; }
  public static String batchPrint(LibraryMember[] members) {
    StringBuilder result = new StringBuilder();
    for (LibraryMember member : members) {
      result.append(member.displayInfo());
      if (member instanceof StudentMember) {
        StudentMember student = (StudentMember)member;
        result.append(" [Course via downcast: ")
            .append(student.getCourse())
            .append("]");
      }
      result.append(" | ");
    }
    return result.toString();
  }
}

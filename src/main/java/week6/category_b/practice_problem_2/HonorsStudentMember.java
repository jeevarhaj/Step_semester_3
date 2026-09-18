package week6.category_b.practice_problem_2;
public class HonorsStudentMember extends StudentMember {
  private int bonusLimit;
  public HonorsStudentMember(String id, int limit, String course,
                             int bonusLimit) {
    super(id, limit, course);
    this.bonusLimit = bonusLimit;
  }
  @Override
  public String displayInfo() {
    return "Honors Student Member | Course: " + getCourse() +
        " | Bonus Limit: " + bonusLimit +
        " | Books Borrowed: " + getBooksBorrowed();
  }
}

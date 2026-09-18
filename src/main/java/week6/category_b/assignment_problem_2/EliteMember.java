package week6.category_b.assignment_problem_2;
public class EliteMember extends PremiumMember {
  private String lockerNumber;
  public EliteMember(String id, int fee, String trainerName,
                     String lockerNumber) {
    super(id, fee, trainerName);
    this.lockerNumber = lockerNumber;
  }
  @Override
  public String displayInfo() {
    return "Elite Member | Trainer: " + getTrainerName() +
        " | Locker: " + lockerNumber +
        " | Sessions: " + getSessionsAttended();
  }
}

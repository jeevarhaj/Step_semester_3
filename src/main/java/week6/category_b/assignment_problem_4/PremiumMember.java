package week6.category_b.assignment_problem_4;
public class PremiumMember extends GymMember {
  private String trainerName;
  public PremiumMember(String id, int fee, String trainerName) {
    super(id, fee);
    this.trainerName = trainerName;
  }
  public String getTrainerName() { return trainerName; }
  @Override
  public String displayInfo() {
    return "Premium | Trainer: " + trainerName +
        " | Sessions: " + getSessionsAttended();
  }
}

package week6.category_b.assignment_problem_1;
public class PremiumMember extends GymMember {
  private String trainerName;
  public PremiumMember(String memberId, int monthlyFee, String trainerName) {
    super(memberId, monthlyFee);
    this.trainerName = trainerName;
  }
  public String getTrainerName() { return trainerName; }
}

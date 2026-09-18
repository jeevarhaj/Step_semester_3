package week6.category_b.assignment_problem_3;
public class PremiumMember extends GymMember {
  private String trainerName;
  public PremiumMember(String id, int fee, String trainerName) {
    super(id, fee);
    this.trainerName = trainerName;
  }
  @Override
  protected void chargeLateFee(int amount) {
    super.chargeLateFee(amount / 2);
  }
  public void applyLateFee(int amount) { chargeLateFee(amount); }
}

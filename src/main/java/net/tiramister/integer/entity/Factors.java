package net.tiramister.integer.entity;

import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Factors {
  ArrayList<Factor> factors;

  public Factors() {
    this.setFactors(new ArrayList<Factor>());
  }

  public void add(long prime, int exp) {
    this.getFactors().add(new Factor(prime, exp));
  }

  public static Factors one() {
    Factors factors = new Factors();
    factors.add(1, 1);
    return factors;
  }

  public boolean isOne() {
    return this.getFactors().get(0).getPrime() == 1;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < this.getFactors().size(); ++i) {
      sb.append(this.getFactors().get(i));
      if (i + 1 < this.getFactors().size()) {
        sb.append(" \\cdot ");
      }
    }
    return sb.toString();
  }

  @Getter
  @Setter
  @AllArgsConstructor
  public class Factor {
    private long prime;
    private int exp;

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append(this.getPrime());
      if (this.getExp() != 1) {
        sb.append("^{");
        sb.append(this.getExp());
        sb.append("}");
      }
      return sb.toString();
    }
  }
}

package HashTable;

import java.math.BigDecimal;

public class MyIntMul extends MyInt {
  public MyIntMul(int val) {
    super(val);
  }

  @Override
  public int hashCode() {
    // TODO implement multiplication hash
    // TODO floor(m(kA mod 1))

    BigDecimal a = new BigDecimal("2654435769");
    BigDecimal b = new BigDecimal(String.valueOf(BigDecimal.valueOf(Math.pow(2, 32))));
    BigDecimal A = a.divide(b);

    int m = HashTableLinearProbing.getCapacity();
    int k = super.getVal();
    BigDecimal c = A.multiply(new BigDecimal(Integer.toString(k)));
    return c.remainder(new BigDecimal(Integer.toString(1))).multiply(new BigDecimal(Integer.toString(m))).intValue();

  }
}

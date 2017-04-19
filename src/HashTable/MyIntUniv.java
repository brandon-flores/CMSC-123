package HashTable;

import java.math.BigInteger;
import java.util.Random;

public class MyIntUniv extends MyInt {
  private static Random rand = new Random();
  private static int a = rand.nextInt();
  private static int b = rand.nextInt();
  
  public MyIntUniv(int val) {
    super(val);
  }

  @Override
  public int hashCode() {
    // TODO implement universal hash
    // TODO h(k) = [(ak + b) mod p] mod m
    // TODO m/n

    int k = super.getVal();
    BigInteger m = new BigInteger(Integer.toString(HashTableLinearProbing.getCapacity()));
    BigInteger p = m.nextProbablePrime();
    BigInteger ans1 = (new BigInteger(Integer.toString(a))).multiply(new BigInteger(Integer.toString(k))).add(new BigInteger(Integer.toString(b))).mod(p);
    return ans1.intValue();

  }
}

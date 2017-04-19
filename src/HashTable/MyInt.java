package HashTable;
public class MyInt {
  protected int val;

  public MyInt(int val) {
    this.val = val;
  }

  public int getVal() {
    return val;
  }

  public String toString() {
    return String.valueOf(val);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof MyInt)) return false;

    MyInt myInt = (MyInt) o;

    return val == myInt.val;
  }

  @Override
  public int hashCode() {
    return val;
  }
}

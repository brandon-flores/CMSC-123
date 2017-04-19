package HashTable;

public class HashTableLinearProbing {

  private static int capacity;
  private MyInt[] items;
  private int collisions;

  public HashTableLinearProbing(int i) {
    capacity = i;
    this.items = new MyInt[capacity];
    this.collisions = 0;
  }

  private int index(int hash) {
    return hash % capacity;
  }

  public boolean add(MyInt value) {
    int i = index(value.hashCode());
    //System.out.println("tae " + i);
    int temp;
    if (items[i] == null) {
      items[i] = value;
      return true;
    }

    collisions++;

    temp = i;
    i = succ(i);

    for( ; i != temp; i = succ(i)){
      if(items[i] == null){
        items[i] = value;
        return true;
      }
    }


    return false;
  }

  private int succ(int i) {
    return i + 1 == capacity ? 0 : i + 1;
  }

  public boolean remove(MyInt value) {
    int i = index(value.hashCode());

    if (items[i] == null) {
      return false;
    }

    if (value.equals(items[i])) {
      items[i] = new Bridge();
      return true;
    }

    int temp = i;
    i = succ(i);

    for( ; i != temp;){
      if(items[i].equals(value)){
        items[i] = new Bridge();
        return true;
      }else{
        i = succ(i);
      }
    }


    return false;
  }

  public boolean contains(MyInt value) {
    int i = index(value.hashCode());

    if (items[i] == null) {
      return false;
    }

    if (value.equals(items[i])) {
      return true;
    }

    int temp = i;
    i = succ(i);

    for( ; i != temp && items[i] != null;){
      if(items[i].equals(value)){
        return true;
      }else{
        i = succ(i);
      }
    }

    return false;
  }

  public String toString() {
    String val = "[";
    for (int i = 0; i < capacity; i++) {
      if (items[i] != null) {
        val += items[i].toString();
      } else {
        val += " ";
      }

      if (i < capacity - 1) {
        val += ", ";
      }
    }
    val += "]";
    return val;
  }

  public static int getCapacity() {
    return capacity;
  }

  public int getCollisions() {
    return collisions;
  }

  private class Bridge extends MyInt {
    public Bridge(int val) {
      super(val);
    }

    public Bridge() {
      super(0);
    }

    @Override
    public String toString() {
      return "B";
    }
  }



}

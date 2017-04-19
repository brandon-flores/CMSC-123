package Hash;
import java.util.LinkedList;
import java.util.List;

public class HashTable<V> {

  private int capacity;
  private List<V>[] buckets;

  public HashTable(int capacity) {
    this.capacity = capacity;
    this.buckets = new LinkedList[capacity];
    fillList();
  }

  public void add(V value) {
    buckets[getMod(value)].add(value);
  }

  public void remove(V value) {
    buckets[getMod(value)].remove(value);
  }

  public boolean contains(V value) {
    for(Object o : buckets[getMod(value)]){
      if(o.equals(value)) return true;
    }
    return false;
  }

  public void fillList(){
    for(int i = 0; i < capacity; i++){
      buckets[i] = new LinkedList<>();
    }
  }

  public int getMod(V val){
    return val.hashCode() % capacity;
  }
}

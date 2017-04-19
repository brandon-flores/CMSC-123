/**
 * created by brandon flores
 */

public class AList {  
  private String[] items;
  private int count;
  private int max;
  
  public AList() {
    this.items = new String[10];
    this.count = 0;
    this.max = 10;
  }
  
  public void reSize(){
    String temp[] = new String[max + 10];
    for(int i = 0; i < count; i++){
      temp[i] = items[i];
    }
    this.items = temp;
    this.max += 10;
  }
  
  public void add(String item) {
    if(count == max){
      reSize();
    }
    items[count++] = item;
  }
  
  public void add(int i, String item) {
    if(count == max){
      reSize();
    }
    String temp;
    int x;
    for(x = count; x > i; x--){
      items[x] = items[x-1];
    }
    items[x] = item;
    count++;
  }
  
  public String get(int i) {
    check(i);
    return items[i];
  }
  
  public void remove(int i) {
    check(i);
    for(int x = i; x < count; x++){
      items[x] = items[x+1];
    } 
     count--;
  }

  public void remove(String s) {
    int x;
    for(x = 0; x < count && !(items[x].equals(s)); x++){  
    } 
    if(x == count && !(items[x-1].equals(s))){
      throw new IndexOutOfBoundsException();
    }
    else{
      remove(x);
    }
  }
  
  public void set(int i, String item) {
    check(i);
    items[i] = item;
  }
 
  public void check(int i){
    if (count == 0 || i >= count || i < 0) {
      throw new IndexOutOfBoundsException();
    }
  }
  
}

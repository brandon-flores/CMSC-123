package HeapSort;

public class HeapSorter {
  private int[] items;
  private int heapSize;
  private final int ROOT = 0;

  public HeapSorter(int[] items) {
    this.items = items;
    this.heapSize = 0;
  }

  public void sort() {
    for (int i = 0; i < items.length; i++) {
      add(items[i]);
    }

    for (int i = items.length - 1; i >= 0; i--) {
      items[i] = remove();
    }
  }

  public void add(int x) {
    items[heapSize] = x;
    bubbleUp(heapSize++);
  }

  public void bubbleUp(int i) {
    int temp = items[i];

    while (i > 0 && temp > items[parent(i)]) {
      items[i] = items[parent(i)];
      i = parent(i);
    }
    items[i] = temp;
  }

  public void swap(int i, int j) {
    int temp = items[i];
    items[i] = items[j];
    items[j] = temp;
  }

  public int parent(int i) {
    //return items[(i - 1)/2];
      return (i - 1)/2;
  }

  public int remove() {
    if (heapSize == 0){
      throw new IndexOutOfBoundsException("Empty!");
    }
    int i = items[ROOT];
    swap(ROOT, --heapSize);
    trickleDown(ROOT);
    return i;
  }

  public void trickleDown(int i) {
    if (heapSize!= 0){
        int temp = items[i];
        int greater;

        while (i < heapSize/2) {
            if (hasRight(i) && items[left(i)] < items[right(i)]) {
                greater = right(i);
            }
            else {
                greater = left(i);
            }

            if (temp > items[greater]) break;

            items[i] = items[greater];
            i = greater;
        }
        items[i] = temp;
    }
  }

  public boolean hasLeft(int i) {
    return i*2 + 1  < heapSize;
  }

  public boolean hasRight(int i) {
    return i*2 + 2  < heapSize;
  }

  public int right(int i) {
      return i*2 + 2;
  }

  public int left(int i) {
      return i*2 + 1;
  }

}
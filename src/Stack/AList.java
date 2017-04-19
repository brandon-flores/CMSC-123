public class AList<E> {

    private E[] items;
    private int count;
    private static final int DEFAULT_SIZE = 10;

    public AList() {
        items = (E[])(new Object[DEFAULT_SIZE]);
        count = 0;
    }

    public void add(E item) {
        if (count >= DEFAULT_SIZE) {
            E[] newItems = (E[])(new Object[DEFAULT_SIZE * 2]);
            items = newItems;
        }
        items[count++] = item;
    }

    public void add(int i, E item) {
        String store = (String) items[i];
        items[i + 1] = (E) store;
        items[i] = item;
        count++;
    }

    public E get(int i) {
        if (count == 0 || i >= count) {
            throw new IndexOutOfBoundsException();
        }
        return (E) (String) items[i];
    }

    public void remove(int i) {
        for (int x = i; x < count - 1; x++) {
            items[i] = items[x + 1];
        }
        count--;
    }

    public void set(int i, E item) {
        this.items[i] = (E) item;
    }
}
